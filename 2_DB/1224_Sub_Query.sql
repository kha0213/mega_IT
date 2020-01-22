--SCOTT�� �ٹ��ϴ� �μ��̸�

SELECT DNAME FROM EMP E,DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT';
SELECT DNAME 
    FROM DEPT 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');  --�������� ���� ������ ����Ǿ����
-- ������ 1�� -> ������ ��������, ������ -> ������ ��������
-- ���������� ���� : ������ ��������, ������ ��������
-- JOBDL 'MANAGER'�� ����� �μ� �̸�
SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; --��������
SELECT DNAME FROM DEPT 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB IN'MANAGER'); --����ȵ� ������ �������� = ->IN ���� ����
SELECT DNAME FROM DEPT
    WHERE DEPTNO IN(10,20,30);

--������ ��������
SELECT MAX(SAL) FROM EMP;
SELECT ENAME, SAL FROM EMP
    WHERE SAL=(SELECT MAX(SAL) FROM EMP); --�̸��� �ְ� �ݾ� ��
--SCOTT�� ���� �μ��� �ٹ��ϴ� ����� �̸�
SELECT ENAME FROM EMP 
    WHERE ENAME!='SCOTT' AND DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); --��������
SELECT E.ENAME FROM EMP E, EMP W
    WHERE W.ENAME='SCOTT' AND W.DEPTNO=E.DEPTNO AND E.ENAME != 'SCOTT'; --��������
--SCOTT�� ���� �ٹ����� �ٹ��ϴ� ����� �̸�
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
SELECT * FROM DEPT;
INSERT INTO EMP VALUES (9999,'ȫ�浿',NULL,NULL,NULL,9000,NULL,50);
SELECT * FROM EMP;
SELECT ENAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND 
    D.LOC=(SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT') AND
    ENAME<>'SCOTT';
ROLLBACK; -- INSERT ���

--SCOTT �� ���� JOB�� ���� ������� ��� ���� ���
SELECT * FROM EMP WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT') AND ENAME != 'SCOTT';
--SCOTT �� �޿��� �����ϰų� �� ���� �޴� ����̸��� �޿� ���
SELECT ENAME, SAL FROM EMP WHERE SAL>=(SELECT SAL FROM EMP WHERE ENAME='SCOTT') AND ENAME ^= 'SCOTT';
--���ӻ���� KING�� ����� �̸��� �޿�
SELECT ENAME, SAL FROM EMP WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING'); -- ��������~
SELECT E.ENAME, E.SAL FROM EMP E, EMP W
    WHERE E.MGR=W.EMPNO AND W.ENAME='KING';
--��� �޿� ���ϸ� �޴� ������ ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<=(SELECT AVG(SAL) FROM EMP);
--�μ���ȣ, �μ��� �ִ�޿�, �� �ִ�޿��� �޴� ����� �̸�, �׻���� �޿�
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, SAL, ENAME FROM EMP 
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO); --������ ��������
--������ ���߿� �������� SCOTT�� JOB�� ���� �μ���ȣ�� ���� ����� ��� �ʵ�
SELECT * FROM EMP 
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT');

--�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�

--������ �������� : ���������� �������� �������� �� ������ IN, NOT IN, ANY=SOME, ALL, EXISTS �� ����Ѵ�.
--�μ���ȣ, DEPTNO(�μ���ȣ)�� �ִ�޿�, �ִ�޿� �޴� ����� �̸�
SELECT DEPTNO, SAL, ENAME FROM EMP
    WHERE (DEPTNO,SAL) IN 
    (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- IN ; (EX) �޿��� 3000 �̻� �޴� ����� �Ҽӵ� �μ�(10��, 20��)�� ������ �μ����� �ٹ��ϴ� ������� ��� ������ ����ϴ� SQL��
SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>=3000);

--�Ի�⵵, �ּұ޿�, �Ի�� �� �ּұ޿��� �޴� ���
SELECT TO_CHAR(HIREDATE,'YY') H_YEAR, SAL, ENAME FROM EMP
    WHERE (TO_CHAR(HIREDATE,'YY'), SAL) IN 
        (SELECT TO_CHAR(HIREDATE,'YY'), MIN(SAL) FROM EMP GROUP BY  TO_CHAR(HIREDATE,'YY'))
        ORDER BY H_YEAR;
SELECT SUBSTR(EXTRACT(YEAR FROM HIREDATE),3,2), MIN(SAL) FROM EMP GROUP BY SUBSTR(EXTRACT(YEAR FROM HIREDATE),3,2);

--	�μ����� �Ի����� ���� ���� ����� �μ���ȣ, �̸�, �Ի����� ����Ͻÿ�
SELECT DEPTNO, ENAME, HIREDATE FROM EMP
    WHERE (DEPTNO,HIREDATE) IN 
        (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);
--	JOB(��å��)�� ���� ���� ������ �޴� ����� �̸�, ��å, ������ ���
SELECT ENAME, JOB, SAL FROM EMP
    WHERE (JOB,SAL) IN (SELECT JOB, MIN(SAL) FROM EMP GROUP BY JOB)
    ORDER BY SAL;

--	ALL (EX) 30�� �Ҽ� ����� �߿��� �޿��� ���� ���� �޴� ������� �� ���� �޿��� �޴� ����� �̸�, �޿��� ����ϴ� SQL��
SELECT ENAME, SAL FROM EMP WHERE SAL>(SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);
SELECT ENAME, SAL FROM EMP WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO=30);  -- SELECT SAL SAL FROM EMP WHERE DEPTNO=30; �� ��簪���� ŭ�� �ǹ�


-- ANY (EX) �μ���ȣ�� 30���� ������� �޿� �� ���� ���� ��(950)���� ���� �޿��� �޴� ����� �̸�, �޿��� ����ϴ� SQL��
SELECT ENAME, SAL FROM EMP 
    WHERE SAL>ANY(SELECT SAL FROM EMP WHERE DEPTNO=30)
    ORDER BY SAL;
SELECT ENAME, SAL FROM EMP 
    WHERE SAL>(SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30)
    ORDER BY SAL;
--	EXISTS : SQL������ Exists�� ����ϴ� ���� � ������ �����ϴ� ������ ���� ���θ� Ȯ���� ��쿡 ��� 
--(EX) ���Ӻ��ϰ� �ִ� ����� �����ȣ, �̸�, �޿��� ���
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE EMPNO IN (SELECT MGR FROM EMP)
    ORDER BY SAL;
SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL FROM EMP M, EMP W
    WHERE M.EMPNO=W.MGR
    ORDER BY SAL;
--���Ӻ��ϰ� ���� ��� �ѷ���
SELECT * FROM EMP E
    WHERE NOT EXISTS(SELECT MGR FROM EMP WHERE MGR=E.EMPNO); --EXISTS
SELECT * FROM EMP E
    WHERE EMPNO NOT IN (SELECT NVL(MGR, 0) FROM EMP); -- NULL �� ���� �� IN ������ �տ� NOT�� ���̴� �� �����ض�~~~~~~~~~
SELECT * FROM EMP E
    WHERE EMPNO NOT IN (SELECT MGR FROM EMP WHERE MGR IS NOT NULL);
SELECT * FROM EMP E
    WHERE EMPNO IN (SELECT MGR FROM EMP); 
SELECT W.* FROM EMP M, EMP W
    WHERE M.MGR(+)=W.EMPNO AND M.ENAME IS NULL; --SELF JOIN+OUTER JOIN
--MANAGER �� ���� ��� �Ѹ�
SELECT EMPNO, ENAME, MGR FROM EMP WORKER
    WHERE EXISTS (SELECT EMPNO FROM EMP WHERE WORKER.MGR=EMPNO);
    
SELECT empno, ename, sal FROM EMP manager
    WHERE EXISTS (SELECT empno FROM EMP worker WHERE manager.empno=worker.mgr);
    
SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
    WHERE EXISTS (SELECT EMPNO FROM EMP WHERE MGR=MANAGER.EMPNO);
--���, �̸�, �μ���ȣ, SAL, �ش������μ� ���(SELECT���� SUBQUERY)
SELECT EMPNO, ENAME, DEPTNO, SAL, (SELECT ROUND(AVG(SAL)) FROM EMP WHERE DEPTNO=E.DEPTNO) "�ش�μ����"
    FROM EMP E
    ORDER BY SAL;





--źź��������������~
--	�μ����� ���� �޿��� ���� �޴� ����� ����(��� ��ȣ, ����̸�, �޿�, �μ���ȣ)�� ���(IN ������ �̿�)
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP
    WHERE (DEPTNO,SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
--	����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT E.DEPTNO, DNAME, LOC FROM DEPT D, EMP E
    WHERE D.DEPTNO=E.DEPTNO AND JOB='MANAGER';
--	������ 1500�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND (SAL, GRADE) IN 
        (SELECT MAX(SAL), GRADE FROM EMP, SALGRADE
        WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=1500
        GROUP BY GRADE)
    ORDER BY SAL;
--	�����ȭ : �Ի��� �б⺰�� ���� ���� ������ �޴� ������� �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
SELECT TO_CHAR(HIREDATE, 'MM') "�Ի�б�", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM,0)
    FROM EMP
    WHERE (TO_CHAR(HIREDATE, 'MM'), SAL) IN 
        (SELECT TO_CHAR(HIREDATE, 'MM'), MAX(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE, 'MM')) 
    ORDER BY �Ի�б�;
SELECT DECODE(CEIL(TO_NUMBER(TO_CHAR(HIREDATE, 'MM'))/3), 1, '1', 2, '2', 3, '3', 4, '4') "�б�", 
       EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM,0)
    FROM EMP
    WHERE (DECODE(CEIL(TO_NUMBER(TO_CHAR(HIREDATE, 'MM'))/3), 1, '1�б�', 2, '2�б�', 3, '3�б�', 4, '4�б�'),SAL) IN 
        (SELECT DECODE(CEIL(TO_NUMBER(TO_CHAR(HIREDATE, 'MM'))/3), 1, '1�б�', 2, '2�б�', 3, '3�б�', 4, '4�б�') , MAX(SAL) 
             FROM EMP GROUP BY  DECODE(CEIL(TO_NUMBER(TO_CHAR(HIREDATE, 'MM'))/3), 1, '1�б�', 2, '2�б�', 3, '3�б�', 4, '4�б�'))
    ORDER BY �б�;
    

SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "�б�", MAX(SAL) FROM EMP GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3);
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "�б�", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL ,NVL(COMM,0) FROM EMP
    WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3),SAL) IN 
    (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "�б�", MAX(SAL) FROM EMP GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3))
    ORDER BY �б�;
--    WHERE TO_CHAR(HIREDATE, 'MM') BETWEEN '01' AND '03';
--	SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME, SAL, JOB FROM EMP
    WHERE SAL>ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN');
--	SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� �����ؼ� ���(ANY)
SELECT ENAME, SAL, JOB FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB='SALESMAN') OR JOB='SALESMAN';
--	������ 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, ����, �Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);
--	������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� �̸�, �޿�, ����, �μ���ȣ�� ����ϵ� �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT ENAME, SAL, JOB, DEPTNO FROM EMP
    WHERE DEPTNO!=20 AND SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');



-- (4).	�� ��������
-- 1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE FROM EMP
    WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP);
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL FROM EMP
    WHERE SAL=(SELECT MIN(SAL) FROM EMP);
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO FROM EMP
    WHERE SAL>(SELECT AVG(SAL) FROM EMP);
-- 4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL<=(SELECT AVG(SAL) FROM EMP);
-- 5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME,SAL,HIREDATE, GRADE FROM EMP E,SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');

-- 6. 5���� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME,SAL,HIREDATE, GRADE, DNAME FROM EMP E,DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE<(SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')
        ORDER BY SAL DESC;
-- 7. ������̺��� BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME= 'BLAKE');
-- 8. ������̺��� MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի����� �˻��Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP
    WHERE HIREDATE>(SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');
-- 9. ������̺��� �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO,ENAME,SAL FROM EMP
    WHERE SAL>(SELECT AVG(SAL) FROM EMP);
-- 10. ������̺��� CLARK�� ���� �μ���, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO,ENAME,SAL FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='CLARK') AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);
-- 11. �����ȭ. ������̺��� CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT DNAME,EMPNO,ENAME,SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME =(SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK')
        AND SAL>(SELECT SAL FROM EMP WHERE EMPNO=7698);
-- 12. ��� ���̺��� BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի����ڸ� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME,HIREDATE FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE') AND ENAME!='BLAKE';
-- 13. ��� ���̺��� ��� �޿� �̻��� �޴� ��� �������� ���ؼ� ������ ��ȣ�� �̸��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. (�� �޿��� ���� ������ ����Ͽ���.)
SELECT EMPNO, ENAME FROM EMP
    WHERE SAL>=(SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;
--������� ������

-- 14. ��� ���̺��� �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� �������� ���� ��� ��ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� �����ȣ ������ ����Ͽ���.
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%I%');
-- 15. ��� ���̺��� �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME,JOB,SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='DALLAS';
SELECT ENAME, JOB, SAL FROM EMP E
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'); 
-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT E.ENAME, E.SAL FROM EMP E, EMP W
    WHERE E.MGR=W.EMPNO AND W.ENAME = 'KING';
SELECT ENAME, SAL FROM EMP
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME='KING');
-- 17. ��� ���̺��� SALES�μ� ����� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
SELECT ENAME,JOB FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='SALES';
-- 18. ��� ���̺��� ������ �μ� 30�� ���� ���޺��� ���� ����� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, SAL FROM EMP
    WHERE SAL>(SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);
-- 19. ��� ���̺��� �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP
    WHERE DEPTNO=10 AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30);
-- 20. ��� ���̺��� FORD�� ������ ���޵� ���� ����� ��� ������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT * FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB,SAL FROM EMP WHERE ENAME='FORD') AND ENAME!='FORD';

-- 21. ��� ���̺��� �̸��� JONES�� ������ JOB�� ���ų� ������ FORD�̻��� ����� ������ �̸�,����,�μ���ȣ,�޿��� ����ϴ� SELECT���� �ۼ�. ��, ������ ���ĺ� ��, ������ ���� ������ ����Ͽ���.
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
    WHERE SAL>=(SELECT SAL FROM EMP WHERE ENAME='FORD') OR JOB=(SELECT JOB FROM EMP WHERE ENAME='JONES');

-- 22. ��� ���̺��� SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB, SAL FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME='SCOTT' OR ENAME='WARD');
-- 23. ��� ���̺��� CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP
    WHERE JOB IN (SELECT DISTINCT JOB FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO');

-- 24. ��� ���̺��� �μ����� ������ ��� ���޺��� ���� ����� �����ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT EMPNO, ENAME, SAL
    FROM EMP E 
    WHERE SAL>(SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO)
    ORDER BY SAL;
    
-- 25. ��� ���̺��� �������� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT DEPTNO, ENAME, SAL FROM EMP E
    WHERE SAL<(SELECT AVG(SAL) FROM EMP WHERE JOB=E.JOB GROUP BY JOB);

-- 26 ��� ���̺��� ��� �Ѹ� �̻����κ��� ���� ���� �� �ִ� ����� ����,�̸�,�����ȣ,�μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP
    WHERE EMPNO IN (SELECT DISTINCT MGR FROM EMP WHERE MGR IS NOT NULL)
    ORDER BY DEPTNO DESC;

-- 27. ��� ���̺��� ���� ����� �����ȣ,�̸�,����,�μ���ȣ�� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP E
    WHERE NOT EXISTS (SELECT MGR FROM EMP WHERE E.EMPNO=MGR);
SELECT M.EMPNO, M.ENAME, M.JOB, M.DEPTNO FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO AND W.EMPNO IS NULL;