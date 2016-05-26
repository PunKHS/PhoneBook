package com.phonebook.model;

import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by PunKHS on 07.05.2016.
 */

@Entity
@Table(name = "department", schema = "public")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String shortName;
    private Long parent;
}
