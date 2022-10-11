package classes;

// снаряд
public abstract class Projectile
        extends AmmunitionImpl{
    // радиус поражения в м
    protected final float damageRadius;

    public Projectile(String name, float damageRadius){
        super(name);
        this.damageRadius = damageRadius;
    }
}
