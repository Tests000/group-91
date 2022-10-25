package classes;
import interfaces.Cat;
import java.util.Objects;


public abstract class CatImpl implements Cat {
    //Имя кiта
    protected final String name;

    //Кастрирован/Стерилизован ли кiт
    protected boolean isCastrated;
    //Лысый ли кiт
    protected boolean isBold;


    public CatImpl(String name){
        this.name = name;
        isCastrated = false;
        isBold = false;
    }

    protected String isCastratedToString(){
        if (isCastrated) return "Кастрирован...";
        else return "Не кастрирован!";
    }

    protected String isBoldToString(){
        if (isCastrated) return "Лысый...";
        else return "Не лысый!";
    }

    @Override
    public void showInfo(){
        System.out.print(this);
    }

    @Override
    public void castrate() {
        showInfo();
        if (isCastrated){
            System.out.println("Резать уже нечего.");
        }
        else {
            System.out.println("После этого резать будет нечего.");
            isCastrated = true;
        }
    }

    @Override
    public void haircut() {
        showInfo();
        if (isBold){
            System.out.println("Кот и так лысый!.");
        }
        else {
            System.out.println("Теперь у вас Фараон!");
            isBold= true;
        }
    }



    @Override
    public abstract String toString();

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }



}
