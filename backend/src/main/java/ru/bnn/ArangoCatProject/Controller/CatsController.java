package ru.bnn.ArangoCatProject.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> create(@RequestBody Cats cat) {
        if(catsDAO.save(cat) != null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/cats")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> update(@RequestBody Cats cat) {

        if(catsDAO.update(cat) != null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
