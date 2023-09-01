-- 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE; -- 회원번호
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE;	-- 게시글번호
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE; -- 댓글번호


INSERT INTO MEMBER
VALUES(SEQ_MEMBER_NO.NEXTVAL,
  'mem01@google.com', 
  '123123',
  '1번회원',
  '01012341234',
  '서울시 중구',
 DEFAULT, DEFAULT);
 
SELECT * FROM "MEMBER" m ;
ROLLBACK;
-- 이메일, 비밀번호가 일치하는 회원의
-- 닉네임, 전화번호, 주소 수정
UPDATE MEMBER
SET MEMBER_NICKNAME = '변경된 닉네임',
MEMBER_TEL = '01011112222',
MEMBER_ADDRESS = '경기도 수원시'
WHERE MEMBER_EMAIL = 'mem01@google.com'
AND MEMBER_PW  = '123123'
;


DELETE FROM MEMBER 
WHERE MEMBER_EMAIL = '이메일'
AND MEMBER_PW = '비밀번호';



UPDATE MEMBER
SET MEMBER_PW = '변경할비밀번호'
WHERE MEMBER_EMAIL = '이메일'
AND MEMBER_PW = '비밀번호'



