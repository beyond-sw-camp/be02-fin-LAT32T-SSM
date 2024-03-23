



## 🤼‍♂️팀원 소개

<br><br>

&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　&nbsp;　 🐻 **[이동규](https://github.com/PTCman)**&nbsp;　 🦁 **[양호신](https://github.com/Hosae0905)** &nbsp;　 🐶 **[김주연](https://github.com/jyk147369)** &nbsp;　 🐯 **[장대현](https://github.com/poil4291)** &nbsp;
<br><br><br><br><br>


## ✔️ 기술 스택
<br>
<div align="center">
<img src="https://img.shields.io/badge/k8s-326CE5?style=for-the-badge&logo=#326CE5&logoColor=white">
<img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">
<img src="https://img.shields.io/badge/jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/grafana-F46800?style=for-the-badge&logo=grafana&logoColor=white">
<img src="https://img.shields.io/badge/prometheus-E6522C?style=for-the-badge&logo=prometheus&logoColor=white">
<img src="https://img.shields.io/badge/slack-4A154B?style=for-the-badge&logo=slack&logoColor=white">
<img src="https://img.shields.io/badge/webhook-2088FF?style=for-the-badge&logo=webhook&logoColor=white">
</div>
<br>

## 🖥️ Lat32t 운영 환경

<details>
    <summary>
<span style="font-size:150%"> k8s 내부 아키텍처 </span></summary>
- k8s 아키텍처 - 클러스터 구성

- Master Node :1대
- Worker Node: 4대
- Node간 Connection을 위해 Calico CNI를 설치
- Service 생성시 LoadBalance Type 사용을 위해 Metallb를 설치
- 프로메테우스와 그라파나로 모니터링 시스템 구축
</br>
<p align="center">
<img width="80%" src="./img/k8s_system.png"></p>
</details>

<details>
    <summary>
<span style="font-size:150%"> k8s 전체 서비스 아키텍쳐 </span></summary>

<p align="center">
<img width="80%" src="./img/k8s.png">

서비스 아키텍처
User는 Load Balancer Service를 통해 Nginx Server에 접속 가능하다.
</p>
</details>


## ✨젠킨스 파이프라인(배포 시나리오)
<details>
    <summary>
<span style="font-size:150%"> 백엔드 배포 시나리오 </span></summary>
<p align="center">
<img width="80%" src="img/jenkins-backend.png">

1. git push
    - 브랜치에 대한 설명
2. webhook
    - 어떤 경로로 웹 훅이 이뤄지는지
3. Project Clean ~ Project Build
    - 스프링 프로젝트가 어떤 과정으로 처리되는지
4. Docker Build ~ Docker Push
    - 도커 관련 작업
5. Docker Image Push
    - 도커 허브에 이미지 푸쉬
6. Send Artifacts ~ Apply Deployment
    - 마스터 노드에 적용하는 과정
7. K8S Deployment Docker Image Update
    - 마스터 노드에서 이뤄지는 작업 설명
8. Send Slack Alert
    - 성공시 메시지를 어떻게 보내는지
    - 실패시 메시지를 어떻게 보내는지
</br>
</br>
</details>

<details>
    <summary>
<span style="font-size:150%"> 프론트엔드 배포 시나리오 </span></summary>
<p align="center">
<img width="80%" src="img/jenkins-front.png">

1. git push
    - 브랜치에 대한 설명
2. webhook
    - 어떤 경로로 웹 훅이 이뤄지는지
3. Install Dependencies
    - npm 설치하는 과정
4. Project Test ~ Project Build
    - 프로젝트 테스트와 빌드되는 과정 설명
5. Docker Build ~ Docker Push
    - 도커 관련 작업
6. Docker Image Push
    - 도커 허브에 이미지 푸쉬
7. Send Artifacts ~ Apply Deployment
    - 마스터 노드에 적용하는 과정
8. K8S Deployment Docker Image Update
    - 마스터 노드에서 이뤄지는 작업 설명
9. Send Slack Alert
    - 성공시 메시지를 어떻게 보내는지
    - 실패시 메시지를 어떻게 보내는지
</details>