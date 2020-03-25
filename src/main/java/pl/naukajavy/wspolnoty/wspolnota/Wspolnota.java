package pl.naukajavy.wspolnoty.wspolnota;

import pl.naukajavy.wspolnoty.budynek.Budynek;

import javax.persistence.*;
import java.util.List;

@Entity
public class Wspolnota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "wspolnota")
    private List<Budynek> budynki;

    public Long getId() {
        return id;
    }

    public List<Budynek> getBudynki() {
        return budynki;
    }

    public void setBudynki(List<Budynek> budynki) {
        this.budynki = budynki;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
