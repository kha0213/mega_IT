-- 2019.12.20 ~ 12.23 4장 단일행 함수 (반대 그룹함수, 다중행 함수)
SELECT ENAME, TO_CHAR(HIREDATE, 'YY-MM-DD DY"요일" AM HH:MI:SS') FROM EMP; --단일행 함수
SELECT SUM(SAL) FROM EMP; -- EMP 테이블의 SAL들의 합을 출력 -그룹함수(다중행 함수)
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; -- 그룹함수 DEPTNO가 앞 뒤로 있다.

--단일행 함수의 종류 : 숫자관련함수, 문자처리함수, 날짜관련함수, 형변환함수, NULL관련 함수(NVL), DECODE함수, ETC...
-- (1)숫자관련 함수
SELECT ABS(-9) FROM DUAL; --아무 의미 없는 1행짜리 테이블 DUAL(수학연산할때 써봐라) : DUAL
--(1)	ABS(x) : 절대값
--(2)	COS(x) : COSINE 값을 반환
--(3)	EXP(x) : e(2.71828183……)의 x승
--★(4)	FLOOR(x) : 소수점 아래를 버림
--(5)	LOG(x) : log값을 반환
--(6)	POWER(m,n) : m의 n승
--(7)	SIGN(n) : n<0이면 -1, n=0이면 0, n>0이면 1을 반환
--(8)	SIN(x) : SINE값 반환
--(9)	TAN(x) : tangent값 반환
--★(10)	ROUND(x) : 특정 자릿수에서 반올림
--★(11)	ROUND(데이터, 반올림할 소수점 자리수) ; 반올림할 자리수가 음수인 경우 -1은 십단위. -2는 백단위
--★(12)	TRUNC(x, n):n으로 지정한 자리수 이하를 버림
--★(13)	MOD(x, n) : x를 n으로 나눈 나머지값

SELECT FLOOR(34.5678) FROM DUAL;-- 소수점 이하를 내림
SELECT FLOOR(34.5678*10)/10 FROM DUAL;
SELECT TRUNC(34.5678,2) FROM DUAL; -- 소수점 몇자리까지 내림
SELECT TRUNC(156.54, -2) FROM DUAL; 
-- 이름, SAL(백의자리 내림으로 출력)
SELECT ENAME, TRUNC(SAL, -2) FROM EMP;
-- 반올림
SELECT ROUND(34.5678) FROM DUAL; --소수점 첫째자리에서 반올림
SELECT ROUND(34.5678, 2) FROM DUAL;
SELECT ROUND(34.5678, -1) FROM DUAL;
--이름, SAL(백의자리 반올림 출력)
SELECT ENAME, ROUND(SAL, -3) FROM EMP;
-- 올림
SELECT CEIL(34.5678) FROM DUAL;
SELECT TRUNC(10/4) FROM DUAL;
SELECT POWER(3,2) FROM DUAL;
SELECT MOD(9,2) FROM DUAL; --MOD 9%2의 나머지
--홀수달에 입사한 직원들의 모든 필드
SELECT * FROM EMP
    WHERE MOD(TO_CHAR(HIREDATE, 'MM'), 2) = 1;

-- (2) 문자관련함수
--(1)	LOWER(str) : 소문자로
--(2)	UPPER(str) : 대문자로
--(3)	INITCAP(str) : 첫 글자만 대문자로 나머지 글자는 소문자로
--(4)	CONCAT(str1, str2) : 문자 연결 ||랑 비슷하지만 2개만 연결가능
--(5)	SUBSTR(str, 시작할위치, 추출할갯수) : 문자를 잘라 추출 (한글은 1byte), 시작할위치는 인덱스 아님
--                   시작할 위치가 음수이면 끝에서부터 자리수를 센다
--(6)	SUBSTRB(str, 시작할위치,추출할갯수) : 문자를 잘라 추출 (한글은 2byte)
--(7)	LENGTH(str) : 문자길이 (한글은 1byte)
--(8)	LENGTHB(str) : 문자길이 (한글은 2~3byte)
--(9)	INSTR(str, 찾을글자, 시작위치, 몇번째발견 검색된 횟수) str에서 찾을글자를 몇번째 발견하는지
--(10)	LPAD, RPAD : 입력 받은 문자열과 기호를 정렬하여 특정 길이의 문자열로 반환한다
--(11)	TRIM : 잘라내고 남은 문자를 표시한다
--(12)	CONVERT : CHAR SET을 변환
--(13)	CHR : ASCII코드 값으로 
--(14)	ASCII : ASCII코드값을 문자로
--(15)	REPLACE : 문자열에서 특정문자를 변경

SELECT UPPER('ABCabc') FROM DUAL;-- 대문자로
SELECT LOWER('ABCabc') FROM DUAL;-- 소문자로
-- 첫 번째문자만 대문자, 나머지는 소문자
SELECT INITCAP('the soap') FROM DUAL;
-- JOB이 MANAGER인 직원의 모든 필드
SELECT * FROM EMP
    WHERE UPPER(JOB)='MANAGER';
SELECT * FROM EMP
    WHERE LOWER(JOB)='manager';
SELECT EMPNO,INITCAP(ENAME), INITCAP(JOB) FROM EMP;
--A || B || C 와 비슷한 CONCAT(A, B)를 합해준다. 매개변수 2개만 가능
SELECT CONCAT('ABC','DEF') FROM DUAL;
SELECT CONCAT(CONCAT('ABE','DEF'),'GHI') FROM DUAL;
--XXX는 JOB이다.
SELECT CONCAT(CONCAT(ENAME, '는 '), CONCAT(JOB,'이다')) TITLE FROM EMP;
-- SUBSTR(str, 시작할 위치, 추출할 갯수) 첫번째 위치가 1부터 시작한다
SELECT SUBSTR('ABCDEFG',3,4) FROM DUAL;
SELECT SUBSTRB('ABCDEFG',1,4.2) FROM DUAL;
SELECT SUBSTR('welcome to Oracle', 3, 2) FROM DUAL;
SELECT SUBSTR('welcome to Oracle', -3, 2) FROM DUAL; -- -붙이면 뒤에서 부터 시작한다.
SELECT SUBSTR('롱롱이다라라라아', 3, 5) FROM DUAL;

-- 우리 시스템 날짜 포맷 : 81/01/02
-- substr함수를 이용해서 짝수일자에 입사한 직원의 모든 필드를 출력
SELECT * FROM EMP
    WHERE MOD(SUBSTR(HIREDATE, -2,2), 2)=0;
SELECT SUBSTR('데이터베이스',2,2) FROM DUAL; -- 2번째 자리부터 2자리 추출하라
SELECT SUBSTRB('데이터베이스',2,2) FROM DUAL; -- 2번째 BYTE위치부터 2BYTE뽑아내라.

--9월에 입사한 사원의 모든 필드를 출력
SELECT * FROM EMP
    WHERE HIREDATE LIKE '__/09/__'; --LIKE 쓰기
SELECT * FROM EMP
    WHERE SUBSTR(HIREDATE, 4, 2)='09'; --SUBSTR 쓰기
SELECT * FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM')='09'; --TO_CHAR 쓰기
SELECT * FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM')=9;
SELECT SUBSTRB('ABCD',2,4) FROM DUAL; --2번째 위치의 글자부터 4글자 출력 넘어가면 끝까지 출력하고 끝 'BCD'
SELECT SUBSTRB('에비씨디',2,3) FROM DUAL; --2번째 BYTE 위치부터 3BYTE 출력
SELECT SUBSTR('오락클디비',2,3) FROM DUAL; -- 2번째 위치 글자부터 3글자 : '락클디'
SELECT SUBSTRB('오락클디비',4,5) FROM DUAL;
--LENGTH(문자):문자의 길이 수, LENGTHB(문자):문자의 BYTE수
SELECT LENGTH('ABCD'), LENGTHB('ABCD') FROM DUAL;
SELECT LENGTH('오라클'), LENGTHB('오라클') FROM DUAL; --3,9나옴 한글은 3BYTE
--INSTR(string, 찾을 글자) : string에서 찾을 글자의 위치
--INSTR(string, 찾을 글자, 시작위치) : 시작 위치부터string에서 찾을 글자의 위치
--INSTR(string, 찾을 글자, 시작위치, K) : 시작 위치부터 K번째 나오는 찾는 글자의 위치
SELECT INSTR('ABCABCABC','B') FROM DUAL; --2번째 B가 있으니 2나옴
SELECT INSTR('ABCABCABC','B',3) FROM DUAL; -- 3번째부터 B찾으니 5나옴
SELECT INSTR('ABCABCABCABC', 'B',6,2) FROM DUAL; --6번째 위치부터 2번째로 나올 B를 찾음
--9월에 입사한 직원들 모든 필드 출력
SELECT * FROM EMP
    WHERE INSTR(HIREDATE, '09')=4;

--LPAD(문자,10,'*') --문자를 10자리 확보하고 왼쪽에 '*'을 채웁니다.
SELECT LPAD('ORACLE',20,'#') FROM DUAL; --20개의 만큼 출력하는데 왼쪽에 '#'을 출력
--RPAD(문자,20,'#') --문자를 20자리 확보하고 오른쪽에 '#'을 채웁니다.
SELECT LPAD(RPAD('ORACLE',10,'★'),20,'*') FROM DUAL;
SELECT ENAME, LPAD(SAL,6) FROM EMP; --없으면 빈거출력
--TRIM, LTRIM, RTRIM 스페이스 없애는 거 왼쪽,오른쪽
SELECT TRIM('    ORACLE DB     ') TITLE FROM DUAL;
SELECT LTRIM('    ORACLE DB     '),RTRIM('    ORACLE DB     ') FROM DUAL;
SELECT TRIM('a' FROM 'aaaORACLE DBaaa') FROM DUAL; --왼쪽 오른쪽 특정한 문자를 없앨 때도 이용한다.
SELECT TRIM('-' FROM '----WOWWOW--') FROM DUAL;

--REPLACE(문자, 원글자, 바꿀글자)
SELECT REPLACE('abcabc','a','999') FROM DUAL;

-- 탄탄다지기
SELECT * FROM EMP;
--	83년도에 입사한 직원을 알아내기 위해 SUBSTR 함수를 이용하여 HIREDATE 컬럼에서 첫 글자부터 2개를 추출하여 그 값이 83인지를 체크하는 방법으로도 구해 보도록 하세요. 
SELECT * FROM EMP
    WHERE SUBSTR(HIREDATE, 1, 2)=83;
SELECT * FROM EMP
    WHERE INSTR(HIREDATE, '83')=1;
SELECT * FROM EMP
    WHERE TO_CHAR(HIREDATE, 'YY')='83';
SELECT * FROM EMP
    WHERE HIREDATE LIKE '%83%';
--	다음은 이름이 E로 끝나는 사원을 검색해 보도록 합시다. SUBSTR 함수를 이용하여 ENAME 컬럼의 마지막 문자 한개만 추출해서 이름이 E로 끝나는 사원을 검색해 보도록 하시오.
SELECT ENAME FROM EMP
    WHERE SUBSTR(ENAME, -1)='E';
SELECT * FROM EMP
    WHERE ENAME LIKE '%E';
SELECT * FROM EMP
    WHERE INSTR(ENAME, 'E', LENGTH(ENAME))=LENGTH(ENAME);

-- 이름이 E로 끝나는 사원의 이름(****E)로 출력하기
SELECT ENAME, LPAD('*',LENGTH(ENAME)-1,'*')||SUBSTR(ENAME,-1,1) FROM EMP
    WHERE SUBSTR(ENAME, -1)='E';
SELECT ENAME, LPAD(SUBSTR(ENAME, -1,1), LENGTH(ENAME),'*') FROM EMP
    WHERE ENAME LIKE '%E';
-- 사번, 이름(S****), 직책, 입사일(81/**/09)
SELECT EMPNO, SUBSTR(ENAME,1,1)||RPAD('*',LENGTH(ENAME)-1,'*') "ENAME", JOB, TO_CHAR(HIREDATE,'YY/**/DD') FROM EMP;
SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1), LENGTH(ENAME),'*') "ENAME", JOB, RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') FROM EMP;


--	“사번, 이름, 직책(이름의 문자열 수 만큼만 표시)”의 형식의 데이터를 화면에 LIST
--7369   SMITH   CLERK
--7499   ALLEN   SALES
--7521   WARD   SALE
--7566   JONES   MANAG
SELECT EMPNO, ENAME, SUBSTR(JOB,1,LENGTH(ENAME)) FROM EMP;

	
--	Hiredate의 경우, 데이터 type이 날짜 형식이지만, 자동 형변환 되어 문자열 처리 함수를 문자열을 추출하여 처리할 수 있다

	
--	EMP 테이블에서 사원이름을 2자리만 출력되고 나머지는 *로 숨기도록 출력
SELECT RPAD(SUBSTR(ENAME, 1, 2), LENGTH(ENAME), '*') "ENAME" FROM EMP;
--	1982년 12월1일 ~1982년12월31일 입사한 사람을 이름과 입사일로 출력;날짜형이문자형으로 자동 형변환
SELECT ENAME, HIREDATE FROM EMP
    WHERE HIREDATE BETWEEN '82/12/01' AND '82/12/31';
SELECT ENAME, HIREDATE FROM EMP
    WHERE HIREDATE LIKE '82/12%';
SELECT ENAME, HIREDATE FROM EMP
    WHERE SUBSTR(HIREDATE, 1,5)='82/12';
SELECT ENAME, HIREDATE FROM EMP
    WHERE INSTR(HIREDATE, '82/12')=1;
-- 이름의 세번째 글자가 R인 사원의 이름을 출력
SELECT * FROM EMP
    WHERE SUBSTR(ENAME, 3, 1)='R';
SELECT * FROM EMP
    WHERE ENAME LIKE '__R%';
SELECT * FROM EMP
    WHERE INSTR(ENAME, 'R', 3)=3;
    
--(3) 날짜관련 예약어와 함수
--1.SYSDATE 시스템 저장된 현재 날짜를 반환한다.
--2.MONTHS_BETWEEN 두 날짜 사이가 몇 개월인지를 반환한다
--3.ADD_MONTHS 특정 날짜에 개월 수를 더한다
--4.NEXT_DAY(특정날짜, N요일) 특정 날짜에서 최초로 도래하는 인자로 받은 요일의 날짜를 반환한다
--5.LAST_DAY 해당 달의 마지막 날짜를 반환한다
--6.ROUND 인자로 받은 날짜를 특정 기준으로 반올림한다
--7.TRUNC 인자로 받은 날짜를 특정 기준으로 버린다

SELECT SYSDATE "지금현재" FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD DY"요일" HH24:MI:SS') FROM DUAL;
SELECT SYSDATE-1 "어제", SYSDATE "오늘", SYSDATE+1 "내일" FROM DUAL; --  -1,+1하면 지금으로부터 -24시간, +24시간
SELECT TO_CHAR(SYSDATE+14, 'YY-MM-DD HH24') FROM DUAL; --도서관 기한
--이름, 입사일, 근무일자
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE)||'일' "근무일자" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE,0)||'일' "근무일자" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE)/365,0)||'년' "근무년수" FROM EMP;
--MONTHS_BETWEEN(날짜, 날짜) ; 두 날짜간의 개월 수
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))||'월' "근무월수" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(HIREDATE, SYSDATE))||'월' "근무월수" FROM EMP; --결과가 음수다.
--ADD_MONTHS(특정날짜, N) ; 특정 날짜에서 N개월 후
--ENAME, HIREDATE(입사일), 수습기간마지막날(수습은 입사 후 6개월동안)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) "수습마지막 날" FROM EMP;
--NEXT_DAY(특정날짜, '수') 특정날짜로 처음 도래하는 수요일
SELECT SYSDATE, NEXT_DAY(SYSDATE,'토') FROM DUAL;
--사원이름, 입사일, 입사 후 맞는 첫 주말
SELECT ENAME, HIREDATE, NEXT_DAY(HIREDATE, '수') FROM EMP;
--LAST_DAY(특정날짜) ; 특정날짜 해당 달의 마지막 날을 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL; --말일 출력
--ENAME, HIREDATE, 월급날(말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "말일" FROM EMP;
SELECT NEXT_DAY(SYSDATE, '월') FROM DUAL;
--ROUND(반올림), TRUNC(버림) -YEAR (1월1일), -MONTH(1일), DAY(가까운 일요일로), DEFAULT(생략)
SELECT ROUND(SYSDATE) FROM DUAL;
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL; --반올림 가까운 1월 1일
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; --버림 올해 1월 1일
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL; --가까운 1일
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL; --이번달 1일
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL; --가까운 일요일
SELECT ROUND(TO_DATE('191226','YYMMDD'), 'DAY') FROM DUAL;
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL; --이번주 일요일
SELECT TRUNC(TO_DATE('191226','YYMMDD'), 'DAY') FROM DUAL;
SELECT TO_CHAR(ROUND(SYSDATE),'YY-MM-DD HH24:MI:SS') FROM DUAL; -- DEFAULT 반올림 결과는 0시 0분 0초
SELECT TO_CHAR(TRUNC(SYSDATE),'YY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT HIREDATE, ROUND(HIREDATE, 'DAY') "가까운일요일" FROM EMP;

--탄탄다지기
-- ENAME, 입사일, 입사일달의 1일
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') "입사일의 1일" FROM EMP;
--ENAME, 입사일, 입사일의 그달의 말일(월급날)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "말일" FROM EMP;
--ENAME, 입사일, 월급날(25일)
--SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+24 "25일 월급날" FROM EMP; 오답!!!!!
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9,'MONTH')+24 "25일 월급날" FROM EMP;
--ENAME, 입사일, 월급날(17일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-1,'MONTH')+16 "17일 월급날" FROM EMP;
--SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+16 "16일 월급날" FROM EMP; 오답!!!!!!!!!!
--ENAME, 입사일, SAL(월급), 이때까지 받은 월급 합
SELECT ENAME, HIREDATE, SAL "월급", TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))*SAL "총월급" FROM EMP;
--ENAME, 입사일, SAL(월급), 이때까지 받은 월급+COMM 합
SELECT ENAME, HIREDATE, SAL "월급",NVL(COMM,0) "상여",TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))*SAL "총월급", 
    TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))*(SAL+NVL(COMM,0)) "총월급+상여" FROM EMP;
SELECT ENAME, HIREDATE, SAL, NVL(COMM,0) COMM,
    SAL*TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))+NVL(COMM,0)*(TO_CHAR(SYSDATE,'YY')-TO_CHAR(HIREDATE,'YY')) "총급여"
    FROM EMP;
    
--(4) 형변환 함수(날짜, 패턴)
-- TO_CHAR(날짜, 패턴) 날짜를 문자로
-- YY(년도) MM(월) MON(월 이름) DD(일) DY(요일) HH24(시간 24단위) AM(오전/오후) HH(시간 12단위) MI(분) SS(초)
SELECT ENAME, SAL, TO_CHAR(HIREDATE, 'YY/MM/DD DY AM HH:MI:SS') FROM EMP;
-- 패턴내에 알파벳이나 특수문자 사용가능 외래어일 경우 ""안에 들어가야함
SELECT TO_CHAR(SYSDATE, 'YY"년"MM"월"DD"일" DY"요일" AM HH"시"MI"분"SS"초"') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MM-DD') FROM DUAL;

-- TO_CHAR(숫자, 패턴) 숫자를 문자로
-- 패턴 내 0(자릿수, 자릿수가 맞지 않으면 0으로 채운다) 
--        9(자릿수, 자릿수가 맞지 않으면 채우지 않는다)
--        L(지역 통화단위 붙음 : 우리나라 ￦붙음)
--        $($통화 단위 붙음)
--        ,(천 단위마다 ,를 붙이고 싶을 때
SELECT ENAME, SAL, TO_CHAR(SAL, 'L000,000.0') FROM EMP;
SELECT ENAME, SAL, TO_CHAR(SAL, '$999,999.9') FROM EMP;

-- TO_DATE(문자, 패턴) 문자를 날짜로 '191216' -> 날짜로 '19/12/16' 가능 (그러나 숫자를 문자로는 안됨)
-- DATE_FORMET을 모른 상태에서 81년 5월 1일부터 83년 5월 1일 사이에 입사한 직원들의 모든 필드
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('19810501','YYYYMMDD') AND TO_DATE('19830501','YYYYMMDD');

-- 2019,8,1 기념일 //오늘이 며칠 되었을까
SELECT TRUNC(SYSDATE-TO_DATE('20190801','YYYY/MM/DD'))+1 "기념일" FROM DUAL;
SELECT CEIL(SYSDATE-TO_DATE('20190801','YYYY/MM/DD')) "기념일" FROM DUAL;
-- TO_NUMBER(문자, 패턴) 문자를 숫자로 '9,876' -> 9876
SELECT TO_NUMBER('1,000','9,999')+100 FROM DUAL; --1000인 문자
SELECT TO_NUMBER('1,000','9,999')+1 FROM DUAL; --1000인 문자

--(5) NULL관련 함수 = NVL(NULL일수도 있는 데이터, NULL이면 대신 쓸 값) 단 앞과 뒤가 형이 일치해야함
--사원이름, MGR(MGR이 NULL이면 'CEO'라고 출력)
SELECT ENAME, NVL(TO_CHAR(MGR,'9999'), 'CEO') "상사번호" FROM EMP;
--사원이름, 상사의 이름(상사의 이름이 NULL이면 'CEO'라고 출력)
SELECT W.ENAME "사원이름", NVL(M.ENAME,'CEO') "상사의 이름" FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
-- (6) DECODE(데이터, 값1, 결과1, 값2, 결과2, 값3, 결과3,..., 값N,결과N,그외결과)
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;
SELECT JOB, SUM(SAL) FROM EMP GROUP BY JOB;

SELECT ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATIONS','ETC') AS "DNAME"
    FROM EMP;
-- CASE 문
SELECT ENAME, DEPTNO, CASE WHEN DEPTNO=10 THEN 'ACCOUNTING' 
                            WHEN DEPTNO=20 THEN 'RESEARCH'
                            WHEN DEPTNO=30 THEN 'SALES'
                            WHEN DEPTNO=40 THEN 'OPERATIONS'
                            ELSE 'ETC' END AS "DNAME" FROM EMP;
SELECT ENAME, DEPTNO, CASE DEPTNO WHEN 10 THEN 'ACCOUNTING'
                                  WHEN 20 THEN 'RESEARCH'
                                  WHEN 30 THEN 'SALES'
                                  WHEN 40 THEN 'OPERATIONS'
                                  ELSE 'ETC' END AS "DNAME" FROM EMP;
                                  
-- 기존의 SAL을 이용해서 조정될 SAL은 JOB에 따라 조정될 예정이다. 'ANALYST' 10%인상 'SALESMAN' 20%인상
--                                                          'MANAGER' 30%인상 'CLERK' 40%인상
--                                                          그외는 조정없음
SELECT DISTINCT JOB FROM EMP;
-- 사번, 이름, 조정전 SAL, 인상된 SAL
SELECT EMPNO, ENAME, JOB, SAL, CASE JOB WHEN 'ANALYST' THEN SAL*1.1
                                   WHEN 'SALESMAN' THEN SAL*1.2
                                   WHEN 'MANAGER' THEN SAL*1.3
                                   WHEN 'CLERK' THEN SAL*1.4
                                   ELSE SAL END "인상급여" FROM EMP; --CASE
SELECT EMPNO, ENAME, JOB, SAL, DECODE(JOB, 'ANALYST', SAL*1.1,
                                    'SALESMAN', SAL*1.2,
                                    'MANAGER',SAL*1.3,
                                    'CLERK', SAL*1.4,
                                     SAL ) "인상급여" FROM EMP; --DECODE
--입사한 년도만 뽑을 때
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY') FROM EMP; --'1980'
SELECT ENAME, EXTRACT(YEAR FROM HIREDATE) FROM EMP; -- 년도만 추출 1980 숫자로 추출
SELECT ENAME, EXTRACT(MONTH FROM HIREDATE) FROM EMP;

--(7) 그 외
-- LEVEL, START WITH, CONNECT BY PRIOR
SELECT LEVEL, LPAD(' ',LEVEL*3)||'>'||ENAME, MGR FROM EMP
    WHERE ENAME!='SCOTT'
    START WITH MGR IS NULL 
    CONNECT BY PRIOR EMPNO=MGR; --윗레벨과 아랫레벨의 연결 조건


--<셤 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;
-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여, 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장을 기술하시오.

-- 3. EMP 테이블에서 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.

-- 4. EMP 테이블에서 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력하는 SELECT 문장을 기술하시오.

-- 5. EMP 테이블에서 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력하는 SELECT 문장을 기술하시오.

-- 6. EMP 테이블에서 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.

-- 7. EMP 테이블에서 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력하는 SELECT 문장을 기술하시오.

-- 8. EMP 테이블에서 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력하는 SELECT 문장을 기술하시오.

-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 

-- 10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 

-- 11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
--…….

-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO	 ENAME 	입사일
--7369	  SMITH		1980-12-17
--….

-- 13. 사원 테이블에서 급여에 따라 사번, 이름, 급여, 등급을 검색하는 SQL 문장을 작성 하시 오. 급여가 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A

--------급여가- 0~999 E / 1000~1999 D / 2000~2999 C / 3000~3999 B / 4000이상 A

-- 14. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)

