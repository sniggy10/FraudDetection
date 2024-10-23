package spendreport.detailed;

import java.util.Objects;
import java.util.Random;

public class DetailedTransaction {

    private long accountId;

    private long timestamp;

    private double amount;

    // Adding the zipcode detail to the class
    private String zipcode;

    public DetailedTransaction() {
    }

    public DetailedTransaction(long accountId, long timestamp, double amount, String zipcode) {
        this.accountId = accountId;
        this.timestamp = timestamp;
        this.amount = amount;
        this.zipcode = zipcode;
    }

    public long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null && this.getClass() != o.getClass()) {
            return false;
        } else {
            DetailedTransaction that = (DetailedTransaction)o;
            return this.accountId == that.accountId
                    && this.timestamp == that.timestamp
                    && Double.compare(that.amount, this.amount) == 0
                    && this.zipcode.equalsIgnoreCase(that.zipcode);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.accountId, this.timestamp, this.amount, this.zipcode});
    }

    public String toString() {
        return "Transaction{accountId=" + this.accountId + ", timestamp=" + this.timestamp + ", amount=" + this.amount + ", zipcode=" + this.zipcode + '}';
    }
}
