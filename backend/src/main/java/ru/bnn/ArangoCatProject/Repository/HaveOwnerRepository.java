package ru.bnn.ArangoCatProject.Repository;

import com.arangodb.springframework.repository.ArangoRepository;
import ru.bnn.ArangoCatProject.Model.HaveOwner;


public interface HaveOwnerRepository extends ArangoRepository<HaveOwner, String> {
}
