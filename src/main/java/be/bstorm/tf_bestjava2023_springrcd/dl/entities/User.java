package be.bstorm.tf_bestjava2023_springrcd.dl.entities;

import be.bstorm.tf_bestjava2023_springrcd.dl.enums.UserGender;
import be.bstorm.tf_bestjava2023_springrcd.dl.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER_")
@ToString(of = {"id", "lastname", "firstname", "email", "role", "gender"})
@EqualsAndHashCode(of = {"id", "lastname", "firstname", "email", "role", "gender"})
public class User implements UserDetails {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Getter
    @Setter
    @Column(name = "FIRSTNAME", nullable = false, length = 50)
    private String firstname;

    @Getter
    @Setter
    @Column(name = "LASTNAME", nullable = false, length = 50)
    private String lastname;

    @Getter
    @Setter
    @Column(name = "EMAIL", nullable = false, unique = true, length = 150)
    private String email;

    @Getter
    @Setter
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Getter
    @Setter
    @Column(name = "GENDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGender gender;

    @ManyToMany
    @JoinTable(name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
    private Set<Address> addresses;

    public User() {
        this.addresses = new HashSet<>();
    }

    public User(String email, String password) {
        this();
        this.email = email;
        this.password = password;
    }

    public User(String firstname, String lastname, String email, String password, UserGender gender) {
        this(email, password);
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    public Set<Address> getAddresses() {
        return Set.copyOf(this.addresses);
    }

    public void addAddress(Address address){
        this.addresses.add(address);
    }

    public void removeAddress(Address address){
        this.addresses.remove(address);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.toString()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
