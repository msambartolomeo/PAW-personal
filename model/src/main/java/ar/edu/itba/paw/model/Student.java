package ar.edu.itba.paw.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends UserInheritance{

    @Column(nullable = false)
    private long legajo;

    private float promedio;

    Student() {}
}
