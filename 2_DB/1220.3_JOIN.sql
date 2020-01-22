--2019.12.20_ 3장. JOIN(테이블들을 JOIN)
SELECT * FROM EMP;
SELECT * FROM DEPT; --부서정보

SELECT * FROM EMP WHERE ENAME ='SMITH';
SELECT * FROM DEPT;
SELECT * FROM EMP, DEPT WHERE ENAME= 'SMITH'; -- (1) CROSS JOIN(잘 쓰지 않음)
-- (2) 동등JOIN(EQUI JOIN)
SELECT * FROM EMP, DEPT
    WHERE ENAME ='SMITH' AND emp.deptno = DEPT.DEPTNO;
SELECT * FROM EMP, DEPT
    WHERE EMP.DEPTNO=DEPT.DEPTNO;
SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;  -- 테이블 별명생성
SELECT E.*, D.DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;  -- 테이블 별명생성
-- 사번, 이름, 부서번호, 부서이름, 근무지
SELECT EMPNO, ENAME, EMP.DEPTNO, DNAME, LOC FROM EMP , DEPT  WHERE EMP.DEPTNO=DEPT.DEPTNO; 
-- 위의 예제에서 DEPTNO만 이름이 같기 때문에 어딘지 정확히 써줘야함
SELECT EMPNO, ENAME, E.DEPTNO, DNAME, LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO; 
--사번, 이름, 급여, 부서번호(부서코드), 부서명
SELECT EMPNO, ENAME, SAL, E.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno;
--이름, 업무, 급여, 부서명, 근무지, 급여가 2000이상인사람
SELECT ENAME, JOB, SAL, DNAME, LOC FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno AND SAL>=2000;
--이름, 업무, 부서명, 근무지. 근무지가 CHICAGO인 사람
SELECT ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno AND LOC='CHICAGO';
--이름, 업무, 근무지. DEPTNO이 10 또는 20인 경우, 급여순 정렬
SELECT ENAME, JOB, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN(10,20) 
    ORDER BY SAL;
--이름, 급여, COMM, 연봉(별칭), 부서명, 근무지. 연봉= 단 COMM이 NULL이면 0
SELECT ENAME, SAL, NVL(COMM,0), (SAL+NVL(COMM,0))*12 "연봉", DNAME, LOC
    FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno;
--위에서 JOB가 SALESMAN이거나 MANAGER를 대상으로 연봉이 큰 순서대로 출력  
SELECT ENAME, SAL, NVL(COMM,0), (SAL+NVL(COMM,0))*12 "연봉", DNAME, LOC
    FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno AND JOB IN('SALESMAN','MANAGER')
    ORDER BY "연봉" DESC;
--이름, 급여, 입사일, 부서코드(번호), 부서명. COMM이 NULL이고 급여가 1200이상인 경우 출력.
-- 부서명 순서 정렬. 부서명이 같으면 급여 큰 순 정렬
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno AND COMM IS NULL AND SAL>=1200
    ORDER BY DNAME , SAL DESC;
    
--  탄탄다지기
--	뉴욕에서 근무하는 사원의 이름과 급여를 출력하시오
SELECT ENAME, SAL FROM EMP E,DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
--	ACCOUNTING 부서 소속 사원의 이름과 입사일을 출력하시오
SELECT ENAME, HIREDATE, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='ACCOUNTING';
--	직급이 MANAGER인 사원의 이름, 부서명을 출력하시오
SELECT ENAME, DNAME FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno AND JOB='MANAGER';
--	Comm이 null이 아닌 사원의 이름, 급여, 부서코드, 근무지를 출력하시오.
SELECT ENAME, SAL, E.DEPTNO, LOC FROM EMP E,DEPT D
    WHERE e.deptno=d.deptno AND COMM IS NOT NULL;

-- NON-EQUI JOIN (동일한 필드가 없는 2개의 테이블을 JOIN)
SELECT * FROM EMP; -- 사원
SELECT * FROM SALGRADE; --급여 등급 정보

SELECT ENAME, SAL, GRADE||'등급' GRADE 
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL;


--탄탄다지기 NON-EQUI JOIN
--	Comm이 null이 아닌 사원의 이름, 급여, 등급, 부서번호, 부서이름, 근무지를 출력하시오.
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME, LOC 
    FROM EMP E,DEPT D,salgrade S
    WHERE COMM IS NOT NULL AND E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
--	이름, 급여, 입사일, 급여등급 (급여등급이 큰 순서대로 정렬, 같으면 급여 높은 순)
SELECT ENAME, SAL, HIREDATE, GRADE 
    FROM EMP E,salgrade S
    WHERE SAL BETWEEN s.losal AND s.hisal
    ORDER BY GRADE DESC, SAL DESC;
--	이름, 급여, 입사일, 급여등급, 부서명, 근무지
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E,DEPT D,salgrade S
    WHERE e.deptno=d.deptno AND SAL BETWEEN LOSAL AND s.hisal;
--	이름, 급여, 등급, 부서코드, 근무지. 단 comm 이 null아닌 경우
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC
    FROM EMP E, DEPT D, salgrade S
    WHERE COMM IS NOT NULL AND e.deptno=d.deptno AND SAL BETWEEN LOSAL AND s.hisal;
--	이름, 급여, 급여등급, 연봉, 부서명, 부서별 출력, 부서가 같으면 연봉순. 연봉=(sal+comm)*12 comm이 null이면 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))*12 SALARY, DNAME
    FROM EMP E, DEPT D, SALGRADE S
    WHERE E.DEPTNO=d.deptno AND SAL BETWEEN LOSAL AND HISAL
    ORDER BY E.DEPTNO, SALARY DESC;
--	이름, 업무, 급여, 등급, 부서코드, 부서명 출력. 급여가 1000~3000사이. 정렬조건 : 부서별, 부서같으면 업무별, 업무같으면 급여 큰순
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D, salgrade S
    WHERE e.deptno=d.deptno AND (SAL>=LOSAL AND SAL<=HISAL) AND SAL BETWEEN 1000 AND 3000
    ORDER BY DNAME, JOB, SAL DESC;
    
--	이름, 급여, 등급, 입사일, 근무지. 81년에 입사한 사람. 등급 큰순
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, salgrade S
    WHERE e.deptno=d.deptno AND SAL BETWEEN LOSAL AND s.hisal AND e.hiredate LIKE '81%'
    ORDER BY GRADE DESC;
-- 한글 쓸꺼면 "" 쓰고 영어는 ''
SELECT ENAME, SAL, GRADE, TO_CHAR(HIREDATE, 'YYYY"년"MM"월"DD"일 "AM HH:MI:SS DY"요일"') HIREDATE, LOC
    FROM EMP E, DEPT D, salgrade S
    WHERE e.deptno=d.deptno AND SAL BETWEEN LOSAL AND s.hisal AND TO_CHAR(e.hiredate, 'YYYY/MM/DD') LIKE '1981%'
    ORDER BY GRADE DESC;


--SELF JOIN : 한 테이블을 서로 JOIN 하는 것
SELECT EMPNO,ENAME, MGR FROM EMP; -- MGR 내 직속상사의 사번

SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR ||' '|| MANAGER.ENAME MGR_NAME 
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.MGR=MANAGER.EMPNO;
-- 사원 직속상사의 이름
SELECT W.ENAME, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+); --(+) outer join
--xx의 상사는 xx이다.
SELECT W.ENAME ||'의 상사는 '|| M.ENAME "WORKER AND MANAGER" FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;

-- 탄탄다지기
--	매니저가 KING인 사원들의 이름과 직급을 출력하시오.
SELECT W.ENAME, W.JOB 
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME='KING';
-- SCOTT과 동일한 부서번호에서 근무하는 사원의 이름을 출력하시오(1단계)
SELECT M.ENAME FROM EMP M, EMP M2
    WHERE m.deptno=m2.deptno AND m2.ename = 'SCOTT' AND M.ENAME != 'SCOTT';

--	SCOTT과 동일한 근무지에서 근무하는 사원의 이름을 출력하시오
SELECT E1.ENAME FROM EMP E1,EMP E2, DEPT D1, DEPT D2 
    WHERE E1.deptno=D1.DEPTNO AND E2.DEPTNO=D2.DEPTNO AND E2.ENAME='SCOTT' AND D2.LOC=D1.LOC
        AND E1.ENAME !='SCOTT'; --테이블 4개

--TEST 용
INSERT INTO DEPT VALUES (50,'IT','DALLAS');
INSERT INTO EMP VALUES (9999,'홍길동','MANAGER',7902,'19/12/20',1000,NULL,50);
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT E1.* FROM EMP E1,EMP E2, DEPT D
    WHERE E1.deptno=D.DEPTNO AND E2.DEPTNO=D.DEPTNO
        AND E2.ENAME='SCOTT' AND E1.ENAME !='SCOTT'; --테이블 3개
ROLLBACK; --INSERT 취소

SELECT * FROM DEPT;

-- OUTER JOIN : JOIN 조건에 만족하지 않는 행을 나타나게 하는 JOIN
SELECT W.ENAME "부하",W.MGR, M.EMPNO, M.ENAME "직속상사" 
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
-- XX의 매니저는 XX(無)입니다. 
SELECT W.ENAME || '의 매니저는 ' || NVL(M.ENAME, '無')|| '입니다.'
    FROM EMP M, EMP W
    WHERE W.MGR=M.EMPNO(+);
SELECT NVL(W.ENAME,'신입사원') ENAME, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO; --말단사원들 LIST뿌리기
SELECT M.ENAME FROM EMP W, EMP M WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL;

-- EQUI JOIN에서 손실된 DATA
SELECT * FROM EMP; -- 14명 (10,20,30부서있음)
SELECT * FROM DEPT; -- 4개부서 (10,20,30,40부서있음)
SELECT * FROM EMP,DEPT WHERE emp.deptno(+)=dept.deptno;
--이름, 업무(JOB), 부서명(DNAME), 급여(SAL) 출력(단, 직원이 없는 부서명도 함께 출력하라. NULL 대신 '-') 부서명 순서 정렬
SELECT NVL(ENAME,'-'), NVL(JOB,'-'), DNAME, NVL(TO_CHAR(SAL,'9,999'),'-') 
    FROM EMP E, DEPT D
    WHERE e.deptno(+)=d.deptno
    ORDER BY DNAME, SAL DESC;




