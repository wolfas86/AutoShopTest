package lt.codeacademy.javau5.autopart;


import lt.codeacademy.javau5.autopartshop.entities.Kategorija;
import lt.codeacademy.javau5.autopartshop.repositories.KategorijaRepository;
import lt.codeacademy.javau5.autopartshop.services.KategorijaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class KategorijaServiceTest {

    @InjectMocks
    private KategorijaService kategorijaService;

    @Mock
    private KategorijaRepository kategorijaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGautiVisasKategorijas() {
        Kategorija kategorija1 = new Kategorija();
        Kategorija kategorija2 = new Kategorija();
        when(kategorijaRepository.findAll()).thenReturn(Arrays.asList(kategorija1, kategorija2));

        List<Kategorija> result = kategorijaService.gautiVisasKategorijas();

        assertEquals(2, result.size());
        verify(kategorijaRepository, times(1)).findAll();
    }

    @Test
    public void testGautiKategorijaPagalId() {
        Long id = 1L;
        Kategorija kategorija = new Kategorija();
        when(kategorijaRepository.findById(id)).thenReturn(Optional.of(kategorija));

        Kategorija result = kategorijaService.gautiKategorijaPagalId(id);

        assertEquals(kategorija, result);
        verify(kategorijaRepository, times(1)).findById(id);
    }

    // ... kitos testų funkcijos, testuojančios kitus metodus ...

}
