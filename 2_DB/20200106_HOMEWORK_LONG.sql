-- 2020_01_06 숙제 김영롱
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
SELECT 
    *
FROM
    PERSONAL
WHERE
    PAY >= 2000 && PAY <= 5000;-- ||, && 연산자 사용가능 
   
SELECT 
    PNO, PNAME, DNO
FROM
    PERSONAL
WHERE
    DNO = 10 || DNO = 20;
SELECT PNO,PNAME,DNO FROM PERSONAL
	WHERE DNO IN (10,20);
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
SELECT 
    PNO, PNAME, PAY
FROM
    PERSONAL
WHERE
    BONUS IS NULL
ORDER BY PAY DESC;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정열 같으면 큰 순
SELECT 
    PNO, PNAME, DNO, PAY
FROM
    PERSONAL
ORDER BY DNO , PAY DESC;

-- 6. 사번, 이름, 부서명
SELECT 
    PNO, PNAME, DNAME
FROM
    PERSONAL P,
    DIVISION D
WHERE
    P.DNO = D.DNO;
-- 7. 사번, 이름, 상사이름
SELECT 
    W.PNO, W.PNAME, M.PNAME 상사
FROM
    PERSONAL W,
    PERSONAL M
WHERE
    W.MANAGER = M.PNO;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
SELECT 
    W.PNO, W.PNAME, IFNULL(M.PNAME,'없음')
FROM
    PERSONAL W
        LEFT OUTER JOIN
    PERSONAL M ON W.MANAGER = M.PNO;
-- 9. 이름이 s로 시작하는 사원 이름
SELECT 
    PNAME
FROM
    PERSONAL
WHERE
    PNAME LIKE 'S%';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
SELECT 
    W.PNO, W.PNAME, W.PAY, DNAME, IFNULL(M.PNAME,'없음') 상사명
FROM
    PERSONAL W,
    DIVISION D,
    PERSONAL M
WHERE
    W.DNO = D.DNO && W.MANAGER = M.PNO;
-- 11. 부서코드, 급여합계, 최대급여
SELECT 
    DNO, SUM(PAY), MAX(PAY)
FROM
    PERSONAL
GROUP BY DNO;
-- 12. 부서명, 급여평균, 인원수
SELECT 
    DNAME, AVG(PAY), COUNT(*)
FROM
    PERSONAL P,
    DIVISION D
WHERE
    P.DNO = D.DNO
GROUP BY DNAME;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
SELECT 
    DNO, SUM(PAY), COUNT(*)
FROM
    PERSONAL
GROUP BY DNO
HAVING COUNT(*) >= 4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
SELECT 
    PNO, PNAME, PAY
FROM
    PERSONAL
WHERE
    PAY = (SELECT 
            MAX(PAY)
        FROM
            PERSONAL);
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여
SELECT 
    PNAME, PAY
FROM
    PERSONAL
WHERE
    PAY > (SELECT 
            AVG(PAY)
        FROM
            PERSONAL);
-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
SELECT 
    PNAME, PAY, DNAME
FROM
    PERSONAL P,
    DIVISION D
WHERE
    P.DNO = D.DNO
        && PAY > (SELECT 
            AVG(PAY)
        FROM
            PERSONAL)
ORDER BY DNAME , PAY DESC;
-- 17. 자기부서평균보다 급여를 많이 받는 사람 이름, 급여
SELECT 
    PNAME, PAY
FROM
    PERSONAL P
WHERE
    PAY > (SELECT 
            AVG(PAY)
        FROM
            PERSONAL
        WHERE
            P.DNO = DNO);
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
SELECT 
    PNAME, PAY, DNAME
FROM
    PERSONAL P,
    DIVISION D
WHERE
    P.DNO = D.DNO
        && STARTDATE = (SELECT 
            MIN(STARTDATE)
        FROM
            PERSONAL);
    
-- 19. 이름, 급여, 해당부서평균
SELECT 
    PNAME,
    PAY,
    (SELECT 
            AVG(PAY)
        FROM
            PERSONAL
        WHERE
            P.DNO = DNO) 해당부서평균
FROM
    PERSONAL P;
-- 20. 이름, 급여, 부서명, 해당부서평균
SELECT 
    PNAME,
    PAY,
    DNAME,
    (SELECT 
            AVG(PAY)
        FROM
            PERSONAL
        WHERE
            P.DNO = DNO) 해당부서평균
FROM
    PERSONAL P,
    DIVISION D
WHERE
    D.DNO = P.DNO;
