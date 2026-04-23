# devlife-manager
개발자의 학습, 작업, 활동을 통합 관리하고 데이터 기반으로 생산성을 분석하는 웹 애플리케이션

# 프로젝트 개요
• 프로젝트명: DevLife Manager<br>
• 개발 기간: 2026.04 ~ 진행중<br>
• 목적:<br>
  개발자의 일상(학습, 작업, 활동)을 기록하고<br>
  데이터를 기반으로 생산성을 분석하여 자기 개선을 돕는 서비스 구현

# 주요 기능
1. 인증 (Auth)<br>
• 회원가입 (이메일 중복 체크, BCrypt 암호화)<br>
• 로그인 (JWT 기반 인증 예정)<br>
• 회원 정보 변경

2. Task 관리<br>
• 할 일 생성 / 조회<br>
• 상태 변경 (TODO / DOING / DONE)<br>
• 우선순위 설정

3. 활동 기록 (Activity)<br>
• 학습 / 코딩 / 기타 활동 기록<br>
• 활동 시간 저장 및 조회

3. 대시보드<br>
• 오늘의 Task 요약<br>
• 활동 시간 집계<br>
• 생산성 점수 표시

4. 통계<br>
• 날짜별 활동 시간 그래프<br>
• 생산성 추이 분석

# 기술 스택
Backend<br>
• Java 17<br>
• Spring Boot 3.5<br>
• Spring Security<br>
• JPA (Hibernate)

Database<br>
• PostgreSQL

Frontend<br>
• Vue.js 3<br>
• Chart.js (통계 시각화)

DevOps / Tool<br>
• Git / GitHub

# 주요 설계 포인트
• Stateless 인증 (JWT):서버 확장성 고려<br>
• Pre-computation 전략:통계 성능 개선 (실시간 집계 대신 배치 처리)<br>
• 계층형 아키텍처:유지보수성과 확장성 확보<br>
• Enum 관리:상태값을 문자열로 저장하고 애플리케이션에서 관리

# Author
GitHub: https://github.com/SUJINCH

