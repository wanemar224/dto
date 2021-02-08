package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Location {
    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    String streetName;

    @OneToMany(
            mappedBy = "address",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private Set<User> users;
    public void addUser(User user){
        this.users.add(user);
    }
}
