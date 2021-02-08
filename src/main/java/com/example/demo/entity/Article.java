package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Article {
    @Id
    @Column()
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private String title;
    @Column()
    private  String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
