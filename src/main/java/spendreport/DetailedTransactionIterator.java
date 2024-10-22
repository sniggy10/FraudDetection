package spendreport;

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

    private static List<DetailedTransaction> data =
            Arrays.asList(
                    new DetailedTransaction(1, 0L, 188.23),
                    new DetailedTransaction(2, 0L, 374.79),
                    new DetailedTransaction(3, 0L, 112.15),
                    new DetailedTransaction(4, 0L, 478.75),
                    new DetailedTransaction(5, 0L, 208.85),
                    new DetailedTransaction(1, 0L, 379.64),
                    new DetailedTransaction(2, 0L, 351.44),
                    new DetailedTransaction(3, 0L, 320.75),
                    new DetailedTransaction(4, 0L, 259.42),
                    new DetailedTransaction(5, 0L, 273.44),
                    new DetailedTransaction(1, 0L, 267.25),
                    new DetailedTransaction(2, 0L, 397.15),
                    new DetailedTransaction(3, 0L, 0.219),
                    new DetailedTransaction(4, 0L, 231.94),
                    new DetailedTransaction(5, 0L, 384.73),
                    new DetailedTransaction(1, 0L, 419.62),
                    new DetailedTransaction(2, 0L, 412.91),
                    new DetailedTransaction(3, 0L, 0.77),
                    new DetailedTransaction(4, 0L, 22.10),
                    new DetailedTransaction(5, 0L, 377.54),
                    new DetailedTransaction(1, 0L, 375.44),
                    new DetailedTransaction(2, 0L, 230.18),
                    new DetailedTransaction(3, 0L, 0.80),
                    new DetailedTransaction(4, 0L, 350.89),
                    new DetailedTransaction(5, 0L, 127.55),
                    new DetailedTransaction(1, 0L, 483.91),
                    new DetailedTransaction(2, 0L, 228.22),
                    new DetailedTransaction(3, 0L, 871.15),
                    new DetailedTransaction(4, 0L, 64.19),
                    new DetailedTransaction(5, 0L, 79.43),
                    new DetailedTransaction(1, 0L, 56.12),
                    new DetailedTransaction(2, 0L, 256.48),
                    new DetailedTransaction(3, 0L, 148.16),
                    new DetailedTransaction(4, 0L, 199.95),
                    new DetailedTransaction(5, 0L, 252.37),
                    new DetailedTransaction(1, 0L, 274.73),
                    new DetailedTransaction(2, 0L, 473.54),
                    new DetailedTransaction(3, 0L, 119.92),
                    new DetailedTransaction(4, 0L, 323.59),
                    new DetailedTransaction(5, 0L, 353.16),
                    new DetailedTransaction(1, 0L, 211.90),
                    new DetailedTransaction(2, 0L, 280.93),
                    new DetailedTransaction(3, 0L, 347.89),
                    new DetailedTransaction(4, 0L, 459.86),
                    new DetailedTransaction(5, 0L, 82.31),
                    new DetailedTransaction(1, 0L, 373.26),
                    new DetailedTransaction(2, 0L, 479.83),
                    new DetailedTransaction(3, 0L, 454.25),
                    new DetailedTransaction(4, 0L, 83.64),
                    new DetailedTransaction(5, 0L, 292.44));
}
