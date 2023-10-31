package co.com.crudtest.usecase.animales;

import co.com.crudtest.model.animales.Animals;
import co.com.crudtest.model.animales.gateways.AnimalsRepository;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CrudAnimalsUseCase {

    private AnimalsRepository animalsRepository;

    public void create(Animals animal) throws Exception {
        animalsRepository.create(animal);
    }

    public Animals read(String id) {
        return animalsRepository.read(id);
    }

    public Animals update(String id, Animals animal) throws Exception {
        animalsRepository.update(id, animal);
        return animal;
    }

    public void delete(String id) {
        animalsRepository.delete(id);
    }

    public List<Animals> getAll() { return animalsRepository.getAll(); }
}
