package com.project.batch.job;

import lombok.*;

import java.time.LocalDateTime;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class sendScheduleAlarmReq {
    private Long eventIdx;
    private LocalDateTime startedAt;
    private String title;
    private String memberId;
}
