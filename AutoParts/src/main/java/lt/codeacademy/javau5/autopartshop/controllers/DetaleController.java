package lt.codeacademy.javau5.autopartshop.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import lt.codeacademy.javau5.autopartshop.entities.Detale;
import lt.codeacademy.javau5.autopartshop.entities.Kategorija;
import lt.codeacademy.javau5.autopartshop.services.DetaleService;
import lt.codeacademy.javau5.autopartshop.services.KategorijaService;

import java.util.List;

@RestController
@RequestMapping("/api/detales")
@CrossOrigin(origins = "http://localhost:3000")
public class DetaleController {
    
    private final DetaleService detaleService;
    private final KategorijaService kategorijaService;

    public DetaleController(DetaleService detaleService, KategorijaService kategorijaService) {
        this.detaleService = detaleService;
        this.kategorijaService = kategorijaService;
    }

    @GetMapping
    public List<Detale> getAllDetales() {
        return detaleService.getAllDetales();
    }

    @GetMapping("/{id}")
    public Detale getDetaleById(@PathVariable Long id) {
        System.out.println("Gaunamas Detale pagal ID: " + id);
        return detaleService.getDetaleById(id);
    }

    @GetMapping("/search/pavadinimas/{pavadinimas}")
    public List<Detale> searchByPavadinimas(@PathVariable String pavadinimas) {
        return detaleService.searchByPavadinimas(pavadinimas);
    }

    @GetMapping("/search/kategorija/{kategorija}")
    public List<Detale> searchByKategorija(@PathVariable String kategorija) {
        return detaleService.searchByKategorija(kategorija);
    }

    @GetMapping("/search/prekesKodas/{prekesKodas}")
    public List<Detale> searchByPrekesKodas(@PathVariable String prekesKodas) {
        return detaleService.searchByPrekesKodas(prekesKodas);
    }

    @GetMapping("/search/gamintojas/{gamintojas}")
    public List<Detale> searchByGamintojas(@PathVariable String gamintojas) {
        return detaleService.searchByGamintojas(gamintojas);
    }

    @PostMapping
    public Detale createDetale(@RequestBody Detale detale) {
        System.out.println("Gautas Detale objektas: " + detale);

        String kategorijosPavadinimas = detale.getDetaleKategorija().getPavadinimas();
        Kategorija kategorija = kategorijaService.gautiPagalPavadinima(kategorijosPavadinimas);
        detale.setDetaleKategorija(kategorija);

        return detaleService.saveDetale(detale);
    }

    @PutMapping("/{id}")
    public Detale updateDetale(@PathVariable Long id, @RequestBody Detale updatedDetale) {
        System.out.println("Atnaujinama Detale pagal ID: " + id);
        
        Detale existingDetale = detaleService.getDetaleById(id);
        
        if (existingDetale == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Detale nerasta");
        }
        
        String kategorijosPavadinimas = updatedDetale.getDetaleKategorija().getPavadinimas();
        Kategorija kategorija = kategorijaService.gautiPagalPavadinima(kategorijosPavadinimas);
        updatedDetale.setDetaleKategorija(kategorija);
        
        return detaleService.saveDetale(updatedDetale);
    }

    @DeleteMapping("/{id}")
    public void deleteDetale(@PathVariable Long id) {
        System.out.println("Trinama Detale pagal ID: " + id);
        detaleService.deleteDetale(id);
    }
}
