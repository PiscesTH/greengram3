package com.green.greengram3.dm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class DmSelMsgDto {
    private int page;
    private int idm;
    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount;

}
