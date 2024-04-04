# Spring Security, JWT 사이드 프로젝트!

Spring Security와 JWT를 이용한 인증 처리를 구현 해보기위한 사이드 프로젝트 입니다.


## 핵심 소스

### 1. SpringSecurityConfig

Spring Security 설정 파일로 권한, Filter, 보안 등의 설정사항들을 입력 해 놓았습니다.

- 권한
  
1. /login/** (모든유저)
   Login관련 처리를 하는 URL입니다.

   1-1. /signUp.do
   회원가입 API 입니다.

   1-2. /signIn.do
   로그인 API입니다.

   1-3. /getUserInfo.do
   로그인 확인 API입니다.

2. /admin/** (관리자)
   관리자 접근 URL입니다.

   2-1. /admin/index.do
   관리자 페이지 접근 API입니다.

3. /user/** (사용자)
   사용자 접근 URL입니다.

   3-1. /user/index.do
   사용자 페이지 접근 API입니다.

### 2. JwtTokenFilter

Jwt를 사용한 Security Filter처리 및 Security Authentication 생성 소스입니다.

### 3. JwtTokenProvider

Jwt 토큰 생성 및 만료시간 체크, id 추출 등 Util성 소스입니다.

  
