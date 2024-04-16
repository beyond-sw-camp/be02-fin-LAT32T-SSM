<template>
    <div class="timeline">
        <div class="timeline-header">
            <div class="timeline-hour-header">Time</div>
            <div class="timeline-events">
                <div v-for="(event, index) in events" :key="index" class="timeline-event">
                    {{ event }}
                </div>
            </div>
        </div>
        <div class="timeline-body">
            <div v-for="hour in hours" :key="hour" class="timeline-hour">
                {{ hour }}
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'MeetingRoomTimelineComponent',
    props: {
        roomName: {
            type: String,
            required: true,
        },
    },
    data() {
        return {
            startTime: 6,
            endTime: 19,
            events: [
            ]
        };
    },
    computed: {
        hours() {
            const hours = [];
            for (let i = this.startTime; i <= this.endTime; i++) {
                hours.push(this.formatHour(i));
            }
            return hours;
        }
    },
    methods: {
        formatHour(hour) {
            // 12보다 작으면 AM 크면 PM으로 적용
            return hour > 12 ? `PM ${hour - 12}` : `AM ${hour}`;
        }
    }
};
</script>

<style scoped>
.timeline {
    display: flex;
    flex-direction: column;
    border: 1px solid #ccc;
    border-radius: 8px;
    overflow: hidden;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    color: #333;
}

.timeline-header,
.timeline-body {
    border-bottom: 1px solid #ccc;
}

.timeline-hour-header,
.timeline-hour {
    padding: 15px;
    background-color: #f9f9f9;
    border-bottom: 1px solid #eee;
}

.timeline-hour:last-child {
    border-bottom: none;
}

.timeline-events {
    padding: 0;
}

.timeline-event {
    padding: 15px;
    border-bottom: 1px solid #eee;
    background-color: #fff;
    transition: background-color 0.3s;
}

.timeline-event:last-child {
    border-bottom: none;
}

.timeline-event:hover {
    background-color: #e8f4ff;
}

/* Scrollbar Styles */
.timeline::-webkit-scrollbar {
    width: 6px;
}

.timeline::-webkit-scrollbar-track {
    background: #f1f1f1;
}

.timeline::-webkit-scrollbar-thumb {
    background: #888;
}

.timeline::-webkit-scrollbar-thumb:hover {
    background: #555;
}
</style>