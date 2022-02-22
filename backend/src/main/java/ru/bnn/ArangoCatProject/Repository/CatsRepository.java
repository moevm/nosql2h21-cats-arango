package ru.bnn.ArangoCatProject.Repository;

import com.arangodb.springframework.repository.ArangoRepository;
import ru.bnn.ArangoCatProject.Model.Cats;

public interface CatsRepository extends ArangoRepository<Cats, String> {

}
