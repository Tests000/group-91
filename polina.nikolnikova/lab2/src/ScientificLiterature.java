import java.util.Objects;

public class ScientificLiterature extends Book {

    private final String scopeOfStudy;
    private final String difficultyLevel;

    ScientificLiterature(String titleOfTheBook, String autor, int availability, int price, String scopeOfStudy,
                         String difficultyLevel) {
        super(titleOfTheBook, autor, availability, price);
        this.scopeOfStudy = scopeOfStudy;
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public String toString() {
        return "Название книги: " + titleOfTheBook + "\nАвтор: " + autor + "\nСфера изучения: " + scopeOfStudy +
                "\nУровень сложности: " + difficultyLevel + "\nЦена: " + price + " руб" + "\nВ наличии " +
                availability + " шт";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ScientificLiterature book)) {
            return false;
        }

        return this.titleOfTheBook.equals(book.titleOfTheBook) && this.autor.equals(book.autor) &&
                this.scopeOfStudy.equals(book.scopeOfStudy) && this.difficultyLevel.equals(book.difficultyLevel) &&
                book.price == this.price && book.availability == this.availability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOfTheBook, autor, price, availability, scopeOfStudy, difficultyLevel);
    }
}