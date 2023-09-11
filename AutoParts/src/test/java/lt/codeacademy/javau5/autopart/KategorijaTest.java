package lt.codeacademy.javau5.autopart;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lt.codeacademy.javau5.autopartshop.entities.Kategorija;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class KategorijaTest {

    private Kategorija kategorija;

    @BeforeEach
    public void setUp() {
        kategorija = new Kategorija();
    }

    @Test
    public void testSetAndGetId() {
        kategorija.setId(1L);
        assertEquals(Long.valueOf(1), kategorija.getId());
    }

    @Test
    public void testSetAndGetPavadinimas() {
        kategorija.setPavadinimas("Vairo kolonėlė");
        assertEquals("Vairo kolonėlė", kategorija.getPavadinimas());
    }

    @Test
    public void testEqualsWithSameId() {
        Kategorija kategorija1 = new Kategorija();
        Kategorija kategorija2 = new Kategorija();

        kategorija1.setId(1L);
        kategorija2.setId(1L);

        assertEquals(kategorija1, kategorija2);
    }

    @Test
    public void testNotEqualsWithDifferentId() {
        Kategorija kategorija1 = new Kategorija();
        Kategorija kategorija2 = new Kategorija();

        kategorija1.setId(1L);
        kategorija2.setId(2L);

        assertNotEquals(kategorija1, kategorija2);
    }

    @Test
    public void testToString() {
        kategorija.setId(1L);
        kategorija.setPavadinimas("Vairo kolonėlė");
        String expectedString = "Kategorija{id=1, pavadinimas='Vairo kolonėlė'}";

        assertEquals(expectedString, kategorija.toString());
    }
}
