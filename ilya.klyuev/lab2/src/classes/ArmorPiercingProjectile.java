package classes;

// бронебойный снаряд
public class ArmorPiercingProjectile
        extends Projectile{
    // пробивание брони в мм
    private final float armorPenetration;

    public ArmorPiercingProjectile
            (String name, float damageRadius, float armorPenetration) {
        super(name, damageRadius);
        this.armorPenetration = armorPenetration;
    }

    @Override
    public String toString() {
        return String.format(
                "Бронебойный снаряд %s\n" +
                "Радиус поражения %.3f м\n" +
                "Пробивание брони %.3f мм\n" +
                isUsedToString(),
                name,
                damageRadius,
                armorPenetration
        );
    }
}
