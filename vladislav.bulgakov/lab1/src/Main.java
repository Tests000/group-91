public class Main {
    public static void main(String[] args) {

        //примеры
        //{2,3,1,1,4,1,1,1,0}; size = 9; count = 3;  //оптимальный путь не первый найденный
        //{2,4,1,0,2,0,1}; size = 7; count = 3;      //обход нулей
        //{2,1,3,1,4,1,2,0}; size = 8; count = 3      //перелет за границу и нуль на конце
        //{2,3,0,1,4}; size = 5; count = 2      //пример из задания

        int size = CorrectInput.getIntInRange(1, 1000);
        int[] array = CorrectInput.getIntArray(size);

        JumpGame.printArray(array);
        int jumpsCount = JumpGame.getMinimumJumps(array, size);
        System.out.println("\n" + jumpsCount);
    }
}