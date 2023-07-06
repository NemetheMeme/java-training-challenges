package design_patterns.proxy;

public class Apartment {
        private String location;
        private int monthlyRentCost;
        private boolean isRented; // Additional property to check
                                  // if the apartment is already rented or not
        private Student rentedBy;

    public Apartment(String location, int monthlyRentCost) {
        this.location = location;
        this.monthlyRentCost = monthlyRentCost;
        this.isRented = false;
        this.rentedBy = null;
    }

    public String getLocation() {
        return location;
    }

    public int getMonthlyRentCost() {
        return monthlyRentCost;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public Student getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(Student rentedBy) {
        this.rentedBy = rentedBy;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "location='" + location + '\'' +
                ", monthlyRentCost=" + monthlyRentCost +
                ", isRented=" + isRented +
                ", rentedBy=" + rentedBy +
                '}';
    }
}
