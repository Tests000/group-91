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
        if (isBold) return "Лысый...";
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
            System.out.println("\nРезать уже нечего.");
        }
        else {
            System.out.println("\nПосле этого резать будет нечего.");
            isCastrated = true;
        }
    }

    @Override
    public void haircut() {;
        if (isBold){
            System.out.println("\nКот и так лысый!\n");
        }
        else {
            System.out.println("\nТеперь у вас Фараон!\n");
            isBold= true;
        }
    }



    @Override
    public abstract String toString();

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass()))
            return false;
        return ((HomeCat)obj).name.equalsIgnoreCase(name);
    }

}
