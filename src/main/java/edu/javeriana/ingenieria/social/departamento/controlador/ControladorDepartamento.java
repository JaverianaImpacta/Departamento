package edu.javeriana.ingenieria.social.departamento.controlador;

import edu.javeriana.ingenieria.social.departamento.dominio.Departamento;
import edu.javeriana.ingenieria.social.departamento.servicio.ServicioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorDepartamento {
    @Autowired
    private ServicioDepartamento servicio;

    @GetMapping("listar")
    public List<Departamento> obtenerDepartamentos() {
        return servicio.obtenerDepartamentos();
    }

    @GetMapping("obtenerFacultad")
    public ResponseEntity<List<Departamento>> obtenerDepartamentos(@RequestParam Integer facultad) {
        if(facultad==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerDepartamentos(facultad).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerDepartamentos(facultad), HttpStatus.OK);
    }

    @GetMapping("obtener")
    public ResponseEntity<Departamento> obtenerDepartamento(@RequestParam Integer codigo){
        if(codigo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.departamentoExiste(codigo)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerDepartamento(codigo), HttpStatus.OK);
    }
}
