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
 * @date 2022/9/6 19:55
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Share {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    /**
     * 发布人id
     */
    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否原创 0:否 1:是
     */
    private int isOriginal;

    /**
     * 作者
     */
    private String author;

    /**
     * 封面
     */
    private String cover;

    /**
     * 概要信息
     */
    private String summary;

    /**
     * 价格（需要的积分）
     */
    private Integer price;

    /**
     * 下载地址
     */
    private String downloadUrl;

    /**
     * 下载数
     */
    private Integer buyCount;

    /**
     * 是否显示 0:否 1:是
     */
    private boolean showFlag;

    /**
     * 审核状态 not_yet: 待审核 passed:审核通过 rejected:审核不通过
     */
    private String auditStatus;

    /**
     * 审核不通过原因
     */
    private String reason;
}
