public class PAWPatrolDogMember extends Dog implements PAWPatrolMember {

    protected final String Role;
    protected final String Vehicle;
    protected final String SpecialPower;
    protected final String Catchphrase;

    public PAWPatrolDogMember(String name, String breed, Integer age,
                               String role, String vehicle, String specialPower, String catchphrase) {

        super(name, breed, age);
        Role = role;
        Vehicle = vehicle;
        SpecialPower = specialPower;
        Catchphrase = catchphrase;
    }

    public void UseSpecialPower() {
        System.out.print(Name + " использует: " + SpecialPower);
    }

    @Override
    public void UseVehicle() {
        System.out.print(Name + " использует: " + Vehicle);
    }

    @Override
    public void SayCatchphrase() {
        System.out.print(Catchphrase);
    }

    @Override
    public String toString() {
        return super.toString() + "%nРоль: " + Role;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof PAWPatrolDogMember pawPatrolDogMember) {
            return super.equals(obj) && Role.equals(pawPatrolDogMember.Role)
                    && Vehicle.equals(pawPatrolDogMember.Vehicle)
                    && SpecialPower.equals(pawPatrolDogMember.SpecialPower)
                    && Catchphrase.equals(pawPatrolDogMember.Catchphrase);
        }

        return false;
    }
}