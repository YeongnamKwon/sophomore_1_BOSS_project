# 🖥️ BOSS(Basic_Open_Source_Software) — Mini Online Judge System

> 동국대학교 WISE캠퍼스 컴퓨터공학과 2학년 1학기 팀 프로젝트<br>
> Java기반 알고리즘 문제를 제출하고 자동으로 채점하는 온라인 저지(Online Judge) 시스템<br>
> 본 프로젝트는 (BOJ, Programmers 등) 여러 코딩 테스트 관련 문헌을 참고하였습니다.<br>
> 본 프로젝트는 바이브 코딩 및 코드를 기반으로 설계하였습니다.<br>
> ※ 해당 프로그램은 로컬호스트 (http://localhost:8080/) 환경에서만 작동하도록 설계되었습니다.<br>

---

## 📌 프로젝트 개요

**BOSS**는 백준(BOJ), Programmers와 같은 온라인 채점 시스템을 직접 구현한 프로젝트입니다.  
사용자가 문제를 선택하고 소스코드를 제출하면, 서버에서 컴파일·실행 후 테스트케이스와 비교하여 채점 결과를 반환합니다.

---

## ⚙️ 채점 흐름

```
[1] 사용자가 로그인 후 문제 선택
      ↓
[2] 알고리즘 작성 및 소스코드 제출
      ↓
[3] 서버가 코드 컴파일
      ↓
[4] 서버가 테스트케이스 입력
      ↓
[5] 실행 결과와 정답 비교
      ↓
[6] 채점 결과 출력
```

---

## 🛠️ 기술 스택

| 분류 | 기술 |
|------|------|
| Language | Java 17 |
| Framework | Spring Boot |
| Template Engine | Thymeleaf |
| Build Tool | Gradle |
| Frontend | HTML, CSS, JavaScript |
| Realtime Output | SSE(Server-Sent Events) |

---

## 📁 프로젝트 구조

```
sophomore_1_BOSS_project
├── src
│   └── main
│       ├── java
│       │   └── com.example.codejudge
│       │       ├── CodejudgeApplication.java
│       │       ├── controller
│       │       │   ├── LoginController.java
│       │       │   └── SubmitController.java
│       │       └── judge
│       │           ├── compiler.java
│       │           ├── errormanager.java
│       │           ├── judge.java
│       │           ├── judgemodel.java
│       │           ├── runner.java
│       │           ├── testcase.java
│       │           └── testcasemanager.java
│       └── resources
│           ├── templates
│           │   ├── login.html
│           │   └── submit.html
│           └── application.properties
├── build.gradle
├── settings.gradle
└── README.md
```

---

## 📝 지원 문제

| 문제 유형 | 설명 |
|---|---|
| A+B | 두 정수를 입력받아 합을 출력 |
| 최댓값 | N개의 정수 중 최댓값 출력 |
| 소수 찾기 | 입력된 수들 중 소수의 개수 출력 |

---

## 🚀 실행 방법

### 💡 사전 요구사항

- Java 17 이상
- Gradle (또는 포함된 `gradlew` 사용 가능)

---

### ✅ 빌드 및 실행

```bash
# 프로젝트 클론
git clone https://github.com/YeongnamKwon/sophomore_1_BOSS_project.git
cd sophomore_1_BOSS_project

# 빌드
./gradlew build

# 실행
./gradlew bootRun
```

서버가 실행되면 브라우저에서 `http://localhost:8080` 으로 접속합니다.

---

## 👥 팀원

| 이름 | 역할 |
|------|------|
| 권영남 | 백엔드 채점 로직 구현, JavaScript 기반 프론트엔드 동작 로직 구현, Spring Boot - 웹 연동, 테스트케이스 관리, "BOSS" 프로젝트 운영, 관리, 총괄, README 정리 |
| 김형규 | 프론트엔드 UI/UX 설계 및 마크업 구현, 글래스모피즘 기반 다크모드 로그인 페이지 개발, 다중 문제 선택 및 실시간 코드 템플릿 연동 로직 구현, 채점 결과 출력용 콘솔 인터페이스 설계 |

---

## 📝 참고

- 본 프로젝트는 학습 목적의 팀 프로젝트입니다.
- 채점 대상 언어 및 문제 목록은 추후 업데이트 예정입니다.
