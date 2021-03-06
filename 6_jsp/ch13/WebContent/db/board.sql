DROP TABLE BOARD;

CREATE TABLE BOARD(
    NUM NUMBER(5) PRIMARY KEY, --글 번호
    WRITER VARCHAR2(30) NOT NULL, --작성자
    SUBJECT VARCHAR2(100) NOT NULL,
    CONTENT VARCHAR2(1000) NOT NULL,
    EMAIL VARCHAR2(30),
    HIT NUMBER(5) DEFAULT 0,
    PW VARCHAR2(30) NOT NULL,
    REF NUMBER(5) NOT NULL,
    RE_STEP NUMBER(5) NOT NULL,
    RE_LEVEL NUMBER(5) NOT NULL, --답변글일 경우 들여쓰기 정도
    IP VARCHAR2(20) NOT NULL,
    RDATE DATE DEFAULT SYSDATE
    );
    
-- 글 갯수
SELECT COUNT(*) CNT FROM BOARD; 
-- 글 목록(최신글이 위로)
SELECT * FROM BOARD ORDER BY REF DESC;
-- 글쓰기 
SELECT NVL(MAX(NUM),0)+1 FROM BOARD;

INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP) VALUES (
    (SELECT NVL(MAX(NUM),0)+1 FROM BOARD),
    'WRITER_TEST', 'SUBJECT_TEST', 'CONTENT_TEST_CONTENT', NULL, 'PW', (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '0', '0', '192.168.20.55');
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_LEVEL, IP) VALUES (
    (SELECT NVL(MAX(NUM),0)+1 FROM BOARD),
    '테스트 글쓴이', '테스트 제목', '테스트 내용', '테스트이메일', '테스트비밀번호', (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '0', '0', '192.168.20.55');
COMMIT;

UPDATE BOARD SET HIT=100 WHERE NUM=2;

-- 글번호로 글(DTO) 가져오기
SELECT * FROM BOARD WHERE NUM=1;
-- HIT수 올리기
UPDATE BOARD SET HIT=HIT+1 WHERE NUM=1;
COMMIT;
-- 글 수정
UPDATE BOARD SET WRITER = '김길동',SUBJECT='바뀐제목', CONTENT='내용 수정했어요', EMAIL='MAIL수정',PW='바꾼 PW', IP='바꾼IP' WHERE NUM=1;
COMMIT;
-- 글 삭제
DELETE FROM BOARD WHERE NUM=32;

SELECT * FROM BOARD ORDER BY REF DESC;

SELECT RN REF FROM (SELECT * FROM BOARD B ORDER BY NUM DESC) WHERE RN BETWEEN 5 AND 10;

-- TOP N 구문
SELECT C.*  FROM (SELECT ROWNUM RN, B.* FROM (SELECT * FROM BOARD ORDER BY REF DESC) B) C WHERE RN BETWEEN 6 AND 10;


