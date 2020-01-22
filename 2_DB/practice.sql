
--현재 날짜를 출력하고 열 레이블은 Current Date로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE FROM DUAL;
--EMP 테이블에서 현재 급여에 15%가 증가된 급여를 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장을 기술하시오.

--EMP 테이블에서 이름,입사일,입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '월') FROM EMP; 
--EMP 테이블에서 이름,입사일, 입사일로부터 현재까지의 월수,급여, 입사일부터 현재까지의 급여의 총계를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP;
--EMP 테이블에서 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, LPAD(TO_CHAR(SAL,'9999'), 15, '*') FROM EMP;
--EMP 테이블에서 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'DY') FROM EMP;
--EMP 테이블에서 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력하는 SELECT 문장을 기술하시오.

--EMP 테이블에서 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력하는 SELECT 문장을 기술하시오

--사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오.
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;
--사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오
SELECT ENAME, HIREDATE FROM EMP
    WHERE HIREDATE LIKE '%/12/%';


--다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
--…….
--다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO	 ENAME 	입사일
--7369	  SMITH		1980-12-17
--….
--사원 테이블에서 급여에 따라 사번, 이름, 급여, 등급을 검색하는 SQL 문장을 작성 하시 오. (Hint : CASE 함수 사용) 급여가 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
--  (cf) 급여가- 0~999 E / 1000~1999 D / 2000~2999 C / 3000~3999 B / 4000이상 A

SELECT ENAME, SAL, DECODE(TRUNC((SAL-1)/1000), 0, 'E', 1,'D','A')  FROM EMP;
    


--14. 사원 테이블에서 부서번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오(급여는 앞에 $를 삽입하고 3자리마다 ,를 출력한다)


















-- 1. 사원 테이블에서 인원수,최대 급여,최소 급여,급여의 합을 계산하여 출력하는 SELECT 문장을 작성하여라.
SELECT COUNT(*), MAX(SAL) FROM EMP;
-- 2. 사원테이블에서 업무별 인원수를 구하여 출력하는 SELECT 문장을 작성하여라.

--- 3. 사원테이블에서 최고 급여와 최소 급여의 차이는 얼마인가 출력하는 SELECT문장을 작성하여라.
SELECT MAX(SAL)-MIN(SAL) FROM EMP;
-- 4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력하되 급여의 합이 많은 순으로 출력하라.

-- 5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하라(출력결과는 부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB;
-- 6. 업무별, 부서별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하라.(출력결과는 업무순, 부서번호 순 오름차순 정렬)
-- 7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력하시오.

-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력하시오
-- 9. 사원 테이블에서 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 구하여 출력하라
-- 10. 사원테이블에서 급여합이 5000을 초과하는 각 업무에 대해서 업무와 급여합계를 출력하라 단, 급여 합계로 내림차순 정렬하라.
-- 11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력하라.
-- 12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 부서별 최소급여의 최대치를 출력하라.
-- 13. 사원 테이블에서 아래의 결과를 출력하는 SELECT 문장을 작성하여라.
--     H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--	80	  1		800		800		800		800
	--	81	 10		950		5000		2282.5		22825
	--	82	  2		1300		3000		2150		4300
--       83       1		1100		1100		1100		1100
SELECT TO_CHAR(HIREDATE,'YY'),COUNT(*),	MIN(SAL),	MAX(SAL),	AVG(SAL),	SUM(SAL)
    FROM EMP
    GROUP BY  TO_CHAR(HIREDATE,'YY')
    ORDER BY  TO_CHAR(HIREDATE,'YY');
-- 14. 사원테이블에서 아래의 결과를 출력하는 SELECT 문 작성
-- TOTAL		1980	1981	1982	1983
--   14         	1	  10	  2	  1
-- 15. 사원테이블에서 아래의 결과를 출력하는 SELECT 문 작성(JOB 순으로 오름차순 정렬)
-- JOB		DEPTNO10	DEPTNO20	DEPTNO30     TOTAL
-- ANALYST	     0		   6000		    0		6000
-- CLERK	  1300		   1900		  950		4150
-- ….
--SALESMAN	      0	 		0	 5600		 5600
-- 16. 사원테이블에서 최대급여, 최소급여, 전체급여합, 평균을 구하시오
-- 17. 사원테이블에서 부서별 인원수를 구하시오
-- 18. 사원 테이블에서 부서별 인원수가 6명이상인 부서코드를 구하시오
-- 19. 사원테이블에서 다음과 같은 결과가 나오게 하시오
--DNAME               CLERK    MANAGER  PRESIDENT    ANALYST   SALESMAN
--ACCOUNTING            1300       2450       5000          0          0
--RESEARCH               1900       2975          0       6000          0
--SALES                 950       2850          0          0       5600
-- 20. 사원테이블에서 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. (힌트 self join, group by, count사용)
--ENAME	    등수
--________________________
--KING		1
--SCOTT		2
--FORD		2
--JONES		4
SELECT E.ENAME, COUNT(W.SAL)+1 "등수" FROM EMP E, EMP W
    WHERE E.SAL<W.SAL(+)
    GROUP BY E.ENAME
    ORDER BY 등수;
