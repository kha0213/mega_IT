-- 고객테이블
INSERT INTO CUSTOMER (CID,CPW,CNAME,CTEL,CEMAIL,CADDRESS,CGENDER,CBIRTH) VALUES 
('CID6','CPW','CNAME','CTEL','CEMAIL','CADDRESS','m','1992-02-05');


COMMIT;

-- 책 테이블
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은 자바다',20000,'NOTHING.JPG','noImg.png','내용',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것은 공짜다',10000,'NOTHING.JPG','noImg.png','내용',10);
COMMIT;
    
-- 게시판 테이블
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP,FRE_LEVEL,FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL,'CID6','FSUBJECT','FCONTENT','FFILENAME','FPW',FILEBOARD_SEQ.CURRVAL,0,0,'FIP');
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP,FRE_LEVEL,FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL,'CID7','FSUBJECT','FCONTENT','FFILENAME','FPW',4,3,2,'FIP');
COMMIT;
