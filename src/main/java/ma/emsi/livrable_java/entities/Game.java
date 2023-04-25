package ma.emsi.livrable_java.entities;

import java.util.Objects;

public class Game {
    private String title;
    private String genre;
    private int releaseYear;
    private double price;
    private int rating;


    public Game(String title, String genre, int releaseYear, double price, int rating) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.price = price;
        this.rating = rating;

    }

    public Game() {

    }

    // Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return getReleaseYear() == game.getReleaseYear() && Double.compare(game.getPrice(), getPrice()) == 0 && getRating() == game.getRating() && Objects.equals(getTitle(), game.getTitle()) && Objects.equals(getGenre(), game.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getGenre(), getReleaseYear(), getPrice(), getRating());
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
