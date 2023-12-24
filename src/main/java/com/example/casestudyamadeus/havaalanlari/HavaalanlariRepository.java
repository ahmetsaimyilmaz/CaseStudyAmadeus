package com.example.casestudyamadeus.havaalanlari;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HavaalanlariRepository extends JpaRepository<Havaalanlari, Long> {
    // Additional custom queries can be added here if needed
}