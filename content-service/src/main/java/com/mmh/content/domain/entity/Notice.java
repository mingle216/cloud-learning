package com.mmh.content.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author mingle
 * @date 2022/9/6 20:04
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Notice {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 内容
     */
    private String content;

    /**
     * 是否显示 0:否 1:是
     */
    private boolean showFlag;

    /**
     * 创建时间
     */
    private Date createTime;
}
