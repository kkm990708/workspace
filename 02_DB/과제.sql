ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER example IDENTIFIED BY "example";

GRANT CONNECT, RESOURCE TO example;

ALTER USER example DEFAULT TABLESPACE "A230724"
QUOTA 10M ON "A230724";

CREATE USER example2 IDENTIFIED BY "example";

GRANT CONNECT, CREATE VIEW TO example2;

REVOKE CONNECT FROM example2;

DROP USER example2;

CREATE TABLE "MEMBER"(
	MEMBER_NO NUMBER PRIMARY KEY,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PASSWORD VARCHAR2(30) NOT NULL,
	PHONE_NUMBER VARCHAR2(20),
	DELETE_YN CHAR(1) CHECK(DELETE_YN IN('Y','N'))
);

COMMENT ON COLUMN MEMBER.MEMBER_NO IS '회원번호';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PASSWORD IS '비밀번호';
COMMENT ON COLUMN MEMBER.PHONE_NUMBER IS '핸드폰번호';
COMMENT ON COLUMN MEMBER.DELETE_YN IS '삭제여부';

CREATE TABLE BOARD (
	BAORD_NO NUMBER PRIMARY KEY,
	BOARD_TITLE VARCHAR2(300) NOT NULL,
	BAORD_CONTENT VARCHAR2(4000) NOT NULL,
	BOARD_WRITER NUMBER REFERENCES "MEMBER",
	CREATE_DATE DATE DEFAULT SYSDATE
);

COMMENT ON COLUMN BOARD.BAORD_NO IS '글번호';
COMMENT ON COLUMN BOARD.BOARD_TITLE IS '글제목';
COMMENT ON COLUMN BOARD.BAORD_CONTENT IS '글내용';
COMMENT ON COLUMN BOARD.BOARD_WRITER IS '작성자';
COMMENT ON COLUMN BOARD.CREATE_DATE IS '작성일자';

CREATE SEQUENCE SEQ_MEMBER_NO
START WITH 100
INCREMENT BY 100
;

CREATE SEQUENCE SEQ_BOARD_NO
START WITH 1
INCREMENT BY 1
;

INSERT INTO "MEMBER" VALUES (SEQ_MEMBER_NO.NEXTVAL,'step1','step11', NULL ,'N');
INSERT INTO "MEMBER" VALUES (SEQ_MEMBER_NO.NEXTVAL,'step2','step22','010-1111-2222','N');
INSERT INTO "MEMBER" VALUES (SEQ_MEMBER_NO.NEXTVAL,'step3','step33', NULL ,'N');


INSERT INTO BOARD VALUES (SEQ_BOARD_NO.NEXTVAL, '첫 글', '스텝평가', '100', '2023-03-12');
INSERT INTO BOARD VALUES (SEQ_BOARD_NO.NEXTVAL, '두 번째 글', '재밌다', '300', '2023-03-12');
INSERT INTO BOARD VALUES (SEQ_BOARD_NO.NEXTVAL, '세 번째 글', '하하', '200', '2023-03-12');

SELECT BAORD_NO 글번호,BOARD_TITLE 제목,BAORD_CONTENT 내용,MEMBER_ID 작성자, 
TO_CHAR(CREATE_DATE, 'YY/MM/DD') 작성일
FROM BOARD
JOIN "MEMBER" ON (BOARD_WRITER = MEMBER_NO)
ORDER BY BAORD_NO DESC;





