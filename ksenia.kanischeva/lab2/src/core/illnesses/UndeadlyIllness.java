package core.illnesses;

public abstract class UndeadlyIllness extends AbstractIllness {



    public UndeadlyIllness(int damage, String name) {
        super(damage, name);
    }

    public void leave() {
        System.out.println("Человек здоров!!");
    }

    @Override
    public String toString(){
        return super.toString() + "несмертельная болезнь - ";
    }


    public String getGoodNews(){
        return "Хорошая новость для тебя, ты скоро вылечишься от " + super.getName();
    }

}
