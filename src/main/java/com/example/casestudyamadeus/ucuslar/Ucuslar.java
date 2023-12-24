package com.example.casestudyamadeus.ucuslar;
import com.example.casestudyamadeus.havaalanlari.Havaalanlari;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ucuslar")
@Getter
@Setter
public class Ucuslar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kalkis_havaalani_id")
    private Havaalanlari kalkisHavaalani;

    @ManyToOne
    @JoinColumn(name = "varis_havaalani_id")
    private Havaalanlari varisHavaalani;

    @Column(name = "kalkis_tarih_saati", nullable = false)
    private Date kalkisTarihSaati;

    @Column(name = "donus_tarih_saati")
    private Date donusTarihSaati;

    @Column(name = "fiyat", nullable = false, precision = 10, scale = 2)
    private BigDecimal fiyat;


    public Ucuslar(Havaalanlari kalkisHavaalani, Havaalanlari varisHavaalani, Date kalkisTarihSaati, Date donusTarihSaati, BigDecimal fiyat) {
        this.kalkisHavaalani = kalkisHavaalani;
        this.varisHavaalani = varisHavaalani;
        this.kalkisTarihSaati = kalkisTarihSaati;
        this.donusTarihSaati = donusTarihSaati;
        this.fiyat = fiyat;
    }

    public Ucuslar() {

    }
}