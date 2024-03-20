package com.project.ssm.events.model.response;

import com.project.ssm.events.model.entity.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DeleteEventRes {

    private Long eventIdx;

    public static DeleteEventRes buildEventRes(Event event){
        return DeleteEventRes.builder()
                .eventIdx(event.getEventIdx())
                .build();
    }
}
