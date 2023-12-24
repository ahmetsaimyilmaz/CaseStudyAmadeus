package com.example.casestudyamadeus.havaalanlari;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "havaalanlari")
@Getter
@Setter
public class Havaalanlari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sehir", nullable = false)
    private String sehir;

    public Havaalanlari(Long id, String sehir) {
        this.id = id;
        this.sehir = sehir;
    }

    public Havaalanlari(Long id) {
        this.id = id;
    }

    public Havaalanlari() {
    }
}
