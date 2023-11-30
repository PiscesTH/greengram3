package com.green.greengram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class FeedInsDto {
    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;
}
