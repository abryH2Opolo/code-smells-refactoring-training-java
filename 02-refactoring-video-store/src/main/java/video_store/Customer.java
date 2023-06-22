package video_store;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public Customer(String name) {
        this.name = name;
    }

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = getTotalAmount();
        int frequentRenterPoints = getFrequentRenterPoints();
        return generateStatement(totalAmount, frequentRenterPoints);
    }

    private double getTotalAmount() {
        int amount = 0;
        for (Rental rental: rentals) {
            amount += rental.determineAmount();
        }
        return amount;
    }

    private String generateStatement(double totalAmount, int points) {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental: rentals) {
            result += "\t" + rental.getMovieTitle() + "\t"
                + String.valueOf(rental.determineAmount()) + "\n";
        }
        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(points) + " frequent renter points\n";
        return result;
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getPoints();
        }
        return frequentRenterPoints;
    }
}
