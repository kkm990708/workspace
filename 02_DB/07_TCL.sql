-- TCL (Transaction Control Lnaguage)
-- Transaction : 업무, 처리, 거래


/* TRANSACTION이란?
 - 데이터베이스의 논리적 연산 단위
 
 - 데이터 변경 사항을 묶어 하나의 트랜잭션에 담아 처리함.

 - 트랜잭션의 대상이 되는 데이터 변경 사항 : INSERT, UPDATE, DELETE (DML)
 
 EX) INSERT 수행 --------------------------------> DB 반영(X)
   
     INSERT 수행 --> 트랜잭션에 추가 --> COMMIT --> DB 반영(O)
     
     INSERT 10번 수행 --> 1개 트랜잭션에 10개 추가 --> ROLLBACK --> DB 반영 안됨


    1) COMMIT : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 DB에 반영
    
    2) ROLLBACK : 메모리 버퍼(트랜잭션)에 임시 저장된 데이터 변경 사항을 삭제하고
                 마지막 COMMIT 상태로 돌아감.
                
    3) SAVEPOINT : 메모리 버퍼(트랜잭션)에 저장 지점을 정의하여
                   ROLLBACK 수행 시 전체 작업을 삭제하는 것이 아닌
                   저장 지점까지만 일부 ROLLBACK 
    
    [SAVEPOINT 사용법]
    
    SAVEPOINT 포인트명1;
    ...
    SAVEPOINT 포인트명2;
    ...
    ROLLBACK TO 포인트명1; -- 포인트1 지점 까지 데이터 변경사항 삭제

*/

-- 'D0' 가 있을경우 삭제
SELECT * FROM DEPARTMENT2 D ;
DELETE FROM DEPARTMENT2 D2  WHERE DEPT_ID ='D9';
COMMIT;

CREATE TABLE DEPARTMENT3 
AS SELECT * FROM DEPARTMENT2 D ;

SELECT * FROM DEPARTMENT3;

-- 'D0', '경리부', 'L2'
INSERT INTO DEPARTMENT3 VALUES ('D0', '경리부', 'L2');

-- DEPARTMENT3 테이블
-- DEPT_ID가 D9인 부서의 이름과 지역코드를
-- '전략 기획팀', 'L3'로 수정
UPDATE DEPARTMENT3
SET DEPT_TITLE = '전략 기획팀', LOCATION_ID = 'L3'
WHERE DEPT_ID = 'D9';

COMMIT;	-- 현재 트랜잭션에 저장된 DML(INSERT, UPDATE)를 실제 DB에 반영
ROLLBACK; -- 한번 COMMIT 된 내용을 ROLLBACK으로는 취소 불가

SELECT * FROM DEPARTMENT3;




--------------------------------------------------------------------------


-- DEPT_ID가 'D0'인 행을 삭제 
DELETE FROM DEPARTMENT3 WHERE DEPT_ID = 'D0';

-- DEPT_ID가 'D9'인 행을 삭제 
DELETE FROM DEPARTMENT3 WHERE DEPT_ID = 'D9';

-- DEPT_ID가 'D8'인 행을 삭제 
DELETE FROM DEPARTMENT3 WHERE DEPT_ID = 'D8';

ROLLBACK;

SELECT * FROM DEPARTMENT3;

-------------------------------------------------
-- SAVEPOINT

SELECT * FROM DEPARTMENT3;
-- DEPT_ID가 'D0'인 행을 삭제 
DELETE FROM DEPARTMENT3 WHERE DEPT_ID = 'D0';
SAVEPOINT SP1;

-- DEPT_ID가 'D9'인 행을 삭제 
DELETE FROM DEPARTMENT3 WHERE DEPT_ID = 'D9';
SAVEPOINT SP2;

-- DEPT_ID가 'D8'인 행을 삭제 
DELETE FROM DEPARTMENT3 WHERE DEPT_ID = 'D8';
SAVEPOINT SP3;

SELECT * FROM DEPARTMENT3;

ROLLBACK TO SP1;
SELECT * FROM DEPARTMENT3;

ROLLBACK;