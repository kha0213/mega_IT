SELECT ENAME, JOB, HIREDATE FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('19810220','YYYYMMDD') AND TO_DATE('19810501','YYYYMMDD')
    ORDER BY HIREDATE;

SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, NVL(M.ENAME,'����')
    FROM EMP W,EMP M,DEPT D
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO; --2��
    
SELECT ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%L%';

SELECT EMPNO,ENAME,JOB,SAL,GRADE FROM EMP E,SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC; --4��

SELECT EMPNO,ENAME,TO_CHAR(SAL, '$999,999') SAL FROM EMP
    WHERE DEPTNO=20;

SELECT DNAME, COUNT(*) FROM EMP E,DEPT D
    WHERE E.DEPTNO=D.DEPTNO 
    GROUP BY DNAME
    HAVING COUNT(*)>=5; --6��
    
SELECT * FROM EMP
    WHERE ENAME != 'FORD' AND (JOB,SAL) IN (SELECT JOB,SAL FROM EMP WHERE ENAME='FORD');
    
SELECT ENAME,SAL FROM EMP
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING'); --8��
    
SELECT EMPNO, ENAME, SAL,DEPTNO FROM EMP E
    WHERE SAL>(SELECT AVG(SAL) FROM EMP WHERE E.DEPTNO=DEPTNO GROUP BY DEPTNO); --9��
SELECT EMPNO,ENAME,SAL,DEPTNO FROM EMP E
    WHERE SAL> (SELECT AVG(SAL)FROM EMP WHERE E.DEPTNO=DEPTNO); --9

    

DELETE FROM EMP WHERE ENAME='FORD'; --10��

UPDATE EMP SET SAL=SAL*1.1 WHERE SAL>=3000; --11��

UPDATE EMP SET DEPTNO=20, JOB='MANAGER' WHERE ENAME='SCOTT'; --12��

UPDATE EMP SET SAL=SAL+1000 WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'); --13��

SELECT RN, EMPNO, ENAME, HIREDATE 
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE 
            FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 6 AND 10; --14��
    
COMMIT; --15




ROLLBACK;

SELECT * FROM EMP;


    