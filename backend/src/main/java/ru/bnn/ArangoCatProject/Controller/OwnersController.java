package ru.bnn.ArangoCatProject.Controller;

import org.json.JSONException;
import org.json.JSONObject;
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
    @CrossOrigin(origins = "http://localhost:3000")
    public Owners create(@RequestBody @Valid Owners owner) {
        return ownersDAO.save(owner);
    }

    @PutMapping("/owners")
    @CrossOrigin(origins = "http://localhost:3000")
    public Owners update(@RequestBody @Valid Owners owner) {
        return ownersDAO.update(owner);
    }

    @GetMapping("/owners")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Owners> list() {
        return ownersDAO.findAll();
    }

    @GetMapping("/owners/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<Owners> findByTitle(@PathVariable @NotNull String id) {
        return ownersDAO.findOne(id);
    }

    @DeleteMapping("/owners/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteById(@PathVariable @NotNull String id) {
        ownersDAO.delete(id);
    }
}
