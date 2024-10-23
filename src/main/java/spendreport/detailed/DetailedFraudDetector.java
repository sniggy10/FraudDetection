package spendreport.detailed;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

/**
 * Implementing detailed fraud detector class.
 */
public class DetailedFraudDetector extends KeyedProcessFunction<Long, DetailedTransaction, DetailedAlert> {

    private static final long serialVersionUID = 1L;

    private static final double SMALL_AMOUNT = 20.00;
    private static final double LARGE_AMOUNT = 200.00;
    private static final long ONE_MINUTE = 60 * 1000;
    private transient ValueState<Boolean> flagState;
    private transient ValueState<Long> timerState;
    private transient ValueState<String> zipcodeState;

    @Override
    public void open(Configuration parameters) {
        ValueStateDescriptor<Boolean> flagDescriptor = new ValueStateDescriptor<>(
                "flag",
                Types.BOOLEAN);
        flagState = getRuntimeContext().getState(flagDescriptor);
        ValueStateDescriptor<Long> timerDescriptor = new ValueStateDescriptor<>(
                "timer-state",
                Types.LONG);
        timerState = getRuntimeContext().getState(timerDescriptor);

        ValueStateDescriptor<String> zipcodeDescriptor = new ValueStateDescriptor<>(
                "zip-state",
                Types.STRING);
        zipcodeState = getRuntimeContext().getState(zipcodeDescriptor);
    }

    @Override
    public void processElement(
            DetailedTransaction detailedTransaction,
            Context context,
            Collector<DetailedAlert> collector) throws Exception {

        // Get the current state for the current key
        Boolean lastTransactionWasSmall = flagState.value();

        // Check if the flag is set
        if (lastTransactionWasSmall != null) {
            if (detailedTransaction.getAmount() > LARGE_AMOUNT) {
                // Output an alert downstream if zip code of small transaction is equal to zipcode of large transaction
                if (detailedTransaction.getZipcode().equalsIgnoreCase(zipcodeState.value())) {
                    DetailedAlert detailedAlert = new DetailedAlert();
                    detailedAlert.setId(detailedTransaction.getAccountId());
                    detailedAlert.setZip(detailedTransaction.getZipcode());
                    collector.collect(detailedAlert);
                }
            }

            // Clean up our state
            cleanUp(context);
        }

        if (detailedTransaction.getAmount() < SMALL_AMOUNT) {
            // Set the flag to true
            flagState.update(true);

            // set the zipcode state with the zipcode during the small transaction
            zipcodeState.update(detailedTransaction.getZipcode());

            // set the timer and timer state
            long timer = context.timerService().currentProcessingTime() + ONE_MINUTE;
            context.timerService().registerProcessingTimeTimer(timer);
            timerState.update(timer);
        }
    }

    @Override
    public void onTimer(long timestamp, OnTimerContext ctx, Collector<DetailedAlert> out) {
        // remove flag after 1 minute
        timerState.clear();
        flagState.clear();
        zipcodeState.clear();
    }

    private void cleanUp(Context ctx) throws Exception {
        // delete timer
        Long timer = timerState.value();
        ctx.timerService().deleteProcessingTimeTimer(timer);

        // clean up all state
        timerState.clear();
        flagState.clear();
        zipcodeState.clear();
    }
}

