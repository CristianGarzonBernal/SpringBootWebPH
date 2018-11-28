package com.pacto.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "*Porfavor ingresa un email valido")
    @NotEmpty(message = "*Ingresa tu email")
    private String email;
    @Column(name = "password")
    @Length(min = 6, message = "*Minimo 6 caracteres en la contraseña")
    @NotEmpty(message = "*Ingresa tu contraseña")
    private String password;

    @Column(name = "passwordN")
    private String passwordN;

    @Column(name = "surname")
    @NotEmpty(message = "*Ingresa tu nombre de usuario")
    private String surname;

    @Column(name = "name")
    @NotEmpty(message = "*Ingresa tu nombre")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "*Ingresa tu apellido")
    private String lastName;

    @Column(name = "sex")
    @NotEmpty(message = "*Ingresa tu sexo")
    private String sex;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

}
