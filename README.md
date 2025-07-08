# 스터디/과제용 GitHub 저장소 사용 가이드

스터디와 과제(homework)를 효율적으로 관리하기 위해 아래와 같이 디렉토리 구조를 나누고, 각자 Fork를 통해 작업하는 방법을 안내합니다.

---

## 📁 디렉토리 구조

```
kucdas-algorithm/
├── study/
│   ├── week1/
│   ├── week2/
│   └── ...
├── homework/
│   ├── week1/
│   ├── week2/
│   └── ...
├── README.md
└── 기타 파일
```

- **study/** : 스터디(예: 이론, 발표, 필기 등) 관련 자료를 주차별로 정리
- **homework/** : 과제(문제 풀이, 실습 등) 자료를 주차별로 정리
- 각 주차별 디렉토리에 본인 학번-이름 (EX. 2025320024-kimduho)형식의 디렉토리를 만들고, 해당 디렉토리 내에 문제 풀이(숙제)코드를 추가하여 작성하면 됩니다.

# ✅ GitHub PR 가이드: `kucdas-algorithm` 레포지토리 기여 방법

---

## 1️⃣ Git 설치하기

**🔗 공식 사이트**: [https://git-scm.com](https://git-scm.com)

1. 사이트 접속 후, 운영체제에 맞는 설치파일 다운로드  
2. 설치 진행 (기본 옵션 그대로 진행해도 무방)  
3. 설치 완료 후, 터미널(Git Bash 등)에서 설치 확인:

```bash
git --version
```

---

## 2️⃣ Git 초기 설정

### 📌 사용자 정보 설정 (GitHub 계정과 동일하게 설정할 것)

```bash
git config --global user.name "Your GitHub Username"
git config --global user.email "your_email@example.com"
```

### ✅ 설정 확인

```bash
git config --global --list
```

---

## 3️⃣ Repository Fork & Clone

### 🍴 1. 레포지토리 Fork

- [`kucdas-algorithm`](https://github.com/kucdas-koreauniv/kucdas-algorithm) 페이지 접속
- 우측 상단의 `Fork` 버튼 클릭
- 본인 계정으로 Fork 완료

### 📥 2. Fork한 레포지토리 Clone

```bash
git clone https://github.com/your-username/kucdas-algorithm.git
cd kucdas-algorithm
```

---

## 4️⃣ 수정 후 Commit & Push

### ✏️ 1. 코드 수정

- `main.py` 등 원하는 파일 수정

### 💾 2. 변경사항 확인

```bash
git status
```

### ✅ 3. 변경사항 추가 및 커밋

```bash
git add .
git commit -m "fix: 문제 XX 해결"
```

### ⬆️ 4. 변경사항 푸시

```bash
git push origin main  # 또는 작업한 브랜치명
```

---

## 5️⃣ Pull Request 보내기 (PR)

1. GitHub 본인의 Fork 저장소로 이동
2. `Compare & Pull Request` 버튼 클릭
3. PR 제목과 설명 작성 (무엇을 수정했는지 간단히) -> PR 작성 시, [Homework][Week해당주차] 제목 형식으로 작성해주세요. (EX. [Homework][Week1] 김두호 숙제 제출합니다. 등)
4. `Create Pull Request` 클릭

---

## 💡 추가 팁

### 🔄 원본 저장소의 변경사항을 반영하려면? 
(Fork한 저장소에는 최신 변경사항이 반영되지 않으므로, 아래와 같이 설정하면 새로운 주차의 숙제 / 풀이 디렉토리가 추가되었을 때 반영이 가능합니다.)

```bash
git remote add upstream https://github.com/kucdas-koreauniv/kucdas-algorithm.git
git fetch upstream
git merge upstream/main
```


> 이 가이드는 `kucdas-algorithm` 저장소에 기여하는 모든 스터디원들을 위한 문서입니다.
