package ru.bnn.ArangoCatProject.DataAccessObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bnn.ArangoCatProject.Model.Cats;
import ru.bnn.ArangoCatProject.Repository.CatsRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

@Service
public class CatsDAO {

    private CatsRepository catsRepository;

    @Autowired
    public CatsDAO(CatsRepository catsRepository) {
        this.catsRepository = catsRepository;
    }

    public Cats save(Cats cats) {
        return catsRepository.save(cats);
    }

    public Optional<Cats> findOne(String catID) {
        if (catID == null || catID.isEmpty())
            return Optional.empty();
        return catsRepository.findById(catID);
    }

    public Cats update(Cats cat) {
        String catID = cat.getKey();
        if (catID == null || catID.isEmpty())
            return null;

        return catsRepository.save(cat);
    }

    public void delete(String catID) {
        if (catID == null || catID.isEmpty())
            return;
        catsRepository.deleteById(catID);
    }

    public Iterable<Cats> findHomeless() {
        Iterable<Cats> iter = catsRepository.findAll();
        ArrayList<Cats> list = (ArrayList<Cats>) iter;

        list.removeIf(cat -> cat.getOwner() == null);

        return iter;
    }

    public Iterable<Cats> findAdopted() {
        Iterable<Cats> iter = catsRepository.findAll();
        ArrayList<Cats> list = (ArrayList<Cats>) iter;

        list.removeIf(cat -> cat.getOwner() != null);

        return iter;
    }
}
