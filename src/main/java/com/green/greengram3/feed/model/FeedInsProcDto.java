package com.green.greengram3.feed.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FeedInsProcDto {
    private int iuser;
    private String contents;
    private String location;
    private int ifeed;
}
