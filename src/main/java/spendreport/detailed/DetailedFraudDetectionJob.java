package spendreport.detailed;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class DetailedFraudDetectionJob {
    /**
     * Skeleton code for the datastream walkthrough
     */
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<DetailedTransaction> detailedTransactions = env
                .addSource(new DetailedTransactionSource())
                .name("detailedTransactions");

        DataStream<DetailedAlert> detailedAlerts = detailedTransactions
                .keyBy(DetailedTransaction::getAccountId)
                .process(new DetailedFraudDetector())
                .name("detailed-fraud-detector");

        detailedAlerts
                .addSink(new DetailedAlertSink())
                .name("send-alerts");

        env.execute("Fraud Detection");
    }
}
