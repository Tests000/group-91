package Classes;

import Interfaces.InterfacePlant;

import java.util.Objects;

public abstract class Plant implements InterfacePlant {
    protected final int height;
    protected boolean isNeedWatering = true;
    protected String name;

    public Plant(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public void water() {
        if (isNeedWatering) {
            isNeedWatering = false;
            System.out.printf("Растение полито %s", name);
        }
    }

    public void grow() {
    }

    public boolean isNeedWatering() {
        return isNeedWatering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Plant plant)) {
            return false;
        }
        return name.equals(plant.name);
    }

    @Override
    public String toString() {
        return name + ", height = " + height + " ";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
