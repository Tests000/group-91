public final class AllergicPAWPatrolDogMember extends PAWPatrolDogMember {

    private final String Allergy;

    public AllergicPAWPatrolDogMember(String name, String breed, int age,
                                      String role, String vehicle, String specialPower, String catchphrase,
                                      String allergy) {

        super(name, breed, age, role, vehicle, specialPower, catchphrase);
        Allergy = allergy;
    }

    public void SmellAllergy() {
        System.out.print(Name + " учуял: " + Allergy + ". Чихает!");
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof AllergicPAWPatrolDogMember allergicPAWPatrolDogMember) {
            return super.equals(obj) && Allergy.equals(allergicPAWPatrolDogMember.Allergy);
        }

        return false;
    }
}