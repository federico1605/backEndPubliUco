package co.edu.uco.publiuco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departamento")
public class DepartamentoEntity {

    @Id
    private UUID codigo;
    @ManyToOne
    @JoinColumn(name = "pais")
    private PaisEntity paisEntity;
    private String nombre;
}
