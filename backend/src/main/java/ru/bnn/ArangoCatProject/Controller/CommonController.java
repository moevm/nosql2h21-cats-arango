package ru.bnn.ArangoCatProject.Controller;

import org.springframework.web.bind.annotation.*;
import ru.bnn.ArangoCatProject.DataAccessObject.DataAccessObject;
import ru.bnn.ArangoCatProject.Model.Cats;
import ru.bnn.ArangoCatProject.Model.HaveOwner;
import ru.bnn.ArangoCatProject.Model.Owners;

import java.util.Optional;

@RestController
public class CommonController {
    private final DataAccessObject dao;

    public CommonController(DataAccessObject dao) {
        this.dao = dao;
    }

    @PostMapping("/cats/makehome")
    @CrossOrigin(origins = "http://localhost:3000")
    public HaveOwner create(@RequestParam("catKey") String catKey, @RequestParam("ownerKey") String ownerKey) {

        HaveOwner edge = new HaveOwner();

        Optional<Cats> cat = dao.findCat(catKey);
        Optional<Owners> owner = dao.findOwner(ownerKey);

        cat.ifPresent(edge::set_from);
        owner.ifPresent(edge::set_to);

        cat.ifPresent(cats -> cats.setOwner(edge));

        return dao.save(edge);
    }
}