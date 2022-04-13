package Program;

import Ciphering.CesarCipher;
import Ciphering.Cipher;

public class CipheringMethod {

    public static Cipher getCipheringMethod(String command, String text){
        if(command.equals("1")){
            return new CesarCipher(text);
        }
        return null;
    }
}
