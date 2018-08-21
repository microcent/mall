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
@Table(name = "t_product_specification")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSpecification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "specification")
    private String specification;

    @Column(name = "value")
    private String value;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_time")
    private Date createTime;

}
