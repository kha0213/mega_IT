DROP TABLE MVC_MEMBER;
CREATE TABLE MVC_MEMBER(
    MID VARCHAR2(30),
    MPW VARCHAR2(30) NOT NULL,
    MNAME VARCHAR2(30) NOT NULL,
    MEMAIL VARCHAR2(30),
    MPHOTO VARCHAR2(30) DEFAULT 'NOING.JPG' NOT NULL,
    MBIRTH DATE,
    MADDRESS VARCHAR2(300),
    MRDATE DATE DEFAULT SYSDATE,
    PRIMARY KEY(MID) );

SELECT * FROM MVC_MEMBER;

SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM mvc_member ORDER BY MRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 5;
    
-- 멤버가입(id체크)
SELECT * FROM mvc_member WHERE mid='ID';

INSERT INTO mvc_member (MID,MPW,MNAME,MEMAIL,MPHOTO,MBIRTH,MADDRESS) VALUES
    ('ID','PW','NAME','EMAIL','PHOTO',NULL,'ADDR');
COMMIT;

-- 로그인
SELECT * FROM mvc_member WHERE mid='ID' AND MPW='MODIPW';

-- session에 넣기 위해 mid로 member dto 가져오기
SELECT * FROM mvc_member WHERE mid='ID';

-- 수정
UPDATE mvc_member SET MPW='MODIPW', MNAME='NA',MEMAIL='NN',MPHOTO='POPO',MBIRTH=SYSDATE,MADDRESS='D' WHERE MID='ID';

-- 전체 회원 수 
SELECT COUNT(*) FROM mvc_member;




