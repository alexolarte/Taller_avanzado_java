package co.com.crudtest.model.animales;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)

public class Animals {

    private String id;
    private int numpatas;
    private char genero;
    private String especie;
    private String habitad;
    private boolean domest;

}
