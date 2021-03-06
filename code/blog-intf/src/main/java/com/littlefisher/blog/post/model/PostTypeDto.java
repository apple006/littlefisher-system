package com.littlefisher.blog.post.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 *
 * Description: post_type 实体
 *
 * Created on 2017年05月24日
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Table(name = "post_type")
@ApiModel(value = "post_type实体")
public class PostTypeDto implements Serializable {
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    @Id
    private String type;

    /**
     * 类型名
     */
    @ApiModelProperty(value = "类型名")
    @Column(name = "type_name")
    private String typeName;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String comments;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Description: toString<br>
     *
     * @author autoCreated <br>
    
     * @return String String<br>
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", type=").append(type);
        sb.append(", typeName=").append(typeName);
        sb.append(", comments=").append(comments);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}