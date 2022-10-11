package classes;

import interfaces.AntiUSAAmmunition;

// осклочный/кластерный снаряд
public class FragmentationProjectile
        extends Projectile
        implements AntiUSAAmmunition {
    // количество поражющих элементов
    private final int damagingElementsNumber;

    public FragmentationProjectile
            (String name, float damageRadius, int damagingElementsNumber) {

        super(name, damageRadius);
        this.damagingElementsNumber = damagingElementsNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Фугасный снаряд %s\n" +
                "Радиус поражения %.3f м\n" +
                "Количество поражающих элементов %d\n" +
                isUsedToString(),
                name,
                damageRadius,
                damagingElementsNumber
        );
    }

    @Override
    public void atackUSACity(String cityName) {
        showInfo();
        if (isUsed){
            System.out.println("Снаряд уже был использован");
        }
        else {
            System.out.printf("Город %s был успешно атакован\n", cityName);
            isUsed = true;
        }
    }
}
