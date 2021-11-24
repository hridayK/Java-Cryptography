import java.util.*;

class Caesar{

    private int key;

    public String encrypt(String message, int shift){
        String encrypted = "";
        char ch;
        key=shift;
        for(int i=0;i<message.length();i++){
            ch=message.charAt(i);
            if(Character.isLetter(ch)){
                if(Character.isUpperCase(ch)){
                    encrypted+=(char)((int)(ch+shift-65)%26+65);
                }else if(Character.isLowerCase(ch)){
                    encrypted+=(char)((int)(ch+shift-97)%26+97);
                }
            }else{
                encrypted+=ch;
            }
        }
        return encrypted;
    }

    public String decrypt(String cipher, int key){
        return encrypt(cipher, 26-key);
    }

    String[] bruteForce(String cipher){
        String results[]=new String[26];
        for(int i=0;i<26;i++){
            results[i]=decrypt(cipher, 26-i);
        }
        return results;
    }

}