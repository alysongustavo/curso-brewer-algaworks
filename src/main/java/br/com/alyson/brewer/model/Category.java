package br.com.alyson.brewer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    @Getter
    @Setter
    private Integer id;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    private String name;

    @Column(nullable = true, length = 255)
    @Setter
    @Getter
    private String image;

}
