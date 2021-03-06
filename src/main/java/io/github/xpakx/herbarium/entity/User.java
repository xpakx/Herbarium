package io.github.xpakx.herbarium.entity;

import javax.persistence.Entity;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.Size;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.persistence.Table;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  
  @Column(nullable=false, unique=true)
  @NotEmpty
  private String username;
  
  @Column(nullable=false, unique=true)
  @NotEmpty
  @Email(message="Wrong e-mail address")
  private String email;
  
  @Column(nullable=false)
  @NotEmpty
  @Size(min=6)
  private String password;
  
  @Transient
  private String confirmPassword;
  
  @ManyToMany(cascade=CascadeType.MERGE)
  @JoinTable(name="user_role", 
             joinColumns={@JoinColumn(name="user_id",  referencedColumnName="id")},
             inverseJoinColumns={@JoinColumn(name="role_id",  referencedColumnName="id")})
  private List<UserRole> roles;
}
