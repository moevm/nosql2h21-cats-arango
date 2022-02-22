package ru.bnn.ArangoCatProject.DataAccessObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bnn.ArangoCatProject.Model.Cats;
import ru.bnn.ArangoCatProject.Model.HaveOwner;
import ru.bnn.ArangoCatProject.Model.Owners;
import ru.bnn.ArangoCatProject.Repository.CatsRepository;
import ru.bnn.ArangoCatProject.Repository.HaveOwnerRepository;
import ru.bnn.ArangoCatProject.Repository.OwnersRepository;

import java.util.Optional;

@Service
public class DataAccessObject {

    private CatsRepository catsRepository;
    private OwnersRepository ownersRepository;
    private HaveOwnerRepository haveOwnerRepository;

    @Autowired
    public DataAccessObject(CatsRepository catsRepository, OwnersRepository ownersRepository, HaveOwnerRepository haveOwnerRepository) {
        this.catsRepository = catsRepository;
        this.ownersRepository = ownersRepository;
        this.haveOwnerRepository = haveOwnerRepository;
    }

    public HaveOwner save(HaveOwner edge) {
        haveOwnerRepository.save(edge);
        return edge;
    }

    public Optional<Cats> findCat(String catID) {
        if (catID == null || catID.isEmpty()) return Optional.empty();
        return catsRepository.findById(catID);
    }

    public Optional<Owners> findOwner(String ownerID) {
        if (ownerID == null || ownerID.isEmpty()) return Optional.empty();
        return ownersRepository.findById(ownerID);
    }
}
