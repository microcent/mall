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
@Table(name = "t_topic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "content")
    private String content;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "read_count")
    private int readCount;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "sort_no")
    private int sortNo;

    @Column(name = "products")
    private String products;

    @Column(name = "create_time")
    private Date createTime;

}
