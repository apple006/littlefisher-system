package com.littlefisher.blog.commentary.model.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Description: 查询评价列表条件
 *  
 * Created on 2017年5月23日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@ApiModel("查询评价列表条件")
public class GetCommentaryList4PagerByCondRequest {

    /**
     * pageNum
     */
    @ApiModelProperty(value = "页码")
    private int pageNum;
    
    /**
     * pageSize 每页行数
     */
    @ApiModelProperty(value = "每页行数")
    private int pageSize;
    
    /**
     * postId 博文主键
     */
    @ApiModelProperty(value = "博文主键")
    private Long postId;

    /**
     * keyword 关键字，针对评价博湖查询
     */
    @ApiModelProperty(value = "关键字，针对评价博湖查询")
    private String keyword;

    /**
     * createdDateStart 创建时间，时间范围开始
     */
    @ApiModelProperty(value = "创建时间，时间范围开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdDateStart;

    /**
     * createdDateEnd 创建时间，时间范围结束
     */
    @ApiModelProperty(value = "创建时间，时间范围结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdDateEnd;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getCreatedDateStart() {
        return createdDateStart;
    }

    public void setCreatedDateStart(Date createdDateStart) {
        this.createdDateStart = createdDateStart;
    }

    public Date getCreatedDateEnd() {
        return createdDateEnd;
    }

    public void setCreatedDateEnd(Date createdDateEnd) {
        this.createdDateEnd = createdDateEnd;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GetCommentaryList4PagerByCondRequest [pageNum=");
        builder.append(pageNum);
        builder.append(", pageSize=");
        builder.append(pageSize);
        builder.append(", postId=");
        builder.append(postId);
        builder.append(", keyword=");
        builder.append(keyword);
        builder.append(", createdDateStart=");
        builder.append(createdDateStart);
        builder.append(", createdDateEnd=");
        builder.append(createdDateEnd);
        builder.append("]");
        return builder.toString();
    }
    
    
}
