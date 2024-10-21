package spendreport;

import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.walkthrough.common.entity.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DetailedTransactionSource implements SourceFunction<Transaction> {

    private boolean isRunning = true;
    private final List<String> zipCodes = new ArrayList<>(Arrays.asList("01003", "02115", "78712"));

    @Override
    public void run(SourceContext<Transaction> ctx) throws Exception {
        while (isRunning) {

            Transaction transaction = new Transaction();
            Random random = new Random();

            // Getting a random zip code to add to Transaction class
            String zipCode = zipCodes.get(random.nextInt(zipCodes.size()));

            // Creating new DetailedTransaction class
            DetailedTransaction detailedTransaction = new DetailedTransaction(transaction, zipCode);

//            System.out.println(detailedTransaction);
            // Collect the detailed transaction in the context
            ctx.collect(transaction);
        }
    }

    @Override
    public void cancel() {
        isRunning = false;
    }
}
