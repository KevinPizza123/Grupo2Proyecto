package proyectodeinvestigacion.GRUPO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import proyectodeinvestigacion.GRUPO2.entities.Carrera;
import proyectodeinvestigacion.GRUPO2.services.CarreraService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/carreras")
@CrossOrigin("*")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @PostMapping("/create")
    public ResponseEntity<Carrera> crearCarrera(@RequestBody Carrera carrera) {
        Carrera nuevaCarrera = carreraService.crearCarrera(carrera);
        return new ResponseEntity<>(nuevaCarrera, CREATED);
    }

    @GetMapping("/lista")
    public List<Carrera> getAll() {
        return carreraService.getAll();
    }

    @GetMapping("buscar/{id}/")
    public Carrera findById(@PathVariable long id) {
        return carreraService.findById(id);
    }

    @DeleteMapping("eliminar/{id}")
    public void deleteById(@PathVariable long id) {
        carreraService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Carrera> actualizarCarrera(@PathVariable("id") Long id, @RequestBody Carrera carrera) {
        Carrera carreraExistente = carreraService.findById(id);

        if (carreraExistente == null) {
            return new ResponseEntity<>(NOT_FOUND);
        }

        carreraExistente.setNombre(carrera.getNombre());
        carreraExistente.setDescripcion(carrera.getDescripcion());

        Carrera carreraActualizada = carreraService.actualizarCarrera(carreraExistente);
        if (carreraActualizada == null) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(carreraActualizada, OK);
    }
}
