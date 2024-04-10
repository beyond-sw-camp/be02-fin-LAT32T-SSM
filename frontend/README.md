![header](https://capsule-render.vercel.app/api?type=Venom&color=ffe599&height=300&section=header&text=SSM&desc=📆Smart%20Schedule%20Manager&descSize=30&descAlign=50&descAlignY=70&fontSize=100&animation=fadeIn&fontColor=5f475f)

### **[플레이 데이터] 한화시스템 BEYOND SW캠프 2기 / Latest** :sunny:

# 💪팀원 구성

<div align="left">

|                 **양호신**                 |                 **김주연**                 |              **이동규**              |                 **장대현**                 |
| :----------------------------------------: | :----------------------------------------: | :----------------------------------: | :----------------------------------------: |
| [@Hosae0905](https://github.com/Hosae0905) | [@jyk147369](https://github.com/jyk147369) | [@PTCman](https://github.com/PTCman) | [ @DaeHyeon](https://github.com/poil4291/) |

</div>

# ✒️ 사용 기술 스택

<details>
<summary><b style="font-size: 18px;">기술 설명</b></summary>

### Vue.js

- vue.js란 SPA 즉 Single Page Application(단일 페이지 애플리케이션)을 의미한다.
- vue3를 사용하는 이유로는 기존의 다중 페이지 애플리케이션(html)은 사용자가 링크를 클릭할때마다 새로운 페이지를 로드하므로 프론트엔드 서버에 부담이 가중된다.
- 해당 부담을 줄이기 위해 초기에 전체 페이지를 로드하고 사용자의 요청에 따라 서버로부터 비동기적인 데이터를 받아올수 있는 vue.js를 사용하게 되었다.
- 또한 개발자 입장에서는 컴포넌트 기반이기 때문에 모든 페이지에 필요한 코드의 경우 전체html에 작성할 필요 없이 코드 한줄 등록으로 재사용이 간편하다.
- 가상 DOM을 활용하여 효율적인 렌더링을 구현하고 실제 DOM 조작을 최소화하여 성능을 향상이 된다.
- 기존 html, js를 사용할 떄와 달리 Axios, Pinia 등을 이용해 불필요한 데이터 조회를 줄여 결과적으로 서버에 부담이 줄어든다.

### Pinia

- <b>Pinia vs Vuex</b>
    - 피니아를 사용해야 하는 이유로는
    - Vuex의 주요 단점 중 하나는 액션과 돌연변이 생성의 복잡성과 반복성 때문이다.
    - 대규모 애플리케이션에서 작업할 때 돌연변이를 유발하는 작업을 생성해야 하는데 노가다 그 자체다.
    - Vue.js에서 제공하는 Pinia 기능을 활용해 최대한 동적으로 페이지, 데이터를 제공할 수 있도록 구현
      <br>
      Pinia를 활용해 가상 DOM 등을 이용했기 때문에 유저가 빠르고 쾌적하게 서비스를 이용할 수 있다.
    - 또한 Props로 관리시 자식 컴포넌트에서 부모 컴포넌트로 데이터가 전달이 되지 않는 데이터를 전역적으로 관리함으로써 데이터 관리에 용이하다.
- Pinia는 기본적으로 state, actions, getters의 구조로 되어 있다
    - State<br>
      애플리케이션의 상태를 저장 반응성이 있는 데이터 객체 컴포넌트에서 공유될 수 있는 데이터를 포함
      로그인 상태 혹은 회의실 상태 등 상태 데이터들을 저장
    - Actions<br>
      actions은 주로 API 호출과 같은 비동기 작업을 수행후 데이터를 업데이트
      백엔드로 api를 보낸후 데이터를 여기에 저장
    - Getters<br>
      getters는 state 기반으로 추가적인 데이터를 계산할 때 사용
      사용자 목록에서 활성 사용자만 필터링 즉 현재 접속중인 유저를 찾거나 장바구니에 추가하여 총 구매 금액을 계산할 수 있음

### Axios , Jquery

- <b>Axios vs Ajax</b>
    - ajax = Asynchronous(비동기) Javascript And Xml이다
    - XML은 데이터를 저장하고 전송하기 위한 마크업 언어이다.
    - 프론트엔드 개발에 XML을 주로 데이터 형식으로 사용했었지만, 현재는 JSON방식으로 데이터를 주고받는게 더 많이 사용함으로써 후속 유지보수 개발자를 구하기 쉬워진다.
    - 주된 사용이유로는 요청 혹은 응답을 자동으로 JSON 형태로 변환시켜준다.
    - 또한 요청과 응답을 가로채고 수정하기 쉬운 인터셉터를 제공해서 요청에 토큰과 같은 정보를 쉽게 전달할수 있다
    - 그리고 Axios 라이브러리는 명확한 API를 제공하기때문에 유저들이 사용하기 용이하다.
- 다만 메시지를 보내는(sendMessage)데에 대해서는 사용자 편의(텍스트에 이미지 삽입이나 영상 추가)를 위해 Summernote를 사용하기 위하여, J쿼리 코드를 사용하였고 <br>
  Full-calendar 의 기능을 사용하기 위해서 공식 문서를 보고 J쿼리를 사용하여 DB에 저장을 구현하였다.

### JWT

- 요청 본문에(헤더) 필요한 사용자 정의 데이터를 포함할 수 있어, 다양한 환경에서 쉽게 요구사항을 충족한다. <br>
- JWT는 표준 규격을 따르고 있어, 이를 지원하는 다양한 라이브러리와 플랫폼에서 쉽게 사용할 수 있다.
- JWT는 JSON 형식을 사용하며, 정보를 포함하는 데 필요한 최소한의 필드(토큰을 저장할 수 있는 변수)만을 가지고 있다.
  이는 토큰 크기를 작게 유지하면서 필요한 정보를 전송하는 데 매우 좋다.

### Jest

- <b>Jest vs RTL(React Testing Library)</b>
    - React Testing Library는 사용자가 직접 컴포넌트를 시험하는것처럼 테스트 할 수 있다.
    - 그래서 테스트하기에는 용이하나 다만 사용법이 어렵고, 컴포넌트 내부 상태 테스트도 어려워 프로젝트의 기간에 여유가 없을 시엔 사용이 힘들다.
    - 따라서 강력한 기능과 사용하기 쉬운 문법을 제공하고, 또한 내장 모킹을 지원하여 함수와 모듈을 자동으로 목을 해주므로 사용성이 간편한 Jest를 사용하게 되었다.
    - 다만 Jest의 단점으로는 메모리를 과다 소비하는 점 때문에 대규모 프로젝트의 경우 문제를 일으킬 가능성이 있다.

### Full-calendar

- 일정을 구현하기 위해 여러 달력 라이브러리중 Full-calendar를 선택하여 제공하게 되었다.
- 사용하게된 가장 큰 이유는 제공되는 API 라이브러리가 많고, 월별 주별 일별 달력이 구현되어 있으며 프론트에 보여주는데 제공되는 기능이 많아 선정하게 되었다.
- Pinia를 사용하여 데이터를 전역적으로 관리를 하여 Full-calendar의 API를 사용하였고 Axios를 통해 데이터를 요청, 응답을 받아 캘린더에 데이터를 시각적으로 보여주었다.

</details>

<br>
<br>

# Badges

<div align="left">
	<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=JavaScript&logoColor=white" />
  <img src="https://img.shields.io/badge/vuejs-%2335495e.svg?style=flat&logo=vuedotjs&logoColor=%234FC08D" />
  <img src="https://img.shields.io/badge/Vcalendar-%23C21325?style=for-the-badge&logo=Vcalendar&logoColor=white" width="73" />
<img src="https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens" width="60" />

<img src="https://img.shields.io/badge/Jest-323330?style=for-the-badge&logo=Jest&logoColor=white" width="55" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/-pinia-gold?style=for-the-badge&logo=Pinia&logoColor=white" width="53" />
<img src="https://img.shields.io/badge/-axios-pink?style=for-the-badge&logo=Axios&logoColor=white" width="70" />
<img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white" width="78" >
  <br>

</div>
