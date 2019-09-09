package de.groeschn.javaee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select distinct a from User a left join fetch a.roles"),
        @NamedQuery(name = "User.findByUsername", query = "select distinct a from User a left join fetch a.roles where a.username = :username")
})
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String username;
    @ManyToMany
    private Set<Role> roles;

    @Transient
    public boolean isAuthorisedFor(String roleName) {
        return roles.stream().anyMatch(
                role -> role.getName().equalsIgnoreCase(roleName)
        );
    }
}


