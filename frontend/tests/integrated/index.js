const { Builder, By, until } = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');

async function mainPageTest() {
    let options = new chrome.Options();
    options.setUserPreferences({ 'profile.default_content_setting_values.notifications': 1 });
    let driver = await new Builder().forBrowser('chrome').setChromeOptions(options).build();
    try {
        // 메인 페이지로 이동
        await driver.get('https://www.ssm32.kro.kr:14147/');

        await driver.sleep(1500);

        await driver.get('https://www.ssm32.kro.kr:14147/signup');
        await driver.sleep(1500);
        await driver.findElement(By.css('input[placeholder="아이디를 입력해주세요"]')).sendKeys('memberTest');
        await driver.sleep(1500);
        await driver.findElement(By.css('input[placeholder="이름을 입력해주세요"]')).sendKeys('test');
        await driver.sleep(1500);
        await driver.findElement(By.css('input[placeholder="비밀번호를 입력해주세요"]')).sendKeys('qwer1234');
        await driver.sleep(1500);
        await driver.findElement(By.css('input[placeholder="비밀번호를 한번더 입력해주세요"]')).sendKeys('qwer1234');
        await driver.sleep(1500);
        await driver.findElement(By.css('input[placeholder="부서명을 입력해주세요"]')).sendKeys('IT');
        await driver.sleep(1500);
        await driver.findElement(By.css('input[placeholder="직책을 입력해주세요"]')).sendKeys('Developer');
        await driver.sleep(1500);

        await driver.findElement(By.css('button.btn-primary')).click();

        await driver.sleep(1500);

        await driver.get('https://www.ssm32.kro.kr:14147/login');

        await driver.findElement(By.css('input[placeholder="아이디를 입력해주세요"]')).sendKeys('member02');
        await driver.sleep(1500);
        await driver.findElement(By.css('input[placeholder="비밀번호를 입력해주세요"]')).sendKeys('qwer1234');
        await driver.sleep(1500);

        await driver.findElement(By.css('button.btn-primary')).click();

        await driver.sleep(1500);

        const closeButtons = await driver.findElements(By.css('.Toastify__toast .Toastify__close-button'));
        for (const button of closeButtons) {
            await button.click();
            await driver.sleep(100);
        }

        const createChatRoomButton = await driver.findElement(By.className('button-show'));
        await createChatRoomButton.click();

        const chatRoomNameField = await driver.findElement(By.id('chatRoomName'));
        await chatRoomNameField.sendKeys('test');

        // 멤버 ID 입력
        const addMember = driver.findElement(By.id('memberId'));
        await addMember.sendKeys('member01');
        await driver.sleep(1500);

        await driver.findElement(By.xpath('//button[contains(text(),"추가")]')).click();
        await driver.sleep(1500);

        await driver.findElement(By.xpath('//button[contains(text(),"생성하기")]')).click();
        await driver.sleep(1500);

        const closeCreatedButtons = await driver.findElements(By.css('.Toastify__toast .Toastify__close-button'));
        for (const button of closeCreatedButtons) {
            await button.click();
            await driver.sleep(100);
        }

        await driver.wait(until.elementLocated(By.className('channels')), 10000);

        const chatRooms = await driver.findElements(By.css('.channels li a'));
        if (chatRooms.length > 0) {
            await chatRooms[0].click();
        } else {
            throw new Error('No chat rooms found');
        }

        const switchChat = await driver.findElements(By.css('.btn-borderless .btn-slack info'));
        switchChat[0].click();

    } finally {
        await driver.quit();
    }
}

mainPageTest().then(() => console.log('Test completed')).catch(err => console.error('Test failed', err));
