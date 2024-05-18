package edu.javeriana.ingenieria.social.departamento.repositorio;

import edu.javeriana.ingenieria.social.departamento.dominio.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDepartamento extends JpaRepository<Departamento, Integer> {
    Departamento findOneByCodigo(Integer codigo);

    boolean existsByCodigo(Integer codigo);

    List<Departamento> findAllByFacultad(Integer facultad);
}
