package com.example.casestudyamadeus.havaalanlari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HavaalanlariService {

    private final HavaalanlariRepository havaalanlariRepository;

    @Autowired
    public HavaalanlariService(HavaalanlariRepository havaalanlariRepository) {
        this.havaalanlariRepository = havaalanlariRepository;
    }

    public List<Havaalanlari> getAllHavaalanlari() {
        return havaalanlariRepository.findAll();
    }

    public Optional<Havaalanlari> getHavaalaniById(Long id) {
        return havaalanlariRepository.findById(id);
    }

    public Havaalanlari createHavaalani(Havaalanlari havaalani) {
        return havaalanlariRepository.save(havaalani);
    }

    public Havaalanlari updateHavaalani(Long id, Havaalanlari updatedHavaalani) {
        if (havaalanlariRepository.existsById(id)) {
            updatedHavaalani.setId(id);
            return havaalanlariRepository.save(updatedHavaalani);
        }
        return null; // Handle not found case
    }

    public void deleteHavaalani(Long id) {
        havaalanlariRepository.deleteById(id);
    }
}