package lt.codeacademy.javau5.autopartshop.services;
import java.util.List;

import org.springframework.stereotype.Service;

import lt.codeacademy.javau5.autopartshop.entities.Automobilis;
import lt.codeacademy.javau5.autopartshop.repositories.AutomobilisRepository;

@Service
public class AutomobilisService {
    
    private final AutomobilisRepository automobilisRepository;
    
    public AutomobilisService(AutomobilisRepository automobilisRepository) {
        this.automobilisRepository = automobilisRepository;
    }

    public List<Automobilis> getAllAutomobiliai() {
        return automobilisRepository.findAll();
    }

    public Automobilis getAutomobilisById(Long id) {
        return automobilisRepository.findById(id).orElseThrow(() -> new RuntimeException("Automobilis nerastas"));
    }

    public Automobilis saveAutomobilis(Automobilis automobilis) {
        return automobilisRepository.save(automobilis);
    }

    public void deleteAutomobilis(Long id) {
        automobilisRepository.deleteById(id);
    }
}
