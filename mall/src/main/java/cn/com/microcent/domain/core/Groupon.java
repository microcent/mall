package cn.com.microcent.domain.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/8/17.
 */
@Entity
@Table(name = "t_groupon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Groupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "discount_member")
    private int discountMember;

    @Column(name = "expire_time")
    private Date expireTime;

    @Column(name = "create_time")
    private Date createTime;

}
