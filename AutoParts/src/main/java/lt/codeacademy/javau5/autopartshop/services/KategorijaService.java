package lt.codeacademy.javau5.autopartshop.services;

import lt.codeacademy.javau5.autopartshop.entities.Kategorija;
import lt.codeacademy.javau5.autopartshop.repositories.KategorijaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategorijaService {

    private final KategorijaRepository kategorijaRepository;

    public KategorijaService(KategorijaRepository kategorijaRepository) {
        this.kategorijaRepository = kategorijaRepository;
    }

    public Kategorija gautiPagalPavadinima(String pavadinimas) {
        System.out.println("Gaunami kategorija pagal pavadinimą: " + pavadinimas);
        return kategorijaRepository.findByPavadinimas(pavadinimas);
    }

    public List<Kategorija> gautiVisasKategorijas() {
        System.out.println("Gaunamos visos kategorijos");
        return kategorijaRepository.findAll();
    }

    public Kategorija gautiKategorijaPagalId(Long id) {
        System.out.println("Gaunama kategorija pagal ID: " + id);
        return kategorijaRepository.findById(id).orElse(null);
    }

    public void issaugotiArAtnaujintiKategorija(Kategorija kategorija) {
        System.out.println("Išsaugoma arba atnaujinama kategorija: " + kategorija);
        kategorijaRepository.save(kategorija);
    }

    public void istrintiKategorija(Long id) {
        System.out.println("Trinama kategorija pagal ID: " + id);
        kategorijaRepository.deleteById(id);
    }
}
