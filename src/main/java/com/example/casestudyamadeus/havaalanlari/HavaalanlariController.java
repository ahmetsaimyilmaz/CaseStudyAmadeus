package com.example.casestudyamadeus.havaalanlari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/havaalanlari")
public class HavaalanlariController {

    private final HavaalanlariService havaalanlariService;

    @Autowired
    public HavaalanlariController(HavaalanlariService havaalanlariService) {
        this.havaalanlariService = havaalanlariService;
    }

    @GetMapping
    public List<Havaalanlari> getAllHavaalanlari() {

        return havaalanlariService.getAllHavaalanlari();
    }

    @GetMapping("/{id}")
    public Optional<Havaalanlari> getHavaalaniById(@PathVariable Long id) {
        return havaalanlariService.getHavaalaniById(id);
    }

    @PostMapping
    public Havaalanlari createHavaalani(@RequestBody Havaalanlari havaalani) {
        return havaalanlariService.createHavaalani(havaalani);
    }

    @PutMapping("/{id}")
    public Havaalanlari updateHavaalani(@PathVariable Long id, @RequestBody Havaalanlari updatedHavaalani) {
        return havaalanlariService.updateHavaalani(id, updatedHavaalani);
    }

    @DeleteMapping("/{id}")
    public void deleteHavaalani(@PathVariable Long id) {
        havaalanlariService.deleteHavaalani(id);
    }
}