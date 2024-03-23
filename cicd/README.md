



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
</br>
<p align="center">
<img width="80%" src="./img/back/02. k8s_내부_아키텍처.png"></p>
</details>

<details>
    <summary>
<span style="font-size:150%"> k8s 전체 서비스 아키텍쳐 </span></summary>

<p align="center">
<img width="80%" src="./img/back/01. k8s_전체서비스_아키텍처.png">

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
2. webhook
3. Project Clean ~ Project Build
4. Docker Build ~ Docker Push
5. Docker Image Push
6. Send Artifacts ~ Apply Deployment
7. K8S Deployment Docker Image Update
8. Send Slack Alert
</details>

<details>
    <summary>
<span style="font-size:150%"> 프론트엔드 배포 시나리오 </span></summary>
<p align="center">
<img width="80%" src="img/jenkins-front.png">

1. git push
2. webhook
3. Project Clean ~ Project Build
4. Docker Build ~ Docker Push
5. Docker Image Push
6. Send Artifacts ~ Apply Deployment
7. K8S Deployment Docker Image Update
8. Send Slack Alert
</details>