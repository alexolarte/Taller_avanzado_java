package co.com.crudtest.model.animales.gateways;

import co.com.crudtest.model.animales.Animals;
import java.util.List;

public interface AnimalsRepository {

    void create(Animals animal) throws Exception;

    Animals read(String id);

    default Animals update(String id, Animals animal) throws Exception {
        return animal;
    }

    void delete(String id);

    List<Animals> getAll();
}
