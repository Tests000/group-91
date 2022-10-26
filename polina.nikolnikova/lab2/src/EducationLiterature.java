import java.util.Objects;

public class EducationLiterature extends Book implements AdditionalInformationable {

    private final String objectOfStudy;
    private final int studyClass;

    EducationLiterature(String titleOfTheBook, String autor, int availability, int price, String objectOfStudy,
                        int studyClass) {
        super(titleOfTheBook, autor, availability, price);
        this.objectOfStudy = objectOfStudy;
        this.studyClass = studyClass;
    }

    @Override
    public String toString() {
        return "Название книги: " + titleOfTheBook + "\nАвтор: " + autor + "\nПредмет: " + objectOfStudy +
                "\nКласс изучения: " + studyClass + "\nЦена: " + price + " руб"+ "\nВ наличии " + availability + " шт";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EducationLiterature book)) {
            return false;
        }

        return this.titleOfTheBook.equals(book.titleOfTheBook) && this.autor.equals(book.autor) &&
                this.objectOfStudy.equals(book.objectOfStudy) && book.studyClass == this.studyClass &&
                book.price == this.price && book.availability == this.availability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleOfTheBook, autor, price, availability, objectOfStudy, studyClass);
    }

    @Override
    public void gettingAdditionalPieces(int n) {
        if (n == 1) {
            System.out.println("Продается с диском");
        } else {
            System.out.println("Продается без дополнительной литературы");
        }
    }
}