package lt.codeacademy.javau5.autopart;


import lt.codeacademy.javau5.autopartshop.entities.Detale;
import lt.codeacademy.javau5.autopartshop.repositories.DetaleRepository;
import lt.codeacademy.javau5.autopartshop.services.DetaleService;

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

public class DetaleServiceTest {

    @InjectMocks
    private DetaleService detaleService;

    @Mock
    private DetaleRepository detaleRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllDetales() {
        Detale detale1 = new Detale();
        Detale detale2 = new Detale();
        when(detaleRepository.findAll()).thenReturn(Arrays.asList(detale1, detale2));

        List<Detale> result = detaleService.getAllDetales();

        assertEquals(2, result.size());
        verify(detaleRepository, times(1)).findAll();
    }

    @Test
    public void testGetDetaleById() {
        Long id = 1L;
        Detale detale = new Detale();
        when(detaleRepository.findById(id)).thenReturn(Optional.of(detale));

        Detale result = detaleService.getDetaleById(id);

        assertEquals(detale, result);
        verify(detaleRepository, times(1)).findById(id);
    }

    // ... kitos testų funkcijos, testuojančios kitus metodus ...

}
