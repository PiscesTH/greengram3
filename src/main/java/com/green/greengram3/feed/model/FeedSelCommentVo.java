package com.green.greengram3.feed.model;

import lombok.Data;

@Data
public class FeedSelCommentVo {
    private int ifeedComment;
    private String comment;
    private String createdAt;
    private int writerIuser;
    private String writerNm;
    private String writerPic;
}
