package lt.codeacademy.javau5.autopartshop.controllers;
import org.springframework.web.bind.annotation.*;

import lt.codeacademy.javau5.autopartshop.entities.Automobilis;
import lt.codeacademy.javau5.autopartshop.services.AutomobilisService;

import java.util.List;

@RestController
@RequestMapping("/api/automobiliai")
public class AutomobilisController {
    
    private final AutomobilisService automobilisService;
    
    public AutomobilisController(AutomobilisService automobilisService) {
        this.automobilisService = automobilisService;
    }

    @GetMapping
    public List<Automobilis> getAllAutomobiliai() {
        return automobilisService.getAllAutomobiliai();
    }

    @GetMapping("/{id}")
    public Automobilis getAutomobilisById(@PathVariable Long id) {
        return automobilisService.getAutomobilisById(id);
    }

    @PostMapping
    public Automobilis createAutomobilis(@RequestBody Automobilis automobilis) {
        return automobilisService.saveAutomobilis(automobilis);
    }

    @PutMapping("/{id}")
    public Automobilis updateAutomobilis(@PathVariable Long id, @RequestBody Automobilis automobilis) {
        automobilis.setId(id);
        return automobilisService.saveAutomobilis(automobilis);
    }

    @DeleteMapping("/{id}")
    public void deleteAutomobilis(@PathVariable Long id) {
        automobilisService.deleteAutomobilis(id);
    }
}
