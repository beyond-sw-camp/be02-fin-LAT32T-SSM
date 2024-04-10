import { shallowMount } from '@vue/test-utils';
import CalendarComponent from '@/components/CalendarComponent.vue'; // 컴포넌트 경로를 정확하게 수정하세요.
import { createPinia, setActivePinia } from 'pinia';

describe('CalendarComponent', () => {
    beforeEach(() => {
        setActivePinia(createPinia());
    });

    it('날짜에 따른 이벤트 색상 결정', () => {
        const wrapper = shallowMount(CalendarComponent);

        expect(wrapper.vm.functionEvents('2023-03-09')).toEqual(false);
        expect(wrapper.vm.functionEvents('2023-03-12')).toEqual(true);
        expect(wrapper.vm.functionEvents('2023-03-19')).toEqual(['red', '#00f']);
    });
});
