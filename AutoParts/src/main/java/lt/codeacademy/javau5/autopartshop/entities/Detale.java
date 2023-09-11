package lt.codeacademy.javau5.autopartshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"kategorija"})  // Ši eilutė apsaugo nuo JSON nesugadinimo
public class Detale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pavadinimas;
    private String prekesKodas;
    private BigDecimal kaina;
    private String gamintojas;
    private int kiekisSandelyje;

    @ManyToOne(fetch = FetchType.EAGER)  // Įjungiamas eager loading, kad užkrauti Kategorija objektą
    @JoinColumn(name = "kategorija_id")
    private Kategorija detaleKategorija;

    @ManyToMany(mappedBy = "detale")
    private List<Automobilis> automobiliai = new ArrayList<>();

    // Getteriai ir Setteriai
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getPrekesKodas() {
        return prekesKodas;
    }

    public void setPrekesKodas(String prekesKodas) {
        this.prekesKodas = prekesKodas;
    }

    public BigDecimal getKaina() {
        return kaina;
    }

    public void setKaina(BigDecimal kaina) {
        this.kaina = kaina;
    }

    public String getGamintojas() {
        return gamintojas;
    }

    public void setGamintojas(String gamintojas) {
        this.gamintojas = gamintojas;
    }

    public int getKiekisSandelyje() {
        return kiekisSandelyje;
    }

    public void setKiekisSandelyje(int kiekisSandelyje) {
        this.kiekisSandelyje = kiekisSandelyje;
    }

    public Kategorija getDetaleKategorija() {
        return detaleKategorija;
    }

    public void setDetaleKategorija(Kategorija detaleKategorija) {
        this.detaleKategorija = detaleKategorija;
    }

    public List<Automobilis> getAutomobiliai() {
        return automobiliai;
    }

    public void setAutomobiliai(List<Automobilis> automobiliai) {
        this.automobiliai = automobiliai;
    }

    // equals, hashCode ir toString metodai
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detale detale = (Detale) o;
        return id.equals(detale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Detale{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", prekesKodas='" + prekesKodas + '\'' +
                ", kaina=" + kaina +
                ", gamintojas='" + gamintojas + '\'' +
                ", kiekisSandelyje=" + kiekisSandelyje +
                ", detaleKategorija=" + detaleKategorija +
                '}';
    }
}