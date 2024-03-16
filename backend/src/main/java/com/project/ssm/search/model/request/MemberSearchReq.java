package com.project.ssm.search.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberSearchReq {
    private String keyword;
}
