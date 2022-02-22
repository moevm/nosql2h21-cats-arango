package ru.bnn.ArangoCatProject.Repository;

import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.stereotype.Component;
import ru.bnn.ArangoCatProject.Model.Cats;

public interface CatsRepository extends ArangoRepository<Cats, String> {

}
