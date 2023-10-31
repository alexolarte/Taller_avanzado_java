
package co.com.crudtest.jpa;
import co.com.crudtest.model.animales.Animals;
import co.com.crudtest.model.animales.gateways.AnimalsRepository;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JpaAnimalsImpl implements AnimalsRepository {

    private JPARepositoryAdapter jpaRepositoryAdapter;

    @Override
    public void create(Animals animal) throws Exception  {
        String id = animal.getId();

        Animals animalDb = jpaRepositoryAdapter.findById(id);
        if (animalDb != null) throw new Exception("Animal ya Existe : " + id);
        //String id = UUID.randomUUID().toString();
        //animal.setId(id);
        jpaRepositoryAdapter.save(animal);
    }

    @Override
    public Animals read(String id) { return jpaRepositoryAdapter.findById(id); }

    @Override
    public Animals update(String id, Animals animal) throws Exception {
        Animals animalDb = jpaRepositoryAdapter.findById(id);

        if (animalDb == null) throw new Exception("Animal No Encontrado : " + id);

          animalDb.setNumpatas(animal.getNumpatas());
          animalDb.setGenero(animal.getGenero());
          animalDb.setEspecie(animal.getEspecie());
          animalDb.setHabitad(animal.getHabitad());
          animalDb.setDomest(animal.isDomest());

        jpaRepositoryAdapter.save(animalDb);
        return animalDb;
    }

    @Override
    public void delete(String id) { jpaRepositoryAdapter.deleteById(id); ; }

    @Override
    public List<Animals> getAll() {
        return jpaRepositoryAdapter.findAll();
    }
}
