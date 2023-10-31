package co.com.crudtest.jpa.entities;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "animals")
public class AnimalsEntity {

    @Id
    private String id;
    @Column
    private int numpatas;
    @Column
    private char genero;
    @Column
    private String especie;
    @Column
    private String habitad;
    @Column
    private boolean domest;

}
