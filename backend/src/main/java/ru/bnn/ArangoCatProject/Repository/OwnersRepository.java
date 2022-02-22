package ru.bnn.ArangoCatProject.Repository;

import com.arangodb.springframework.repository.ArangoRepository;
import ru.bnn.ArangoCatProject.Model.Owners;

public interface OwnersRepository extends ArangoRepository<Owners, String> {

}