package ru.bnn.ArangoCatProject.Controller;

import org.springframework.web.bind.annotation.*;
import ru.bnn.ArangoCatProject.DataAccessObject.CatsDAO;
import ru.bnn.ArangoCatProject.Model.Cats;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
public class CatsController {
    private final CatsDAO catsDAO;

    public CatsController(CatsDAO catsDAO) {
        this.catsDAO = catsDAO;
    }

    @PostMapping("/cats")
    @CrossOrigin(origins = "http://localhost:3000")
    public Cats create(@RequestBody Cats cat) {
        return catsDAO.save(cat);
    }

    @PutMapping("/cats")
    @CrossOrigin(origins = "http://localhost:3000")
    public Cats update(@RequestBody Cats cat) {
        return catsDAO.update(cat);
    }

    @GetMapping("/homeless")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Cats> listHomeless() {
        return catsDAO.findHomeless();
    }

    @GetMapping("/adopted")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Cats> listAdopted() {
        return catsDAO.findAdopted();
    }

    @GetMapping("/cats/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<Cats> findByTitle(@PathVariable @NotNull String id) {
        return catsDAO.findOne(id);
    }

    @DeleteMapping("/cats/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteById(@PathVariable @NotNull String id) {
        catsDAO.delete(id);
    }
}