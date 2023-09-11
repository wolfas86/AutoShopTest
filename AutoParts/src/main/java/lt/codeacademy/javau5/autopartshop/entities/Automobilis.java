package lt.codeacademy.javau5.autopartshop.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Automobilis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marke;
    private String modelis;
    private int gamybosMetai;

    @ManyToMany
    @JoinTable(
            name = "automobilis_detale",
            joinColumns = @JoinColumn(name = "automobilis_id"),
            inverseJoinColumns = @JoinColumn(name = "detale_id"))
    private List<Detale> detale = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getModelis() {
		return modelis;
	}

	public void setModelis(String modelis) {
		this.modelis = modelis;
	}

	public int getGamybosMetai() {
		return gamybosMetai;
	}

	public void setGamybosMetai(int gamybosMetai) {
		this.gamybosMetai = gamybosMetai;
	}

	public List<Detale> getDetale() {
		return detale;
	}

	public void setDetale(List<Detale> detale) {
		this.detale = detale;
	}

    
}
