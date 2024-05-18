package edu.javeriana.ingenieria.social.departamento.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Departamento {
    @Id
    private Integer id;
    private Integer codigo, facultad, programa;
    private String nombre;
}
