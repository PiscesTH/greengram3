package com.green.greengram3.feed;

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

    public List<FeedSelVo> getAllFeed(FeedSelDto dto){
        List<FeedSelVo> resultVo = feedMapper.selAllFeed(dto);
        Map<Integer,FeedSelVo> map = new HashMap<>();
        List<Integer> ifeeds = new ArrayList<>();
        for (FeedSelVo vo : resultVo) {
            ifeeds.add(vo.getIfeed());
            map.put(vo.getIfeed(),vo);
        }
        List<FeedSelPicVo> picsVo = picsMapper.selPicsByIfeeds(ifeeds);
        for (FeedSelPicVo picVo : picsVo) {
            map.get(picVo.getIfeed()).getPics().add(picVo.getPic());
        }
        return resultVo;
    }
}
