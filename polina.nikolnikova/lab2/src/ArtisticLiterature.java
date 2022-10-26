import java.util.Objects;

public class ArtisticLiterature extends Book {

    private final String genre;
    private final String content;
    ArtisticLiterature(String titleOfTheBook, String autor, int availability, int price, String genre, String content) {
        super(titleOfTheBook, autor, availability, price);
        this.genre = genre;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Название книги: " + titleOfTheBook + "\nАвтор: " + autor + "\nЖанр: " + genre + "\nСодержание: " +
                content + "\nЦена: " + price + " руб" + "\nВ наличии " + availability + " шт";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ArtisticLiterature book)) {
            return false;
        }

        return this.titleOfTheBook.equals(book.titleOfTheBook) && this.autor.equals(book.autor) &&
                this.genre.equals(book.genre) && this.content.equals(book.content) && book.price == this.price &&
                book.availability == this.availability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOfTheBook, autor, price, availability, genre, content);
    }
}