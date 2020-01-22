-- V. �׷��Լ� SUM, AVG, MIN, MAX, COUNT, STDDEV, VARIANCE
SELECT SUM(SAL) FROM EMP;
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; --DEPTNO ���� SAL�� SUM�� ���
SELECT DEPTNO, SUM(SAL) FROM EMP
    WHERE ENAME!='SMITH'
    GROUP BY DEPTNO
    HAVING SUM(SAL)>=9000 -- HAVIG���� WHERE ���� ���
    ORDER BY DEPTNO;
-- EMP ���̺��� ��� SAL
SELECT ROUND(AVG(SAL), 2) FROM EMP;
SELECT COUNT(*) FROM EMP; -- EMP���̺��� ���
SELECT SUM(SAL)/COUNT(*), AVG(SAL) FROM EMP; --COUNT ���� *�� ��� ���
SELECT SUM(COMM) FROM EMP; -- �׷��Լ� �� ��� NULL���� �ڵ�����
SELECT SUM(COMM)/COUNT(COMM), AVG(COMM) FROM EMP;
SELECT COUNT(COMM) FROM EMP;
SELECT VARIANCE(SAL) �л�, STDDEV(SAL)*STDDEV(SAL) "ǥ������*ǥ������" FROM EMP;  
SELECT DEPTNO, AVG(SAL), STDDEV(SAL) FROM EMP
    GROUP BY DEPTNO
    ORDER BY AVG(SAL);
SELECT MAX(SAL) FROM EMP;
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; --10���μ��� 5000�޴»�� �̸��� �Ѹ����� ���߿� ����
--������ ������
SELECT COUNT(DISTINCT(JOB)) FROM EMP; -- �ߺ����� �ؾ��Ѵ�.
--źź������
--���� �ֱٿ� �Ի��� ������ �Ի��ϰ� ���� ���ʿ� �Ի��� ������ �Ի��� ���
SELECT MIN(HIREDATE) �����Ի���,MAX(HIREDATE) �ֱ��Ի��� FROM EMP;
--�ֱٿ� �Ի��� ������ �Ի���,�ٹ���, �Ի����� ���� ������ ������ �Ի���, �ٹ���
SELECT MIN(HIREDATE) "�����Ի���", TRUNC(SYSDATE-MIN(HIREDATE)), MAX(HIREDATE) �ֱ��Ի���, TRUNC(SYSDATE-MAX(HIREDATE)) FROM EMP;
--	10�� �μ� �Ҽ��� ����� ��� �޿�
SELECT AVG(SAL) FROM EMP
    WHERE DEPTNO=10;
--	10�� �μ� �Ҽ��� ��� �߿��� �󿩱��� �޴� ����� ���� ���� ���ÿ�
SELECT COUNT(COMM) FROM EMP
    WHERE DEPTNO=10;
--AVG(SAL)�� 2000�̻� (�׷��Լ��� ���� ������ WHERE ���� �ƴϰ� HAVING ���� )
SELECT DEPTNO, AVG(SAL) FROM EMP
    GROUP BY DEPTNO
    HAVING AVG(SAL)>=2000;
-- �μ��� �� ��� �޿� �޿� �ּҰ�, �޿� �ִ� ���
SELECT DEPTNO, AVG(SAL), MIN(SAL), MAX(SAL) FROM EMP
    GROUP BY DEPTNO;
   
-- �μ��� �� ��� �޿� ��� (�μ��� ABCD������ ���)
SELECT DNAME, AVG(SAL) FROM EMP E,DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    ORDER BY DNAME;
-- �μ��� �� ��� ��, �󿩱��� �޴� ��� ��
SELECT DNAME �μ�, COUNT(*), COUNT(COMM) FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME --GROUP BY �μ� �� ����!!!!!
    ORDER BY �μ�;
-- GROUP BY �ʵ�1
SELECT DEPTNO, AVG(SAL) 
    FROM EMP
    GROUP BY DEPTNO;
-- GROUP BY �ʵ�1, �ʵ�2
SELECT DEPTNO, JOB, AVG(SAL) 
    FROM EMP 
    GROUP BY DEPTNO,JOB
    ORDER BY DEPTNO; --���� �� �ȵ���
-- GROUP BY ���� �ʵ尡 2�� �� �� �������� ���̱� ���� DECODE �Լ�
-- [1�ܰ�] DECODE�̿�
SELECT ENAME, DEPTNO, DECODE(JOB, 'CLERK', SAL, 0) CLERK,
                      DECODE(JOB, 'MANAGER', SAL, 0) MANAGER,
                      DECODE(JOB, 'PRESIDENT', SAL, 0) PRESIDENT,
                      DECODE(JOB, 'ANALYST', SAL, 0) ANALYST,
                      DECODE(JOB, 'SALESMAN', SAL, 0) SALESMAN
      FROM EMP;  
-- [2�ܰ�] DECODE+GROUP BY �̿�
SELECT DEPTNO, SUM(DECODE(JOB, 'CLERK', SAL, 0)) CLERK,
               SUM(DECODE(JOB, 'MANAGER', SAL, 0)) MANAGER,
               SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) PRESIDENT,
               SUM(DECODE(JOB, 'ANALYST', SAL, 0)) ANALYST,
               SUM(DECODE(JOB, 'SALESMAN', SAL, 0)) SALESMAN
      FROM EMP
      GROUP BY DEPTNO; 
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB;
--ROLLUP �Լ�
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
-- [3�ܰ�] DECODE+GROUP BY+ROLLUP �̿�
SELECT DEPTNO, SUM(DECODE(JOB, 'CLERK', SAL, 0)) CLERK,
               SUM(DECODE(JOB, 'MANAGER', SAL, 0)) MANAGER,
               SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) PRESIDENT,
               SUM(DECODE(JOB, 'ANALYST', SAL, 0)) ANALYST,
               SUM(DECODE(JOB, 'SALESMAN', SAL, 0)) SALESMAN,
               SUM(SAL) "�μ��� �޿� ��"
      FROM EMP
      GROUP BY ROLLUP(DEPTNO); 
-- ��� ����(DEPTNO) ����(JOB) SUM(SAL) �Ұ� ����
-- ����(JOB) ����(DEPTNO) AVG(SAL) ��� ����
SELECT SAL, JOB, DEPTNO FROM EMP ORDER BY JOB;
SELECT * FROM DEPT;
SELECT JOB, ROUND(AVG(DECODE(DEPTNO, 10, SAL))) "ACCOUNTING(10�� �μ�)",
            ROUND(AVG(DECODE(DEPTNO, 20, SAL))) "RESEARCH(20�� �μ�)",
            ROUND(AVG(DECODE(DEPTNO, 30, SAL))) "SALES(30�� �μ�)",
            ROUND(AVG(SAL)) "��� �� ��"
    FROM EMP
    GROUP BY ROLLUP(JOB);

-- �μ���ȣ�� ��ձ޿����(��� �޿��� 2000�̻��� �׷츸 ���)
SELECT DEPTNO, AVG(SAL)
    FROM EMP
    GROUP BY DEPTNO
    HAVING AVG(SAL)>=2000;
-- �μ���ȣ�� �ִ�޿� ���
SELECT DEPTNO, MAX(SAL)
    FROM EMP
    GROUP BY DEPTNO;
-- �μ���ȣ�� �μ���ȣ, �ִ�޿�, �ִ�޿� �޴� ����̸� => SUB_QUERY


    


