package com.example.IntelliasTask.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * This entity class for table "good" id db
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(schema = "public", name = "good")
public class Good {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "good_id")
    private Integer id;


    @Column(name = "good_name")
    private String name;

    @Column(name = "good_price")
    private Integer price;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "good", cascade = CascadeType.REMOVE)
    private Collection<UserGood> users = new ArrayList<>();
}
