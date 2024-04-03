package com.project.ssm.events.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Setter
@Builder
@Getter
public class PatchEventReq {

    @NotBlank
    private Long eventIdx;

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    private String startedAt;

    @NotBlank
    private String closedAt;

    @NotBlank
    @Size(max = 100)
    private String eventContent;

    @NotBlank
    private String type;

    @NotBlank
    private String backgroundColor;

    @NotBlank
    private Boolean allDay;

}
