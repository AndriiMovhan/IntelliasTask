package com.example.IntelliasTask.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * This class embeddable for UserGood class
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserGoodId implements Serializable {

    private static final long serialVersionUID = 140758034071459421L;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "good_id")
    private Integer goodId;
}
