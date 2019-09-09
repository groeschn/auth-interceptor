package de.groeschn.javaee.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long roleId;
    private String name;
}
