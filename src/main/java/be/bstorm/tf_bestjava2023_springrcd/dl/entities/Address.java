package be.bstorm.tf_bestjava2023_springrcd.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@ToString(of = {"id","street","number","zipCode","city","country"})
@EqualsAndHashCode(of = {"id","street","number","zipCode","city","country"})
@Table(name = "ADDRESS")
public class Address {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Getter
    @Setter
    @Column(name = "STREET",nullable = false)
    private String street;

    @Getter
    @Setter
    @Column(name = "NUMBER",nullable = false)
    private String number;

    @Getter
    @Setter
    @Column(name = "ZIP_CODE",nullable = false)
    private String zipCode;

    @Getter
    @Setter
    @Column(name = "CITY",nullable = false)
    private String city;

    @Getter
    @Setter
    @Column(name = "COUNTRY",nullable = false)
    private String country;
}
