package lt.codeacademy.javau5.autopartshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.javau5.autopartshop.entities.Detale;

import java.util.List;

public interface DetaleRepository extends JpaRepository<Detale, Long> {
    List<Detale> findByPavadinimasContainingIgnoreCase(String pavadinimas);

    List<Detale> findByDetaleKategorijaPavadinimasContainingIgnoreCase(String kategorijaPavadinimas);

    List<Detale> findByPrekesKodasContainingIgnoreCase(String prekesKodas);

    List<Detale> findByGamintojasContainingIgnoreCase(String gamintojas);
}
