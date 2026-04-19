# devlife-manager
개발자의 학습, 작업, 활동을 통합 관리하고 데이터 기반으로 생산성을 분석하는 웹 애플리케이션

# 프로젝트 개요
• 프로젝트명: DevLife Manager
• 개발 기간: 2026.04 ~ 진행중
• 목적:
  개발자의 일상(학습, 작업, 활동)을 기록하고
  데이터를 기반으로 생산성을 분석하여 자기 개선을 돕는 서비스 구현

# 주요 기능
1. 인증 (Auth)
• 회원가입 (이메일 중복 체크, BCrypt 암호화)
• 로그인 (JWT 기반 인증 예정)
• 회원 정보 변경

2. Task 관리
• 할 일 생성 / 조회
• 상태 변경 (TODO / DOING / DONE)
• 우선순위 설정
3. 활동 기록 (Activity)
• 학습 / 코딩 / 기타 활동 기록
• 활동 시간 저장 및 조회

3. 대시보드
• 오늘의 Task 요약
• 활동 시간 집계
• 생산성 점수 표시

4. 통계
• 날짜별 활동 시간 그래프
   생산성 추이 분석

# 기술 스택
Backend
• Java 17
• Spring Boot 3.x
• Spring Security
• JPA (Hibernate)

Database
• PostgreSQL

Frontend
• Vue.js 3 (예정)
• Chart.js (통계 시각화)

DevOps / Tool
• Git / GitHub

# 주요 설계 포인트
• Stateless 인증 (JWT):서버 확장성 고려
• Pre-computation 전략:통계 성능 개선 (실시간 집계 대신 배치 처리)
• 계층형 아키텍처:유지보수성과 확장성 확보
• Enum 관리:상태값을 문자열로 저장하고 애플리케이션에서 관리

# Author
GitHub: https://github.com/SUJINCH

