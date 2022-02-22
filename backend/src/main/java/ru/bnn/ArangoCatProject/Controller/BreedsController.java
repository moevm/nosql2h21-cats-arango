package ru.bnn.ArangoCatProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bnn.ArangoCatProject.DataAccessObject.BreedsDAO;
import ru.bnn.ArangoCatProject.Model.Breeds;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
public class BreedsController {
    private final BreedsDAO breedsDAO;

    public BreedsController(BreedsDAO breedsDAO) {
        this.breedsDAO = breedsDAO;
    }

    @PostMapping("/breeds")
    public Breeds create(@RequestBody @Valid Breeds breed) {
        return breedsDAO.save(breed);
    }

    @PutMapping("/breeds")
    public Breeds update(@RequestBody @Valid Breeds breed) {
        return breedsDAO.update(breed);
    }

    @GetMapping("/breeds")
    public Iterable<Breeds> list() {
        return breedsDAO.findAll();
    }

    @GetMapping("/breeds/{id}")
    public Optional<Breeds> findByTitle(@PathVariable @NotNull String id) {
        return breedsDAO.findOne(id);
    }

    @DeleteMapping("/breeds/{id}")
    public void deleteById(@PathVariable @NotNull String id) {
        breedsDAO.delete(id);
    }
}