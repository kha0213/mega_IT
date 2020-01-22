--2019.12.20_ 3��. JOIN(���̺���� JOIN)
SELECT * FROM EMP;
SELECT * FROM DEPT; --�μ�����

SELECT * FROM EMP WHERE ENAME ='SMITH';
SELECT * FROM DEPT;
SELECT * FROM EMP, DEPT WHERE ENAME= 'SMITH'; -- (1) CROSS JOIN(�� ���� ����)
-- (2) ����JOIN(EQUI JOIN)
SELECT * FROM EMP, DEPT
    WHERE ENAME ='SMITH' AND emp.deptno = DEPT.DEPTNO;
SELECT * FROM EMP, DEPT
    WHERE EMP.DEPTNO=DEPT.DEPTNO;
SELECT * FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;  -- ���̺� �������
SELECT E.*, D.DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;  -- ���̺� �������
-- ���, �̸�, �μ���ȣ, �μ��̸�, �ٹ���
SELECT EMPNO, ENAME, EMP.DEPTNO, DNAME, LOC FROM EMP , DEPT  WHERE EMP.DEPTNO=DEPT.DEPTNO; 
-- ���� �������� DEPTNO�� �̸��� ���� ������ ����� ��Ȯ�� �������
SELECT EMPNO, ENAME, E.DEPTNO, DNAME, LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO; 
--���, �̸�, �޿�, �μ���ȣ(�μ��ڵ�), �μ���
SELECT EMPNO, ENAME, SAL, E.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno;
--�̸�, ����, �޿�, �μ���, �ٹ���, �޿��� 2000�̻��λ��
SELECT ENAME, JOB, SAL, DNAME, LOC FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno AND SAL>=2000;
--�̸�, ����, �μ���, �ٹ���. �ٹ����� CHICAGO�� ���
SELECT ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno AND LOC='CHICAGO';
--�̸�, ����, �ٹ���. DEPTNO�� 10 �Ǵ� 20�� ���, �޿��� ����
SELECT ENAME, JOB, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN(10,20) 
    ORDER BY SAL;
--�̸�, �޿�, COMM, ����(��Ī), �μ���, �ٹ���. ����= �� COMM�� NULL�̸� 0
SELECT ENAME, SAL, NVL(COMM,0), (SAL+NVL(COMM,0))*12 "����", DNAME, LOC
    FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno;
--������ JOB�� SALESMAN�̰ų� MANAGER�� ������� ������ ū ������� ���  
SELECT ENAME, SAL, NVL(COMM,0), (SAL+NVL(COMM,0))*12 "����", DNAME, LOC
    FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno AND JOB IN('SALESMAN','MANAGER')
    ORDER BY "����" DESC;
--�̸�, �޿�, �Ի���, �μ��ڵ�(��ȣ), �μ���. COMM�� NULL�̰� �޿��� 1200�̻��� ��� ���.
-- �μ��� ���� ����. �μ����� ������ �޿� ū �� ����
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno AND COMM IS NULL AND SAL>=1200
    ORDER BY DNAME , SAL DESC;
    
--  źź������
--	���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL FROM EMP E,DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
--	ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, HIREDATE, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='ACCOUNTING';
--	������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME FROM EMP E, DEPT D
    WHERE e.deptno=d.deptno AND JOB='MANAGER';
--	Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, E.DEPTNO, LOC FROM EMP E,DEPT D
    WHERE e.deptno=d.deptno AND COMM IS NOT NULL;

-- NON-EQUI JOIN (������ �ʵ尡 ���� 2���� ���̺��� JOIN)
SELECT * FROM EMP; -- ���
SELECT * FROM SALGRADE; --�޿� ��� ����

SELECT ENAME, SAL, GRADE||'���' GRADE 
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL;


--źź������ NON-EQUI JOIN
--	Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME, LOC 
    FROM EMP E,DEPT D,salgrade S
    WHERE COMM IS NOT NULL AND E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
--	�̸�, �޿�, �Ի���, �޿���� (�޿������ ū ������� ����, ������ �޿� ���� ��)
SELECT ENAME, SAL, HIREDATE, GRADE 
    FROM EMP E,salgrade S
    WHERE SAL BETWEEN s.losal AND s.hisal
    ORDER BY GRADE DESC, SAL DESC;
--	�̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E,DEPT D,salgrade S
    WHERE e.deptno=d.deptno AND SAL BETWEEN LOSAL AND s.hisal;
--	�̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC
    FROM EMP E, DEPT D, salgrade S
    WHERE COMM IS NOT NULL AND e.deptno=d.deptno AND SAL BETWEEN LOSAL AND s.hisal;
--	�̸�, �޿�, �޿����, ����, �μ���, �μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))*12 SALARY, DNAME
    FROM EMP E, DEPT D, SALGRADE S
    WHERE E.DEPTNO=d.deptno AND SAL BETWEEN LOSAL AND HISAL
    ORDER BY E.DEPTNO, SALARY DESC;
--	�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D, salgrade S
    WHERE e.deptno=d.deptno AND (SAL>=LOSAL AND SAL<=HISAL) AND SAL BETWEEN 1000 AND 3000
    ORDER BY DNAME, JOB, SAL DESC;
    
--	�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, salgrade S
    WHERE e.deptno=d.deptno AND SAL BETWEEN LOSAL AND s.hisal AND e.hiredate LIKE '81%'
    ORDER BY GRADE DESC;
-- �ѱ� ������ "" ���� ����� ''
SELECT ENAME, SAL, GRADE, TO_CHAR(HIREDATE, 'YYYY"��"MM"��"DD"�� "AM HH:MI:SS DY"����"') HIREDATE, LOC
    FROM EMP E, DEPT D, salgrade S
    WHERE e.deptno=d.deptno AND SAL BETWEEN LOSAL AND s.hisal AND TO_CHAR(e.hiredate, 'YYYY/MM/DD') LIKE '1981%'
    ORDER BY GRADE DESC;


--SELF JOIN : �� ���̺��� ���� JOIN �ϴ� ��
SELECT EMPNO,ENAME, MGR FROM EMP; -- MGR �� ���ӻ���� ���

SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR ||' '|| MANAGER.ENAME MGR_NAME 
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.MGR=MANAGER.EMPNO;
-- ��� ���ӻ���� �̸�
SELECT W.ENAME, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+); --(+) outer join
--xx�� ���� xx�̴�.
SELECT W.ENAME ||'�� ���� '|| M.ENAME "WORKER AND MANAGER" FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;

-- źź������
--	�Ŵ����� KING�� ������� �̸��� ������ ����Ͻÿ�.
SELECT W.ENAME, W.JOB 
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME='KING';
-- SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(1�ܰ�)
SELECT M.ENAME FROM EMP M, EMP M2
    WHERE m.deptno=m2.deptno AND m2.ename = 'SCOTT' AND M.ENAME != 'SCOTT';

--	SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT E1.ENAME FROM EMP E1,EMP E2, DEPT D1, DEPT D2 
    WHERE E1.deptno=D1.DEPTNO AND E2.DEPTNO=D2.DEPTNO AND E2.ENAME='SCOTT' AND D2.LOC=D1.LOC
        AND E1.ENAME !='SCOTT'; --���̺� 4��

--TEST ��
INSERT INTO DEPT VALUES (50,'IT','DALLAS');
INSERT INTO EMP VALUES (9999,'ȫ�浿','MANAGER',7902,'19/12/20',1000,NULL,50);
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT E1.* FROM EMP E1,EMP E2, DEPT D
    WHERE E1.deptno=D.DEPTNO AND E2.DEPTNO=D.DEPTNO
        AND E2.ENAME='SCOTT' AND E1.ENAME !='SCOTT'; --���̺� 3��
ROLLBACK; --INSERT ���

SELECT * FROM DEPT;

-- OUTER JOIN : JOIN ���ǿ� �������� �ʴ� ���� ��Ÿ���� �ϴ� JOIN
SELECT W.ENAME "����",W.MGR, M.EMPNO, M.ENAME "���ӻ��" 
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
-- XX�� �Ŵ����� XX(��)�Դϴ�. 
SELECT W.ENAME || '�� �Ŵ����� ' || NVL(M.ENAME, '��')|| '�Դϴ�.'
    FROM EMP M, EMP W
    WHERE W.MGR=M.EMPNO(+);
SELECT NVL(W.ENAME,'���Ի��') ENAME, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO; --���ܻ���� LIST�Ѹ���
SELECT M.ENAME FROM EMP W, EMP M WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL;

-- EQUI JOIN���� �սǵ� DATA
SELECT * FROM EMP; -- 14�� (10,20,30�μ�����)
SELECT * FROM DEPT; -- 4���μ� (10,20,30,40�μ�����)
SELECT * FROM EMP,DEPT WHERE emp.deptno(+)=dept.deptno;
--�̸�, ����(JOB), �μ���(DNAME), �޿�(SAL) ���(��, ������ ���� �μ��� �Բ� ����϶�. NULL ��� '-') �μ��� ���� ����
SELECT NVL(ENAME,'-'), NVL(JOB,'-'), DNAME, NVL(TO_CHAR(SAL,'9,999'),'-') 
    FROM EMP E, DEPT D
    WHERE e.deptno(+)=d.deptno
    ORDER BY DNAME, SAL DESC;




