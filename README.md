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

> 각 폴더 안에 본인 GitHub ID로 서브폴더를 만들어 관리하면 충돌 방지 및 관리가 수월합니다.
>  
> 예시: `study/week1/hodomaroo/`, `homework/week1/hodomaroo/`

---

## 💡 작업 흐름

1. **공통 저장소(Repository) Fork**
   - 스터디용 원본 저장소를 자신의 GitHub 계정으로 Fork합니다.

2. **Fork한 저장소를 Local로 Clone**
   ```bash
   git clone https://github.com/본인ID/원본-repo명.git
   cd 원본-repo명
   ```

3. **업스트림(원본) 저장소 연결 (선택)**
   ```bash
   git remote add upstream https://github.com/원본ID/원본-repo명.git
   ```

4. **주차별 디렉토리/본인 폴더 생성 및 파일 작성**
   - 예시:
     ```
     mkdir -p study/week1/hodomaroo
     mkdir -p homework/week1/hodomaroo
     # 파일 추가/수정
     ```

5. **커밋 및 자신의 Fork로 Push**
   ```bash
   git add .
   git commit -m "[study][week1] 1주차 발표 자료 추가 (hodomaroo)"
   git push origin main
   ```

6. **GitHub에서 Pull Request(PR) 생성**
   - 자신의 Fork 저장소에서 **원본 저장소(main)**로 Pull Request를 생성합니다.
   - PR 설명에 작업 내용, 주차, 본인 ID 등을 명확히 적어주세요.

7. **(선택) 원본 저장소 변경사항 동기화**
   - 여러 명이 작업하는 경우, 주기적으로 원본 저장소의 최신 내용을 자신의 Fork에 반영해야 합니다.
   ```bash
   git fetch upstream
   git merge upstream/main
   git push origin main
   ```

---

## ✨ 참고사항 및 규칙

- **디렉토리/파일명 규칙**:  
  - 각 주차별 폴더 안에 본인 GitHub ID로 폴더를 만드시고, 그 안에 자료를 정리해주세요.
- **커밋 메시지 예시**:  
  - `[study][week2] 2주차 발표 정리 (hodomaroo)`
  - `[homework][week1] 과제 풀이 제출 (hodomaroo)`
- **PR 제목/내용**:  
  - 주차, 스터디/과제, 본인 ID, 주요 변경 사항을 명확히 작성
- **코드/자료의 저작권 및 인용**:  
  - 외부 자료 인용 시 반드시 출처를 남겨주세요.

---

## 🏁 요약

1. 원본 저장소 Fork → Clone  
2. 주차별/본인 폴더에 자료 작성  
3. Fork에 Push → PR 생성  
4. PR이 머지되면, 동기화도 주기적으로 진행!

궁금한 점이 있으면 언제든 Issue로 질문해 주세요!