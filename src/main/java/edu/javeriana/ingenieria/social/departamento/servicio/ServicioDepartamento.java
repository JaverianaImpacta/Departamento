package edu.javeriana.ingenieria.social.departamento.servicio;

import edu.javeriana.ingenieria.social.departamento.dominio.Departamento;
import edu.javeriana.ingenieria.social.departamento.repositorio.RepositorioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDepartamento {

    @Autowired
    private RepositorioDepartamento repositorio;

    public List<Departamento> obtenerDepartamentos() {
        return repositorio.findAll();
    }

    public List<Departamento> obtenerDepartamentos(Integer facultad) {
        return repositorio.findAllByFacultad(facultad);
    }

    public Departamento obtenerDepartamento(Integer codigo){
        return repositorio.findOneByCodigo(codigo);
    }

    public boolean departamentoExiste(Integer codigo){
        return repositorio.existsByCodigo(codigo);
    }
}
