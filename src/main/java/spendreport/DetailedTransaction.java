package spendreport;

import org.apache.flink.walkthrough.common.entity.Transaction;

public class DetailedTransaction {

    private long accountId;

    private long timestamp;

    private double amount;

    private String zipCode;

    public DetailedTransaction(Transaction transaction, String zipCode) {
        this.zipCode = zipCode;
        this.accountId = transaction.getAccountId();
        this.timestamp = transaction.getTimestamp();
        this.amount = transaction.getAmount();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
