package com.project.ssm.calendar.model.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class GetEventReq {

//    private Long memberIdx;
//    private String memberId;
    private Long eventIdx;

//    public GetEventReq getEventReqBuilder(Long memberIdx, Long eventIdx){
//        GetEventReq getEventReq = GetEventReq.builder()
//                .memberIdx(memberIdx)
//                .eventIdx(eventIdx)
//                .build();
//
//        return getEventReq;
//    }
}
