package video_store;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    double determineAmount(int daysRented) {
        double movieAmount = 0;
        switch (priceCode) {
            case REGULAR:
                movieAmount = 2;
                if (daysRented > 2) {
                    movieAmount += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                movieAmount = daysRented * 3;
                break;
            case CHILDRENS:
                movieAmount = 1.5;
                if (daysRented > 3){
                    movieAmount += (daysRented - 3) * 1.5;
                }
                break;
        }
        return movieAmount;
    }

    int extracted(int daysRented1) {
        int points;
        if (priceCode == NEW_RELEASE
            && daysRented1 > 1) {
            points = 2;
        }else{
            points =1;
        }
        return points;
    }
}
