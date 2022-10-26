import java.util.Objects;

public abstract class Book {

    protected String titleOfTheBook;
    protected String autor;
    protected int availability;
    protected int price;

    Book(String titleOfTheBook, String autor, int availability, int price) {
        this.titleOfTheBook = titleOfTheBook;
        this.autor = autor;
        this.availability = availability;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Название книги: " + titleOfTheBook + "\nАвтор: " + autor + "\nЦена: " + price + " руб" +
                "\nВ наличии " + availability + " шт";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Book book)) {
            return false;
        }

        return this.titleOfTheBook.equals(book.titleOfTheBook) && this.autor.equals(book.autor) &&
                book.price == this.price && book.availability == this.availability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOfTheBook, autor, price, availability);
    }
}