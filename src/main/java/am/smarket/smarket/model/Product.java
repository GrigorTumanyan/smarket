package am.smarket.smarket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String price;
    @Column
    private int discount;
    @Column
    private String description;
    @Column
    private String img_url;
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Category category;
    @Column
    private int sub_category_id;
    @Column
    private int second_sub_category_id;
}
