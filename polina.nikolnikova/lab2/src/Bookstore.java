/*Описать иерархию классов для книжного магазина, которая должна содержать:

- интерфейс
- абстрактный класс
- несколько наследников одного класса (или реализаций интерфейса)
- переопределение метода toString
- переопределение методов equals и hashCode
- переопределение публичного метода класса-предка
- использование конструктора с параметрами класса-предка

В коде программы продемонстрировать использование принципов ООП на основе созданной иерархии классов.
*/

import java.util.Objects;

interface Printable {
    String toString();
}

abstract class Book implements Printable {

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

    public String toString() {
        return "Название книги: " + titleOfTheBook + "\nАвтор: " + autor + "\nЦена: " + price + " руб" + "\nВ наличии " + availability + " шт";
    }

    public boolean equals(Object object) {
        if (!(object instanceof Book book)) {
            return false;
        }

        return this.titleOfTheBook.equals(book.titleOfTheBook) && this.autor.equals(book.autor) && book.price == this.price
                && book.availability == this.availability;
    }

    public int hashCode(){
        return Objects.hash(titleOfTheBook, autor, price, availability);
    }
}

class EducationLiterature extends Book {

    private final String objectOfStudy;
    private final int studyClass;

    EducationLiterature(String titleOfTheBook, String autor, int availability, int price, String objectOfStudy, int studyClass) {
        super(titleOfTheBook, autor, availability, price);
        this.objectOfStudy = objectOfStudy;
        this.studyClass = studyClass;
    }

    @Override
    public String toString() {
        return "Название книги: " + titleOfTheBook + "\nАвтор: " + autor + "\nПредмет: " + objectOfStudy + "\nКласс изучения: " + studyClass +
                "\nЦена: " + price + " руб"+ "\nВ наличии " + availability + " шт";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EducationLiterature book)) {
            return false;
        }

        return this.titleOfTheBook.equals(book.titleOfTheBook) && this.autor.equals(book.autor) && this.objectOfStudy.equals(book.objectOfStudy)
                && book.studyClass == this.studyClass && book.price == this.price && book.availability == this.availability;
    }

    @Override
    public int hashCode(){
        return Objects.hash(titleOfTheBook, autor, price, availability, objectOfStudy, studyClass);
    }
}

class ScientificLiterature extends Book {

    private final String scopeOfStudy;
    private final String difficultyLevel;

    ScientificLiterature(String titleOfTheBook, String autor, int availability, int price, String scopeOfStudy, String difficultyLevel) {
        super(titleOfTheBook, autor, availability, price);
        this.scopeOfStudy = scopeOfStudy;
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public String toString() {
        return "Название книги: " + titleOfTheBook + "\nАвтор: " + autor + "\nСфера изучения: " + scopeOfStudy + "\nУровень сложности: " +
                difficultyLevel + "\nЦена: " + price + " руб" + "\nВ наличии " + availability + " шт";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ScientificLiterature book)) {
            return false;
        }

        return this.titleOfTheBook.equals(book.titleOfTheBook) && this.autor.equals(book.autor) && this.scopeOfStudy.equals(book.scopeOfStudy)
                && this.difficultyLevel.equals(book.difficultyLevel) && book.price == this.price && book.availability == this.availability;
    }

    @Override
    public int hashCode(){
        return Objects.hash(titleOfTheBook, autor, price, availability, scopeOfStudy, difficultyLevel);
    }
}

class ArtisticLiterature extends Book {

    private final String genre;
    private final String content;
    ArtisticLiterature(String titleOfTheBook, String autor, int availability, int price, String genre, String content) {
        super(titleOfTheBook, autor, availability, price);
        this.genre = genre;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Название книги: " + titleOfTheBook + "\nАвтор: " + autor + "\nЖанр: " + genre + "\nСодержание: " + content + "\nЦена: " + price +
                " руб" + "\nВ наличии " + availability + " шт";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ArtisticLiterature book)) {
            return false;
        }

        return this.titleOfTheBook.equals(book.titleOfTheBook) && this.autor.equals(book.autor) && this.genre.equals(book.genre)
                && this.content.equals(book.content) && book.price == this.price && book.availability == this.availability;
    }

    @Override
    public int hashCode(){
        return Objects.hash(titleOfTheBook, autor, price, availability, genre, content);
    }
}

public class Bookstore {
    public static void main(String[] args) {
    Book book = new ArtisticLiterature("Денискины рассказы", "Виктор Юзефович Драгунский", 7, 170,
            "Литературный цикл", "Первый день, Похититель собак, Рыцари, Слон и радио, Старый мореход");
    System.out.println(book);

    Book book1 = new EducationLiterature("Учебное пособие", "Гарик Гагикович Петросян", 12, 500,
            "Алгебра", 11);
        System.out.println(book1);

    Book book2 = new ScientificLiterature("Познание", "Игорь Петрович Мешков", 3, 740,
            "Ядерная физика", "Начальный");
    System.out.println(book2);
    }
}