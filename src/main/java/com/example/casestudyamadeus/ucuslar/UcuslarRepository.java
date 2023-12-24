package com.example.casestudyamadeus.ucuslar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface UcuslarRepository extends JpaRepository<Ucuslar, Long> {

    @Query(value = "SELECT * FROM ucuslar WHERE kalkis_havaalani_id = :kalkisYeri AND varis_havaalani_id = :varisYeri AND DATE(kalkis_tarih_saati) = DATE(:kalkisTarihi)",nativeQuery = true)
    List<Ucuslar> findByKalkisAndVaris(
            @Param("kalkisYeri") Integer kalkisHavaalaniId,
            @Param("varisYeri") Integer varisHavaalaniId,
            @Param("kalkisTarihi") Timestamp kalkisTarihSaati
    );

    @Query(value = "SELECT * FROM ucuslar WHERE varis_havaalani_id = :kalkisYeri AND kalkis_havaalani_id = :varisYeri AND DATE(donus_tarih_saati) = DATE(:kalkisTarihi)",nativeQuery = true)
    List<Ucuslar> findByKalkisAndVarisTersYon(
            @Param("kalkisYeri") Integer kalkisHavaalaniId,
            @Param("varisYeri") Integer varisHavaalaniId,
            @Param("kalkisTarihi") Timestamp kalkisTarihSaati
    );



}