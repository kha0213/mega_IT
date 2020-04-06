-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
-- Book.xml(신규순list, 도서보기(paging), 책 갯수,상세보기, 도서등록, 도서 정보수정)
SELECT * FROM BOOK;

-- ID = mainList(신규순 List)
SELECT * FROM BOOK ORDER BY brdate DESC;

-- ID = bookList(paging처리해서 도서이름 순으로 list가져오기)
SELECT * FROM (SELECT ROWNUM RN,A.* FROM (SELECT * FROM BOOK ORDER BY btitle) A) WHERE RN BETWEEN 2 AND 3;
-- ID = cntBook (등록된 책 갯수 가져오기)
SELECT COUNT(*) FROM BOOK;
-- ID = getBook (책번호 bnum으로 dto가져오기)
SELECT * FROM BOOK WHERE BNUM=1;
-- ID = registerBook (책 등록하기)
INSERT INTO BOOK (BID, BTITLE, BWRITER, BRDATE, BINFO) VALUES
    (BOOK_SQ.NEXTVAL, 'Spring', '롱롱이',SYSDATE,'좋은 스프링책');
INSERT INTO BOOK (BID, BTITLE, BWRITER, BRDATE, BIMG1, BINFO) VALUES
    (BOOK_SQ.NEXTVAL, 'Spring', '롱롱이',SYSDATE,'noImg.png','좋은 스프링책');
INSERT INTO BOOK (BID, BTITLE, BWRITER, BRDATE, BIMG2, BINFO) VALUES
    (BOOK_SQ.NEXTVAL, 'Spring', '롱롱이',SYSDATE,'noImg.png','좋은 스프링책');
INSERT INTO BOOK (BID, BTITLE, BWRITER, BRDATE, BIMG1, BIMG2, BINFO) VALUES
    (BOOK_SQ.NEXTVAL, 'Spring', '롱롱이',SYSDATE,'noImg.png','noImg.png','좋은 스프링책');
-- ID = modifyBook (책 정보 수정하기)
UPDATE BOOK SET
    bTITLE = 'Spring', bWRITER = '롱롱이', bRDATE = SYSDATE, bINFO = '좋은 스프링책'
    WHERE BNUM = 1;
UPDATE BOOK SET
    bTITLE = 'Spring', bWRITER = '롱롱이', bRDATE = SYSDATE, bIMG1 = 'noImg.png', bINFO = '좋은 스프링책'
    WHERE BNUM = 1;
UPDATE BOOK SET
    bTITLE = 'Spring', bWRITER = '롱롱이', bRDATE = SYSDATE, bIMG2 = 'noImg.png', bINFO = '좋은 스프링책'
    WHERE BNUM = 1;
UPDATE BOOK SET
    bTITLE = 'Spring', bWRITER = '롱롱이', bRDATE = SYSDATE, bIMG1 = 'noImg.png', bIMG2 = 'noImg.png', bINFO = '좋은 스프링책'
    WHERE BNUM = 1;
COMMIT;
-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
-- Member.xml (id중복체크, 가입, id로 dto가져오기, 정보수정
SELECT * FROM MEMBER;
-- ID = idConfirm (해당 id가 몇 개인지)
SELECT COUNT(*) FROM MEMBER WHERE MID='aaa';
-- ID = joinMember (회원가입)
INSERT INTO MEMBER VALUES
    ('aaa','1','멤버링링이','kha0213@naver.com','057-85','우편번호다잉');
-- ID = getMember (mid로 dto가져오기)
SELECT * FROM MEMBER WHERE MID='aaa';
-- ID = modifyMember (회원정보수정)
UPDATE MEMBER SET
    MPW='1', MNAME= '멤버링링이', MMAIL = 'kha0213@naver.com', MPOST = '057-85', MADDR = '우편번호다잉'
    WHERE MID = 'aaa';
