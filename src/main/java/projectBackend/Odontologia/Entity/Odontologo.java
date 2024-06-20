package projectBackend.Odontologia.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "odontologos")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String matricula;
}
