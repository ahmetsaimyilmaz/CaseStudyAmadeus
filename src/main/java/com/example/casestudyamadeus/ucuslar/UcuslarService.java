package com.example.casestudyamadeus.ucuslar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UcuslarService {

    private final UcuslarRepository ucuslarRepository;

    @Autowired
    public UcuslarService(UcuslarRepository ucuslarRepository) {
        this.ucuslarRepository = ucuslarRepository;
    }

    public List<Ucuslar> getAllUcuslar() {
        return ucuslarRepository.findAll();
    }

    public Optional<Ucuslar> getUcusById(Long id) {
        return ucuslarRepository.findById(id);
    }

    public Ucuslar createUcus(Ucuslar ucus) {
        return ucuslarRepository.save(ucus);
    }

    public Ucuslar updateUcus(Long id, Ucuslar updatedUcus) {
        if (ucuslarRepository.existsById(id)) {
            updatedUcus.setId(id);
            return ucuslarRepository.save(updatedUcus);
        }
        return null; // Handle not found case
    }

    public void deleteUcus(Long id) {
        ucuslarRepository.deleteById(id);
    }

    public List<Ucuslar> findByKalkisAndVaris(Integer kalkisYeri, Integer varisYeri, Timestamp kalkisTarihi) {
        return ucuslarRepository.findByKalkisAndVaris(kalkisYeri,varisYeri,kalkisTarihi);
    }

    public List<Ucuslar> findByKalkisAndVarisTersYon(Integer kalkisYeri, Integer varisYeri, Timestamp kalkisTarihi) {
        return ucuslarRepository.findByKalkisAndVarisTersYon(kalkisYeri,varisYeri,kalkisTarihi);
    }


}