package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "user_table")
public class User {
    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private String pseudo;
    @Column
    private String telephone;
    @Column
    private String password;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<Article> article;

    @ManyToOne
    @JoinColumn(nullable = true, name = "location_id")
    private Location address;
}
