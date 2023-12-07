package com.green.greengram3.dm.model;

import lombok.Data;


@Data
public class DmSelMsgVo {
    private int seq;
    private int writerIuser;
    private String writerPic;
    private String msg;
    private String createdAt;
}
