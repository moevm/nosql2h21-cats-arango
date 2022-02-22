package ru.bnn.ArangoCatProject.DataAccessObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.bnn.ArangoCatProject.Model.Cats;
import ru.bnn.ArangoCatProject.Repository.CatsRepository;

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
        if (catID == null || catID.isEmpty()) return Optional.empty();
        return catsRepository.findById(catID);
    }


    public Iterable<Cats> findAll() {
        return catsRepository.findAll();
    }

    public Iterable<Cats> findAllAdopted() {
        Iterable<Cats> adoptedCats = new LinkedList<>();
        catsRepository.findAll();
        for(Cats i : catsRepository.findAll()){
            if (i.getOwner() != null)
                ((LinkedList) adoptedCats).addLast(i);
        }
        return adoptedCats;
    }

    public Cats update(Cats cat) {
        String catID = cat.get_id();
        if (catID == null || catID.isEmpty())
            return null;

        return catsRepository.save(cat);
    }

    public void delete(String catID) {
        if (catID == null || catID.isEmpty())
            return;
        catsRepository.deleteById(catID);
    }
}
