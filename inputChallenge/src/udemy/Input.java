package udemy;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        int count = 1;
        int sum = 0;
        Scanner keyboard = new Scanner(System.in);

        while( count < 11 ){
            System.out.print("Enter number #" + count+": ");
            if( keyboard.hasNextInt()){
                count++;
                sum += keyboard.nextInt();
            }
            else System.out.println("wrong input");
            keyboard.nextLine();
        }

        System.out.println("Sum: "+ sum);
        keyboard.close();
    }
}
