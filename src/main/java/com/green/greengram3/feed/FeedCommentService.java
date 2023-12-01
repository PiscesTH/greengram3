package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedInsCommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper commentMapper;

    public ResVo postFeedComment(FeedInsCommentDto dto) {
        int insResult = commentMapper.insFeedComment(dto);
        if (insResult == 0) {
            return new ResVo(insResult);
        }
        return new ResVo(dto.getIfeedComment());
    }
}
