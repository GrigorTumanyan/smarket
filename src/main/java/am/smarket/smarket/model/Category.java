package am.smarket.smarket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column(name = "category_name")
    private String name;
    @Column (name = "parent_id")
    private int parent;
//    @OneToMany(mappedBy = "category",orphanRemoval = true,cascade = CascadeType.ALL)
//    private List<Product> products;
}
