package ciphering;

import ciphering.RailFenceCipher;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RailFenceCipherTests {
    RailFenceCipher underTest;

    @Test
    void itShouldEncryptAlphabeticString(){
        //given
        String input = "aBcDeFgHiJkL";

        //when
        underTest = new RailFenceCipher(input);
        String result = this.underTest.encrypt();

        //then
        String expected = "aeiBDFHJLcgk";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void encryptedStringShouldContainSpaces(){
        //given
        String input = "a bc de fgh";
        long numOfSpacesInInput = input.chars().filter(Character :: isWhitespace).count();
        //when
        underTest = new RailFenceCipher(input);
        String result = this.underTest.encrypt();

        //then
        long numOfSpacesIResult = result.chars().filter(Character :: isWhitespace).count();
        assertThat(numOfSpacesInInput).isEqualTo(numOfSpacesIResult);
    }

    @Test
    void itShouldEncryptNonAlphabeticCharacters(){
        //given
        String input = "+-.^%";

        //when
        underTest = new RailFenceCipher(input);
        String result = this.underTest.encrypt();

        //then
        String expected = "+%-^.";
        assertThat(result).isEqualTo(expected);
    }
}
