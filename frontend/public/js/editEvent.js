/* ****************
 *  일정 편집
 * ************** */
var backend = window.apiEndpoint;

var editEvent = function (event, element, view) {

    $('#deleteEvent').data('id', event._id); //클릭한 이벤트 ID

    $('.popover.fade.top').remove();
    $(element).popover("hide");

    if (event.allDay === true) {
        editAllDay.prop('checked', true);
    } else {
        editAllDay.prop('checked', false);
    }

    if (event.end === null) {
        event.end = event.start;
    }

    if (event.allDay === true && event.end !== event.start) {
        editEnd.val(moment(event.end).subtract(1, 'days').format('YYYY-MM-DD HH:mm'))
    } else {
        editEnd.val(event.end.format('YYYY-MM-DD HH:mm'));
    }

    modalTitle.html('일정 수정');
    editTitle.val(event.title);
    editStart.val(event.start.format('YYYY-MM-DD HH:mm'));
    editType.val(event.type);
    editDesc.val(event.description);
    editColor.val(event.backgroundColor).css('color', event.backgroundColor);

    addBtnContainer.hide();
    modifyBtnContainer.show();
    eventModal.modal('show');

    //업데이트 버튼 클릭시
    $('#updateEvent').unbind();
    $('#updateEvent').on('click', function () {

        if (editStart.val() > editEnd.val()) {
            alert('끝나는 날짜가 앞설 수 없습니다.');
            return false;
        }

        if (editTitle.val() === '') {
            alert('일정명은 필수입니다.')
            return false;
        }

        var statusAllDay;
        var startDate;
        var endDate;
        var displayDate;

        if (editAllDay.is(':checked')) {
            statusAllDay = true;
            startDate = moment(editStart.val()).format('YYYY-MM-DD');
            endDate = moment(editEnd.val()).format('YYYY-MM-DD');
            displayDate = moment(editEnd.val()).add(1, 'days').format('YYYY-MM-DD');
        } else {
            statusAllDay = false;
            startDate = editStart.val();
            endDate = editEnd.val();
            displayDate = endDate;
        }

        eventModal.modal('hide');

        event.allDay = statusAllDay;
        event.title = editTitle.val();
        event.start = startDate;
        event.end = displayDate;
        event.type = editType.val();
        event.backgroundColor = editColor.val();
        event.description = editDesc.val();

        $("#calendar").fullCalendar('updateEvent', event);

        //일정 업데이트
        $.ajax({
            type: "PATCH",
            url: backend + "/calendar/event/update",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': localStorage.getItem('accessToken')
            },
            datatype: "JSON",
            data: JSON.stringify({
                "eventIdx":event._id,
                "title": event.title,
                "startedAt":event.start,
                "closedAt":event.end,
                "eventContent":event.description,
                "type":"null",
                "backgroundColor":event.backgroundColor,
                "allDay":statusAllDay,
            }),
            success: function (response) {
                console.log(response)
                alert('수정되었습니다.')
            },
            error: function (error) {
                if(error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-002' || error.response.data.code === 'COMMON-003'){
                    alert(error.responseJSON.message);
                } else if (error.response.data.code === 'ACCOUNT-001' || error.response.data.code === 'ACCOUNT-002' || error.response.data.code === 'ACCOUNT-003' || error.response.data.code === 'ACCOUNT-004') {
                    alert(error.responseJSON.message);
                } else if (error.response.data.code === 'MEMBER-008') {
                    alert(error.responseJSON.message);
                } else if (error.responseJSON.code ==='CALENDAR_007' || error.responseJSON.code ==='CALENDAR_008') {
                    alert(error.responseJSON.message);
                } else {
                    alert('오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
                }
            }
        });

    });

    // 삭제버튼
    $('#deleteEvent').on('click', function () {
    
    $('#deleteEvent').unbind();
    //$("#calendar").fullCalendar('removeEvents', $(this).data('id'));
    eventModal.modal('hide');

    //삭제시
    $.ajax({
        type: "DELETE",
        url: backend + "/calendar/event/delete/" + event._id,
        headers: {
            'Authorization': localStorage.getItem('accessToken')
        },
        dataType: "JSON",
        data: {
            
        },
        success: function (response) {
            console.log(response)           
            alert('삭제되었습니다.');
            $('#calendar').fullCalendar('removeEvents');
            $('#calendar').fullCalendar('refetchEvents');
        }
    });

});
};

