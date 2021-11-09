//class matrix to get the multiplication of Matrix and Transpose Matrix
import java.util.Scanner;

class Hill{

    //returns array removing mod of each element
    int[] reduce(int arr[]){
        //reduce the array to the mod of 26
        for(int i = 0; i<arr.length; i++){
            arr[i] = arr[i]%26;
        }
        return arr;
    }
    char[] encrypt(int arr[]){
        char ch[] = new char[arr.length];
        for(int i = 0; i<arr.length; i++){
         ch[i] = (char)(arr[i]+65);
        }
        return ch;
    }


    //generates random key
    int[][] generateKey(int txt[]){
        int key[][] = new int[txt.length][txt.length];
        for(int i = 0; i<txt.length; i++){
            for(int j = 0; j<txt.length; j++){
                key[i][j] = (int)((Math.random()*26)+65);
                //print key
                System.out.print(key[i][j]+" ");
            }
            System.out.println();
        }
         return key; 
    }


    //convert message to int and returns array
    int[] convertmsg(String msg){
        int arr[] = new int[msg.length()];
        for(int i = 0; i<msg.length(); i++){
            if(msg.charAt(i)>=65 && msg.charAt(i)<=90){
                arr[i] = msg.charAt(i)-65;
            }
            else if(msg.charAt(i)>=97 && msg.charAt(i)<=122){
                arr[i] = msg.charAt(i)-97;
            }
        }
        return arr;
    }


    //values needed to calculate the inverse modular
    int[] modeq(int c, int x, int y){
        int ans = 0;
        int max = 0;
        int arr[] = new int[2];
        if(Math.abs((double)x)>Math.abs((double)y)){
            max = (int)Math.abs((double)x);
        }
        else{
            max = (int)Math.abs((double)y);
        }
       
            for(int i = (-max*2) ; i<=max*2 ; i++){
                for(int j = (-max*2); j<=max*2; j++){
                    if(y*i-x*j == c){
                        ans = 1;
                        arr[1] = -(i-x)+x;
                        arr[0] = -(j-y)+y;
                        break;
                    }
                }
        }
        if(ans==0){
            System.out.println("\nNo Solution");
        }
        return arr;
    }


    //calculate mod of number
    int mod(int x, int y){
        //print x and y
       // System.out.println("\nx = "+x+" y = "+y);
        int ans = 0;
        if(x>=0){
            ans = x%y;
        }
        else{
            ans = y+x%y;
        }
        return ans;
    }

    void allstff(){

        Scanner sc = new Scanner(System.in);

        Matrix m = new Matrix();

        Hill h = new Hill();

        System.out.println("Enter the message");
        String msg = sc.nextLine();

        int key[][] = {{6,24,1},{13,16,10},{20,17,15}};
        //int key[][] = {{5,6,2},{3,4,1},{7,8,9}};
        int txt[] = h.convertmsg(msg);

        int arr[] = m.MatrixMul(key,txt);

        char en[]=h.encrypt(h.reduce(arr));

        String keyd = "";
        //print key array in int
        // for(int i = 0; i<key.length; i++){
        //     for(int j = 0; j<key.length; j++){
        //         keyd = keyd+key[i][j]+" ";
        //     }
        //     System.out.println(keyd);
        //     keyd = "";
        // }

        //print key in string
        //convert key to string
        System.out.println("Your Key is: ");
        for(int i = 0; i<key.length; i++){
            for(int j = 0; j<key[0].length; j++){
                keyd+=(char)((key[i][j]+65));
            }    
        }
        //print key
        System.out.println(keyd);

        //print encrypted message
        System.out.println("Encrypted Message is : ");
        for(int i = 0; i<arr.length; i++){
            System.out.print(en[i]);
        }

        //decrypt message
        
        int r1[] = h.modeq(1,m.determinant(key),26);
       // System.out.println("\nEqn");
       // System.out.println(r1[0]+" "+r1[1]);
       // System.out.println("Inve  "+h.mod(-50, 36));

        int newarr[][];
        int matrixmod[][]=new int[key.length][key.length];
        newarr=m.cofactor(key);
        
        int multipliedmatrix[][]=m.multiply(newarr,r1[0]);


        for(int o=0;o<multipliedmatrix.length;o++){
            for(int p=0;p<multipliedmatrix.length;p++){
                matrixmod[o][p]=h.mod(multipliedmatrix[o][p],26);
            }
        }
        //print matrixmod array
        // System.out.println("\nModified Matrix");
        // for(int i = 0; i<matrixmod.length; i++){
        //     for(int j = 0; j<matrixmod.length; j++){
        //         System.out.print(matrixmod[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        //transpose of matrixmod
        int transpose[][] = m.transpose(matrixmod);

       // System.out.println("\nThe determinant of key is = "+m.determinant(key));

        int decrypted[]=new int[arr.length];

        //decrypted = m.MatrixMul(matrixmod,arr);
        decrypted=m.MatrixMul(transpose,arr);
        //print decrypted array
        // System.out.println("\nDecrypted Message is : ");
        // for(int i = 0; i<decrypted.length; i++){
        //     System.out.print((decrypted[i] +" "));
        // }
       // System.out.println();
        int decryptedmod[]=new int[decrypted.length];
        decryptedmod= h.reduce(decrypted);
        //print decryptedmod array
        System.out.println("\nDecrypted Message is : ");
        // for(int i = 0; i<decryptedmod.length; i++){
        //     System.out.print((decryptedmod[i])+" ");
        // }
       // System.out.println();
        char decryptedmsg[]=new char[decrypted.length];
        //final anser
        //System.out.println("Final ans");
        for(int i = 0; i<decryptedmod.length; i++){
            System.out.print((char)(decryptedmod[i]+65));
        }
    }

}
//size of martix is the square of the text length