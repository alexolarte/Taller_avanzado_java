package co.com.crudtest.jpa;

import co.com.crudtest.jpa.entities.AnimalsEntity;
import co.com.crudtest.jpa.helper.AdapterOperations;
import co.com.crudtest.model.animales.Animals;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryAdapter
    extends AdapterOperations<
        Animals /* change for domain model */,
        AnimalsEntity /* change for adapter model */,
        String,
        JPARepository>
// implements ModelRepository from domain
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Animals.class));
    }
}
