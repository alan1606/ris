package com.diagnocons.ris.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tipoUsuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String tipo;

}
