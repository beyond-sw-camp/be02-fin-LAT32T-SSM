package com.project.ssm.events.model.response;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
public class GetEventRes {

    @NotBlank
    private Long _id;

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    @Size(max = 100)
    private String description;

    @NotBlank
    private String start;

    @NotBlank
    private String end;

    @NotBlank
    private String type;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    private String backgroundColor;

    @NotBlank
    private String textColor;

    @NotBlank
    private Boolean allDay;

    public static GetEventRes buildEventRes(EventParticipants eventParticipants) {
        return GetEventRes.builder()
                ._id(eventParticipants.getEvent().getEventIdx())
                .title(eventParticipants.getEvent().getTitle())
                .description(eventParticipants.getEvent().getEventContent())
                .start(eventParticipants.getEvent().getStartedAt())
                .end(eventParticipants.getEvent().getClosedAt())
                .type(eventParticipants.getEvent().getType())
                .username(eventParticipants.getMember().getMemberName())
                .backgroundColor(eventParticipants.getEvent().getBackgroundColor())
                .textColor(eventParticipants.getEvent().getTextColor())
                .allDay(eventParticipants.getEvent().getAllDay())
                .build();
    }


//    [{\n" +
//        "    \"_id\": 1,\n" +
//                "    \"title\": \"거래처 미팅\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-07T09:30\",\n" +
//                "    \"end\": \"2019-05-07T15:00\",\n" +
//                "    \"type\": \"카테고리1\",\n" +
//                "    \"username\": \"다현\",\n" +
//                "    \"backgroundColor\": \"#D25565\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": false\n" +
//                "  }

//    public static GetEventRes getEventResBuilder(Long memberIdx, Long eventIdx, String title) {
//        return GetEventRes.builder()
//                .memberIdx(memberIdx)
//                .eventIdx(eventIdx)
//                .title(title)
////                .priority(priority)
////                .isLooped(isLooped)
////                .startedAt(startedAt)
////                .closedAt(closedAt)
//                .build();
//    }
}
