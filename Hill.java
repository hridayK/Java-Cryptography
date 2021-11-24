//class matrix to get the multiplication of Matrix and Transpose Matrix
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

class Hill{

   
    int r1[]=new int[2];
    int txt[];
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
                char random = (char)((int)(Math.random()*26)+65);
                if((int)random>=65 && (int)random<=90){
                    key[i][j] = (int)random;
                }
                else{
                    j--;
                }
                //print key
                //System.out.print(key[i][j]+" ");
            }
            //System.out.println();
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

    String[] encrypt(String msg){
        // Scanner sc = new Scanner(System.in);

        Matrix m = new Matrix();

        Hill h = new Hill();
    

        // System.out.println("Enter the message");
        //  msg = sc.nextLine();

        int key[][] = new int[msg.length()][msg.length()];

        //{{6,24,1},{13,16,10},{20,17,15}};
        //int key[][] = {{5,6,2},{3,4,1},{7,8,9}};



        txt = h.convertmsg(msg);

        
        /** String carring key and message
         * @param key[0] : key
         * @param key[1] : encrypted message
         * @return
         */
        String keyd[] =new String[2];
        String keyfinal= "";

        int generatetrial[][] = new int[txt.length][txt.length];


        
        //decrypt message
        for(int i=0; i <= 5000; i++){
            generatetrial=h.generateKey(txt);
            // System.out.println(i);
             r1 = h.modeq(1,m.determinant(generatetrial),26);
             if(r1[0]!=0 && r1[1]!=0){
                System.out.println("\nEqn");
                System.out.println(r1[0]+" "+r1[1]);
                key= generatetrial;
                break;
             }
             else{
                System.out.println("r1[0] "+r1[0]+" r1[1] "+r1[1]);
             }
            
    //    System.out.println("Inve  "+h.mod(-50, 36));
       }
       
      

       int arr[] = m.MatrixMul(key,txt);

        char en[]=h.encrypt(h.reduce(arr));

        
        //print key array in int
        // System.out.println("\nKey");
        // for(int i = 0; i<key.length; i++){
        //     for(int j = 0; j<key.length; j++){
        //         keyd = keyd+key[i][j]+" ";
        //     }
        //     System.out.println(keyd);
        //     keyd = "";
        // }

        //print key in string
        //convert key to string
        //System.out.println("Your Key is: ");
        for(int i = 0; i<key.length; i++){
            for(int j = 0; j<key[0].length; j++){
                keyfinal+=(char)((h.mod(key[i][j],26)+65));
            }    
        }
        //print key
        //System.out.println(keyfinal);
        keyd[0] = keyfinal;


        
            //printing the generated key
        // System.out.println("\nGenerated Key Trial is: ");
        // for(int i = 0; i<generatetrial.length; i++){
        //     for(int j = 0; j<generatetrial[0].length; j++){
        //         System.out.print(generatetrial[i][j]);
        //     }
        // }
        // System.out.println();

        String enmsg = "";
        //print encrypted message
        //System.out.println("Encrypted Message is : ");
        for(int i = 0; i<arr.length; i++){
           // System.out.print(en[i]);
            enmsg+=en[i];
        }
        System.out.println();
        keyd[1] = enmsg;

        return keyd;
        
    }

    /**
     * decrypts the message
     * @param keyd : key in string
     * @param txte : encrypted message
     * @return
     */
    String decrypt(String keyd, String txte){//, String msg){
        
        Matrix m = new Matrix();

        Hill h = new Hill();


        int[] txt = new int[txte.length()];
        int[][] key = new int[txte.length()][txte.length()];
        int k=0;
         //convert String Key to int array
        for(int i = 0; i<key.length; i++){
            for(int j = 0; j<key[0].length; j++){
               
                    if(keyd.charAt(k)>=65 && keyd.charAt(k)<=90){
                         key[i][j] = keyd.charAt(k)-65;
                     }
                    else if(keyd.charAt(k)>=97 && keyd.charAt(k)<=122){
                        key[i][j] = keyd.charAt(k)-97;
                    }
                    k++;
                }
        }
        //System.out.println("\nMessage :"+ msg);
        //convert String message to int array
       // System.out.println("\nEncrypted Message is : ");
        for(int i = 0; i<txte.length(); i++){
           // System.out.print(txte.charAt(i));
            txt[i] = (int)txte.charAt(i);
            
        }
            txt = h.convertmsg(txte);

        //print text mod 26
        // System.out.println("\nText mod 26");
        // for(int i = 0; i<txt.length; i++){
        //     System.out.print(txt[i]);

        // }
        // System.out.println();




        // print key array
        // System.out.println("\nKey arr");
        // for(int i = 0; i<key.length; i++){
        //     for(int j = 0; j<key[0].length; j++){
        //         System.out.print(key[i][j]);
        //     }
        //     System.out.println();
        // }
        
        
        // int arr[] = m.MatrixMul(key,txt);

        // //print arr array
        // System.out.println("\nDecrypted Message is : ");
        // for(int i = 0; i<arr.length; i++){
        //     System.out.print(arr[i]+" ");
        // }
        
         //mod of each element in arr and store back in arr
        // for(int mk = 0; mk<arr.length; mk++){
        //     arr[mk] = h.mod(arr[mk],26);
        // }
        int newarr[][];
        int matrixmod[][]=new int[key.length][key.length];
                
        newarr=m.cofactor(key);
        

        //print newarr array
        // System.out.println("\nNewarr or co factor");
        // for(int i = 0; i<newarr.length; i++){
        //     for(int j = 0; j<newarr[0].length; j++){
        //         System.out.print(newarr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        int multipliedmatrix[][]=m.multiply(newarr,r1[0]);
        

        //print multiplied matrix array
        // System.out.println("\nMultiplied Matrix");
        // for(int i = 0; i<multipliedmatrix.length; i++){
        //     for(int j = 0; j<multipliedmatrix[0].length; j++){
        //         System.out.print(multipliedmatrix[i][j] +" ");
        //     }
        //     System.out.println();
        // }
        

        for(int o=0;o<multipliedmatrix.length;o++){
            for(int p=0;p<multipliedmatrix.length;p++){
                matrixmod[o][p]=h.mod(multipliedmatrix[o][p],26);
            }
        }
        // print matrixmod array
        // System.out.println("\nModified Matrix");
        // for(int i = 0; i<matrixmod.length; i++){
        //     for(int j = 0; j<matrixmod.length; j++){
        //         System.out.print(matrixmod[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        //transpose of matrixmod
        int transpose[][] = m.transpose(matrixmod);

        // print transpose array
        // System.out.println("\nTranspose Matrix");
        // for(int i = 0; i<transpose.length; i++){
        //     for(int j = 0; j<transpose.length; j++){
        //         System.out.print(transpose[i][j]+" ");
        //     }
        //     System.out.println();
        // }

       // System.out.println("\nThe determinant of key is = "+m.determinant(key));

        int decrypted[]=new int[txt.length];

        // System.out.println("\nDecrypted Message is : ");
        // for(int i=0;i<arr.length;i++){
        //    System.out.print((char)((h.mod(arr[i],26)+65)));
        // }
        // System.out.println();

        


        //decrypted = m.MatrixMul(matrixmod,arr);

        //print transpose array
        // System.out.println("\nTranspose Matrix");
        // for(int i = 0; i<transpose.length; i++){
        //     for(int j = 0; j<transpose.length; j++){
        //         System.out.print(transpose[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        decrypted=m.MatrixMul(transpose,txt);
        //print decrypted array
    //     System.out.println("\nDecrypted Message is : ");
    //     for(int i = 0; i<decrypted.length; i++){
    //         System.out.print((decrypted[i] +" "));
    //     }
    //    System.out.println();
        int decryptedmod[]=new int[decrypted.length];
        decryptedmod= h.reduce(decrypted);
        //print decryptedmod array
        // System.out.println("\nDecrypted Message is : ");
        // for(int i = 0; i<decryptedmod.length; i++){
        //     System.out.print((decryptedmod[i])+" ");
        // }
       System.out.println();
        char decryptedmsg[]=new char[decrypted.length];
        //final anser
        //System.out.println("Final ans");
        String decryptedmsg1="";
        for(int j = 0; j<decryptedmod.length; j++){
            System.out.print((char)(decryptedmod[j]+65));
            decryptedmsg1+=(char)(decryptedmod[j]+65);
        }
        System.out.println();
        return decryptedmsg1;
        }

    }

//size of martix is the square of the text length