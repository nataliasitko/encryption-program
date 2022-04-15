package program;

import ciphering.BaconianCipher;
import ciphering.CaesarCipher;
import ciphering.Cipher;
import ciphering.RailFenceCipher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CipheringMethodTest {
    @Autowired
    private Cipher underTest;

    @Test
    void itShouldReturnCaesarCipherObject() {
        //given
            String command = "1";
            String text = "text";
        //when
            underTest = CipheringMethod.getCipheringMethod(command, text);
        //then
            assertThat(underTest).hasSameClassAs(new CaesarCipher("text"));
    }

    @Test
    void itShouldReturnRailFenceCipherObject() {
        //given
        String command = "2";
        String text = "text";
        //when
        underTest = CipheringMethod.getCipheringMethod(command, text);
        //then
        assertThat(underTest).hasSameClassAs(new RailFenceCipher("text"));
    }

    @Test
    void itShouldReturnBaconianCipherObject() {
        //given
        String command = "3";
        String text = "text";
        //when
        underTest = CipheringMethod.getCipheringMethod(command, text);
        //then
        assertThat(underTest).hasSameClassAs(new BaconianCipher("text"));
    }
}