package com.example.casestudyamadeus.ucuslar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ucuslar")
public class UcuslarController {

    private final UcuslarService ucuslarService;


    @GetMapping("/ucusBul")
    public List<Ucuslar> getUcuslar(
            @RequestParam Integer kalkisYeri,
            @RequestParam Integer varisYeri,
            @RequestParam String kalkisTarihi,
            @RequestParam(required = false) String donusTarihi) throws ParseException {

        List<Ucuslar> ucuslarListesi = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDateKalkisTarihi = dateFormat.parse(kalkisTarihi);


        // Convert Date to Timestamp
        Timestamp kalkisTarihiTimeStamp = new Timestamp(parsedDateKalkisTarihi.getTime());


            ucuslarListesi.addAll(ucuslarService.findByKalkisAndVaris(
                    kalkisYeri, varisYeri, kalkisTarihiTimeStamp));
            ucuslarListesi.addAll(ucuslarService.findByKalkisAndVarisTersYon(
                    kalkisYeri, varisYeri, kalkisTarihiTimeStamp));

        if (donusTarihi != null) {
            Date parsedDateDonusTarihi = dateFormat.parse(donusTarihi);

            Timestamp donusTarihiTimeStamp = new Timestamp(parsedDateDonusTarihi.getTime());

            ucuslarListesi.addAll(ucuslarService.findByKalkisAndVaris(
                    varisYeri, kalkisYeri, donusTarihiTimeStamp));
            ucuslarListesi.addAll(ucuslarService.findByKalkisAndVarisTersYon(
                    varisYeri, kalkisYeri, donusTarihiTimeStamp));

        }

        return ucuslarListesi;
    }

    @Autowired
    public UcuslarController(UcuslarService ucuslarService) {
        this.ucuslarService = ucuslarService;
    }

    @GetMapping
    public List<Ucuslar> getAllUcuslar() {
        return ucuslarService.getAllUcuslar();
    }

    @GetMapping("/{id}")
    public Optional<Ucuslar> getUcusById(@PathVariable Long id) {
        return ucuslarService.getUcusById(id);
    }

    @PostMapping
    public Ucuslar createUcus(@RequestBody Ucuslar ucus) {
        return ucuslarService.createUcus(ucus);
    }

    @PutMapping("/{id}")
    public Ucuslar updateUcus(@PathVariable Long id, @RequestBody Ucuslar updatedUcus) {
        return ucuslarService.updateUcus(id, updatedUcus);
    }

    @DeleteMapping("/{id}")
    public void deleteUcus(@PathVariable Long id) {
        ucuslarService.deleteUcus(id);
    }
}