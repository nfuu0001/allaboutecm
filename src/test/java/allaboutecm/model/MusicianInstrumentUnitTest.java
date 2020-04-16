package allaboutecm.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MusicianInstrumentUnitTest {
    MusicianInstrument mi;
    Musician m;
    MusicalInstrument m1;
    @BeforeEach
    public void setUp() {
        m = new Musician("Justin Bieber");
        m1 = new MusicalInstrument("piano");
        mi = new MusicianInstrument(m,m1);

    }

    @Test
    public void musicianCannotBeNull() {
        assertNotNull(mi.getMusician(),"The object is null");
    }

    @Test
    public void instrumentNotNull() {
        assertNotNull(mi.getMusicalInstrument(),"The object is null");
    }
}
