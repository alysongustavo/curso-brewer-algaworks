package br.com.alyson.brewer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @SequenceGenerator(name = "product_seq_gen", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    @Getter
    @Setter
    private Integer id;

    @Column(length = 100, nullable = false)
    @NotEmpty
    @Getter
    @Setter
    private String name;

    @ManyToOne
    @Getter
    @Setter
    private Category category;

    @Column(nullable = false, scale = 9, precision = 2)
    @NotNull(message = "O Preço deve ser informado")
    @Getter
    @Setter
    private BigDecimal price;

    @Getter
    @Setter
    private String image;



}
