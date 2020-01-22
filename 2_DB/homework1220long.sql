--<셤 연습문제> PART1
SELECT * FROM EMP;
--1. 이름, 직속상사
SELECT W.ENAME "이름", M.ENAME "직속상사"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
--2. 이름, 급여, 업무, 직속상사
SELECT W.ENAME "이름", W.SAL "급여", W.JOB "업무",M.ENAME "직속상사"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
--3. 이름, 급여, 업무, 직속상사. (상사가 없는 직원까지 전체 직원 다 출력. 상사가 없을 시 “없음”으로 출력)
SELECT W.ENAME "이름", W.SAL "급여", W.JOB "업무", NVL(M.ENAME, '없음') "직속상사"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
--4. 이름, 급여, 부서명, 직속상사명
SELECT W.ENAME "이름", W.SAL "급여", DNAME "부서명", M.ENAME "직속상사"
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO;
--5. 이름, 급여, 부서코드, 부서명, 근무지, 직속상사명, (상사가 없는 직원까지 전체 직원 다 출력)
SELECT W.ENAME "이름", W.SAL "급여", W.DEPTNO "부서코드", DNAME "부서명", LOC "근무지", NVL(M.ENAME, '없음') "직속상사명"
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO;
--6. 이름, 급여, 등급, 부서명, 직속상사명. 급여가 2000이상인 사람
SELECT W.ENAME "이름", W.SAL "급여", GRADE "등급", DNAME "부서명",  M.ENAME "직속상사명"
    FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO AND W.SAL BETWEEN S.LOSAL AND S.HISAL AND W.SAL>=2000;

--7. 이름, 급여, 등급, 부서명, 직속상사명, (직속상사가 없는 직원까지 전체직원 부서명 순 정렬)
SELECT W.ENAME "이름", W.SAL "급여", GRADE "등급", DNAME "부서명",  NVL(M.ENAME, '없음') "직속상사명"
    FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL;
    
--8. 이름, 급여, 등급, 부서명, 연봉, 직속상사명. 연봉=(급여+comm)*12 단 comm이 null이면 0
SELECT W.ENAME "이름", W.SAL "급여", GRADE "등급", DNAME "부서명", (W.SAL+NVL(W.COMM, 0))*12 "연봉", M.ENAME "직속상사명"
    FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.MGR=M.EMPNO AND W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL;
--9. 8번을 부서명 순 부서가 같으면 급여가 큰 순 정렬
SELECT W.ENAME "이름", W.SAL "급여", GRADE "등급", DNAME "부서명", (W.SAL+NVL(W.COMM, 0))*12 "연봉", M.ENAME "직속상사명"
    FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.MGR=M.EMPNO AND W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, W.SAL DESC;
--<셤 연습문제> PART2
--1.EMP 테이블에서 모든 사원에 대한 이름,부서번호,부서명을 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME "이름", EMPNO "부서번호", DNAME "부서명"
    FROM EMP E,DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
--2. EMP 테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름,업무,급여,부서명을 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME "이름", JOB "업무", SAL "급여", DNAME "부서명"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
--3. EMP 테이블에서 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME "이름", DNAME "부서명", LOC "위치"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;
--4. EMP 테이블에서 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME "이름", JOB "업무", DNAME "부서명", LOC "위치"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%L%';
--5. 사번, 사원명, 부서코드, 부서명을 검색하라. 사원명기준으로 오름차순정열
SELECT EMPNO "사번", ENAME "사원명", E.DEPTNO "부서코드", DNAME "부서명"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    ORDER BY ENAME;
--6. 사번, 사원명, 급여, 부서명을 검색하라. 단 급여가 2000이상인 사원에 대하여 급여를 기준으로 내림차순으로 정열하시오
SELECT EMPNO "사번", ENAME "사원명", SAL "급여", DNAME "부서명"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000
    ORDER BY SAL DESC;
--7. 사번, 사원명, 업무, 급여, 부서명을 검색하시오. 단 업무가 MANAGER이며 급여가 2500이상인 사원에 대하여 사번을 기준으로 오름차순으로 정열하시오.
SELECT EMPNO "사번", ENAME "사원명", JOB "업무", SAL "급여", DNAME "부서명"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB = 'MANAGER' AND SAL>=2500
    ORDER BY EMPNO;
--8. 사번, 사원명, 업무, 급여, 등급을 검색하시오. 단, 급여기준 내림차순으로 정렬하시오
SELECT EMPNO "사번", ENAME "사원명", JOB "업무", SAL "급여", GRADE "등급"
    FROM EMP E, SALGRADE
    WHERE (SAL>=LOSAL AND SAL<=HISAL)
    ORDER BY SAL DESC;
--9. 사원테이블에서 사원명, 사원의 상사를 검색하시오(상사가 없는 직원까지 전체)
SELECT W.ENAME "사원명", NVL(M.ENAME,'없음') "상사"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
--10. 사원명, 상사명, 상사의 상사명을 검색하시오
SELECT W.ENAME "사원명", M.ENAME "상사", MM.ENAME "상사의 상사"
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR=M.EMPNO AND M.MGR=MM.EMPNO;
--11. 위의 결과에서 상위 상사가 없는 모든 직원의 이름도 출력되도록 수정하시오
SELECT W.ENAME "사원명", NVL(M.ENAME, '없음') "상사", NVL(MM.ENAME, '없음') "상사의 상사"
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR=M.EMPNO(+) AND M.MGR=MM.EMPNO(+);