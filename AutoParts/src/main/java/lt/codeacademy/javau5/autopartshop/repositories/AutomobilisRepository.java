package lt.codeacademy.javau5.autopartshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.javau5.autopartshop.entities.Automobilis;

public interface AutomobilisRepository extends JpaRepository<Automobilis, Long> {
    // papildomi metodai, jei reikia
}
