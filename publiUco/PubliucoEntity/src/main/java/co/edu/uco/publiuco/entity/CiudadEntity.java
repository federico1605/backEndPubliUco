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
@Table(name = "ciudad")
public class CiudadEntity {

    @Id
    private UUID codigo;
    @ManyToOne
    @JoinColumn(name = "departamento")
    private DepartamentoEntity departamentoEntity;
    private String ciudad;
}
