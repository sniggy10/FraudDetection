package spendreport.detailed;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class DetailedFraudDetectionJob {
    /**
     * Skeleton code for the datastream walkthrough
     */
    // In the below main function, we update class names we have used, with the new classes that
    // have been created for the assignment to accomodate the zipcode addition at different levels.
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // We use the DetailedTransaction and DetailedTransactionSource here to
        // have the zip code data for the alert and the updated iterator required for Transaction class.
        DataStream<DetailedTransaction> detailedTransactions = env
                .addSource(new DetailedTransactionSource())
                .name("detailedTransactions");

        // Alert class is replaced with DetailedAlert to get the details of the fraudalent
        // transactions along with the details of the account present in the DetailedTransactions
        // class.
        DataStream<DetailedAlert> detailedAlerts = detailedTransactions
                .keyBy(DetailedTransaction::getAccountId)
                .process(new DetailedFraudDetector())
                .name("detailed-fraud-detector");


        // The detailed alerts then logs the outputs and displays the alerts in the console.
        detailedAlerts
                .addSink(new DetailedAlertSink())
                .name("send-alerts");

        env.execute("Fraud Detection");
    }
}
