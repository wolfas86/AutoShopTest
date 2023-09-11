package lt.codeacademy.javau5.autopartshop.controllers;

import org.springframework.web.bind.annotation.*;

import lt.codeacademy.javau5.autopartshop.entities.Kategorija;
import lt.codeacademy.javau5.autopartshop.services.KategorijaService;

import java.util.List;

@RestController
@RequestMapping("/api/kategorijos")
@CrossOrigin(origins = "http://localhost:3000")
public class KategorijaController {

    private final KategorijaService kategorijaService;

    public KategorijaController(KategorijaService kategorijaService) {
        this.kategorijaService = kategorijaService;
    }

    @GetMapping
    public List<Kategorija> gautiVisasKategorijas() {
        System.out.println("Gaunamos visos kategorijos");
        return kategorijaService.gautiVisasKategorijas();
    }

    @GetMapping("/{id}")
    public Kategorija gautiKategorijaPagalId(@PathVariable Long id) {
        System.out.println("Gaunama kategorija pagal ID: " + id);
        return kategorijaService.gautiKategorijaPagalId(id);
    }

    @PostMapping
    public void issaugotiArAtnaujintiKategorija(@RequestBody Kategorija kategorija) {
        System.out.println("Išsaugoma arba atnaujinama kategorija: " + kategorija);
        kategorijaService.issaugotiArAtnaujintiKategorija(kategorija);
    }

    @DeleteMapping("/{id}")
    public void istrintiKategorija(@PathVariable Long id) {
        System.out.println("Trinama kategorija pagal ID: " + id);
        kategorijaService.istrintiKategorija(id);
    }
}
