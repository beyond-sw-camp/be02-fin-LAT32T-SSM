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

&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　 🐻 **[이동규](https://github.com/PTCman)**&nbsp;　 🦁 **[양호신](https://github.com/Hosae0905)** &nbsp;　 🐶 **[김주연](https://github.com/jyk147369)** &nbsp;　 🐯 **[장대현](https://github.com/poil4291)** &nbsp;
<br><br><br>

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
<img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" style="border-radius: 5px;"> 
<img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white" style="border-radius: 5px;"> 
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


## :green_book: 프로젝트 화면 설계

### &nbsp;&nbsp;➡ &nbsp;[ 피그마(Figma) 바로가기](https://www.figma.com/file/xj93UowlHUunCPSqImxspk/LAT32T?type=design&node-id=0-1&mode=design&t=itaxJcadJzP1pjEG-0)

<br>

## 💡&nbsp;&nbsp;시스템 아키텍처

<br>



<details>
<summary><b>Front</b></summary><br>
    <div>이미지 자리</div>
</details> 

---

<br>
<br>
<details>
<summary><b>BACK</b></summary><br>
    <div>이미지 자리</div>
</details> 

---
<br>
<br>
<details>
<summary><b>CICD</b></summary><br>
    <img src="https://drive.google.com/uc?export=view&id=1APh-lvABOBAuyDSbDPs5ZrYurgfeJtgB"/>
</details> 

---
<br>
<br>
<details>
<summary><b>모니터링시스템</b></summary><br>
    <div>이미지 자리</div>
</details> 

---