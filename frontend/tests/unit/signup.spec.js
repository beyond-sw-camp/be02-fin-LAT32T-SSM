import { shallowMount } from '@vue/test-utils';
import { createPinia, setActivePinia } from 'pinia';
import SignUpPage from '@/pages/member/SignUpPage.vue';

beforeEach(() => {
  setActivePinia(createPinia());
});

describe('SignUpPage.vue', () => {
  it('회원가입 페이지 랜더링', () => {
    const wrapper = shallowMount(SignUpPage);
    expect(wrapper.text()).toContain('회원 가입');
  });

  it('입력값 세팅', async () => {
    const wrapper = shallowMount(SignUpPage);

    const inputId = '[placeholder="아이디를 입력해주세요"]';
    const inputName = '[placeholder="이름을 입력해주세요"]';
    const inputPassword = '[placeholder="비밀번호를 입력해주세요"]';
    const inputDepartment = '[placeholder="부서명을 입력해주세요"]';
    const inputPosition = '[placeholder="직책을 입력해주세요"]';

    await wrapper.find(inputId).setValue('test001@gmail.com');
    await wrapper.find(inputName).setValue('Test Name');
    await wrapper.find(inputPassword).setValue('password123');
    await wrapper.find(inputDepartment).setValue('Development');
    await wrapper.find(inputPosition).setValue('Developer');

    expect(wrapper.find(inputId).element.value).toBe('test001@gmail.com');
    expect(wrapper.find(inputName).element.value).toBe('Test Name');
    expect(wrapper.find(inputPassword).element.value).toBe('password123');
    expect(wrapper.find(inputDepartment).element.value).toBe('Development');
    expect(wrapper.find(inputPosition).element.value).toBe('Developer');

    const mockFileUploadMethod = jest.fn();
    wrapper.vm.handleFileUpload = mockFileUploadMethod;

    await wrapper.find('input[type="file"]').trigger('change');

    expect(mockFileUploadMethod).toHaveBeenCalledTimes(1);
  });
});
