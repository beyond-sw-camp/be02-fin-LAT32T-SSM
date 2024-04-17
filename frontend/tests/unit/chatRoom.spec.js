import { shallowMount } from '@vue/test-utils'
import SidebarComponent from '@/components/utils/SidebarComponent.vue'
import { createPinia, setActivePinia } from 'pinia'

describe('SidebarComponent', () => {
    beforeEach(() => {
        setActivePinia(createPinia())
    })

    it('채널 랜더링 확인', () => {
        const wrapper = shallowMount(SidebarComponent)
        expect(wrapper.text()).toContain('채널')
    })

    it('토글 확인', async () => {
        const wrapper = shallowMount(SidebarComponent)
        expect(wrapper.vm.isArrowVisible).toBe(true)
        await wrapper.vm.toggleArrow()
        expect(wrapper.vm.isArrowVisible).toBe(false)
    })

    it('토클 확인', async () => {
        const wrapper = shallowMount(SidebarComponent)
        expect(wrapper.vm.isChatRoomListVisible).toBe(true)
        await wrapper.vm.chatRoomListHide()
        expect(wrapper.vm.isChatRoomListVisible).toBe(false)
    })
})
