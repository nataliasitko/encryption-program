package program;

import ciphering.BaconianCipher;
import ciphering.Cipher;
import ciphering.CaesarCipher;
import ciphering.RailFenceCipher;

public class CipheringMethod {

    public static Cipher getCipheringMethod(String command, String text){
        return switch (command) {
            case "1" -> new CaesarCipher(text);
            case "2" -> new RailFenceCipher(text);
            case "3" -> new BaconianCipher(text);
            default -> throw new IllegalStateException("Unexpected value: " + command);
        };
    }
}
