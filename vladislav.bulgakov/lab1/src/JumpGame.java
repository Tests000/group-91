public class JumpGame {

    public static void printArray(int[] array) {
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int getMinimumJumps(int[]array, int size){
        int[] jumps = new int [size];
        int count = 0;
        int jumpsCount = size;
        int index = 0;

        jumps[0] = array[index];
        while(jumps[0] != 0) {
            boolean isNull = false;

            while(index < size - 1 && !isNull){
                int newPos = index + jumps[count];
                if(newPos > size - 1){
                    jumps[count] = size - 1 - index;
                    index = size - 1;
                    count++;
                    jumps[count] = array[index];
                }
                else {
                    if (index < size - 1 && array[newPos] != 0 || newPos == size - 1) {
                        index += jumps[count];
                        count++;
                        jumps[count] = array[index];
                    }
                    if (index < size - 1 && array[newPos] == 0) {
                        isNull = true;
                    }
                }
            }

            if(count < jumpsCount && !isNull){
                jumpsCount = count;
            }

            if(jumps[count] != 0){
                jumps[count]--;
            }
            while(index > 0 && jumps[count] == 0){
                count--;
                index -= jumps[count];
                jumps[count]--;
            }
        }

        return jumpsCount;
    }
}