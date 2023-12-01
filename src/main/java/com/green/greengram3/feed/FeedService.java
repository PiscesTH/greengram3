package com.green.greengram3.feed;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper feedMapper;
    private final FeedPicsMapper picsMapper;
    private final FeedFavMapper favMapper;
    private final FeedCommentMapper commentMapper;

    public ResVo postFeed(FeedInsDto dto) {
        FeedInsProcDto pDto1 = FeedInsProcDto.builder()
                .iuser(dto.getIuser())
                .contents(dto.getContents())
                .location(dto.getLocation())
                .build();
        int feedResult = feedMapper.insFeed(pDto1);
        FeedInsPicDto pDto2 = FeedInsPicDto.builder()
                .ifeed(pDto1.getIfeed())
                .pics(dto.getPics())
                .build();
        int picsResult = picsMapper.insPic(pDto2);

        return new ResVo(pDto1.getIfeed());
    }

    public List<FeedSelVo> getAllFeed(FeedSelDto dto) {
        List<FeedSelVo> resultVo = feedMapper.selAllFeed(dto);
        Map<Integer, FeedSelVo> map = new HashMap<>();
        List<Integer> ifeeds = new ArrayList<>();
        FeedSelCommentDto commentDto = FeedSelCommentDto.builder()
                .startIdx(0)
                .commentCnt(Const.MAX_COMMENT_COUNT)
                .build();
        for (FeedSelVo vo : resultVo) {
            ifeeds.add(vo.getIfeed());
            map.put(vo.getIfeed(), vo);

            commentDto.setIfeed(vo.getIfeed());
            List<FeedSelCommentVo> commentVoList = commentMapper.selFeedCommentAll(commentDto);
            vo.setComments(commentVoList);
            if (commentVoList.size() == Const.MAX_COMMENT_COUNT) {
                vo.setIsMoreComment(1);
                vo.getComments().remove(commentVoList.size() - 1);
            }
        }
        List<FeedSelPicVo> picsVo = picsMapper.selPicsByIfeeds(ifeeds);
        for (FeedSelPicVo picVo : picsVo) {
            map.get(picVo.getIfeed()).getPics().add(picVo.getPic());
        }
        return resultVo;
    }

    //좋아요 취소 - 0, 등록 - 1
    public ResVo toggleFeedFav(FeedToggleFavDto dto) {
        try {
            int delResult = favMapper.delFeedFav(dto);
            if (delResult == 1) {
                return new ResVo(Const.FAV_OFF);
            }
            int insResult = favMapper.insFeedFav(dto);
            return new ResVo(Const.FAV_ON);
        } catch (Exception e) {
            return new ResVo(Const.FAV_OFF);
        }
    }
}
