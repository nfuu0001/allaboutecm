package allaboutecm.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class MusicianUnitTest {
    private Musician musician = new Musician("Justin Bieber");

    @Test
    @DisplayName("Musician name cannot be null")
    public void NameCannotBeNull() {
        assertThrows(NullPointerException.class, () -> musician.setName(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    \t"})
    @DisplayName("Album name cannot be empty or blank")
    public void NameConnotBeEmptyOrBlank(String arg) {
        assertThrows(IllegalArgumentException.class, () -> musician.setName(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Stephen Curry", "Tom"})
    @DisplayName("Musician name contains at least two parts separated by a space")
    public void musicianNameContainSpace(String arg) {

        assertTrue(musician.validName(arg),"Musician name contains at least two parts separated by a space");

    }

    @ParameterizedTest
    @ValueSource(strings = {"https://stackoverflow.com", " "})
    public void urlIsValid(String arg) {

        assertTrue(musician.isValidURL(arg),"The URL format is not correct");
    }



}
