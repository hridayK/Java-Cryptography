import java.text.NumberFormat.Style;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        //Testing for Caesar Cipher
        /*Caesar cs = new Caesar();
        int key = (int) (Math.random() * 10000);

        String x = cs.encrypt(message, key);
        System.out.println(x);

        String y = cs.decrypt(x, key);
        System.out.println(y);

        String [] possible = new String[26];
        possible = cs.bruteForce(x);

        System.out.println("The possible message is:");
        display(possible);*/
    }

    static void display(String arr[]){
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
            System.out.println();
        }
    }
}
