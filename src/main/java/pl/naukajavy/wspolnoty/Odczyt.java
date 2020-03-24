package pl.naukajavy.wspolnoty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Odczyt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataOdczytu;

    private double wartosc;
    @ManyToOne
    private Licznik licznik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataOdczytu() {
        return dataOdczytu;
    }

    public void setDataOdczytu(LocalDateTime dataOdczytu) {
        this.dataOdczytu = dataOdczytu;
    }

    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    public Licznik getLicznik() {
        return licznik;
    }

    public void setLicznik(Licznik licznik) {
        this.licznik = licznik;
    }
}
