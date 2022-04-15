package ciphering;

import ciphering.BaconianCipher;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaconianCipherTests {
    BaconianCipher underTest;

    @Test
    void itShouldEncryptLowerCaseAlphabeticString(){
        //given
        String input = "abcde";

        //when
        underTest = new BaconianCipher(input);
        String result = this.underTest.encrypt();

        //then
        String expected = "aaaaaaaaabaaabaaaabbaabaa";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldEncryptUpperCaseAlphabeticString(){
        //given
        String input = "ABCDE";

        //when
        underTest = new BaconianCipher(input);
        String result = this.underTest.encrypt();

        //then
        String expected = "AAAAAAAAABAAABAAAABBAABAA";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void encryptedTextShouldContainSpaces(){
        //given
        String input = "a b c";

        //when
        underTest = new BaconianCipher(input);
        String result = this.underTest.encrypt();

        //then
        String expected = "aaaaa aaaab aaaba";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldNotEncryptNonAphabeticCharacters(){
        //given
        String input = "+-7%";

        //when
        underTest = new BaconianCipher(input);
        String result = this.underTest.encrypt();

        //then
        String expected = "+-7%";
        assertThat(result).isEqualTo(expected);
    }
}
