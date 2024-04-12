var backend = window.apiEndpoint;

var eventModal = $('#eventModal');

var modalTitle = $('.modal-title');
var editAllDay = $('#edit-allDay');
var editTitle = $('#edit-title');
var editStart = $('#edit-start');
var editEnd = $('#edit-end');
var editType = $('#edit-type');
var editColor = $('#edit-color');
var editDesc = $('#edit-desc');
var editMember = $('#edit-member');
var editRoom = $('#edit-room');

var addBtnContainer = $('.modalBtnContainer-addEvent');
var modifyBtnContainer = $('.modalBtnContainer-modifyEvent');


/* ****************
 *  새로운 일정 생성
 * ************** */
var newEvent = function (start, end, eventType) {

    $("#contextMenu").hide(); //메뉴 숨김

    modalTitle.html('새로운 일정');
    editType.val(eventType).prop('selected', true);
    editTitle.val('');
    editStart.val(start);
    editEnd.val(end);
    editDesc.val('');
    editMember.val('');    
    console.log(editMember.val(''));
    editRoom.val('');

    addBtnContainer.show();
    modifyBtnContainer.hide();
    eventModal.modal('show');

    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/
    // var eventId = 1 + Math.floor(Math.random() * 1000);
    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/

    //새로운 일정 저장버튼 클릭
    $('#save-event').unbind();
    $('#save-event').on('click', function () {

        var eventData = {
            title: editTitle.val(),
            start: editStart.val(),
            end: editEnd.val(),
            description: editDesc.val(),
            type: editType.val(),
            username: editMember.val(),
            backgroundColor: editColor.val(),
            textColor: '#ffffff',
            allDay: false,
            roomIdx: editRoom.val() === '' ? null : Number(editRoom.val())
        };

        if (eventData.start > eventData.end) {
            alert('끝나는 날짜가 앞설 수 없습니다.');
            return false;
        }

        if (eventData.title === '') {
            alert('일정명은 필수입니다.');
        
            return false;
        }

        if (eventData.username.length === 0) {
            alert('멤버선택은 필수입니다.');
            return false;
        }

        var realEndDay;

        if (editAllDay.is(':checked')) {
            eventData.start = moment(eventData.start).format('YYYY-MM-DD');
            //render시 날짜표기수정
            eventData.end = moment(eventData.end).add(1, 'days').format('YYYY-MM-DD');
            //DB에 넣을때(선택)
            realEndDay = moment(eventData.end).format('YYYY-MM-DD');

            eventData.allDay = true;
        }

        $("#calendar").fullCalendar('renderEvent', eventData, true);
        eventModal.find('input, textarea').val('');
        editAllDay.prop('checked', false);
        eventModal.modal('hide');


        //새로운 일정 저장
        $.ajax({
            type: "post",
            url: backend + "/calendar/event/create",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': localStorage.getItem('accessToken')
            },
            datatype: "JSON",
            data: JSON.stringify({
                "title": eventData.title,
                "startedAt":eventData.start,
                "closedAt":eventData.end,
                "eventContent":eventData.description,
                "memberId":eventData.username,
                "backgroundColor":eventData.backgroundColor,
                "textColor":eventData.textColor,
                "allDay":eventData.allDay,
                "meetingRoomIdx":eventData.roomIdx,
                "type":eventData.type,
            }),
            success: function (response) {
                console.log(response)
                //DB연동시 중복이벤트 방지를 위한
                $('#calendar').fullCalendar('removeEvents');
                $('#calendar').fullCalendar('refetchEvents');
            },
            error: function (error) {
                if (error.responseJSON.code ==='RESERVATION_006') {
                    alert(error.responseJSON.message);
                } else {
                    // 오류 응답에 code가 없는 경우 일반적인 오류 메시지를 표시
                    alert('오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
                }
            }
        });
    });
};