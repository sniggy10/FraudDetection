package spendreport.detailed;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DetailedTransactionIterator implements Iterator<DetailedTransaction>, Serializable {
    private static final long serialVersionUID = 1L;

    private static final Timestamp INITIAL_TIMESTAMP = Timestamp.valueOf("2024-01-01 00:00:00");

    private static final long SIX_MINUTES = 6 * 60 * 1000;

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
        transaction.setTimestamp(timestamp);
        timestamp += SIX_MINUTES;
        return transaction;
    }

    // Designing the list of Transactions with each Transaction containing accountid, timestamp, amount and zipcode.
    // The zipcodes have been uniformly randomly set across different transactions.
    private static List<DetailedTransaction> data =
            Arrays.asList(
                    new DetailedTransaction(1, 0L, 18.23, zipcode_2),
                    new DetailedTransaction(2, 0L, 374.79, zipcode_3),
                    new DetailedTransaction(3, 0L, 112.15, zipcode_2),
                    new DetailedTransaction(4, 0L, 478.75, zipcode_1),
                    new DetailedTransaction(5, 0L, 208.85, zipcode_3),
                    new DetailedTransaction(1, 0L, 379.64, zipcode_1),
                    new DetailedTransaction(2, 0L, 351.44, zipcode_3),
                    new DetailedTransaction(3, 0L, 320.75, zipcode_1), // Fraudulent transaction for id:3 and zipcode_1
                    new DetailedTransaction(4, 0L, 259.42, zipcode_3),
                    new DetailedTransaction(5, 0L, 273.44, zipcode_2),
                    new DetailedTransaction(1, 0L, 267.25, zipcode_3),
                    new DetailedTransaction(2, 0L, 397.15, zipcode_3),
                    new DetailedTransaction(3, 0L, 0.219, zipcode_1), // Fraudulent transaction for id:3 and zipcode_1
                    new DetailedTransaction(4, 0L, 231.94, zipcode_2),
                    new DetailedTransaction(5, 0L, 19.62, zipcode_3), // Fraudulent transaction for id:5 and zipcode_3
                    new DetailedTransaction(5, 0L, 384.73, zipcode_3), // Fraudulent transaction for id:5 and zipcode_3
                    new DetailedTransaction(2, 0L, 412.91, zipcode_2),
                    new DetailedTransaction(3, 0L, 770.01, zipcode_1), // Fraudulent transaction for id:3 and zipcode_1
                    new DetailedTransaction(4, 0L, 22.1, zipcode_3),
                    new DetailedTransaction(5, 0L, 377.54, zipcode_2),
                    new DetailedTransaction(1, 0L, 375.44, zipcode_1),
                    new DetailedTransaction(2, 0L, 230.18, zipcode_3),
                    new DetailedTransaction(3, 0L, 0.8, zipcode_3),
                    new DetailedTransaction(4, 0L, 350.89, zipcode_1),
                    new DetailedTransaction(5, 0L, 127.55, zipcode_2),
                    new DetailedTransaction(1, 0L, 483.91, zipcode_3),
                    new DetailedTransaction(2, 0L, 228.22, zipcode_1),
                    new DetailedTransaction(3, 0L, 871.15, zipcode_2),
                    new DetailedTransaction(4, 0L, 64.19, zipcode_1),
                    new DetailedTransaction(5, 0L, 79.43, zipcode_2),
                    new DetailedTransaction(1, 0L, 56.12, zipcode_1),
                    new DetailedTransaction(2, 0L, 256.48, zipcode_2),
                    new DetailedTransaction(3, 0L, 148.16, zipcode_3),
                    new DetailedTransaction(4, 0L, 199.95, zipcode_2),
                    new DetailedTransaction(5, 0L, 252.37, zipcode_1),
                    new DetailedTransaction(1, 0L, 274.73, zipcode_3),
                    new DetailedTransaction(2, 0L, 473.54, zipcode_2),
                    new DetailedTransaction(3, 0L, 119.92, zipcode_2),
                    new DetailedTransaction(4, 0L, 323.59, zipcode_1),
                    new DetailedTransaction(5, 0L, 353.16, zipcode_2),
                    new DetailedTransaction(1, 0L, 211.9, zipcode_1),
                    new DetailedTransaction(2, 0L, 280.93, zipcode_2),
                    new DetailedTransaction(3, 0L, 347.89, zipcode_3),
                    new DetailedTransaction(4, 0L, 459.86, zipcode_3),
                    new DetailedTransaction(5, 0L, 82.31, zipcode_2),
                    new DetailedTransaction(1, 0L, 373.26, zipcode_1),
                    new DetailedTransaction(2, 0L, 479.83, zipcode_3),
                    new DetailedTransaction(3, 0L, 454.25, zipcode_1),
                    new DetailedTransaction(4, 0L, 83.64, zipcode_2),
                    new DetailedTransaction(5, 0L, 292.44, zipcode_3));
}
