package com.example.casestudyamadeus;

import com.example.casestudyamadeus.havaalanlari.Havaalanlari;
import com.example.casestudyamadeus.ucuslar.Ucuslar;
import com.example.casestudyamadeus.ucuslar.UcuslarRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MockApiService {

    @Autowired
    UcuslarRepository ucuslarRepository;

    public List<Ucuslar> fetchMockData() {
        List<Ucuslar> ucuslarMockList = new ArrayList<>();
        for(int i =0; i<10;i++){
            ucuslarMockList.add(generateAndPrintMockData());
        }

        return ucuslarMockList;
    }

    private Ucuslar generateAndPrintMockData() {
        Faker faker = new Faker();

        int kalkisHavaalaniId = faker.number().numberBetween(1, 15);
        int varisHavaalaniId = faker.number().numberBetween(1, 15);
        Timestamp kalkisTarihSaati = new Timestamp(faker.date().future(30, TimeUnit.DAYS).getTime());
        Timestamp donusTarihSaati = new Timestamp(faker.date().future(60, TimeUnit.DAYS).getTime());
        BigDecimal fiyat = BigDecimal.valueOf(faker.number().randomDouble(2, 100, 1000));



        System.out.println("Kalkış Havaalanı ID: " + kalkisHavaalaniId);
        System.out.println("Varış Havaalanı ID: " + varisHavaalaniId);
        System.out.println("Kalkış Tarih Saati: " + kalkisTarihSaati);
        System.out.println("Dönüş Tarih Saati: " + donusTarihSaati);
        System.out.println("Fiyat: " + fiyat);
        System.out.println("-----------------------------");

        return new Ucuslar(new Havaalanlari((long) kalkisHavaalaniId), new Havaalanlari((long) varisHavaalaniId), kalkisTarihSaati, donusTarihSaati, fiyat);
    }
}
