package com.example.IntelliasTask.model;

import lombok.*;

import javax.persistence.*;

/**
 * This entity class for table "user_good" id db
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(schema = "public", name = "user_good")
public class UserGood {

    @EmbeddedId
    private UserGoodId id;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @MapsId("goodId")
    @ManyToOne
    @JoinColumn(name = "good_id")
    private Good good;
}
