package com.project.ssm.calendar.model.request;


import com.project.ssm.calendar.model.entity.PersonalEvent;
import com.project.ssm.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class GetPersonalEventReq {

    private Long memberIdx;
    private String memberId;
    private Long eventIdx;

//    public GetPersonalEventReq getPersonalEventReqBuilder(Long memberIdx, Long eventIdx){
//        GetPersonalEventReq getPersonalEventReq = GetPersonalEventReq.builder()
//                .memberIdx(memberIdx)
//                .eventIdx(eventIdx)
//                .build();
//
//        return getPersonalEventReq;
//    }
}
