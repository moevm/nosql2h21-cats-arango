package ru.bnn.ArangoCatProject.DataAccessObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.bnn.ArangoCatProject.Model.Breeds;
import ru.bnn.ArangoCatProject.Repository.BreedsRepository;

import java.util.Optional;

@Service
public class BreedsDAO {

    private BreedsRepository breedsRepository;

    @Autowired
    public BreedsDAO(BreedsRepository breedsRepository) {
        this.breedsRepository = breedsRepository;
    }

    public Breeds save(Breeds breeds) {
        return breedsRepository.save(breeds);
    }

    public Optional<Breeds> findOne(String breedID) {
        if (breedID == null || breedID.isEmpty()) return Optional.empty();
        return breedsRepository.findById(breedID);
    }

    public Iterable<Breeds> findAll() {
        return breedsRepository.findAll();
    }

    public Breeds update(Breeds breed) {
        String breedID = breed.get_id();
        if (breedID == null || breedID.isEmpty())
            return null;

        return breedsRepository.save(breed);
    }

    public void delete(String breedID) {
        if (breedID == null || breedID.isEmpty())
            return;
        breedsRepository.deleteById(breedID);
    }
}
