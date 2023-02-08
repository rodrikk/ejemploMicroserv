package com.ejemplo.Eje.controllers;

import com.ejemplo.Eje.models.useless;
import com.ejemplo.Eje.repositories.uselessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class uselessController {
    @Autowired
    private uselessRepository repository;

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/useless")
    public List<useless> all() {

        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/useless")
    useless newUseless(@RequestBody useless newuseles) {
        return repository.save(newuseles);
    }

    @GetMapping("/useless/{id}")
    public useless one(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("useless: "+ id +" not found."));
    }

    @PutMapping("/useless/{id}")
    useless replaceUseless(@RequestBody useless newuseless, @PathVariable Integer id) {

        return repository.findById(id)
                .map(useless -> {
                    useless.setHowUseless(newuseless.getHowUseless());
                    useless.setWhyUseless(newuseless.getWhyUseless());
                    useless.setYes(newuseless.isYes());
                    useless.setUsefulPercentage(newuseless.getUsefulPercentage());
                    return repository.save(useless);
                })
                .orElseGet(() -> {
                    newuseless.setId(id);
                    return repository.save(newuseless);
                });
    }

    @DeleteMapping("/useless/{id}")
    void deleteUseless(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
