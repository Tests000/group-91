import java.util.Objects;

public class ArtisticLiterature extends Book {

    private final String genre;
    private final String content;
    ArtisticLiterature(String titleOfTheBook, String author, int availability, int price, String genre, String content) {
        super(titleOfTheBook, author, availability, price);
        this.genre = genre;
        this.content = content;
        getType();
    }

    @Override
    public String getType() {
        type = TypeOfBook.ARTISTIC;
        return "Тип книги: Художественная литература\n";
    }

    @Override
    public String toString() {
        return getType() + "Название книги: " + titleOfTheBook + "\nАвтор: " + author + "\nЖанр: " + genre +
                "\nСодержание: " + content + "\nЦена: " + price + " руб" + "\nВ наличии " + availability + " шт";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ArtisticLiterature book)) {
            return false;
        }

        return this.titleOfTheBook.equals(book.titleOfTheBook) && this.author.equals(book.author) &&
                this.genre.equals(book.genre) && this.content.equals(book.content) && book.price == this.price &&
                book.availability == this.availability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOfTheBook, author, price, availability, genre, content);
    }
}