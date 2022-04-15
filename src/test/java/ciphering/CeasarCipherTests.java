package ciphering;

import ciphering.CaesarCipher;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CeasarCipherTests {
    CaesarCipher underTest;

    @Test
    void itShouldEncryptAlphabeticLowerCaseString(){
        //given
        String input = "x";
        int key = 5;
        underTest = new CaesarCipher(input, key);

        //when
        String actual = underTest.encrypt();

        //then
        String expected = "c";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldEncryptAlphabeticUpperCaseString(){
        //given
        String input = "X";
        int key = 5;
        underTest = new CaesarCipher(input, key);

        //when
        String actual = underTest.encrypt();

        //then
        String expected = "C";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldNotEncryptNonAlphabeticString(){
        //given
        String input = "+=-.*";
        underTest = new CaesarCipher(input);

        //when
        String result = underTest.encrypt();

        //then
        assertThat(input).isEqualTo(result);
    }

    @Test
    void itShouldNotEncryptSpaces(){
        //given
        String input = " ";
        underTest = new CaesarCipher(input);

        //when
        String result = underTest.encrypt();

        //then
        assertThat(input).isEqualTo(result);
    }

    @Test
    void itShouldNotEncryptDigits(){
        //given
        String input = "12345";
        underTest = new CaesarCipher(input);

        //when
        String result = underTest.encrypt();

        //then
        assertThat(input).isEqualTo(result);
    }
}
