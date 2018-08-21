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
@Table(name = "t_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "image_urls")
    private String imageUrls;

    @Column(name = "has_image")
    private boolean hasImage;

    @Column(name = "type")
    private int type;

    @Column(name = "value_id")
    private long valueId;

    @Column(name = "content")
    private String content;

    @Column(name = "create_time")
    private Date createTime;

}
