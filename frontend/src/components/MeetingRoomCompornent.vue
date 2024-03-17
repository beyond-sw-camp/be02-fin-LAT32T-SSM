<template>
    <div class="meeting-room">
        <div id="meeting-room-status"> 
            <div class="meeting-rooms"> 회의실 현황
                <div class="room-row">
                    <div class="room available">201</div>
                    <div class="room available">202</div>
                    <div class="room available">203</div>
                </div>
                <div class="room-row">
                    <div class="room available">301</div>
                    <div class="room available">302</div>
                    <div class="room available">303</div>
                </div>
                <div class="room-row">
                    <div class="room available">401</div>
                    <div class="room available">402</div>
                    <div class="room available">403</div>
                </div>
            </div>
            <div class="status-indicator">
                <div class="status available">
                    <div class="color-box"></div>
                    이용 가능
                </div>
                <br>
                <div class="status unavailable">
                    <div class="color-box"></div>
                    이용 불가
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'MeetingRoomCompornent',
    props: {
        msg: String
    }
}
</script>

<style scoped>
#meeting-room-status {
    display: flex;
    flex-direction: column;
    align-items: center;
}
.meeting-rooms {
    display: flex;
    flex-direction: column;
    position: relative;
    margin-top: 20px;
}
.meeting-room-status {
    display: flex;
    flex-direction: column;
    align-items: flex-end; 
    margin-right: 50px; 
}
.meeting-rooms,
.status-indicator {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
}
.room-row {
    display: flex;
}
.room {
    width: 50px;
    height: 50px;
    border: 1px solid #ccc;
    margin: 10px;
    text-align: center;
    line-height: 50px;
    background-color: #f0f0f0;
    border-radius: 10px;
}
.room.reserved {
    background-color: #000000;
    color: #ffffff;
}
#meeting-room-status::after {
    content: "";
    display: flex;
    align-items: center;
    margin-top: 10px;
}
.status-indicators {
    display: flex;
}
.status {
    display: flex;
    align-items: center;
    margin-left: 10px;
    font-size: 14px;
    margin-left: 60px;
}
.color-box {
    width: 20px;
    height: 20px;
    margin-right: 5px;
}
.available .color-box {
    background-color: #b4ffab;
}
.unavailable .color-box {
    background-color: #ff6347;
}
.room.unavailable {
    background-color: #ff6347;
}
.room.available {
    background-color: #b4ffab;
}
.room-row:not(:last-child) {
    margin-bottom: 10px;
}
h2 {
    margin-bottom: 10px;
    font-size: 24px;
}
</style>
