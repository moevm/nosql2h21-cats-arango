package ru.bnn.ArangoCatProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bnn.ArangoCatProject.DataAccessObject.OwnersDAO;
import ru.bnn.ArangoCatProject.Model.Owners;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
public class OwnersController {
    private final OwnersDAO ownersDAO;

    public OwnersController(OwnersDAO ownersDAO) {
        this.ownersDAO = ownersDAO;
    }

    @PostMapping("/owners")
    public Owners create(@RequestBody @Valid Owners owner) {
        return ownersDAO.save(owner);
    }

    @PutMapping("/owners")
    public Owners update(@RequestBody @Valid Owners owner) {
        return ownersDAO.update(owner);
    }

    @GetMapping("/owners")
    public Iterable<Owners> list() {
        return ownersDAO.findAll();
    }

    @GetMapping("/owners/{id}")
    public Optional<Owners> findByTitle(@PathVariable @NotNull String id) {
        return ownersDAO.findOne(id);
    }

    @DeleteMapping("/owners/{id}")
    public void deleteById(@PathVariable @NotNull String id) {
        ownersDAO.delete(id);
    }
}
