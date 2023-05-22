package proyectodeinvestigacion.GRUPO2.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "linea")
public class Linea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String carrera;
    private String estado;
    private LocalDate fecha_aprobacion;

    @ManyToMany()
    @JoinTable(name = "linea_sublinea", joinColumns = @JoinColumn(name = "linea_id"), inverseJoinColumns = @JoinColumn(name = "sublinea_id"))
    private List<Sublinea> sublineas;
}