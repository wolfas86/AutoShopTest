package lt.codeacademy.javau5.autopart;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lt.codeacademy.javau5.autopartshop.entities.Automobilis;
import lt.codeacademy.javau5.autopartshop.entities.Kategorija;
import lt.codeacademy.javau5.autopartshop.entities.Detale;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DetaleTest {

    private Detale detale;

    @BeforeEach
    public void setUp() {
        detale = new Detale();
    }

    @Test
    public void testSetAndGetId() {
        detale.setId(1L);
        assertEquals(Long.valueOf(1), detale.getId());
    }

    @Test
    public void testSetAndGetPavadinimas() {
        detale.setPavadinimas("Vairo kolonėlė");
        assertEquals("Vairo kolonėlė", detale.getPavadinimas());
    }

    @Test
    public void testSetAndGetPrekesKodas() {
        detale.setPrekesKodas("VK12345");
        assertEquals("VK12345", detale.getPrekesKodas());
    }

    @Test
    public void testSetAndGetKaina() {
        detale.setKaina(new BigDecimal("49.99"));
        assertEquals(new BigDecimal("49.99"), detale.getKaina());
    }

    @Test
    public void testSetAndGetGamintojas() {
        detale.setGamintojas("Toyota");
        assertEquals("Toyota", detale.getGamintojas());
    }

    @Test
    public void testSetAndGetKiekisSandelyje() {
        detale.setKiekisSandelyje(5);
        assertEquals(5, detale.getKiekisSandelyje());
    }

    @Test
    public void testSetAndGetKategorija() {
        Kategorija kategorija = new Kategorija();
        kategorija.setPavadinimas("Vairas");
        detale.setDetaleKategorija(kategorija);
        assertEquals(kategorija, detale.getDetaleKategorija());
    }

    @Test
    public void testSetAndGetAutomobiliai() {
        Automobilis auto1 = new Automobilis();
        Automobilis auto2 = new Automobilis();
        List<Automobilis> automobiliai = Arrays.asList(auto1, auto2);

        detale.setAutomobiliai(automobiliai);
        assertEquals(2, detale.getAutomobiliai().size());
        assertEquals(auto1, detale.getAutomobiliai().get(0));
        assertEquals(auto2, detale.getAutomobiliai().get(1));
    }

    @Test
    public void testEqualsWithSameId() {
        Detale detale1 = new Detale();
        Detale detale2 = new Detale();

        detale1.setId(1L);
        detale2.setId(1L);

        assertEquals(detale1, detale2);
    }

    @Test
    public void testNotEqualsWithDifferentId() {
        Detale detale1 = new Detale();
        Detale detale2 = new Detale();

        detale1.setId(1L);
        detale2.setId(2L);

        assertNotEquals(detale1, detale2);
    }

    @Test
    public void testToString() {
        Kategorija kategorija = new Kategorija();
        kategorija.setPavadinimas("Vairas");
        detale.setId(1L);
        detale.setPavadinimas("Vairo kolonėlė");
        detale.setPrekesKodas("VK12345");
        detale.setKaina(new BigDecimal("49.99"));
        detale.setGamintojas("Toyota");
        detale.setKiekisSandelyje(5);
        detale.setDetaleKategorija(kategorija);

        String expectedString = "Detale{id=1, pavadinimas='Vairo kolonėlė', prekesKodas='VK12345', kaina=49.99, gamintojas='Toyota', kiekisSandelyje=5, detaleKategorija=" + kategorija.toString() + "}";

        assertEquals(expectedString, detale.toString());
    }
}
