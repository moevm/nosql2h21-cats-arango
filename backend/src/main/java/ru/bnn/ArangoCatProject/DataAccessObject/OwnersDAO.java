package ru.bnn.ArangoCatProject.DataAccessObject;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bnn.ArangoCatProject.Model.Owners;
import ru.bnn.ArangoCatProject.Repository.OwnersRepository;

import java.util.Optional;

@Service
public class OwnersDAO {

    private OwnersRepository ownersRepository;

    @Autowired
    public OwnersDAO(OwnersRepository ownersRepository) {
        this.ownersRepository = ownersRepository;
    }

    public Owners save(Owners owners) {
        return ownersRepository.save(owners);
    }

    public Optional<Owners> findOne(String ownerID) {
        if (ownerID == null || ownerID.isEmpty())
            return Optional.empty();
        return ownersRepository.findById(ownerID);
    }

    public Iterable<Owners> findAll() {
        return ownersRepository.findAll();
    }

    public Owners update(Owners owner) {
        String ownerID = owner.getKey();
        if (ownerID == null || ownerID.isEmpty())
            return null;
        return ownersRepository.save(owner);
    }

    public void delete(String ownerID) {
        if (ownerID == null || ownerID.isEmpty())
            return;
        ownersRepository.deleteById(ownerID);
    }
}
