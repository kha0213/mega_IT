DROP TABLE MEMBER CASCADE CONSTRAINTS;

DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    ID VARCHAR2(20) PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    PW VARCHAR2(20) NOT NULL,
    PHONE1 VARCHAR2(10),
    PHONE2 VARCHAR2(10),
    PHONE3 VARCHAR2(10),
    GENDER VARCHAR2(10)
);

INSERT INTO MEMBER VALUES ('아이디','롱롱이','123','010','2344','8628','남');

UPDATE MEMBER SET ID='디디디' WHERE ID='아이디';

DELETE FROM MEMBER WHERE ID='아이디';

SELECT * FROM MEMBER;

--회원가입
INSERT INTO MEMBER VALUES ('아이디','롱롱이','123','010','2344','8628','m');
--로그인(ID, PW)
--1. ID와 PW가 맞는지
SELECT * FROM MEMBER WHERE ID='아이디' AND PW='123';
--2. ID가 맞으면 그 아이디인 사람의 정보(session에 추가하기 위함)

--회원정보수정
UPDATE MEMBER SET NAME='롱롱롱롱롱', PW='132456', PHONE1='010', PHONE2='8888', PHONE3='1234', GENDER='m'
    WHERE ID='admin';

COMMIT;



SELECT * FROM MEMBER;
