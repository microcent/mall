package cn.com.microcent.domain.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/17.
 */
@Entity
@Table(name = "t_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_no")
    private String productNo;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "brand_id")
    private long brandId;

    @Column(name = "gallery")
    private String gallery;

    @Column(name = "keyword")
    private String keyword;

    @Column(name = "stock")
    private int stock;

    @Column(name = "create_time")
    private Date createTime;

}
