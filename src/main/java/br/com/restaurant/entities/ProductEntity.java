package br.com.restaurant.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Component
@Table(name = "product")
public class ProductEntity {

    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false)
    private UUID id;

    /**
     * Name
     */
    @Column(name = "name")
    private String name;

}
