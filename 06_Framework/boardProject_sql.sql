/* 계정 생성(관리자) */

ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- 계정 생성
CREATE USER spring_3MIN1K IDENTIFIED BY spring1234;

-- 권한 부여
GRANT CONNECT, RESOURCE, CREATE VIEW TO spring_3MIN1K;

-- 객체 생성 공간 할당
ALTER USER spring_3MIN1K DEFAULT TABLESPACE "A230724";
ALTER USER spring_3MIN1K DEFAULT TABLESPACE "A230724"
QUOTA 20M ON "A230724";

--------------------------------------------------------
-- "" 작성시 대 소문자 구분
-- "" 붙이는걸 권장 

-- VARCHAR2(10) 10 바이트 문자열(바이트 단위)
-- NVARCHAR(10) 10글자 문자열( 유니코드 )

/* MEMBER 테이블 생성*/
CREATE TABLE "MEMBER"(
	"MEMBER_NO" NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY,
	"MEMBER_EMAIL" VARCHAR2(50) NOT NULL,
	"MEMBER_PW" VARCHAR2(100) NOT NULL,
	"MEMBER_NICKNAME" NVARCHAR2(10) NOT NULL,
	"MEMBER_TEL" CHAR(11) NOT NULL,
	"MEMBER_ADDRESS" NVARCHAR2(200),
	"PROFILE_IMG" VARCHAR2(300),
	"ENROLL_DATE" DATE DEFAULT SYSDATE NOT NULL,
	"MEMBER_DEL_FL" CHAR(1) DEFAULT 'N'
		CHECK("MEMBER_DEL_FL" IN ('Y', 'N')),
	"AUTHORITY" NUMBER DEFAULT 1 CHECK("AUTHORITY" IN (1,2))
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 번호 (SEQ_MEMBER_NO)';
COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일(ID역할)';
COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '비밀번호(암호화)';
COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '별명';
COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호(-없음)';
COMMENT ON COLUMN "MEMBER"."MEMBER_ADDRESS" IS '주소';
COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '프로필 이미지 저장 경로';
COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '가입일';
COMMENT ON COLUMN "MEMBER"."MEMBER_DEL_FL" IS '탈퇴여부(Y : 탈퇴,  N : 정상)';
COMMENT ON COLUMN "MEMBER"."AUTHORITY" IS '권한(1 : 일반,  2 : 관리자)';

-- 시퀸스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;

-- 샘플 계정 추가
INSERT INTO "MEMBER" 
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'member01@naver.com', 'pass01',
	'회원1', '01012341234', '04540^^^서울시 중구 남대문로 120^^^2층',
 	NULL, DEFAULT, DEFAULT, DEFAULT);

COMMIT;

SELECT * FROM "MEMBER";

SELECT MEMBER_NO ,MEMBER_EMAIL ,MEMBER_NICKNAME ,MEMBER_TEL ,

MEMBER_ADDRESS ,PROFILE_IMG ,AUTHORITY ,

TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') AS ENROLL_DATE 

FROM "MEMBER"
WHERE MEMBER_DEL_FL = 'N'
AND MEMBER_EMAIL = 'member01@naver.com'
AND MEMBER_PW = 'pass01';

-- 샘플 회원 비밀번호 변경
UPDATE "MEMBER" SET 
MEMBER_PW = '$2a$10$RnjUpZeXcmswC6CQcEREr.NN9vDyOjjGwta44/WX7ZP.kxX4Emeii'
WHERE MEMBER_NO = 1;

-- 회원 정보 수정
-- "MEMBER" 테이블에서 
-- MEMBER_NO가 일치하는 회원의
-- MEMBER_NICKNAME, MEMBER_TEL, MEMBER_ADDRESS 수정

UPDATE "MEMBER" SET
MEMBER_NICKNAME = 'T',
MEMBER_TEL = 01022223333,
MEMBER_ADDRESS =12121
WHERE MEMBER_NO = 1;

-- BCrypt 암호화 시 비밀번호를 조회한 후
-- matches() 메서드를 이용해서 비교
-- 로그인한 회원의 암호화된 비밀번호를 조회
SELECT MEMBER_PW 
FROM "MEMBER"
WHERE MEMBER_NO = '회원번호';

-- 비밀번호 변경
UPDATE "MEMBER" SET 
MEMBER_PW = '비밀번호'
WHERE MEMBER_NO = '회원번호';

UPDATE "MEMBER" SET 
MEMBER_DEL_FL = 'Y'
WHERE MEMBER_NO = 2;

SELECT * FROM "MEMBER" m ;

UPDATE "MEMBER" SET 
MEMBER_DEL_FL = 'N'
WHERE MEMBER_NO = 1;

SELECT * FROM "MEMBER" m ;

UPDATE "MEMBER" SET 
MEMBER_DEL_FL = 'N';
COMMIT;

-- 관리자 권한으로 변경
SELECT * FROM "MEMBER";
UPDATE "MEMBER" SET 
AUTHORITY = 2
WHERE MEMBER_NO = 1;

SELECT MEMBER_NO ,MEMBER_EMAIL ,MEMBER_NICKNAME , ENROLL_DATE ,
MEMBER_TEL ,MEMBER_ADDRESS, AUTHORITY ,MEMBER_DEL_FL  
FROM "MEMBER"
WHERE MEMBER_EMAIL =;

SELECT MEMBER_NO ,MEMBER_EMAIL ,MEMBER_DEL_FL 
FROM "MEMBER"
ORDER BY MEMBER_NO DESC ;

UPDATE "MEMBER" SET 
AUTHORITY = 1
WHERE MEMBER_NO = 8;

COMMIT;

SELECT * FROM "MEMBER" m ;

CREATE TABLE TB_BOARD(
	BOARD_NO NUMBER PRIMARY KEY,
	BOARD_TITLE VARCHAR2(300) NOT NULL,
	BOARD_CONTENT VARCHAR2(4000) NOT NULL,
	BOARD_WRITER VARCHAR2(100) NOT NULL,
	BOARD_PW VARCHAR2(100) NOT NULL,
	WRITE_DATE DATE DEFAULT SYSDATE,
	BOARD_DEL_FL CHAR(1) DEFAULT 'N' CHECK(BOARD_DEL_FL IN ('Y','N')) 
);

CREATE SEQUENCE SEQ_BOARD_NO NOCACHE;

COMMENT ON COLUMN TB_BOARD.BOARD_NO IS '게시글 번호(SEQ_BOARD_NO)';
COMMENT ON COLUMN TB_BOARD.BOARD_TITLE IS '게시글 제목';
COMMENT ON COLUMN TB_BOARD.BOARD_CONTENT IS '게시글 내용';
COMMENT ON COLUMN TB_BOARD.BOARD_WRITER IS '게시글 작성자';
COMMENT ON COLUMN TB_BOARD.BOARD_PW IS '게시글 비밀번호(암호화 O)';
COMMENT ON COLUMN TB_BOARD.WRITE_DATE IS '게시글 작성일(기본값 SYSDATE)';
COMMENT ON COLUMN TB_BOARD.BOARD_DEL_FL IS '게시글 삭제 여부(기본값 N)';

SELECT MEMBER_EMAIL 
FROM "MEMBER" m 
WHERE MEMBER_NO = 0;

SELECT MEMBER_TEL 
FROM "MEMBER"
WHERE MEMBER_EMAIL = ;

-- 이메일 중복 검사(중복 0 -> 1, 중복 X -> 0)
SELECT count(*) FROM "MEMBER" 
WHERE MEMBER_DEL_FL = 'N'
AND MEMBER_NICKNAME  = 'member01@naver.com';

SELECT * FROM "MEMBER" m ;

SELECT MEMBER_EMAIL 
FROM "MEMBER"
WHERE MEMBER_EMAIL = LIKE '%${keyword}%';

SELECT *
FROM TB_AUTH_KEY 


/* 이메일 인증키 테이블 */
CREATE TABLE "TB_AUTH_KEY" (
   "KEY_NO"   NUMBER      NOT NULL,
   "AUTH_KEY"   CHAR(6)      NOT NULL,
   "EMAIL"   VARCHAR2(50)      NOT NULL,
   "CREATE_TIME"   DATE   DEFAULT SYSDATE   NOT NULL
);



COMMENT ON COLUMN "TB_AUTH_KEY"."KEY_NO" IS '인증키 구분 번호(SEQ_KEY_NO)';

COMMENT ON COLUMN "TB_AUTH_KEY"."AUTH_KEY" IS '코드';

COMMENT ON COLUMN "TB_AUTH_KEY"."EMAIL" IS '이메일';

COMMENT ON COLUMN "TB_AUTH_KEY"."CREATE_TIME" IS '인증 코드 생성 시간';

ALTER TABLE "TB_AUTH_KEY" ADD CONSTRAINT "PK_TB_AUTH_KEY" PRIMARY KEY (
   "KEY_NO"
);


CREATE SEQUENCE SEQ_KEY_NO NOCACHE;


SELECT * FROM TB_AUTH_KEY;


---------------------------------------------------------------------------
---------------------------------------------------------------------------


DROP TABLE "MEMBER";

CREATE TABLE "MEMBER" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"MEMBER_EMAIL"	VARCHAR2(50)		NOT NULL,
	"MEMBER_PW"	VARCHAR2(100)		NOT NULL,
	"MEMBER_NICKNAME"	VARCHAR2(30)		NOT NULL,
	"MEMBER_TEL"	CHAR(11)		NOT NULL,
	"MEMBER_ADDRESS"	VARCHAR2(300)		NULL,
	"PROFILE_IMG"	VARCHAR2(300)		NULL,
	"ENROLL_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"MEMBER_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"AUTHORITY"	NUMBER	DEFAULT 1	NOT NULL
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';

COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일(ID 역할)';

COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '비밀번호(암호화)';

COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '회원 닉네임(중복 X)';

COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호(- 없음)';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADDRESS" IS '회원 주소';

COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '프로필 이미지 경로';

COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '회원 가입일';

COMMENT ON COLUMN "MEMBER"."MEMBER_DEL_FL" IS '탈퇴여부(N : 탈퇴X , Y : 탈퇴 O)';

COMMENT ON COLUMN "MEMBER"."AUTHORITY" IS '회원 권한(1 : 일반, 2 : 관리자)';

DROP TABLE "BOARD";

CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(150)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"BOARD_WRITE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"BOARD_UPDATE_DATE"	DATE		NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"BOARD_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_CODE"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';

COMMENT ON COLUMN "BOARD"."BOARD_WRITE_DATE" IS '게시글 작성일';

COMMENT ON COLUMN "BOARD"."BOARD_UPDATE_DATE" IS '마지막 수정일(수정 시 UPDATE)';

COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';

COMMENT ON COLUMN "BOARD"."BOARD_DEL_FL" IS '삭제 여부(N : 삭제X , Y : 삭제O)';

COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';

COMMENT ON COLUMN "BOARD"."BOARD_CODE" IS '게시판 종류별 코드 번호(SEQ_BOARD_CODE)';

DROP TABLE "BOARD_IMG";

CREATE TABLE "BOARD_IMG" (
	"IMG_NO"	NUMBER		NOT NULL,
	"IMG_PATH"	VARCHAR2(300)		NOT NULL,
	"IMG_RENAME"	VARCHAR2(30)		NOT NULL,
	"IMG_ORIGINAL_NAME"	VARCHAR2(300)		NOT NULL,
	"IMG_ORDER"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD_IMG"."IMG_NO" IS '이미지 번호(SEQ_IMG_NO)';

COMMENT ON COLUMN "BOARD_IMG"."IMG_PATH" IS '이미지 저장 폴더 경로';

COMMENT ON COLUMN "BOARD_IMG"."IMG_RENAME" IS '변경된 이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORIGINAL_NAME" IS '원본 이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORDER" IS '이미지 파일 순서 번호';

COMMENT ON COLUMN "BOARD_IMG"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

DROP TABLE "BOARD_LIKE";

CREATE TABLE "BOARD_LIKE" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD_LIKE"."MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';

COMMENT ON COLUMN "BOARD_LIKE"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

DROP TABLE "COMMENT";

CREATE TABLE "COMMENT" (
	"COMMENT_NO"	NUMBER		NOT NULL,
	"COMMENT_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"COMMENT_WRITE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"COMMENT_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL,
	"PARENT_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "COMMENT"."COMMENT_NO" IS '댓글 번호(SEQ_COMMENT_NO)';

COMMENT ON COLUMN "COMMENT"."COMMENT_CONTENT" IS '댓글 내용';

COMMENT ON COLUMN "COMMENT"."COMMENT_WRITE_DATE" IS '댓글 작성일';

COMMENT ON COLUMN "COMMENT"."COMMENT_DEL_FL" IS '댓글 삭제 여부(N : 삭제X, Y : 삭제O)';

COMMENT ON COLUMN "COMMENT"."MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';

COMMENT ON COLUMN "COMMENT"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

COMMENT ON COLUMN "COMMENT"."PARENT_NO" IS '부모댓글 번호(SEQ_COMMENT_NO)';

DROP TABLE "BOARD_TYPE";

CREATE TABLE "BOARD_TYPE" (
	"BOARD_CODE"	NUMBER		NOT NULL,
	"BOARD_NAME"	VARCHAR2(300)		NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CODE" IS '게시판 종류별 코드 번호(SEQ_BOARD_CODE)';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NAME" IS '게시판 이름';

DROP TABLE "TB_AUTH_KEY";

CREATE TABLE "TB_AUTH_KEY" (
	"KEY_NO"	NUMBER		NOT NULL,
	"AUTH_KEY"	CHAR(6)		NOT NULL,
	"EMAIL"	VARCHAR2(50)		NOT NULL,
	"CREATE_TIME"	DATE	DEFAULT SYSDATE	NOT NULL
);

COMMENT ON COLUMN "TB_AUTH_KEY"."KEY_NO" IS '인증키 구분 번호(SEQ_KEY_NO)';

COMMENT ON COLUMN "TB_AUTH_KEY"."AUTH_KEY" IS '코드';

COMMENT ON COLUMN "TB_AUTH_KEY"."EMAIL" IS '이메일';

COMMENT ON COLUMN "TB_AUTH_KEY"."CREATE_TIME" IS '인증 코드 생성 시간';

ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);

ALTER TABLE "BOARD_IMG" ADD CONSTRAINT "PK_BOARD_IMG" PRIMARY KEY (
	"IMG_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "PK_BOARD_LIKE" PRIMARY KEY (
	"MEMBER_NO",
	"BOARD_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "PK_COMMENT" PRIMARY KEY (
	"COMMENT_NO"
);

ALTER TABLE "BOARD_TYPE" ADD CONSTRAINT "PK_BOARD_TYPE" PRIMARY KEY (
	"BOARD_CODE"
);

ALTER TABLE "TB_AUTH_KEY" ADD CONSTRAINT "PK_TB_AUTH_KEY" PRIMARY KEY (
	"KEY_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_BOARD_TYPE_TO_BOARD_1" FOREIGN KEY (
	"BOARD_CODE"
)
REFERENCES "BOARD_TYPE" (
	"BOARD_CODE"
);

ALTER TABLE "BOARD_IMG" ADD CONSTRAINT "FK_BOARD_TO_BOARD_IMG_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_LIKE_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_BOARD_TO_BOARD_LIKE_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_MEMBER_TO_COMMENT_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_BOARD_TO_COMMENT_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_COMMENT_TO_COMMENT_1" FOREIGN KEY (
	"PARENT_NO"
)
REFERENCES "COMMENT" (
	"COMMENT_NO"
);


-- CHECK 제약조건 추가
ALTER TABLE "BOARD" ADD CONSTRAINT CHECK_BOARD_DEL_FL
CHECK(BOARD_DEL_FL IN ('Y','N'));


ALTER TABLE "COMMENT" ADD CONSTRAINT CHECK_COMMENT_DEL_FL
CHECK(COMMENT_DEL_FL IN ('Y','N'));

-- 시퀸스 생성
CREATE SEQUENCE SEQ_BOARD_NO;
CREATE SEQUENCE SEQ_BOARD_CODE;
CREATE SEQUENCE SEQ_COMMENT_NO;
CREATE SEQUENCE SEQ_IMG_NO;


INSERT INTO BOARD_TYPE VALUES(SEQ_BOARD_CODE.NEXTVAL, '공지사항');
INSERT INTO BOARD_TYPE VALUES(SEQ_BOARD_CODE.NEXTVAL, '자유 게시판');
INSERT INTO BOARD_TYPE VALUES(SEQ_BOARD_CODE.NEXTVAL, '질문 게시판');

SELECT *
FROM BOARD_TYPE BT ;

/*BOARD 테이블 샘플 데이터 삽입(PL/SQL)*/
BEGIN
   FOR I IN 1..1500 LOOP
      INSERT INTO BOARD 
      VALUES( SEQ_BOARD_NO.NEXTVAL,
              SEQ_BOARD_NO.CURRVAL || '번째 게시글',
              SEQ_BOARD_NO.CURRVAL || '번째 게시글 내용 입니다.',
              DEFAULT, DEFAULT, DEFAULT, DEFAULT, 1, 
              CEIL(DBMS_RANDOM.VALUE(3,6))
      );
   END LOOP;
END;

SELECT COUNT(*) FROM BOARD B ;
WHERE BOARD_CODE = 6;
COMMIT;
ROLLBACK;
-- COMMENT 테이블 샘플 데이터 삽입(PL/SQL)
BEGIN
   FOR I IN 1..300 LOOP
      INSERT INTO "COMMENT" 
      VALUES(SEQ_COMMENT_NO.NEXTVAL, 
            SEQ_COMMENT_NO.CURRVAL || '번째 댓글',
            DEFAULT, DEFAULT,
            1, CEIL(DBMS_RANDOM.VALUE(1514,4513)), NULL);
   END LOOP;
END;
COMMIT;

SELECT COUNT(*) FROM "COMMENT";
SELECT MIN(BOARD_NO), MAX(BOARD_NO) FROM BOARD ; 

-- 좋아요 샘플데이터
INSERT INTO "BOARD_LIKE" VALUES(1 , 1514);
INSERT INTO "BOARD_LIKE" VALUES(1 , 1515);
INSERT INTO "BOARD_LIKE" VALUES(1 , 1516);
INSERT INTO "BOARD_LIKE" VALUES(1 , 1517);
INSERT INTO "BOARD_LIKE" VALUES(1 , 1518);
SELECT * FROM BOARD_LIKE ;

COMMIT;

SELECT * FROM "BOARD_LIKE";

---------------------------------------------------------

/* 게시글 목록 조회 */
-- 특정 게시판 목록만 조회(BOARD_CODE)
-- 삭제되지 않은 글만 조회
-- 최신글이 먼저 조회 (BOARD_NO 내림차순)
-- 조회할 컬럼 : 
-- [BOARD] 게시글 번호, 제목, 조회수, 작성일, 
-- [MEMBER]작성자닉네임, 

-- [COMMENT]댓글 수, 
-- [BOARD_LIKE]좋아요 수, 
-- [BOARD_IMG]썸네일
-- COMMENT , BOARD_LIKE, BOARD_IMG 테이블 상관 서브쿼리 필요

SELECT BOARD_NO , BOARD_TITLE , READ_COUNT , 
	MEMBER_NICKNAME ,
	
	CASE  
         WHEN SYSDATE - BOARD_WRITE_DATE < 1/24/60
         THEN FLOOR( (SYSDATE - BOARD_WRITE_DATE) * 24 * 60 * 60 ) || '초 전'
         WHEN SYSDATE - BOARD_WRITE_DATE < 1/24
         THEN FLOOR( (SYSDATE - BOARD_WRITE_DATE) * 24 * 60) || '분 전'
         WHEN SYSDATE - BOARD_WRITE_DATE < 1
         THEN FLOOR( (SYSDATE - BOARD_WRITE_DATE) * 24) || '시간 전'
         ELSE TO_CHAR(BOARD_WRITE_DATE, 'YYYY-MM-DD')
      END BOARD_WRITE_DATE,
      
	(SELECT COUNT(*) FROM "COMMENT" C WHERE C.BOARD_NO = B.BOARD_NO) COMMENT_COUNT,
	
	(SELECT COUNT(*) FROM BOARD_LIKE BL WHERE BL.BOARD_NO = B.BOARD_NO ) LIKE_COUNT,
	
	(SELECT IMG_PATH || IMG_RENAME FROM BOARD_IMG I
   WHERE I.BOARD_NO = B.BOARD_NO
   AND IMG_ORDER = 0) THUMBNAIL
   
FROM "BOARD" B 
JOIN "MEMBER" USING(MEMBER_NO) 
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = 4
ORDER BY BOARD_NO DESC 
;

/* 특정 게시판 전체 게시글 수 조회 */
SELECT COUNT(*) FROM BOARD
WHERE BOARD_DEL_FL = 'N' 
AND BOARD_CODE = 5
;


SELECT BOARD_NO , BOARD_TITLE , BOARD_CONTENT ,READ_COUNT ,
	TO_CHAR(BOARD_WRITE_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') BOARD_WRITE_DATE,
	TO_CHAR(BOARD_UPDATE_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') BOARD_UPDATE_DATE,
	MEMBER_NICKNAME ,PROFILE_IMG, MEMBER_NO ,
	(SELECT COUNT(*) FROM BOARD_LIKE BL WHERE BL.BOARD_NO = B.BOARD_NO) LIKE_COUNT
FROM "BOARD" B
JOIN "MEMBER" USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N' 
AND BOARD_NO = 4
AND BOARD_CODE = 4505
;


-- 특정 게시글의 댓글 목록 조회 (계층형 쿼리)
  SELECT LEVEL, C.* FROM
     (SELECT COMMENT_NO, COMMENT_CONTENT,
         TO_CHAR(COMMENT_WRITE_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') COMMENT_WRITE_DATE,
         BOARD_NO, MEMBER_NO, MEMBER_NICKNAME, PROFILE_IMG, PARENT_NO, COMMENT_DEL_FL
     FROM "COMMENT"
     JOIN MEMBER USING(MEMBER_NO)
     WHERE BOARD_NO = 4498) C
  WHERE COMMENT_DEL_FL = 'N'
  START WITH PARENT_NO IS NULL
  CONNECT BY PRIOR COMMENT_NO = PARENT_NO
  ORDER SIBLINGS BY COMMENT_NO
;
COMMIT;

 INSERT INTO "COMMENT" 
      VALUES(SEQ_COMMENT_NO.NEXTVAL, '자식 댓글 2', DEFAULT, DEFAULT,
            1, 4498, 808);
-- START WITH PARENT_NO IS NULL :
-- PARENT_NO가 없는 댓글이 계층의 시작 지점이다
  
-- CONNECT BY PRIOR COMMENT_NO = PARENT_NO
-- PARENT_NO와 COMMENT_NO가 같은 행을 연결    ㄴㅇㅁㄴ

-- ORDER SIBLINGS BY COMMENT_NO
-- 계층 구조 정렬