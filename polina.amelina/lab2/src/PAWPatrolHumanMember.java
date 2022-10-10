public class PAWPatrolHumanMember extends Human implements PAWPatrolMember {

    protected final String Role;
    protected final String Vehicle;
    protected final String Catchphrase;

    public PAWPatrolHumanMember(String name, Integer age,
                                String role, String vehicle, String catchphrase) {

        super(name, age);
        Role = role;
        Vehicle = vehicle;
        Catchphrase = catchphrase;
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

        if (obj instanceof PAWPatrolHumanMember pawPatrolHumanMember) {
            return super.equals(obj) && Role.equals(pawPatrolHumanMember.Role)
                    && Vehicle.equals(pawPatrolHumanMember.Vehicle)
                    && Catchphrase.equals(pawPatrolHumanMember.Catchphrase);
        }

        return false;
    }
}