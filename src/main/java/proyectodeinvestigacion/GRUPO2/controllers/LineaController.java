package proyectodeinvestigacion.GRUPO2.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectodeinvestigacion.GRUPO2.entities.Linea;
import proyectodeinvestigacion.GRUPO2.services.LineaService;

@RestController
@RequestMapping("api/linea")
@CrossOrigin("*")
public class LineaController {

    @Autowired
    private LineaService lineaService;

    // crear
    // metod delimitador de acceso,tipo de dato que retorna,nombre del
    // metodo/funcion
    @PostMapping("/crear")
    public Linea save(@RequestBody Linea entity) {
        return lineaService.save(entity);
    }

    // traer por id
    @GetMapping("/listar/{id}")
    public Linea findById(@PathVariable long id) {
        return lineaService.findById(id);
    }

    // traer todo
    @GetMapping("/listar")
    public List<Linea> findAll() {
        return lineaService.findAll();
    }

    // actualizar
    @PutMapping("/actualizar")
    public Linea update(@RequestBody Linea entity) {
        return lineaService.save(entity);
    }

    // actualizar parcial
    @PatchMapping("/actualizar/{id}")
    public Linea partialUpdate(@PathVariable long id, @RequestBody Map<String, Object> fields) {
        Linea linea = findById(id);
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            try {
                Field campoEntidad = Linea.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(linea, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                
            }
        }
        return update(linea);
    }

    // eliminar
    @DeleteMapping("/eliminar/{id}")
    public void deleteById(@PathVariable long id) {
        lineaService.deleteById(id);
    }

}