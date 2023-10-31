package co.com.crudtest.api;

import co.com.crudtest.model.animales.Animals;
import co.com.crudtest.usecase.animales.CrudAnimalsUseCase;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@ResponseBody
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
  private final CrudAnimalsUseCase crudAnimalesUseCase;

  @GetMapping(path = "/animales/{id}")
  public Animals read(@PathVariable String id) {
    return crudAnimalesUseCase.read(id);
  }

  @PostMapping(path = "/animales")
  public void create(@RequestBody Animals animal) {
    try {
      crudAnimalesUseCase.create(animal);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @PutMapping(path = "/animales/{id}")
  public void update(@PathVariable String id, @RequestBody Animals animal) {
    try {
      crudAnimalesUseCase.update(id, animal);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @DeleteMapping(path = "/animales/{id}")
  public void delete(@PathVariable String id) {
    crudAnimalesUseCase.delete(id);
  }

  @GetMapping(path = "/animales")
  public List<Animals> getAll() {
    return crudAnimalesUseCase.getAll();
  }
}
