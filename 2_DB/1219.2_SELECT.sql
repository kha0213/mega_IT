 -- SELECT ��   (--�� �ּ���) 2019.12.19
SELECT * FROM TAB; -- scott�� ������ �ִ� ��� ���̺�

SELECT * FROM EMP; -- EMP���̺��� ��� �ʵ�(��), ��� ������(��)

DESC EMP;  

SELECT * FROM DEPT; -- DESC ����.(�ʵ庰 Ÿ��)

SELECT EMPNO, ENAME FROM EMP WHERE SAL>2000;

SELECT EMPNO, ENAME, SAL, JOB FROM EMP; -- Ư�� �ʵ常 ���

SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�", JOB AS "�۾�" 
    FROM EMP;
    
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�", JOB "�۾�" FROM EMP;

SELECT EMPNO "NO", ENAME "NAME", SAL "SALARY", JOB "J" FROM EMP; --������ ���� Ÿ��Ʋ �ٲپ� �˻�

SELECT EMPNO AS "NO", ENAME AS ENAME, SAL AS SALARY, JOB AS J FROM EMP; --����ǥ ����

SELECT EMPNO NUM, ENAME NAME, SAL SALARY, JOB J FROM EMP; -- �� ����(�ѱ��� ���� �� ����ǥ ����, ���� �̹�� ����)

SELECT EMPNO ���, ENAME �̸�, SAL �޿�, JOB �۾� FROM EMP;

SELECT EMPNO, ENAME, DEPTNO FROM EMP; -- EMP���̺��� EMPNO,ENAME,DEPTNO(�μ���ȣ) �ʵ��� ��� �����͸� ���
-- WHERE ������ �񱳿����ڸ� ���
SELECT * FROM EMP; 
SELECT * FROM EMP WHERE SAL = 3000; -- SAL�� 3000�� ��� ���� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL = 3000; -- SAL�� 3000�� ������, ���,�̸�,�޿��� LIST 
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL = 3000; -- SAL�� 3000�� ������, ���,�̸�,�޿��� LIST(TITLE : ���,�̸�,�޿��� ����)
--SAL�� 3000�� �ƴ� ������ EMPNO, ENAME, SAL, COMM �ʵ带 LIST
SELECT EMPNO ���,ENAME �̸�,SAL �޿� ,COMM Ŀ�̼� FROM EMP WHERE SAL !=3000;
SELECT EMPNO ,ENAME ,SAL  ,COMM  FROM EMP WHERE SAL <>3000;
SELECT EMPNO ,ENAME ,SAL  ,COMM  FROM EMP WHERE SAL ^=3000;

--EMPNO�� 10���� ������ ��� �ʵ带 LIST
SELECT * FROM EMP WHERE DEPTNO = 10;
--ENAME�� FORD�� ������ ��� �ʵ带 LIST (����Ŭ STRING�� �̱� ����ǥ!!!!)
SELECT * FROM EMP WHERE ENAME = 'FORD'; -- ���ڿ��� ''�� , �ʵ��� ������ �� ���� ""����.
SELECT * FROM EMP WHERE ENAME = 'ford'; -- ��ҹ��� �����Ѵ�.
SELECT * FROM emp where ename = 'FORD';
-- SAL�� 2000�̻� 3000�̸��� ������ ��� �ʵ带 ���
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<3000;
SELECT * FROM EMP WHERE ENAME<'E'; --�񱳿����ڴ� ���� �ƴ϶� ���ڳ� ��¥�� ����
SELECT * FROM EMP WHERE ENAME<'FP';
--�Ի���(HIREDATE)�� 82�� ������ �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE hiredate < '820101'; --��¥�� '' ����.
SELECT * FROM EMP WHERE hiredate < '82.01.01'; --��¥�� '' ����.
SELECT * FROM EMP WHERE hiredate < '82/01/01'; --��¥�� '' ����.
SELECT * FROM EMP WHERE hiredate >='82/01/01' AND HIREDATE < '83/01/01';
--10�� �μ��̰ų� JOB�� 'MANAGER'�� ������ �̸�, �޿��� ���
SELECT ENAME, SAL FROM EMP WHERE deptno=10 OR job = 'MANAGER';
--10�� �μ��� �ƴ� ��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE deptno !=10;
--SAL(����). SAL�� 2000 �̻��� ������ �̸��� ������ ���(COMM�� ����)
SELECT ENAME �̸�, SAL*12 ���� FROM EMP WHERE SAL>=2000;
--��� ������ �����, ��������, �ø�����(300)�� LIST
SELECT ENAME �̸�, SAL ��������, SAL+300 UPGRADESAL FROM EMP;
--��� ������ �����, ��������, �ø�����(10%)�� LIST
SELECT ENAME �̸�, SAL ��������, SAL*1.1 UPGRADE10SAL FROM EMP;
--SAL(����), ����(SAL*12+COMM) . ��� ������ ���ؼ� �̸�,����,��,���� �ʵ� ���
SELECT ENAME, SAL, COMM FROM EMP;
SELECT ENAME �̸�, SAL ����, COMM ��, SAL*12+COMM ���� FROM EMP; -- �󿩰� NULL�̶� �������� ����� �ȵ�
SELECT ENAME �̸�, SAL ����, NVL(COMM,'0') ��, SAL*12+NVL(COMM,0) ���� FROM EMP; -- NVL(COMM, 0) -> COMM�� NULL�̸� 0���� ��ü
--NVL(NULL�ϼ��� �ִ� �ʵ�, 0) ; ù ��° �Ű������� �� ��° �Ű������� Ÿ�� ��ġ
DESC EMP;
SELECT ENAME, NVL(HIREDATE,'810101') FROM EMP;
SELECT * FROM EMP;
SELECT ENAME, NVL(MGR, '�ְ�濵��') FROM EMP; --NVL�Լ��� �Ű����� Ÿ�� ����ġ(X)
SELECT ENAME, NVL(MGR, 9999) FROM EMP; 
-- �������� : AND OR
-- ||(���Ῥ����) : ���̳� ���ڸ� ����
SELECT ENAME || ' '|| JOB FROM EMP; --����
--"SMITH IS CLERK" (ENAME IS JOB) ��µǰ� TITLE�� EMPLOYEES��� ��� ���� LIST
SELECT ENAME || ' IS ' || JOB EMPLOYEES FROM EMP;
-- SMITH�� ������ XX�̴�. ���� : 
SELECT ENAME || '�� ������ ' || (SAL*12+NVL(COMM,0)) ||'�̴�.' "SALARY" FROM EMP; 
--EMP ���̺��� JOB ���(�ߺ����� : DISTINCT)
SELECT JOB FROM EMP; --�̷��� �ߺ�
SELECT DISTINCT JOB FROM EMP;
SELECT DEPTNO FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;
SELECT JOB, DEPTNO FROM EMP;
SELECT DISTINCT JOB, DEPTNO FROM EMP;


--1. emp ���̺��� ���� ���
DESC EMP; 
--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP; --2
--3. ������(scott)���� ��밡���� ���̺� ���
SELECT * FROM TAB; --3
--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO,ENAME,SAL,JOB,HIREDATE FROM EMP; --4
--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000; --5
--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE hiredate >'81.02.01'; --6
--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN'; --7
--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB != 'CLERK'; --8
--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000; --9
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000; --9_2
--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30;
--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, --�μ��ڵ� ���
SELECT EMPNO, ENAME, JOB FROM EMP WHERE JOB = 'SALESMAN' OR SAL>=3000;
--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=2500 OR JOB = 'MANAGER';
--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���
SELECT ENAME || '�� ' || JOB || '�����̰� ������ ' || (SAL*12+NVL(COMM,0)) || '�����̴�' AS "WOW" FROM EMP;

--SQL ������
--BETWEEN A AND B = A���� B���� (A,B����)
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
--�ʵ�� IN(LIST1, ... , LIST2) = LIST�� �� �� ��� �ϳ��� ��ġ�Ѵ�
--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO IN (10,30);
--�ڡ��ʵ�� LIKE PATTERN ���ϵ�ī��(%):0���̻��� ����, (_):1���̻��� ����
--�̸��� M���� �����ϴ� ����� ��� �ʵ带 ����ض�
SELECT * FROM EMP WHERE ENAME LIKE 'M%'; -- M���� �����ϰ� 0�� �̻��� ������� ����ض�.
SELECT * FROM EMP WHERE ENAME LIKE '%N%'; --�̸��� N�� ������ ���
--82�⵵�� �Ի��� ����� EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO�� ���
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP WHERE HIREDATE BETWEEN '82.01.01' AND '82.12.31';
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP WHERE HIREDATE LIKE '82/__/__'; --LIKE
--2���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '%/02/%';
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
-- NOT BETWEEN A AND B
-- NOT �ʵ�� IN (LIST1,...,LIST2)
-- NOT �ʵ�� LIKE ����
--IS NULL
-- ��(COMM)�� NULL�� ������ ���
SELECT * FROM EMP WHERE COMM =NULL; -- �̰� �߸��Ѱ�
SELECT * FROM EMP WHERE COMM IS NULL; -- NULL ���� �� IS NULL;
SELECT * FROM EMP WHERE COMM IS NOT NULL; --COMM�� NULL�� �ƴѰ� �̾ƶ�
--���� ORDER BY �ʵ� (�������� ����)
--���� ORDER BY �ʵ� DESE (�������� ����)
--�޿��� ���� ������� ��� ����ʵ�
SELECT * FROM EMP ORDER BY SAL DESC;
--�޿��� ���� ������� ���
SELECT * FROM EMP ORDER BY SAL ASC;
--�Ի������� ��� ������ �ʵ� ���
SELECT * FROM EMP ORDER BY hiredate;
--�ֱ��� �Ի��� ��������� ��� ������ ��� �ʵ� ���
SELECT * FROM EMP ORDER BY HIREDATE DESC;
-- �̸��� ���ĺ� ����� ��� ������ �ʵ�
SELECT * FROM EMP ORDER BY ENAME;
-- ���� ������� �̸�, SAL, ���� ��� ����
SELECT ENAME, SAL, SAL*12+NVL(COMM,0) "����" FROM EMP ORDER BY "����";
-- ������ 2000�̻��� ������ �̸�, ���� ��� ���������� ����
-- FROM�� -> WHERE�� -> SELECT�� -> ORDER BY�� �ؼ� -- WHERE���� Alias���Ұ�.

SELECT ENAME, SAL*12+NVL(COMM,0) "����" FROM EMP WHERE (SAL*12+NVL(COMM,0))>=2000 ORDER BY "����";

--�� �� ��������
ALTER SESSION SET NLS_DATE_FORMAT= 'YY/MM/DD'; -- DATE �� ������
-- 1. EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000;
-- 2. EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO=7788;
-- 3. ������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT ENAME, ENAME, SAL FROM EMP WHERE (SAL*12+NVL(COMM,0))>=24000 ORDER BY SAL DESC;
-- 4. EMP ���̺��� hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� ename,job,hiredate�� ����ϴ� SELECT ������ �ۼ� (�� hiredate ������ ���)
SELECT ENAME,JOB,HIREDATE FROM EMP 
    WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' 
    ORDER BY HIREDATE; 

SELECT ENAME,JOB,HIREDATE FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('1981/02/20','YYYY/MM/DD') AND TO_DATE ('1981/05/01','YYYY-MM-DD') 
    ORDER BY HIREDATE; --��� ���������� ��¥ Ȯ�ΰ���
    
-- 5. EMP ���̺��� deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN(10,20) ORDER BY ENAME;
-- 6. EMP ���̺��� sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���(�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME "employee", SAL "Monthly Salary" FROM EMP WHERE SAL>=1500 AND DEPTNO IN(10,30);
-- 7. EMP ���̺��� hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE HIREDATE LIKE '82/__/__';
--TO_CHAR(��¥���ʵ�, 'YYYY/MM/DD') -> 'YYYY/MM/DD'��Ÿ���� ���������� ��ȯ
--TO_DATE('1981/01/01','YYYY/MM/DD') -> ���ڸ� ��¥������ ��ȯ�ϴ� �Լ�
SELECT * FROM EMP WHERE HIREDATE LIKE '82%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY/MM/DD') LIKE '1982%';

-- 8. �̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP 
    WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME!='Q' 
    ORDER BY ENAME;
-- 9. EMP ���̺��� comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� ����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, NVL(COMM,0) "COMM" FROM EMP WHERE NVL(COMM,0)>=SAL*1.1;
-- 10. EMP ���̺��� job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP WHERE JOB IN('CLERK', 'ANALYST') AND SAL NOT IN (1000,3000,5000);
-- 11. EMP ���̺��� ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND (DEPTNO=30 OR MGR = 7782);
-- 12. ��� ���̺��� �Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO,ENAME,HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81%';
-- 13. ��� ���̺��� �Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO,ENAME,HIREDATE,JOB,SAL FROM EMP WHERE HIREDATE LIKE '81/%/%' AND JOB != 'SALESMAN';
-- 14. ��� ���̺��� ���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO,ENAME,HIREDATE,JOB,SAL FROM EMP ORDER BY SAL DESC, HIREDATE; --���� ���������
-- 15. ��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';
-- 16. ��� ���̺�������(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO,ENAME,(SAL*12+NVL(COMM,0)) ���� FROM EMP WHERE (SAL*12+NVL(COMM,0))>=35000;


SELECT * FROM EMP WHERE ENAME ='SMITH';
SELECT ENAME FROM EMP WHERE EMPNO=7902;
SELECT * FROM EMP WHERE deptno=20;



