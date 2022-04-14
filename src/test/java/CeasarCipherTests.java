import ciphering.CaesarCipher;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CeasarCipherTests {
    CaesarCipher underTest;

    @Test
    void itShouldEncryptAlphabeticLowerCaseString(){
        //given
        String input = "abcde";
        underTest = new CaesarCipher(input);

        //when
        String result = underTest.encrypt();

        //then
        for(int i = 0; i < input.length() - 1; i++){
            int difference = result.charAt(i)-input.charAt(i);
            int nextDifference = result.charAt(i+1)-input.charAt(i+1);
            assertThat(difference).isEqualTo(nextDifference);
        }
    }

    @Test
    void itShouldEncryptAlphabeticUpperCaseString(){
        //given
        String input = "ABCDE";
        underTest = new CaesarCipher(input);

        //when
        String result = underTest.encrypt();

        //then
        for(int i = 0; i < input.length() - 1; i++){
            int difference = result.charAt(i)-input.charAt(i);
            int nextDifference = result.charAt(i+1)-input.charAt(i+1);
            assertThat(difference).isEqualTo(nextDifference);
        }
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
}
