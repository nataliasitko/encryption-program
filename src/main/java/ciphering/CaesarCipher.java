package ciphering;
import java.util.Random;

public class CaesarCipher extends Cipher{
    private int key;

    public CaesarCipher(String text) {
        super(text);
        setKey();
    }

    public CaesarCipher(String text, int key) {
        super(text);
        setKey(key);
    }

    void setKey() {
        Random r = new Random();
        this.key = r.nextInt(25)+1;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey(){
        return this.key;
    }

    public String encrypt(){
        return processText(this.key);
    }

    public String processText(int key) {
        String alphaLC = "abcdefghijklmnoprstuwxyz";
        String alphaUC = "ABCDEFGHIJKLMNOPRSTUWXYZ";
        String alpha;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.text.length(); ++i) {
            char ch = this.text.charAt(i);
            if(Character.isAlphabetic(ch)){
                if(Character.isUpperCase(ch)) {
                    alpha = alphaUC;
                }else{
                    alpha = alphaLC;
                }
                int j = alpha.indexOf(ch);
                j = (j + key + alpha.length()) % alpha.length();
                sb.append(alpha.charAt(j));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
