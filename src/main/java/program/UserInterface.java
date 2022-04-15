package program;

import ciphering.Cipher;
import java.util.Scanner;

public class UserInterface {
    private Cipher cipher;
    private final Scanner scanner;

    public UserInterface(Scanner scanner){
        this.scanner = scanner;
        this.cipher = null;
    }

    public void start() {

        while (true) {
            printInfo();
            String command = scanner.nextLine();
            if (command.equals("X")) {
                break;
            }
            System.out.println("Your message:");
            String text = scanner.nextLine();
            this.cipher = CipheringMethod.getCipheringMethod(command, text);
            if(this.cipher != null){
                System.out.println("Encrypted:");
                System.out.println(this.cipher.encrypt());
                System.out.println();
            }
        }
    }

    public void printInfo(){
        System.out.println("Chose a ciphering method:");
        System.out.println(" 1 - Cesar Cipher");
        System.out.println(" 2 - Rail Fence Cipher");
        System.out.println(" 3 - Baconian Cipher");
        System.out.println(" X - stop");
    }
}
