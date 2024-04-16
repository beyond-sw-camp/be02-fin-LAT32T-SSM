![header](https://capsule-render.vercel.app/api?type=Venom&color=ffe599&height=300&section=header&text=SSM&desc=📆Smart%20Schedule%20Manager&descSize=30&descAlign=50&descAlignY=70&fontSize=100&animation=fadeIn&fontColor=5f475f)

### :sunny: **[플레이 데이터] 한화시스템 BEYOND SW캠프 2기 / Latest** :sunny:

<br>

<<<<<<< Updated upstream
<br>
=======

### 🤼‍♂️팀원 소개

<br><br>

&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　 🐻 **[이동규](https://github.com/PTCman)**&nbsp;　 🦁 **[양호신](https://github.com/Hosae0905)** &nbsp;　 🐶 **[김주연](https://github.com/jyk147369)** &nbsp;　 🐯 **[장대현](https://github.com/poil4291)** &nbsp;
<br><br><br>

## 📌 기술 스택

<br>


#### :computer:&nbsp;Back
<div align="center">
<img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white">
<img src="https://img.shields.io/badge/Maven-02303A?style=for-the-badge&logo=maven&logoColor=white">
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"> 
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/Spring data jpa-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/Spring batch-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white"> 
<img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white">
<img src="https://img.shields.io/badge/jwt-000000?style=for-the-badge&logo=Json Web Tokens&logoColor=purple">
<img src="https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=red"> 
</div>

### 소프트웨어 아키텍처
<details>
<summary><b>MVC 패턴</b></summary>

<img src="../img/MVC패턴.png">

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

> MVC 패턴과 레이어드 아키텍처 채택 이유
> 1. 

<br>

### 주요 기능
<details>
<summary><b>일정</b></summary>

### ✅ 일정 기능

> SSM 사용자는 일정을 등록, 조회, 삭제하는 기능들을 이용하여 보다 쉽게 효율적인 일정 관리를 할 수 있다.

* **일정 등록 기능**
  * 사용자는 일정 제목, 일정 시작 시간, 일정 종료 시간, 일정 내용, 일정 참가자, 채팅방 이름, 회의실 등의 데이터를 입력하여 일정을 등록할 수 있다.

    <img src="../img/일정 등록.gif">
* **일정 월별 조회 기능**
  * 사용자는 자신의 개인 일정을 조회할 수 있다.
  * 사용자는 같은 채팅방에 존재하는 사용자의 일정을 내 일정과 조회할 수 있다.
    <img src="../img/월간 일정 조회.gif">
* **일정 상세 조회 기능**
  * 사용자는 원하는 날짜의 일정을 개별 조회할 수 있다.
    <img src="../img/일정 상세 조회.gif">
</details>

<details>
<summary><b>회의실</b></summary>

> SSM 사용자는 원하는 시간에 원하는 회의실을 예약함으로써 효과적으로 프로젝트 협업을 진행할 수 있고, 현재 회의실 사용 유무와 예약 내역을 조회할 수 있어 더욱 체계적으로 협업 일정을 계획할 수 있다.

* **회의실 예약 기능**
  * 원하는 날짜 및 시간에 회의실이 공실일 경우 예약이 가능하다.
  * 예약이 완료된 회의실은 다른 사용자가 예약할 수 없다.
  * 회의실 예약 성공 시
    <img src="../img/회의실 일정 예약.gif">
  * 해당 시간에 회의실이 이미 예약이 된 경우 예약 실패
    <img src="../img/회의실 일정 예약 실패.gif">
* **회의실 예약 내역 조회**
  * 회의실에 예약된 일정들을 볼 수 있다.
    <img src="../img/회의실 예약 내역 조회.gif">
* **현재 회의실 조회**
  * 현재 사용 중인 회의실과 미사용 중인 회의실을 조회할 수 있다.
  * 회의실 예약 전 회의실 현황 조회
    <img src="../img/회의실 예약 전 현재 회의실 조회.gif">
  * 회의실 예약 등록
    <img src="../img/회의실 예약.gif">
  * 회의실 예약 후 회의실 현황 조회
    <img src="../img/회의실 예약 후 현재 회의실 조회.gif">

</details>

### ✅ QueryDSL을 사용한 필터링

> 일정 상세 조회, 월간 조회나 회의실 예약 조회, 회의실 현황 조회 등 다양한 조회 기능을 구현함으로써 사용자 일정에 대한 접근 용이성과 효율성을 높이고자 하였다.

* **QueryDSL**
  * 쿼리 생성에 특화된 프레임워크
  * QueryDSL 동작 방식
    (QueryDSL 그림)

* **QueryDSL vs JPQL**
  * 타입 안정성 체크가 가능
    * JPQL은 문자열이기 때문에 문법이 틀려도 개발자가 알아차리기 어렵다. 따라서 타입 안정성이 떨어지지만 QueryDSL은 자체적인 프로세스에서 JPQL 생성을 대신하여 타입 안정성 체크가 가능하다. 
  * 직관적인 동적 쿼리 작성 가능
    * QueryDSL은 빌더 패턴 구조로 으로 가독성 있는 데이터 세팅이 가능하고 쿼리 작성시 제약 조건 등을 메서드 추출을 통해 재사용할 수 있지만 JPQL은 문자열을 조작하는 방식으로 로직을 구성해야 하므로 코드가 직관적이지 않고 가독성이 떨어진다.
    * 같은 기능을 QueryDSL과 JPQL로 구현했을 때 비교
      * JPQL
        <img src="../img/JPQL.png"><br>
      * QueryDSL ️➡️ 빌더패턴 구조로 코드 가독성이 더 높다.
        <img src="../img/QueryDSL.png">
        
> 코드의 가독성과 유지보수성을 고려하여 QueryDSL을 사용하여 조회 기능을 구현했다.
<details>
<summary><b>채팅</b></summary>

### ✅ WebSocket과 STOMP를 이용한 채팅 기능 구현

> 실시간 채팅은 사내 사용자들간 소통을 향상시켜 일의 효율도를 높이고 프로젝트에 대한 적극적인 참여를 유도할 수 있을 것이라 고려되어 구현하게 되었다. 

* **WebSocket**
    * 하나의 TCP 연결을 통해 양방향 통신을 가능하게 하는 프로토콜 기술
  * 서버와 클라이언트 간에 지속적인 연결을 유지하며 데이터를 실시간으로 양방향으로 교환
  * 

* **STOMP(Simple Text Oriented Messaged Protocol)**
  * pub/sub 구조를 따르는 텍스트 기반의 프로토콜
  * 클라이언트와 메시지 브로커 간의 비동기 통신을 위해 설계
  * Subscriber, Sender, Broker를 따로 두어 처리
    1. Sender : Sender는 메시지를 생성해서 채팅방에 발행하는 역할. 메시지는 Broker를 통해 Subscriber에게 전달 ➡️ 채팅방 생성
    2. Subscriber : Subscriber는 채팅방으로부터 메시지를 받기 위해 Broker에 구독 신청 ➡️ 채팅방 입장
    3. Broker : Sender로부터 메시지를 받아 해당 메시지를 Subscriber에게 전달 ➡️ 채팅방에서 메시지 송수신

    <br><img src="../img/StompDiagram.png">

* **WebSocket과 STOMP**
  * STOMP는 WebSocket 위에서 동작
  * WebSocet만으로 채팅을 구현할 경우 해당 메시지가 어떤 요청인지, 어떤 포맷으로 오는지, 메시지 통신 과정을 어떻게 처리해야 하는지 정해져 있지 않으므로 메시지 형식을 각각 커스터마이징해야 함.
  * 하지만 STOMP는 메시지의 형식, 유형, 내용 등을 정의해주는 프로토콜이므로 규격을 갖춘 메시지를 보낼 수 있다.
  * 
  * MessageMapping 어노테이션을 이용해 메시지를 엔드포인트 별로 분리해서 관리할 수 있다. 
    <br><img src="../img/StompCode.png">
    > SSM은 일정 참여자들의 일정을 등록하고 관리하는 그룹 채팅방이 필요했기에 STOMP로 채팅 기능을 고도화 시켰다.

</details>

<details>
<summary><b>알람</b></summary>

* **SSE**
    *

* **Spring Batch**
    *
</details>

### ✅ Kafka

> 서버 이중화로 인한 데이터 동기화 문제로 채팅과 알람 기능에 외부 메시지 브로커를 추가하였다.

(문제가 되는 부분 그림 추가)

> 인프라 비용 감소와 운영 리소스를 효율적으로 관리하기 위해 하나의 메시지 브로커를 사용하기로 판단하였고, Kafka를 채택하여 구현하였다.

* **Kafka vs RabbitMQ**
  1. 채팅과 알람 기능에서 발생하는 높은 트래픽
     - 현재 LAT32T 서비스에서 가장 많은 트래픽이 발생하는 곳은 채팅과 알람 기능이다.
     Kafka는 초당 수백만 건의 메시지를 처리할 수 있어 RabbitMQ 보다 더 많은 트래픽을 감당할 수 있다.

  2. 높은 전송 속도
     - 현재 LAT32T 서비스에서 많은 트래픽을 유발하는 채팅과 알람 기능은 실시간으로 이뤄진다.
     Kafka는 RabbitMQ보다 더 높은 처리 속도를 보유하고 있어 실시간으로 채팅과 알람을 확인할 수 있다.

  3. 전달된 메시지에 대한 휘발성
     - RabbitMQ는 메시지 큐에 저장되어 있던 메시지를 Consumer가 가져가게 되면 메시지 큐에서 해당 메시지를 삭제한다.
     반면에 Kafka는 메시지를 로그 파일에 추가하여 보존 기간이 만료될 때까지 보관된다.

(문제를 해결한 그림 추가)
