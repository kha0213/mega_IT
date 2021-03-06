DROP TABLE BOOK;
DROP SEQUENCE BOOK_SEQ;
DROP SEQUENCE FILEBOARD_SEQ;
DROP TABLE FILEBOARD;
DROP TABLE CUSTOMER;

-- DROP 끝

CREATE SEQUENCE BOOK_SEQ
    MAXVALUE 9999999
    NOCYCLE
    NOCACHE;

CREATE TABLE BOOK(
	bID NUMBER(7) PRIMARY KEY,
    bTITLE VARCHAR2(30) NOT NULL,
    bPRICE NUMBER(7) NOT NULL,
    bIMAGE1 VARCHAR2(30) DEFAULT 'NOTHING.JPG' NOT NULL,
    bIMAGE2 VARCHAR2(30) DEFAULT 'noImg.png' NOT NULL,
    bCONTENT VARCHAR2(4000),
    bDISCOUNT NUMBER(3) NOT NULL,
    bRDATE DATE DEFAULT SYSDATE
);


CREATE TABLE CUSTOMER(
	CID VARCHAR2(50) PRIMARY KEY,
	CPW VARCHAR2(50) NOT NULL,
	CNAME VARCHAR2(50) NOT NULL,
	CTEL VARCHAR2(50) NOT NULL,
	CEMAIL VARCHAR2(100),
	CADDRESS VARCHAR2(100),
    CGENDER VARCHAR2(10) NOT NULL,
	CBIRTH DATE NOT NULL,
	CRDATE DATE DEFAULT SYSDATE
);
CREATE SEQUENCE FILEBOARD_SEQ
    MAXVALUE 9999999
    NOCACHE
    NOCYCLE;
CREATE TABLE FILEBOARD(
    fNUM NUMBER(7) PRIMARY KEY,
    cID VARCHAR2(50) REFERENCES CUSTOMER(cID),
    fSUBJECT VARCHAR2(250) NOT NULL,
    fCONTENT VARCHAR2(4000),
    fFILENAME VARCHAR2(50),
    fPW VARCHAR2(50) NOT NULL,
    fHIT NUMBER(7) DEFAULT 0 NOT NULL,
    fREF NUMBER(7) NOT NULL,
    fRE_STEP NUMBER(7) NOT NULL,
    fRE_LEVEL NUMBER(7) NOT NULL,
    fIP VARCHAR2(50) NOT NULL,
    fRDATE DATE DEFAULT SYSDATE NOT NULL
);


DELETE FROM BOOK;
COMMIT;

SELECT * FROM BOOK;
SELECT * FROM FILEBOARD;
SELECT * FROM CUSTOMER;

--1.id중복체크
SELECT * FROM CUSTOMER WHERE CID='ID';
--2.회원가입
INSERT INTO CUSTOMER (CID,CPW,CNAME,CTEL,CEMAIL,CADDRESS,CBIRTH,CGENDER) VALUES 
('CID','CPW','CNAME','CTEL','CEMAIL','CADDRESS',TO_CHAR('1992-03-08','YYYY-MM-DD'),'m');
--3.로그인처리
SELECT * FROM CUSTOMER WHERE CID='ID' AND CPW='PW';
--4.id로 DTO가져오기
SELECT * FROM CUSTOMER WHERE CID='ID';
--5.회원정보수정
UPDATE CUSTOMER SET CPW='TEST11',CNAME='NAME',CTEL='TEL',CEMAIL='EMAIL',CADDRESS='ADDRESS',CBIRTH=SYSDATE,CGENDER='F' WHERE CID='CID';
COMMIT;

-- 책등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은 자바다',20000,'NOTHING.JPG','noImg.png','내용',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은 JSP다',18000,'NOTHING.JPG','내용',10);    
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '오라클',19000,'noImg.png','내용',10);  
INSERT INTO BOOK (bID, bTITLE, bPRICE, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '오라',20000,'내용',10);    
-- 책목록(bRDATE - TOP-N)

SELECT * FROM BOOK ORDER BY bRDATE DESC;
SELECT ROWNUM RN, C.* FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) C;
SELECT * FROM (SELECT ROWNUM RN, C.* FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) C)
    WHERE RN BETWEEN 6 AND 10;
--등록된 책 갯수
SELECT COUNT(*) FROM BOOK;
commit;


--bID로 책 가져오기
SELECT * FROM BOOK WHERE bID='';


INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FHIT, FREF, FRE_STEP,FRE_LEVEL,FIP,FRDATE)
    VALUES (FILEBOARD_SEQ.NEXTVAL,?,?,?,?,?,0,0,0,0,?,SYSDATE);





