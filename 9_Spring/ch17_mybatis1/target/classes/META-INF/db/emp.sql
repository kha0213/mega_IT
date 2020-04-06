-- Dept.xml (id=deptList)
SELECT * FROM DEPT;



-- Emp.xml (id=empList)
SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%' AND JOB LIKE '%'||'S'||'%' AND DEPTNO LIKE '%30';

