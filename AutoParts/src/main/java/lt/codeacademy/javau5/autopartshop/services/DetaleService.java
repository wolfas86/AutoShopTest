package lt.codeacademy.javau5.autopartshop.services;

import lt.codeacademy.javau5.autopartshop.entities.Detale;
import lt.codeacademy.javau5.autopartshop.repositories.DetaleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetaleService {
    
    private final DetaleRepository detaleRepository;

    public DetaleService(DetaleRepository detaleRepository) {
        this.detaleRepository = detaleRepository;
    }

    public List<Detale> getAllDetales() {
        return detaleRepository.findAll();
    }
    
    public List<Detale> searchByPavadinimas(String pavadinimas) {
        return detaleRepository.findByPavadinimasContainingIgnoreCase(pavadinimas);
    }

    public List<Detale> searchByKategorija(String kategorijaPavadinimas) {
        return detaleRepository.findByDetaleKategorijaPavadinimasContainingIgnoreCase(kategorijaPavadinimas);
    }

    public List<Detale> searchByPrekesKodas(String prekesKodas) {
        return detaleRepository.findByPrekesKodasContainingIgnoreCase(prekesKodas);
    }

    public List<Detale> searchByGamintojas(String gamintojas) {
        return detaleRepository.findByGamintojasContainingIgnoreCase(gamintojas);
    }

    public Detale saveDetale(Detale detale) {
        System.out.println("Saugomas Detale objektas: " + detale);
        return detaleRepository.save(detale);
    }
    
    public Detale getDetaleById(Long id) {
        System.out.println("Ieškoma Detale pagal ID: " + id);
        Optional<Detale> optionalDetale = detaleRepository.findById(id);
        return optionalDetale.orElse(null);
    }

    public void deleteDetale(Long id) {
        detaleRepository.deleteById(id);
    }
}
