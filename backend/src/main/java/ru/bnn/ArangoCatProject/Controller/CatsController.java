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
    public Cats create(@RequestBody Cats cat) {
        return catsDAO.save(cat);
    }

    @PutMapping("/cats")
    public Cats update(@RequestBody Cats cat) {
        return catsDAO.update(cat);
    }

    @GetMapping("/homeless")
    public Iterable<Cats> listHomeless() {
        return catsDAO.findHomeless();
    }

    @GetMapping("/adopted")
    public Iterable<Cats> listAdopted() {
        return catsDAO.findAdopted();
    }

    @GetMapping("/cats/{id}")
    public Optional<Cats> findByTitle(@PathVariable @NotNull String id) {
        return catsDAO.findOne(id);
    }

    @DeleteMapping("/cats/{id}")
    public void deleteById(@PathVariable @NotNull String id) {
        catsDAO.delete(id);
    }
}
