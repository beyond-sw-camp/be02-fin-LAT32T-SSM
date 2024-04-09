![header](https://capsule-render.vercel.app/api?type=Venom&color=ffe599&height=300&section=header&text=SSM&desc=📆Smart%20Schedule%20Manager&descSize=30&descAlign=50&descAlignY=70&fontSize=100&animation=fadeIn&fontColor=5f475f)

### :sunny: **[플레이 데이터] 한화시스템 BEYOND SW캠프 2기 / Latest** :sunny:

<br>

<<<<<<< Updated upstream
<br>
=======
### 소프트웨어 아키텍처 - 모놀리식
<details>
<summary><b>MVC 패턴</b></summary>

<img src="./img/MVC패턴.png">

* 정의
  * Model, View, Controller라는 3가지 구성 요소로 이루어진 소프트웨어 엔지니어링 아키텍처 패턴 
  1. 모델(Model)
     * 데이터와 비즈니스 로직을 처리. 
     * Controller에게 받은 데이터를 가공하는 역할을 수행
  2. 뷰(View)
     * 사용자 인터페이스 요소. 
     * Controller에게 받은 Model의 데이터를 사용자에게 시각적으로 보여주기 위한 역할을 수행
  3. 컨트롤러(Controller)
     * Model과 View 사이에서 데이터 흐름을 제어
     * 사용자가 접근한 URL에 따라 요청을 파악하고 URL에 적절한 Method를 호출하여 Service에서 비즈니스 로직을 처리
    
* 장점
  * 유지보수성
  * 재사용성 및 확장성
  * 개발 효율성
* 단점
  * 복잡성 증가 : 규모가 복잡하고 큰 서비스 및 프로그램의 경우, 하나의 Controller에 많은 View와 Model이 연결되어 있기 때문에 부하가 커지게 된다.
  * 상호의존성 : Model과 View의 의존성을 완전히 분리시킬 수 없다.
 </details>

<details>
<summary><b>레이어드 아키텍처</b></summary>

* 정의
  * 소프트웨어 설계를 위한 일반적인 아키텍처 패턴 중 하나
  * 애플리케이션을 명확하게 구분된 여러 계층으로 나누는 방식
  1. 프레젠테이션 계층 (Presentation Layer)
     * 사용자 인터페이스(UI)와 사용자 경험(UX)을 담당
     * 사용자의 입력을 받아 처리하고, 사용자에게 정보를 시각적으로 표현
  2. 비즈니스 로직 계층 (Business Logic Layer)
     * 데이터의 처리 및 변환, 계산, 비즈니스 규칙의 실행 등을 담당
     * 애플리케이션의 핵심 기능과 비즈니스 규칙을 구현
  3. 퍼시스턴스 계층 (Persistence Layer)
     * 데이터를 생성, 읽기, 업데이트, 삭제(CRUD)하는 로직을 관리하는 계층
     * 데이터를 영구 저장소에 저장하고 필요할 때 해당 데이터를 검색
  4. 데이터 계층 (Database Layer)
      * 실제 데이터를 저장하는 계층
* 장점
* 단점
</details>
<br>

### 주요 기능
<details>
<summary><b>멤버</b></summary>
</details>

<details>
<summary><b>채팅</b></summary>

* WebSocket
  * 양방향 통신을 가능하게 하는 기술
  * 서버와 클라이언트 간에 지속적인 연결을 유지하며 데이터를 실시간으로 양방향으로 교환

* STOMP(Simple Text Oriented Messaged Protocol)
  * pub/sub 구조를 따르는 텍스트 기반의 프로토콜
  * 클라이언트와 메시지 브로커 간의 비동기 통신을 위해 설계
  * Subscriber, Sender, Broker를 따로 두어 처리
    1. Subscriber : Subscriber는 채팅방으로부터 메시지를 받기 위해 Broker에 구독 신청
    2. Sender : Sender는 메시지를 생성해서 채팅방에 발행하는 역할. 메시지는 Broker를 통해 Subscriber에게 전달
    3. Broker : Sender로부터 메시지를 받아 해당 메시지를 Subscriber에게 전달

    <br><img src="./img/StompDiagram.png">

* WebSocket vs STOMP
* Kafka vs RabbitMQ
* Kafka vs Redis
* MongoDB vs MariaDB
</details>

<details>
<summary><b>일정</b></summary>
</details>

<details>
<summary><b>알람</b></summary>

* SSE
  * 

* Spring Batch
  * 
</details>
>>>>>>> Stashed changes

### 🤼‍♂️팀원 소개

<br><br>
<div align="center">

&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　 🐻 **[이동규](https://github.com/PTCman)**&nbsp;　 🦁 **[양호신](https://github.com/Hosae0905)** &nbsp;　 🐶 **[김주연](https://github.com/jyk147369)** &nbsp;　 🐯 **[장대현](https://github.com/poil4291)** &nbsp;
<br><br><br>

</div>

## ✨ 프로젝트 기본 소개
#### 프로젝트 배경
- 기업의 규모가 커질 수록 각 직원들 또는 부서간 소통을 하기 위한 협업툴은 필수적이다.
- 많은 외부 툴들이 있지만 회사보안 및 내규상 외부서버를 이용하지 않고 자체서버 프로그램이 필요한 회사들 입장에서는 회사에 맞는 협업툴이 반드시 필요하다.

#### 프로젝트 목표
- 직원들의 **개인일정 및 그룹일정을 등록 및 확인**한다. 
- **그룹 간 의사소통을 주고 받을 수 있는 채팅방**을 개설 하여 상호소통한다.
- 그룹일정 시 **회의실 예약**을 할 수 있다.
- 등록된 **일정 시간이 다가오면 서버측에서 알림**을 보내 직원이 일정을 상기한다.

<br>

---



## 📌 기술 스택

<br>

#### :door:&nbsp;Front
<div align="center">
<img src="https://img.shields.io/badge/HTML-239120?style=for-the-badge&logo=html5&logoColor=white" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/CSS-239120?&style=for-the-badge&logo=css3&logoColor=white" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vue.js&logoColor=4FC08D" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/Jest-323330?style=for-the-badge&logo=Jest&logoColor=white" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/Visual_Studio_Code-0078D4?style=for-the-badge&logo=visual%20studio%20code&logoColor=white" style="border-radius: 5px;"> 
</div>

#### :computer:&nbsp;Back
<div align="center">
<img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/Spring data jpa-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/Maven-02303A?style=for-the-badge&logo=maven&logoColor=white">
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white"> 
<img src="https://img.shields.io/badge/jwt-000000?style=for-the-badge&logo=Json Web Tokens&logoColor=purple">



</div>

#### :floppy_disk:&nbsp;DB
<div align="center">
<img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white" style="border-radius: 5px;"> 
</div>

#### :loudspeaker:&nbsp;CI/CD
<div align="center">
<img src="https://img.shields.io/badge/k8s-326CE5?style=for-the-badge&logo=#326CE5&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/grafana-F46800?style=for-the-badge&logo=grafana&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/prometheus-E6522C?style=for-the-badge&logo=prometheus&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/slack-4A154B?style=for-the-badge&logo=slack&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/webhook-2088FF?style=for-the-badge&logo=webhook&logoColor=white" style="border-radius: 5px;">
</div>


---



## <svg role="img" style="width: 25px; height: 25px;" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>Figma</title><path d="M15.852 8.981h-4.588V0h4.588c2.476 0 4.49 2.014 4.49 4.49s-2.014 4.491-4.49 4.491zM12.735 7.51h3.117c1.665 0 3.019-1.355 3.019-3.019s-1.355-3.019-3.019-3.019h-3.117V7.51zm0 1.471H8.148c-2.476 0-4.49-2.014-4.49-4.49S5.672 0 8.148 0h4.588v8.981zm-4.587-7.51c-1.665 0-3.019 1.355-3.019 3.019s1.354 3.02 3.019 3.02h3.117V1.471H8.148zm4.587 15.019H8.148c-2.476 0-4.49-2.014-4.49-4.49s2.014-4.49 4.49-4.49h4.588v8.98zM8.148 8.981c-1.665 0-3.019 1.355-3.019 3.019s1.355 3.019 3.019 3.019h3.117V8.981H8.148zM8.172 24c-2.489 0-4.515-2.014-4.515-4.49s2.014-4.49 4.49-4.49h4.588v4.441c0 2.503-2.047 4.539-4.563 4.539zm-.024-7.51a3.023 3.023 0 0 0-3.019 3.019c0 1.665 1.365 3.019 3.044 3.019 1.705 0 3.093-1.376 3.093-3.068v-2.97H8.148zm7.704 0h-.098c-2.476 0-4.49-2.014-4.49-4.49s2.014-4.49 4.49-4.49h.098c2.476 0 4.49 2.014 4.49 4.49s-2.014 4.49-4.49 4.49zm-.097-7.509c-1.665 0-3.019 1.355-3.019 3.019s1.355 3.019 3.019 3.019h.098c1.665 0 3.019-1.355 3.019-3.019s-1.355-3.019-3.019-3.019h-.098z"/></svg>&nbsp;&nbsp;프로젝트 화면 설계

### &nbsp;&nbsp;➡ &nbsp;[ 피그마(Figma) 바로가기](https://www.figma.com/file/xj93UowlHUunCPSqImxspk/LAT32T?type=design&node-id=0-1&mode=design&t=itaxJcadJzP1pjEG-0)

<br>


## <svg role="img" viewBox="0 0 24 24" style="width: 25px; height: 25px;" xmlns="http://www.w3.org/2000/svg"><title>Microsoft Excel</title><path d="M23 1.5q.41 0 .7.3.3.29.3.7v19q0 .41-.3.7-.29.3-.7.3H7q-.41 0-.7-.3-.3-.29-.3-.7V18H1q-.41 0-.7-.3-.3-.29-.3-.7V7q0-.41.3-.7Q.58 6 1 6h5V2.5q0-.41.3-.7.29-.3.7-.3zM6 13.28l1.42 2.66h2.14l-2.38-3.87 2.34-3.8H7.46l-1.3 2.4-.05.08-.04.09-.64-1.28-.66-1.29H2.59l2.27 3.82-2.48 3.85h2.16zM14.25 21v-3H7.5v3zm0-4.5v-3.75H12v3.75zm0-5.25V7.5H12v3.75zm0-5.25V3H7.5v3zm8.25 15v-3h-6.75v3zm0-4.5v-3.75h-6.75v3.75zm0-5.25V7.5h-6.75v3.75zm0-5.25V3h-6.75v3Z"/></svg>&nbsp;&nbsp;요구사항 정의서
### &nbsp;&nbsp;➡ &nbsp;[ 요구사항정의서 바로가기](https://docs.google.com/spreadsheets/d/121T1XodlKwX98hXcoRJmiMPKQaZVn3RyZAUTDPQm5UY/edit?usp=sharing)

<br>

## <svg role="img" viewBox="0 0 24 24" style="width: 25px; height: 25px;" xmlns="http://www.w3.org/2000/svg"><title>Microsoft Excel</title><path d="M23 1.5q.41 0 .7.3.3.29.3.7v19q0 .41-.3.7-.29.3-.7.3H7q-.41 0-.7-.3-.3-.29-.3-.7V18H1q-.41 0-.7-.3-.3-.29-.3-.7V7q0-.41.3-.7Q.58 6 1 6h5V2.5q0-.41.3-.7.29-.3.7-.3zM6 13.28l1.42 2.66h2.14l-2.38-3.87 2.34-3.8H7.46l-1.3 2.4-.05.08-.04.09-.64-1.28-.66-1.29H2.59l2.27 3.82-2.48 3.85h2.16zM14.25 21v-3H7.5v3zm0-4.5v-3.75H12v3.75zm0-5.25V7.5H12v3.75zm0-5.25V3H7.5v3zm8.25 15v-3h-6.75v3zm0-4.5v-3.75h-6.75v3.75zm0-5.25V7.5h-6.75v3.75zm0-5.25V3h-6.75v3Z"/></svg>&nbsp;&nbsp;WBS
### &nbsp;&nbsp;➡ &nbsp;[ WBS 바로가기](https://docs.google.com/spreadsheets/d/1CyA0HzYGfK01-JZf1aBc4vodGZ1Olf65/edit?usp=drive_link&ouid=106833420462517191298&rtpof=true&sd=true)

<br>

## <svg role="img" style="width: 25px; height: 25px;" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>Notion</title><path d="M4.459 4.208c.746.606 1.026.56 2.428.466l13.215-.793c.28 0 .047-.28-.046-.326L17.86 1.968c-.42-.326-.981-.7-2.055-.607L3.01 2.295c-.466.046-.56.28-.374.466zm.793 3.08v13.904c0 .747.373 1.027 1.214.98l14.523-.84c.841-.046.935-.56.935-1.167V6.354c0-.606-.233-.933-.748-.887l-15.177.887c-.56.047-.747.327-.747.933zm14.337.745c.093.42 0 .84-.42.888l-.7.14v10.264c-.608.327-1.168.514-1.635.514-.748 0-.935-.234-1.495-.933l-4.577-7.186v6.952L12.21 19s0 .84-1.168.84l-3.222.186c-.093-.186 0-.653.327-.746l.84-.233V9.854L7.822 9.76c-.094-.42.14-1.026.793-1.073l3.456-.233 4.764 7.279v-6.44l-1.215-.139c-.093-.514.28-.887.747-.933zM1.936 1.035l13.31-.98c1.634-.14 2.055-.047 3.082.7l4.249 2.986c.7.513.934.653.934 1.213v16.378c0 1.026-.373 1.634-1.68 1.726l-15.458.934c-.98.047-1.448-.093-1.962-.747l-3.129-4.06c-.56-.747-.793-1.306-.793-1.96V2.667c0-.839.374-1.54 1.447-1.632z"/></svg>&nbsp;&nbsp;API 명세서

### &nbsp;&nbsp;➡ &nbsp;[ API 명세서 바로가기](https://www.notion.so/0d57403fe28943c3997598c0de35ceb9?v=f54966510f6c4223b61c64146d9c1940&pvs=4)

<br>

## <svg role="img" viewBox="0 0 24 24" style="width: 25px; height: 25px;" xmlns="http://www.w3.org/2000/svg"><title>MariaDB Foundation</title><path d="M23.475 4.031c-.369.013-.262.179-1.06.376-.805.198-1.78.077-2.646.441-2.267.95-2.634 4.624-5.335 6.045-1.77 1-3.576 1.229-5.19 1.735-1.295.52-2.101.864-3.051 1.683-.737.635-.917 1.252-1.687 2.05-.782 1.062-3.744.118-4.506 1.45.402.26.634.332 1.34.24-.146.276-1.074.64-.906 1.048 0 0 2.245.409 4.137-.733.882-.359 1.71-1.119 3.08-1.301 1.777-.236 3.778.373 5.925.544-.444.877-.902 1.395-1.391 2.119-.152.163.13.307.65.209.937-.232 1.615-.483 2.289-.949.878-.606 1.256-1.16 1.997-2.039.644 1.032 2.914 1.26 3.38.367-.867-.367-1.052-2.277-.755-3.101.35-.786.603-1.896.886-2.928.256-.93.413-2.349.718-3.075.365-.903 1.073-1.185 1.605-1.664.532-.479 1.06-.878 1.045-1.974-.006-.356-.19-.553-.525-.543zm-.573.445c.09.307.231.448.841.504-.089.774-.606 1.196-1.183 1.602-.509.356-1.066.7-1.424 1.258-.367.57-.951 2.23-1.52 4.159-.492 1.668-1.065 2.807-2.276 3.807-.15-.36.17-.568.03-.897-.175.496-.558 1.218-.789 1.66-.76 1.454-2.019 2.63-3.901 2.962.893-1.21 1.787-2.543 1.896-4.627-.4.087-.432 1.164-1.078 1.56-.415.045-.995-.05-1.573-.12-1.726-.203-3.465-.282-5.087.24-1.105.353-2.356 1.447-3.292 1.853-1.1.478-1.477.515-2.869.473-.174-.234 1.002-.536.936-1.047-.536-.058-.848.071-1.314-.14a.707.707 0 01.223-.24c.854-.59 3.278-.14 3.927-.777.401-.392.663-.804.935-1.204.265-.388.538-.765.953-1.105.154-.125.394-.341.571-.463.709-.484 1.51-.831 2.373-1.133 1.174-.413 2.361-.552 3.613-1.03.774-.296 1.508-.576 2.193-1.088.162-.121.407-.326.55-.465 2.22-2.192 2.361-5.177 5.415-5.49.37-.038.672-.026.948-.034.317-.01.597-.047.902-.218zm-.15.197c-.017 0-.049.015-.093.056-.265.272-.79.884-.98 1.454-.05.155.048.11.082.01.189-.584.788-1.226.971-1.42.045-.052.051-.099.02-.1zm.08.133c-.017.002-.046.022-.084.069-.224.306-.657.77-.766 1.36-.027.16.064.103.082-.001.106-.605.608-1.11.763-1.327.037-.058.036-.105.006-.101zm.098.12c-.017.004-.044.026-.077.076-.199.325-.46.699-.519 1.295-.013.162.073.097.083-.008.052-.612.379-1.032.515-1.262.032-.06.028-.107-.002-.1zm.107.091c-.018.005-.042.03-.071.082-.169.34-.328.6-.334 1.2.002.163.08.09.081-.015 0-.614.22-.925.335-1.166.026-.063.018-.11-.011-.1zm-2.064.294c-.526.013-.837.242-.938.68.432.375 1.338.074 1.177-.672a2.218 2.218 0 00-.24-.008Z"/></svg>&nbsp;&nbsp;ERD
<details>
<summary><b>ERD보기</b></summary><br>
    <img src="img/ERD_latest.png"/>
</details> 

<br>

## <svg role="img" style="width: 25px; height: 25px;" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>Kubernetes</title><path d="M10.204 14.35l.007.01-.999 2.413a5.171 5.171 0 0 1-2.075-2.597l2.578-.437.004.005a.44.44 0 0 1 .484.606zm-.833-2.129a.44.44 0 0 0 .173-.756l.002-.011L7.585 9.7a5.143 5.143 0 0 0-.73 3.255l2.514-.725.002-.009zm1.145-1.98a.44.44 0 0 0 .699-.337l.01-.005.15-2.62a5.144 5.144 0 0 0-3.01 1.442l2.147 1.523.004-.002zm.76 2.75l.723.349.722-.347.18-.78-.5-.623h-.804l-.5.623.179.779zm1.5-3.095a.44.44 0 0 0 .7.336l.008.003 2.134-1.513a5.188 5.188 0 0 0-2.992-1.442l.148 2.615.002.001zm10.876 5.97l-5.773 7.181a1.6 1.6 0 0 1-1.248.594l-9.261.003a1.6 1.6 0 0 1-1.247-.596l-5.776-7.18a1.583 1.583 0 0 1-.307-1.34L2.1 5.573c.108-.47.425-.864.863-1.073L11.305.513a1.606 1.606 0 0 1 1.385 0l8.345 3.985c.438.209.755.604.863 1.073l2.062 8.955c.108.47-.005.963-.308 1.34zm-3.289-2.057c-.042-.01-.103-.026-.145-.034-.174-.033-.315-.025-.479-.038-.35-.037-.638-.067-.895-.148-.105-.04-.18-.165-.216-.216l-.201-.059a6.45 6.45 0 0 0-.105-2.332 6.465 6.465 0 0 0-.936-2.163c.052-.047.15-.133.177-.159.008-.09.001-.183.094-.282.197-.185.444-.338.743-.522.142-.084.273-.137.415-.242.032-.024.076-.062.11-.089.24-.191.295-.52.123-.736-.172-.216-.506-.236-.745-.045-.034.027-.08.062-.111.088-.134.116-.217.23-.33.35-.246.25-.45.458-.673.609-.097.056-.239.037-.303.033l-.19.135a6.545 6.545 0 0 0-4.146-2.003l-.012-.223c-.065-.062-.143-.115-.163-.25-.022-.268.015-.557.057-.905.023-.163.061-.298.068-.475.001-.04-.001-.099-.001-.142 0-.306-.224-.555-.5-.555-.275 0-.499.249-.499.555l.001.014c0 .041-.002.092 0 .128.006.177.044.312.067.475.042.348.078.637.056.906a.545.545 0 0 1-.162.258l-.012.211a6.424 6.424 0 0 0-4.166 2.003 8.373 8.373 0 0 1-.18-.128c-.09.012-.18.04-.297-.029-.223-.15-.427-.358-.673-.608-.113-.12-.195-.234-.329-.349-.03-.026-.077-.062-.111-.088a.594.594 0 0 0-.348-.132.481.481 0 0 0-.398.176c-.172.216-.117.546.123.737l.007.005.104.083c.142.105.272.159.414.242.299.185.546.338.743.522.076.082.09.226.1.288l.16.143a6.462 6.462 0 0 0-1.02 4.506l-.208.06c-.055.072-.133.184-.215.217-.257.081-.546.11-.895.147-.164.014-.305.006-.48.039-.037.007-.09.02-.133.03l-.004.002-.007.002c-.295.071-.484.342-.423.608.061.267.349.429.645.365l.007-.001.01-.003.129-.029c.17-.046.294-.113.448-.172.33-.118.604-.217.87-.256.112-.009.23.069.288.101l.217-.037a6.5 6.5 0 0 0 2.88 3.596l-.09.218c.033.084.069.199.044.282-.097.252-.263.517-.452.813-.091.136-.185.242-.268.399-.02.037-.045.095-.064.134-.128.275-.034.591.213.71.248.12.556-.007.69-.282v-.002c.02-.039.046-.09.062-.127.07-.162.094-.301.144-.458.132-.332.205-.68.387-.897.05-.06.13-.082.215-.105l.113-.205a6.453 6.453 0 0 0 4.609.012l.106.192c.086.028.18.042.256.155.136.232.229.507.342.84.05.156.074.295.145.457.016.037.043.09.062.129.133.276.442.402.69.282.247-.118.341-.435.213-.71-.02-.039-.045-.096-.065-.134-.083-.156-.177-.261-.268-.398-.19-.296-.346-.541-.443-.793-.04-.13.007-.21.038-.294-.018-.022-.059-.144-.083-.202a6.499 6.499 0 0 0 2.88-3.622c.064.01.176.03.213.038.075-.05.144-.114.28-.104.266.039.54.138.87.256.154.06.277.128.448.173.036.01.088.019.13.028l.009.003.007.001c.297.064.584-.098.645-.365.06-.266-.128-.537-.423-.608zM16.4 9.701l-1.95 1.746v.005a.44.44 0 0 0 .173.757l.003.01 2.526.728a5.199 5.199 0 0 0-.108-1.674A5.208 5.208 0 0 0 16.4 9.7zm-4.013 5.325a.437.437 0 0 0-.404-.232.44.44 0 0 0-.372.233h-.002l-1.268 2.292a5.164 5.164 0 0 0 3.326.003l-1.27-2.296h-.01zm1.888-1.293a.44.44 0 0 0-.27.036.44.44 0 0 0-.214.572l-.003.004 1.01 2.438a5.15 5.15 0 0 0 2.081-2.615l-2.6-.44-.004.005z"/></svg>&nbsp;&nbsp;시스템 아키텍처
<details> -->
<summary><b>시스템아키텍쳐 보기</b></summary><br>

<img src="img/system_architecture.png"/>


### 👉&nbsp;&nbsp;Front
- LoadBalacer type의 서비스에 의해 외부에 연결되어 있다.
- nginx의 Reverse Proxy를 통해 front주소 /api가 붙어 있으면 k8s안의 Backend Service에 연결한다.
- 채팅 및 알람 기능은 연결을 지속적으로 유지하기 위해 http1.1이상 규격을 사용해야하며 nginx가 Reverse proxy 적용시 http1.1을 유지 하게 한다.
- 채팅의 경우 header가 http에서 ws로 upgrade 할 수 있도록 설정한다.
- Deployment로 k8s에서 작동하며 부하분산을 위해 2개의 pod로 운영된다.
- RollingUpdate 방식으로 무중단 배포 된다.


#### 🤔 [ Frontend 설명 더보기 ](https://github.com/beyond-sw-camp/be02-fin-LAT32T-SSM/tree/main/frontend)
<br>

### 👉&nbsp;&nbsp;Back
- SCDF에 의해 batch서버가 1분에 한번씩 pod로 작동하며, 이때 회원의 일정을 조회를 해서 메세지를 produce 하여 Cluster Ip를 통해 kafka broker로 전달한다. kafka broker는 Backend 서버에게 메세지를 전달하며, Backend는 메세지를 consume 하여 Frontend에게 SseEmitter를 통해 데이터를 전송한다.
- Deployment로 k8s에서 작동하며 부하분산을 위해 2개의 pod로 운영된다. 
- 2개의 서버의 websocket session이 서로 달라 채팅 데이터가 누락이 될 수 있어, 채팅 메세지가 생성되면 kafka broker에게 전달하고 그 메세지를 2개의 서버가 consume한다.
- RollingUpdate 방식으로 무중단 배포 된다.
- Front, DB, kafka와 cluster ip로 통신하여 외부에 노출되지 않는다.

#### 🤔 [ Backend 설명 더보기 ](https://github.com/beyond-sw-camp/be02-fin-LAT32T-SSM/tree/main/backend)
<br>

### 👉&nbsp;&nbsp;CI/CD 
- 개발자 Github에 push하게 되면, webhook에 의해 Jenkins가 작동한다.
- Jenkins는 pipeLine script에 따라 git cloone, build, docker image build, docker image push의 과정을 거치고 manifest 파일을 k8s master 서버 전송 후 deployment를 실행한다.

#### 🤔 [ CICD 설명 더보기 ](https://github.com/beyond-sw-camp/be02-fin-LAT32T-SSM/tree/main/cicd)

</details>




---