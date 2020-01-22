-- <�� ��������>!!!
-- 1. ��� ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT COUNT(*) �ο���, MAX(SAL) "�ִ� �޿�", MIN(SAL) "�ּ� �޿�", SUM(SAL) "�޿��� ��" 
    FROM EMP;
-- 2. ������̺��� ������ �ο����� ���Ͽ� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT JOB, COUNT(*) 
    FROM EMP 
    GROUP BY JOB;
--- 3. ������̺��� �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ����ϴ� SELECT������ �ۼ��Ͽ���.
SELECT MAX(SAL)-MIN(SAL) "�޿��� ��" 
    FROM EMP;
-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ����ϵ� �޿��� ���� ���� ������ ����϶�.
SELECT JOB, COUNT(*) �ο���, AVG(SAL) "�޿� ���", MIN(SAL) "���� �޿�", MAX(SAL) "�ְ� �޿�", SUM(SAL) "�޿��� ��" 
    FROM EMP 
    GROUP BY JOB 
    ORDER BY SUM(SAL) DESC;
SELECT DNAME, COUNT(*) �ο���, AVG(SAL) "�޿� ���", MIN(SAL) "���� �޿�", MAX(SAL) "�ְ� �޿�", SUM(SAL) "�޿��� ��" 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO 
    GROUP BY DNAME 
    ORDER BY SUM(SAL) DESC;
-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� ����϶�(��°���� �μ���ȣ, ���������� �������� ����)
SELECT DNAME �μ���, JOB ����, COUNT(*) �ο���, AVG(SAL) "�޿� ���", SUM(SAL) "�޿��� ��" 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO 
    GROUP BY DNAME, JOB 
    ORDER BY DNAME, JOB;
SELECT DEPTNO �μ���ȣ, JOB ����, COUNT(*) �ο���, AVG(SAL) "�޿� ���", SUM(SAL) "�޿��� ��" 
    FROM EMP 
    GROUP BY DEPTNO, JOB 
    ORDER BY DEPTNO, JOB;
-- 6. ������, �μ��� �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� ����϶�.(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB ����, DEPTNO �μ���ȣ, COUNT(*) �ο���, AVG(SAL) "�޿� ���", SUM(SAL) "�޿��� ��" 
    FROM EMP 
    GROUP BY JOB, DEPTNO 
    ORDER BY JOB, DEPTNO;

-- 7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ����Ͻÿ�.
SELECT DEPTNO, COUNT(*) 
    FROM EMP 
    GROUP BY DEPTNO 
    HAVING COUNT(*)>=5;
-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ����Ͻÿ�
SELECT DNAME, COUNT(*) ����� 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME 
    HAVING COUNT(*)>=5;
-- 9. ��� ���̺��� ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���Ͽ� ����϶�
SELECT JOB, AVG(SAL), SUM(SAL) 
    FROM EMP 
    GROUP BY JOB 
    HAVING AVG(SAL)>=3000;
-- 10. ������̺��� �޿����� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿��հ踦 ����϶� ��, �޿� �հ�� �������� �����϶�.
SELECT JOB, SUM(SAL) 
    FROM EMP 
    GROUP BY JOB 
    HAVING SUM(SAL)>=5000 
    ORDER BY SUM(SAL) DESC;
-- 11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ����϶�.
SELECT DEPTNO, AVG(SAL), SUM(SAL), MIN(SAL) 
    FROM EMP
    GROUP BY DEPTNO;
-- 12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ����϶�.

SELECT MAX(AVG(SAL)), MAX(SUM(SAL)), MAX(MIN(SAL)) 
    FROM EMP
    GROUP BY DEPTNO;
    --, MAX(SUM(SAL)) "�μ��� �޿����� �ִ�ġ", MAX(MIN(SAL)) "�μ��� �ּұ޿��� �ִ�ġ"
-- 13. ��� ���̺��� �Ʒ��� ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
--H_YEAR COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--	80	  1		     800		  800		  800		 800
--	81	 10		     950		  5000		 2282.5		 22825
--	82	  2		     1300		  3000		2150		4300
--  83    1		     1100		  1100		1100		1100
SELECT SUBSTR(HIREDATE, 1, 2) "H_YEAR", COUNT(*), MIN(SAL),	MAX(SAL), AVG(SAL),	SUM(SAL) 
    FROM EMP
    GROUP BY SUBSTR(HIREDATE, 1, 2)
    ORDER BY H_YEAR;
-- 14. ������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�
-- TOTAL		1980	1981	1982	1983
--   14           1	     10	      2	     1
SELECT COUNT(*) "TOTAL",  COUNT(DECODE(TO_CHAR(HIREDATE,'YYYY'),1980,'0')) "1980",
                          COUNT(DECODE(TO_CHAR(HIREDATE,'YYYY'),1981,'0')) "1981",
                          COUNT(DECODE(TO_CHAR(HIREDATE,'YYYY'),1982,'0')) "1982",
                          COUNT(DECODE(TO_CHAR(HIREDATE,'YYYY'),1983,'0')) "1983"
    FROM EMP;
-- 15. ������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�(JOB ������ �������� ����)
-- JOB		DEPTNO10	DEPTNO20	DEPTNO30     TOTAL
-- ANALYST	     0		   6000		    0		6000
-- CLERK	  1300		   1900		  950		4150
-- ��.
--SALESMAN	      0	 		0	 5600		 5600
SELECT JOB, SUM(DECODE(DEPTNO, 10, SAL, 0)),
            SUM(DECODE(DEPTNO, 20, SAL, 0)),
            SUM(DECODE(DEPTNO, 30, SAL, 0)),
            SUM(SAL) "TOTAL"
    FROM EMP
    GROUP BY JOB
    ORDER BY JOB;
SELECT JOB, SUM(DECODE(DEPTNO, 10, SAL, 0)),
            SUM(DECODE(DEPTNO, 20, SAL, 0)),
            SUM(DECODE(DEPTNO, 30, SAL, 0)),
            SUM(SAL) "TOTAL"
    FROM EMP
    GROUP BY ROLLUP(JOB)
    ORDER BY JOB;
-- 16. ������̺��� �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���Ͻÿ�
SELECT MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL)
    FROM EMP;
-- 17. ������̺��� �μ��� �ο����� ���Ͻÿ�
SELECT DNAME, COUNT(*)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME;
-- 18. ��� ���̺��� �μ��� �ο����� 6���̻��� �μ��ڵ带 ���Ͻÿ�
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=6;
-- 19. ������̺��� ������ ���� ����� ������ �Ͻÿ�
--DNAME               CLERK    MANAGER  PRESIDENT    ANALYST   SALESMAN
--ACCOUNTING            1300       2450       5000          0          0
--RESEARCH               1900       2975          0       6000          0
--SALES                 950       2850          0          0       5600
SELECT DNAME, SUM(DECODE(JOB, 'CLERK', SAL, 0)) CLERK,
              SUM(DECODE(JOB, 'MANAGER', SAL, 0)) MANAGER,
              SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) PRESIDENT,
              SUM(DECODE(JOB, 'ANALYST', SAL, 0)) ANALYST,
              SUM(DECODE(JOB, 'SALESMAN', SAL, 0)) SALESMAN
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME;

-- 20. ������̺��� �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--FORD		2
--JONES		4
SELECT * FROM EMP ORDER BY SAL DESC;

SELECT E1.ENAME, COUNT(E2.SAL)+1 "���"
    FROM EMP E1, EMP E2
    WHERE E1.SAL<E2.SAL(+)
    GROUP BY E1.ENAME --�Ф�
    ORDER BY COUNT(E2.SAL); 
SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) RANK, --���־��� �ʴ� �Լ�
              DENSE_RANK() OVER(ORDER BY SAL DESC) D_RANK, --���־��� �ʴ� �Լ�
              ROW_NUMBER() OVER(ORDER BY SAL DESC) R_RANK FROM EMP; --���־��� �ʴ� �Լ�





