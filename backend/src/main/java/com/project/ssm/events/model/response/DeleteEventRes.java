package com.project.ssm.events.model.response;

import com.project.ssm.events.model.entity.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class DeleteEventRes {

    @NotBlank
    private Long eventIdx;

    public static DeleteEventRes buildEventRes(Event event){
        return DeleteEventRes.builder()
                .eventIdx(event.getEventIdx())
                .build();
    }
}
