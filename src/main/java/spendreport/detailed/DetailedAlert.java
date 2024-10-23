package spendreport.detailed;

import java.util.Objects;

public class DetailedAlert {

    private long id;

    // Adding the zipcode of the alleged fraudulent activity.
    private String zipCode;

    // This sets the format of the alert message we want to generate and display for the user.
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Get function for the zipcode of the alleged fraudulent activity.
    public String getZip() {
        return zipCode;
    }

    // Set function for the zipcode of the alleged fraudulent activity.
    public void setZip(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DetailedAlert detailedAlert = (DetailedAlert) o;
        return id == detailedAlert.getId()
                && zipCode.equalsIgnoreCase(detailedAlert.getZip());
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return
//        "DetailedAlert{" +
                this.message;
//                + "id=" + id
//                + ", zip code=" +zipCode
//                + '}';
    }

    // This message is set for getting the alert for fraudalent transactions.
    // It is set in DetailedFraudDetector.java class.
    public void setMessage(String message) {
        this.message = message;
    }

}

