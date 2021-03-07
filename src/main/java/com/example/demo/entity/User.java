package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "user_table")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private String pseudo;
    @Column
    private String telephone;
    @Column
    private String password ;

    @ManyToOne
    @JoinColumn(nullable = true, name = "location_id")
    private Location address;
}
