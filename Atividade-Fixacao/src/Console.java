import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInt(String msg){
        int num = 0;

        System.out.print(msg);

        while(true){
            try {
                num = scanner.nextInt();
                break;
            
            } catch (InputMismatchException e) {
                System.out.println("O valor informado não é um inteiro. Digite novamente...");
                System.out.print(">> ");
            
            } finally {
                scanner.nextLine();
            }
        }

        return num;
    }

    public static float lerFloat(String msg) {
        float num = 0;

        System.out.print(msg);

        while(true){
            try {
                num = scanner.nextFloat();
                break;
            
            } catch (InputMismatchException e) {
                System.out.println("O valor informado não é um float. Digite novamente...");
                System.out.print(">> ");
            
            } finally {
                scanner.nextLine();
            }
        }
        return num;
    }

    public static String lerString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }


}