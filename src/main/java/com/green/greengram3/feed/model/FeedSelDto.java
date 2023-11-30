package com.green.greengram3.feed.model;

import com.green.greengram3.common.Const;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class FeedSelDto {
    private int startIdx;
    private int feedCnt = Const.FEED_COUNT_PER_PAGE;

    public FeedSelDto(int page) {
        this.startIdx = (page - 1) * feedCnt;
    }
}
