package com.green.greengram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram3.common.Const;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class FeedSelDto {
    private int page;
    private int loginedIuser;

    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int feedCnt = Const.FEED_COUNT_PER_PAGE;

    public void setPage(int page) {
        this.startIdx = (page - 1) * feedCnt;
    }

}
