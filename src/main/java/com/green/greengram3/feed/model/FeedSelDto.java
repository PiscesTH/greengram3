package com.green.greengram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram3.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class FeedSelDto {
    @Schema(title = "페이지")
    private int page;
    @Schema(title = "로그인한 유저 pk")
    private int loginedIuser;
    @Schema(title = "프로필 주인 유저pk")
    private int targetIuser;

    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int feedCnt = Const.FEED_COUNT_PER_PAGE;

    public void setPage(int page) {
        this.startIdx = (page - 1) * feedCnt;
    }

}
