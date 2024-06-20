package projectBackend.Odontologia.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table (name = "pacientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String cedula;
    @Column
    private LocalDate fechaIngreso;
    @Embedded
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    @PrimaryKeyJoinColumn
    private Domicilio domicilio;
    @Column(nullable = false)
    private String email;


}
