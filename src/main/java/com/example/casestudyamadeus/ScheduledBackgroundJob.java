package com.example.casestudyamadeus;

import com.example.casestudyamadeus.ucuslar.Ucuslar;
import com.example.casestudyamadeus.ucuslar.UcuslarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledBackgroundJob {
    @Autowired
    UcuslarRepository ucuslarRepository;

    //@Scheduled(fixedRate = 50000) // 300,000 milliseconds = 5 minutes
    public void fetchFlightInfo() {
         MockApiService mockApiService = new MockApiService();
         List<Ucuslar> flightInfoList = mockApiService.fetchMockData();
         ucuslarRepository.saveAll(flightInfoList);
         System.out.println("Scheduled job ran at: " + System.currentTimeMillis());
    }
}
