package ru.bnn.ArangoCatProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bnn.ArangoCatProject.DataAccessObject.CatsDAO;
import ru.bnn.ArangoCatProject.Model.Cats;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
public class CatsController {
    private final CatsDAO catsDAO;

    public CatsController(CatsDAO catsDAO) {
        this.catsDAO = catsDAO;
    }

    @PostMapping("/cats")
    public Cats create(@RequestBody @Valid Cats cat) {
        return catsDAO.save(cat);
    }

    @PutMapping("/cats")
    public Cats update(@RequestBody @Valid Cats cat) {
        return catsDAO.update(cat);
    }


    //котов с отцом не присылать
    @GetMapping("/cats")
    public Iterable<Cats> listAll() {
        return catsDAO.findAll();
    }

    @GetMapping("/cats/adopted")
    public Iterable<Cats> listAdopted() {
        return catsDAO.findAllAdopted();
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
