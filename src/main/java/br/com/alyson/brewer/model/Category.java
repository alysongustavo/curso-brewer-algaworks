package br.com.alyson.brewer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Category {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_gen")
    @SequenceGenerator(name = "category_seq_gen", sequenceName = "category_id_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    @NotEmpty
    private String name;

    @Column(nullable = true, length = 255)
    @Setter
    @Getter
    @NotEmpty
    private String image;

}
