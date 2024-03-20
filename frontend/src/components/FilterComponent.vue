<template>
    <div class="container1">   

        <div class="panel panel-default">

            <!-- <div class="panel-heading">
                <h3 class="panel-title">필터</h3>
            </div> -->

            <div class="panel-body">
                <div class="col-lg-6">
                    <label for="calendar_view">구분별</label>
                    <div class="input-group">
                        <select class="filter" id="type_filter" multiple="multiple">
                            <option value="카테고리1">카테고리1</option>
                            <option value="카테고리2">카테고리2</option>
                            <option value="카테고리3">카테고리3</option>
                            <option value="카테고리4">카테고리4</option>
                        </select>
                    </div>
                </div>
                <div class="col-lg-6">
                    <label for="calendar_view">등록자별</label>
                    <div class="input-group">
                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="정연"
                                checked>정연</label>
                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="다현"
                                checked>다현</label>
                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="사나"
                                checked>사나</label>
                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="나연"
                                checked>나연</label>
                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="지효"
                                checked>지효</label>
                        <label class="checkbox-inline"><input class='filter' type="checkbox" value="이동규"
                                checked>이동규</label>
                    </div>
                </div>

            </div>
        </div>
        <!-- /.filter panel -->
    </div>
</template>

<script>
export default {
    data() {
        return {

        }
    },
    mounted() {
        const script = document.createElement('script');
        script.src = "/js/main.js";
        document.body.appendChild(script);

        const script2 = document.createElement('script');
        script2.src = "/js/addEvent.js";
        document.body.appendChild(script2);

        const script3 = document.createElement('script');
        script3.src = "/js/editEvent.js";
        document.body.appendChild(script3);

        const script4 = document.createElement('script');
        script4.src = "/js/etcSetting.js";
        document.body.appendChild(script4);
    },
    methods: {

    },
}
</script>

<style scoped>
.container {
    height: 100vh;
    width: 100vw;
    display: grid;
    grid-template-columns: 1fr;
    grid-template-rows: 2.375rem 1fr;
}

.col-lg-6 {
    margin-top: 0.5rem;
    width: 100%;
}
</style>