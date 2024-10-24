package spendreport.detailed;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DetailedTransactionIterator implements Iterator<DetailedTransaction>, Serializable {
    private static final long serialVersionUID = 1L;

    private static final Timestamp INITIAL_TIMESTAMP = Timestamp.valueOf("2024-01-01 00:00:00");

    private static final long ONE_MINUTE = 60 * 1000;

    private final boolean bounded;

    private int index = 0;

    private long timestamp;

    /* Setting the defined zipcodes given in the question into 3 variables
     which are later uniformly randomly set across different Transaction details. */
    private static String zipcode_1 = "01003";

    private static String zipcode_2 = "02115";

    private static String zipcode_3 = "78712";

    static DetailedTransactionIterator bounded() {
        return new DetailedTransactionIterator(true);
    }

    static DetailedTransactionIterator unbounded() {
        return new DetailedTransactionIterator(false);
    }

    // Function to return random zipcode
    private String getRandomZipcode()
    {
        String[] zipCode_Array = {zipcode_1, zipcode_2, zipcode_3};
        Random random = new Random();
        int randomIndex = random.nextInt(zipCode_Array.length);
        return zipCode_Array[randomIndex];
    }

    private DetailedTransactionIterator(boolean bounded) {
        this.bounded = bounded;
        this.timestamp = INITIAL_TIMESTAMP.getTime();
    }

    @Override
    public boolean hasNext() {
        if (this.index < data.size()) {
            return true;
        } else if (!bounded) {
            index = 0;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public DetailedTransaction next() {
        DetailedTransaction transaction = (DetailedTransaction)data.get(index++);

        // Assigning random zipcode to the transaction
        transaction.setZipcode(this.getRandomZipcode());

        // Setting the timestamp increased by 1 minute
        transaction.setTimestamp(timestamp);
        timestamp += ONE_MINUTE;

        return transaction;
    }

    // Designing the list of Transactions with each Transaction containing account id, timestamp, amount and zipcode.
    private static List<DetailedTransaction> data =
            Arrays.asList(
                    new DetailedTransaction(1L, 0L, 18.23, ""),
                    new DetailedTransaction(2L, 0L, 374.79, ""),
                    new DetailedTransaction(3L, 0L, 2.15, ""),
                    new DetailedTransaction(4L, 0L, 478.75, ""),
                    new DetailedTransaction(1L, 0L, 708.85, ""),
                    new DetailedTransaction(5L, 0L, 3.64, ""),
                    new DetailedTransaction(2L, 0L, 351.44, ""),
                    new DetailedTransaction(1L, 0L, 0.75, ""),
                    new DetailedTransaction(5L, 0L, 659.42, ""),
                    new DetailedTransaction(5L, 0L, 273.44, ""),
                    new DetailedTransaction(1L, 0L, 967.25, ""),
                    new DetailedTransaction(2L, 0L, 397.15, ""),
                    new DetailedTransaction(3L, 0L, 0.219, ""),
                    new DetailedTransaction(4L, 0L, 231.94, ""),
                    new DetailedTransaction(5L, 0L, 384.73, ""),
                    new DetailedTransaction(1L, 0L, 619.62, ""),
                    new DetailedTransaction(2L, 0L, 412.91, ""),
                    new DetailedTransaction(3L, 0L, 0.77, ""),
                    new DetailedTransaction(4L, 0L, 22.1, ""),
                    new DetailedTransaction(2L, 0L, 577.54, ""),
                    new DetailedTransaction(1L, 0L, 375.44, ""),
                    new DetailedTransaction(2L, 0L, 230.18, ""),
                    new DetailedTransaction(3L, 0L, 0.8, ""),
                    new DetailedTransaction(4L, 0L, 450.89, ""),
                    new DetailedTransaction(5L, 0L, 127.55, ""),
                    new DetailedTransaction(1L, 0L, 483.91, ""),
                    new DetailedTransaction(2L, 0L, 228.22, ""),
                    new DetailedTransaction(3L, 0L, 871.15, ""),
                    new DetailedTransaction(4L, 0L, 64.19, ""),
                    new DetailedTransaction(5L, 0L, 79.43, ""),
                    new DetailedTransaction(1L, 0L, 56.12, ""),
                    new DetailedTransaction(2L, 0L, 256.48, ""),
                    new DetailedTransaction(3L, 0L, 148.16, ""),
                    new DetailedTransaction(4L, 0L, 899.95, ""),
                    new DetailedTransaction(5L, 0L, 252.37, ""),
                    new DetailedTransaction(1L, 0L, 274.73, ""),
                    new DetailedTransaction(2L, 0L, 473.54, ""),
                    new DetailedTransaction(3L, 0L, 119.92, ""),
                    new DetailedTransaction(4L, 0L, 323.59, ""),
                    new DetailedTransaction(5L, 0L, 353.16, ""),
                    new DetailedTransaction(4L, 0L, 1.9, ""),
                    new DetailedTransaction(2L, 0L, 280.93, ""),
                    new DetailedTransaction(3L, 0L, 347.89, ""),
                    new DetailedTransaction(4L, 0L, 759.86, ""),
                    new DetailedTransaction(5L, 0L, 8.31, ""),
                    new DetailedTransaction(1L, 0L, 373.26, ""),
                    new DetailedTransaction(2L, 0L, 479.83, ""),
                    new DetailedTransaction(3L, 0L, 454.25, ""),
                    new DetailedTransaction(4L, 0L, 83.64, ""),
                    new DetailedTransaction(5L, 0L, 692.44, ""));
}
