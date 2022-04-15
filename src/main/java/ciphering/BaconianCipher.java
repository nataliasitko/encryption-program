package ciphering;

import java.util.HashMap;
import java.util.Map;

public class BaconianCipher extends Cipher {
    private Map<Character, String> letterCipher;

    public BaconianCipher(String text) {
        super(text);
        setMap();
    }

    private void setMap() {
        this.letterCipher = new HashMap<>();
        this.letterCipher.put('A', "aaaaa");
        this.letterCipher.put('B', "aaaab");
        this.letterCipher.put('C', "aaaba");
        this.letterCipher.put('D', "aaabb");
        this.letterCipher.put('E', "aabaa");
        this.letterCipher.put('F', "aabab");
        this.letterCipher.put('G', "aabbb");
        this.letterCipher.put('H', "abaaa");
        this.letterCipher.put('I', "abaab");
        this.letterCipher.put('J', "ababa");
        this.letterCipher.put('K', "ababb");
        this.letterCipher.put('L', "abbaa");
        this.letterCipher.put('M', "abbab");
        this.letterCipher.put('N', "abbba");
        this.letterCipher.put('O', "abbbb");
        this.letterCipher.put('P', "baaaa");
        this.letterCipher.put('R', "baaab");
        this.letterCipher.put('S', "baaba");
        this.letterCipher.put('T', "baabb");
        this.letterCipher.put('U', "babaa");
        this.letterCipher.put('V', "babab");
        this.letterCipher.put('W', "babba");
        this.letterCipher.put('X', "babbb");
        this.letterCipher.put('Y', "bbaaa");
        this.letterCipher.put('Z', "bbaab");
    }

    @Override
    public String encrypt() {
        for (int i = 0; i < this.text.length(); i++) {
            char ch = this.text.charAt(i);
            boolean isChUpperCase = Character.isUpperCase(ch);
            if (Character.isAlphabetic(ch)) {
                String encryptedChar = letterCipher.get(Character.toUpperCase(ch));
                if(isChUpperCase){
                    this.sb.append(encryptedChar.toUpperCase());
                }else{
                    this.sb.append(encryptedChar);
                }
            } else {
                this.sb.append(ch);
            }
        }
        return this.sb.toString();
    }
}

