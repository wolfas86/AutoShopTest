package lt.codeacademy.javau5.autopartshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.javau5.autopartshop.entities.Kategorija;

public interface KategorijaRepository extends JpaRepository<Kategorija, Long> {
    Kategorija findByPavadinimas(String pavadinimas);
}