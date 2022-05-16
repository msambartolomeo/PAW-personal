package ar.edu.itba.paw.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Professor extends UserInheritance{

    @Column(nullable = false)
    private long sueldo;

    @Column(nullable = false)
    private int modulosAsignados;

    Professor() {}
}
