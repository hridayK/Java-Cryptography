import java.util.*;

public class VigenereCipher{
    
    public String en(String text, String key)
    {
        String r = "";
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, k = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z'){
                continue;
            }
            r += (char) ((c + key.charAt(k) - 2 * 'A') % 26 + 'A');
            k = ++k % key.length();
        }
        return r;
    }
 
    public String de(String text, String key){
        String r = "";
        text = text.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, k = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z'){
                continue;
            }
            r += (char) ((c - key.charAt(k) + 26) % 26 + 'A');
            k = ++k % key.length();
        }
        return r;
    }
}