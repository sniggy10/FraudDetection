package spendreport.detailed;

import java.util.Objects;

public class DetailedAlert {

    private long id;
    private String zipCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZip() {
        return zipCode;
    }

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
        return "Alert{"
                + "id=" + id
                + ", zip code=" +zipCode
                + '}';
    }
}

