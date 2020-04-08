-- Dept.xml id=deptList
SELECT * FROM DEPT;
-- Emp.xml id=empList
SELECT * FROM EMP;
-- EmpDept.xml  id=empDeptList
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY empno) A) WHERE RN BETWEEN 2 AND 3;

-- Emp.xml id=total
SELECT COUNT(*) FROM EMP;

-- Emp.xml id=detail
SELECT * FROM EMP WHERE EMPNO=7900;

-- Emp.xml id=managerList
SELECT * FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);


-- Emp.xml id=insert
INSERT INTO EMP VALUES (1000,'LONGLONG','GAMER',7839,'2011-03-27',2500,NULL,50);

-- Emp.xml id=update
UPDATE EMP SET ENAME='LONGS', JOB='PROGRAMER',MGR=7566,HIREDATE='2012-11-03',SAL = 1200, COMM = 20, DEPTNO =40 WHERE EMPNO=1000;
COMMIT;

-- Emp.xml id=delete
DELETE FROM EMP WHERE EMPNO=1000;

-- EmpDept.xmp id=empDeptList
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT E.*,DNAME,LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO) A) WHERE RN BETWEEN 2 AND 3;



SELECT * FROM EMP;