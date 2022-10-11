package classes;

import interfaces.Ammunition;

import java.util.Objects;

// реализация интерфейса
public abstract class AmmunitionImpl
        implements Ammunition {

    // имя снаряда - может что-то вроде серии, что будет отличать одну партию от другой
    // имеется в виду партия снарядов в одном из типов
    protected final String name;

    // проверяем использовался ли снаряд (2 раза мы его испытать не можем)
    protected boolean isUsed;

    public AmmunitionImpl(String name){
        this.name = name;
        isUsed = false;
    }

    @Override
    public abstract String toString();

    @Override
    public void showInfo(){
        System.out.print(toString());
    }

    @Override
    public void experience() {
        showInfo();
        if (isUsed){
            System.out.println("Снаряд уже был использован");
        }
        else {
            System.out.println("Успешное испытание");
            isUsed = true;
        }
    }

    @Override
    public void disposal() {
        if (isUsed){
            System.out.println("Боеприпас уже был использован, утилизация невозможна");
        }
        else {
            showInfo();
            System.out.println("Успешная утилизация");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass()))
            return false;
        return ((Projectile)obj).name.equalsIgnoreCase(name);
    }

    protected String isUsedToString(){
        return
                isUsed ?
                "Использовано\n" :
                "Не использовано\n";
    }
}
