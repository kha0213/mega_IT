--<�� ��������> PART1
SELECT * FROM EMP;
--1. �̸�, ���ӻ��
SELECT W.ENAME "�̸�", M.ENAME "���ӻ��"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME "�̸�", W.SAL "�޿�", W.JOB "����",M.ENAME "���ӻ��"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���. ��簡 ���� �� ������������ ���)
SELECT W.ENAME "�̸�", W.SAL "�޿�", W.JOB "����", NVL(M.ENAME, '����') "���ӻ��"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME "�̸�", W.SAL "�޿�", DNAME "�μ���", M.ENAME "���ӻ��"
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO;
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME "�̸�", W.SAL "�޿�", W.DEPTNO "�μ��ڵ�", DNAME "�μ���", LOC "�ٹ���", NVL(M.ENAME, '����') "���ӻ���"
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO;
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME "�̸�", W.SAL "�޿�", GRADE "���", DNAME "�μ���",  M.ENAME "���ӻ���"
    FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO AND W.SAL BETWEEN S.LOSAL AND S.HISAL AND W.SAL>=2000;

--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME "�̸�", W.SAL "�޿�", GRADE "���", DNAME "�μ���",  NVL(M.ENAME, '����') "���ӻ���"
    FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL;
    
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME "�̸�", W.SAL "�޿�", GRADE "���", DNAME "�μ���", (W.SAL+NVL(W.COMM, 0))*12 "����", M.ENAME "���ӻ���"
    FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.MGR=M.EMPNO AND W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL;
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME "�̸�", W.SAL "�޿�", GRADE "���", DNAME "�μ���", (W.SAL+NVL(W.COMM, 0))*12 "����", M.ENAME "���ӻ���"
    FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.MGR=M.EMPNO AND W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, W.SAL DESC;
--<�� ��������> PART2
--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME "�̸�", EMPNO "�μ���ȣ", DNAME "�μ���"
    FROM EMP E,DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME "�̸�", JOB "����", SAL "�޿�", DNAME "�μ���"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME "�̸�", DNAME "�μ���", LOC "��ġ"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;
--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME "�̸�", JOB "����", DNAME "�μ���", LOC "��ġ"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%L%';
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO "���", ENAME "�����", E.DEPTNO "�μ��ڵ�", DNAME "�μ���"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    ORDER BY ENAME;
--6. ���, �����, �޿�, �μ����� �˻��϶�. �� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO "���", ENAME "�����", SAL "�޿�", DNAME "�μ���"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000
    ORDER BY SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻��� ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO "���", ENAME "�����", JOB "����", SAL "�޿�", DNAME "�μ���"
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB = 'MANAGER' AND SAL>=2500
    ORDER BY EMPNO;
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO "���", ENAME "�����", JOB "����", SAL "�޿�", GRADE "���"
    FROM EMP E, SALGRADE
    WHERE (SAL>=LOSAL AND SAL<=HISAL)
    ORDER BY SAL DESC;
--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME "�����", NVL(M.ENAME,'����') "���"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME "�����", M.ENAME "���", MM.ENAME "����� ���"
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR=M.EMPNO AND M.MGR=MM.EMPNO;
--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME "�����", NVL(M.ENAME, '����') "���", NVL(MM.ENAME, '����') "����� ���"
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR=M.EMPNO(+) AND M.MGR=MM.EMPNO(+);