import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("queryIP = ");
        String str = in.nextLine();
        System.out.print(ValidateIpAddress.validateIpAddress(str));
        in.close();
    }
}
