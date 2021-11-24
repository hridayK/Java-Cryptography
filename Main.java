import java.text.NumberFormat.Style;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the Message ");
        // String message = sc.nextLine();
        
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

        //Testing for Hill Cipher
        // Hill obj = new Hill();
        // obj.allstff();

        
        VigenereCipher vc = new VigenereCipher();
        String key;
        String message;
        System.out.println("\n\nEnter the Message to be Encrypted:\t");
        message = sc.nextLine();
        System.out.println("\n\nEnter the Encryption Key:\t");
        key = sc.nextLine();
        String ensg = vc.en(message, key);
        System.out.println("\n\nString: " + message);
        System.out.println("\n\nEncrypted message:\t" + ensg);
        System.out.println("\n\nDecrypted message:\t" + vc.de(ensg, key));
    }

    static void display(String arr[]){
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
            System.out.println();
        }
    }
}
