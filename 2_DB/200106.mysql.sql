SHOW DATABASES;
create database kimdb;
use kimdb;
use world;
show tables;-- select * from tab; (sql develope)
SELECT 
    *
FROM
    CITY;
SELECT DATABASE(); -- 현재 위치한 DATABASE
DROP TABLE IF EXISTS major;
CREATE TABLE major (
    major_code INT PRIMARY KEY AUTO_INCREMENT,
    major_name VARCHAR(30)
);

insert into major (major_name) values ('경영정보');    
insert into major (major_name) values ('전자공학');    
insert into major (major_name) values ('화학공학');

SELECT 
    *
FROM
    major;    

drop table if exists student;

CREATE TABLE STUDENT (
    STU_ID INT PRIMARY KEY,
    name VARCHAR(15),
    major_code INT,
    FOREIGN KEY (major_code)
        REFERENCES major (major_code)
);
insert into student values (1001,'홍길동',1);
insert into student values (1002,'김길동',2);
insert into student values (1003,'신길동',3);-- 여기선 foreign key를 밑으로써야해

SELECT 
    *
FROM
    STUDENT;
SELECT 
    *
FROM
    student s
        LEFT JOIN
    major m ON s.major_code = m.major_code; -- outer join

-- 자바(JDBC)수업시간에 쓸 테이블
drop table if exists division;
CREATE TABLE division (
    dno INT PRIMARY KEY,
    dname VARCHAR(20) NOT NULL UNIQUE,
    phone VARCHAR(20) UNIQUE,
    position VARCHAR(20)
);   -- 부서위치
show tables;

create table personal(
	pno int primary key,  -- 사번
    pname varchar(10) not null, -- 이름
    job varchar(15) not null, -- 직책
	manager int,              -- 직속상사의 사번
    startdate date,           -- 입사일
    pay int,                   -- 급여
    bonus int,                -- 보너스
    dno int,					-- 부서번호
    foreign key(dno) references division(dno));
    
insert into division values (10, 'finance','02-777-7777','종로');
insert into division values (20, 'research','041-888-8888','대전');
insert into division values (30, 'sales','031-666-6666','인천');
insert into division values (40, 'marketing','02-555-5555','강남');

select * from division;

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);

select * from personal;


-- (1)	select문 (and 연산자는 && 또는 and)
-- 1. 사번, 이름, 급여를 출력
SELECT 
    pno, pname, pay
FROM
    personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
SELECT 
    *
FROM
    personal
WHERE
    pay BETWEEN 2000 AND 5000;
SELECT * FROM PERSONAL
	WHERE PAY >=2000 && PAY<=5000;-- ||, && 연산자 사용가능 
   
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
SELECT PNO,PNAME,DNO FROM PERSONAL
	WHERE DNO=10 || DNO=20;
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
SELECT PNO,PNAME,PAY FROM PERSONAL
	WHERE BONUS IS NULL
    ORDER BY PAY DESC;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정열 같으면 큰 순
SELECT PNO,PNAME,DNO,PAY FROM PERSONAL
	order by DNO, PAY DESC;

-- 6. 사번, 이름, 부서명
SELECT PNO,PNAME,DNAME FROM PERSONAL P,DIVISION D
	WHERE P.DNO=D.DNO;
-- 7. 사번, 이름, 상사이름
SELECT W.PNO,W.PNAME,M.PNAME 상사
	FROM PERSONAL W, PERSONAL M
    WHERE W.MANAGER=M.PNO;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
SELECT W.PNO,W.PNAME,M.PNAME
	FROM PERSONAL W LEFT JOIN PERSONAL M
    ON W.MANAGER=M.PNO;
-- 9. 이름이 s로 시작하는 사원 이름
SELECT PNAME FROM PERSONAL
	WHERE PNAME LIKE 'S%';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
SELECT W.PNO,W.PNAME,W.PAY,DNAME,M.PNAME
	FROM PERSONAL W,DIVISION D,PERSONAL M
    WHERE W.DNO=D.DNO && W.MANAGER=M.PNO;
-- 11. 부서코드, 급여합계, 최대급여
SELECT DNO,SUM(PAY),MAX(PAY) FROM PERSONAL
	GROUP BY DNO;
-- 12. 부서명, 급여평균, 인원수
SELECT DNAME,AVG(PAY),COUNT(*)
	FROM PERSONAL P,DIVISION D
    WHERE P.DNO=D.DNO
    GROUP BY DNAME;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
SELECT DNO,SUM(PAY),COUNT(*)
	FROM PERSONAL
    GROUP BY DNO
    HAVING COUNT(*)>=4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
SELECT PNO,PNAME,PAY
	FROM PERSONAL
    WHERE PAY=(SELECT MAX(PAY) FROM PERSONAL);
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여
SELECT PNAME,PAY FROM PERSONAL
	WHERE PAY>(SELECT AVG(PAY) FROM PERSONAL);
-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
SELECT PNAME,PAY,DNAME
	FROM PERSONAL P,DIVISION D
	WHERE P.DNO=D.DNO && PAY>(SELECT AVG(PAY) FROM PERSONAL)
    ORDER BY DNAME,PAY DESC;
-- 17. 자기부서평균보다 급여를 많이 받는 사람 이름, 급여
SELECT PNAME,PAY FROM PERSONAL P
	WHERE PAY>(SELECT AVG(PAY) FROM PERSONAL WHERE P.DNO=DNO);
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
 SELECT PNAME,PAY,DNAME
	FROM PERSONAL P,DIVISION D
	WHERE P.DNO=D.DNO && STARTDATE = (SELECT MIN(STARTDATE) FROM PERSONAL);
    
-- 19. 이름, 급여, 해당부서평균
SELECT PNAME,PAY,(SELECT AVG(PAY) FROM PERSONAL WHERE P.DNO=DNO) 해당부서평균
	FROM PERSONAL P;
-- 20. 이름, 급여, 부서명, 해당부서평균
SELECT PNAME,PAY,DNAME,(SELECT AVG(PAY) FROM PERSONAL WHERE P.DNO=DNO) 해당부서평균
	FROM PERSONAL P, DIVISION D
    WHERE D.DNO=P.DNO;



-- ORACLE과 다소 다른 단일행함수(컬럼함수)
SELECT CONCAT(PNAME,'(',JOB,')의 급여는',PAY,'$') FROM PERSONAL; -- 무한정 연결 가능

SELECT ROUND(114.7); -- FROM절 생략가능
SELECT ROUND(114.75,-1); -- 십의자리
SELECT YEAR(STARTDATE) FROM PERSONAL;
SELECT MONTH(STARTDATE) FROM PERSONAL;
SELECT DAY(sysdate());
SELECT MONTHNAME(sysdate()); -- (월 이름 영어로)



