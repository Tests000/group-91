public final class RoboticPAWPatrolDogMember extends PAWPatrolDogMember {

    public RoboticPAWPatrolDogMember(String name, String role) {

        super(name, "робот", null, role, null, null, null);
    }

    @Override
    public void UseSpecialPower() {
        System.out.print(Name + "не имеет суперспособности! Он просто робот :)");
    }

    @Override
    public void UseVehicle() {
        System.out.print(Name + " не имеет собственного транспорта :(");
    }

    @Override
    public void SayCatchphrase() {
        System.out.print(Name + " не умеет разговаривать! Он гавкает в ответ :)");
    }

    @Override
    public String toString() {
        return Name + ": " + Breed + "%nРоль: " + Role;
    }
}