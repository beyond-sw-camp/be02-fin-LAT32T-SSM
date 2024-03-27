![header](https://capsule-render.vercel.app/api?type=Venom&color=ffe599&height=300&section=header&text=SSM&desc=📆Smart%20Schedule%20Manager&descSize=30&descAlign=50&descAlignY=70&fontSize=100&animation=fadeIn&fontColor=5f475f)

### :sunny: **[플레이 데이터] 한화시스템 BEYOND SW캠프 2기 / Latest** :sunny:

<br>

<br>



## 🤼‍♂️팀원 소개

<br><br>

&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　 🐻 **[이동규](https://github.com/PTCman)**&nbsp;　 🦁 **[양호신](https://github.com/Hosae0905)** &nbsp;　 🐶 **[김주연](https://github.com/jyk147369)** &nbsp;　 🐯 **[장대현](https://github.com/poil4291)** &nbsp;
<br><br><br><br><br>


## ✔️ 기술 스택
<br>
<div align="center">
<img src="https://img.shields.io/badge/k8s-326CE5?style=for-the-badge&logo=#326CE5&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white" style="border-radius: 5px;"></br>
<img src="https://img.shields.io/badge/grafana-F46800?style=for-the-badge&logo=grafana&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/prometheus-E6522C?style=for-the-badge&logo=prometheus&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/slack-4A154B?style=for-the-badge&logo=slack&logoColor=white" style="border-radius: 5px;">
<img src="https://img.shields.io/badge/webhook-2088FF?style=for-the-badge&logo=webhook&logoColor=white" style="border-radius: 5px;">
</div>
<br>

## 🖥️ Lat32t 운영 환경

<details>
    <summary>
<span style="font-size:150%"> k8s 내부 아키텍처 </span></summary>

- Master Node :1대
- Worker Node: 4대
- Node간 Connection을 위해 Calico CNI를 설치
- Service 생성시 LoadBalance Type 사용을 위해 Metallb를 설치
- 모니터링 시스템으로 Prometheus와 Grafana 구축
- 같은 네트워크 대역폭을 사용하여 하나의 k8s 클러스터를 구성하기 위해 네트워크 장치로 브릿지를 사용
</br>
<p align="center">
<img width="80%" src="./img/k8s_system.png"></p>
</details>

<details>
    <summary>
<span style="font-size:150%"> k8s 전체 서비스 아키텍처 </span></summary>

- 사용자가 lat32t 서비스에 접속하면 로드밸런서를 통해 화면이 보여지고 nginx 웹 서버의 프록시 설정에 따라 백엔드 서버와 통신하게 된다.
- 사용자는 회원가입을 진행할 때 프로필 사진을 등록하게 되며 aws s3 스토리지에 저장되고 해당 이미지를 받아와서 확인할 수 있다.
- 백엔드 서버는 nginx 웹 서버의 프록시 설정에 따라서 프론트엔드에서 요청을 받아 처리하게 된다. 이때 백엔드 서버의 설정은 미리 정의된 컨피그 맵을 통해서 이뤄진다.
- 백엔드에서 DB와 통신을 할 경우 사전에 정의된 DB의 ClusterIP 서비스를 통해서 접근하게 되고 이때 DB 설정은 미리 정의된 컨피그맵을 통해서 이뤄진다.
- DB는 Pod로 생성하게 되는데 이때 발생하는 데이터 휘발성 문제를 해결하기 위해 PV와 PVC를 구성하여 데이터가 휘발되는 문제를 예방한다.
- 개발자는 개발을 진행하고 Pull Request를 작성하여 develop 브랜치에 merge가 이루어질 시 미리 지정된 젠킨스 서버로 Webhook을 진행하게 된다.
- 젠킨스 서버에서는 사전에 작성된 파이프라인을 통해 각 프로젝트를 Build 하면서 도커 허브에 이미지를 푸쉬하는 작업을 진행하게 된다.
- 젠킨스 파이프라인이 실행되는 동안 발생하는 성공 및 실패 이벤트는 slack 알림을 통해 개발자에게 알림이 전송된다.
<p align="center">
<img width="80%" src="./img/k8s.png">
</p>
</details>


## ✨젠킨스 파이프라인(배포 시나리오)
<details>
    <summary>
<span style="font-size:150%"> 백엔드 배포 시나리오 </span></summary>
<p align="center">
<img width="80%" src="img/jenkins-backend.png">

1. git merge
    - 각 브랜치에서 작업이 끝난 후 PR을 요청하여 develop 브랜치에 merge를 진행한다.
2. webhook
    - merge가 이뤄지면 14149 포트번호로 포트포워딩 되어 있는 젠킨스 서버로 Webhook이 이뤄진다.
3. Project Clean ~ Project Build
    - 최초 깃허브에서 프로젝트를 clone한 뒤 backend 프로젝트로 이동한다.
    - 먼저 Spring Boot 프로젝트를 clean하여 기존에 존재했던 target 폴더를 지운다.
    - 그 다음 Spring Boot 프로젝트를 compile 하여 target 폴더를 생성한다.
    - target 폴더가 생성되고 난 뒤 mvn test를 통해 테스트를 진행한다.
    - 테스트가 완료된 Spring Boot 프로젝트를 mvn package하여 배포할 수 있는 jar 파일을 생성한다.
4. Docker Build ~ Docker Push
    - Spring Boot 프로젝트에 포함되어 있는 도커 파일을 바탕으로 docker build를 하여 새로운 버전의 도커 이미지를 생성한다.
    - 생성된 도커 이미지를 docker push 명령어를 통해서 도커 허브에 이미지를 업로드한다.
5. Send Artifacts ~ Apply Deployment
    - 도커 허브에 이미지를 업로드하는 과정이 성공적으로 완료되면 k8s master 노드의 ssh 서버로 접속하여 기존의 Spring Boot 프로젝트에 있던
백엔드 메니페스트 파일을 옮긴다.
    - k8s master 노드로 옮겨진 백엔드 메니페스트 파일을 kubectl apply 명령어를 통해서 적용시킨다.
6. K8S Deployment Docker Image Update
    - 백엔드 메니페스트 파일이 적용되면 이전에 도커 허브로 올렸던 최신 버전의 도커 이미지를 바탕으로 새로운 Deployment를 생성하게 된다.
7. Send Slack Alert
    - 앞선 모든 과정에서 성공 및 실패할 시 slack 알림을 보낸다.
    - 성공과 실패 메시지에 포함되는 내용
      - 슬랙 채널 명
      - 슬렉 알림 색깔
      - 성공 및 실패 메시지
      - 어떤 파이프라인 stage에서 발생한 이벤트인지
      - 현재 작업의 이름, 빌드 번호, 빌드 url
</br>
</br>
</details>

<details>
    <summary>
<span style="font-size:150%"> 프론트엔드 배포 시나리오 </span></summary>
<p align="center">
<img width="80%" src="img/jenkins-front.png">

1. git merge
   - 각 브랜치에서 작업이 끝난 후 PR을 요청하여 develop 브랜치에 merge를 진행한다.
2. webhook
   - merge가 이뤄지면 14149 포트번호로 포트포워딩 되어 있는 젠킨스 서버로 Webhook이 이뤄진다.
3. Install Dependencies
    - frontend 폴더로 이동하여 package.json 파일을 바탕으로 npm install을 진행한다.
4. Project Test ~ Project Build
    - npm install 과정이 정상적으로 완료된 뒤 npm run test를 통해 미리 작성한 테스트 코드를 실행한다.
    - 테스트가 정상적으로 완료되면 npm run build를 통해 dist 폴더를 생성해준다. 
5. Docker Build ~ Docker Push
   - frontend 프로젝트에 포함되어 있는 도커 파일을 바탕으로 docker build를 하여 새로운 버전의 도커 이미지를 생성한다.
   - 생성된 도커 이미지를 docker push 명령어를 통해서 도커 허브에 이미지를 업로드한다.
6. Send Artifacts ~ Apply Deployment
   - 도커 허브에 이미지를 업로드하는 과정이 성공적으로 완료되면 k8s master 노드의 ssh 서버로 접속하여 기존의 프론트엔드 프로젝트에 있던
   백엔드 메니페스트 파일을 옮긴다.
   - k8s master 노드로 옮겨진 프론트엔드 메니페스트 파일을 kubectl apply 명령어를 통해서 적용시킨다.
7. K8S Deployment Docker Image Update
   - 프론트엔드 메니페스트 파일이 적용되면 이전에 도커 허브로 올렸던 최신 버전의 도커 이미지를 바탕으로 새로운 Deployment를 생성하게 된다.
8. Send Slack Alert
   - 앞선 모든 과정에서 성공 및 실패할 시 slack 알림을 보낸다.
   - 성공과 실패 메시지에 포함되는 내용
      - 슬랙 채널 명
      - 슬렉 알림 색깔
      - 성공 및 실패 메시지
      - 어떤 파이프라인 stage에서 발생한 이벤트인지
      - 현재 작업의 이름, 빌드 번호, 빌드 url
</details>