var eventModal = $('#eventModal');      // 일정 추가 모달

var modalTitle = $('.modal-title');     // 모달 제목
var editAllDay = $('#edit-allDay');     // 하루종일
var editTitle = $('#edit-title');       // 일정명
var editStart = $('#edit-start');       // 시작
var editEnd = $('#edit-end');           // 종료
var editType = $('#edit-type');         // 구분(우리한테는 채팅방 번호)
var editColor = $('#edit-color');       // 이벤트 등록할 때 색상
var editDesc = $('#edit-desc');         // 일정 설명

var addBtnContainer = $('.modalBtnContainer-addEvent');             // 일정 추가 및 취소 버튼
var modifyBtnContainer = $('.modalBtnContainer-modifyEvent');       // 필요없는 부분


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
    
    addBtnContainer.show();
    modifyBtnContainer.hide();
    eventModal.modal('show');

    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/
    var eventId = 1 + Math.floor(Math.random() * 1000);
    /******** 임시 RAMDON ID - 실제 DB 연동시 삭제 **********/

    //새로운 일정 저장버튼 클릭
    $('#save-event').unbind();
    $('#save-event').on('click', function () {

        var eventData = {
            _id: eventId,
            title: editTitle.val(),
            start: editStart.val(),
            end: editEnd.val(),
            description: editDesc.val(),
            type: editType.val(),
            username: '사나',
            backgroundColor: editColor.val(),
            textColor: '#ffffff',
            allDay: false
        };

        if (eventData.start > eventData.end) {
            alert('끝나는 날짜가 앞설 수 없습니다.');
            return false;
        }

        if (eventData.title === '') {
            alert('일정명은 필수입니다.');
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
        // $.ajax({
        //     type: "get",
        //     url: "",
        //     data: {
        //         //.....
        //     },
        //     success: function (response) {
        //         //DB연동시 중복이벤트 방지를 위한
        //         //$('#calendar').fullCalendar('removeEvents');
        //         //$('#calendar').fullCalendar('refetchEvents');
        //     }
        // });
    });
};