-- 2019.12.20 ~ 12.23 4�� ������ �Լ� (�ݴ� �׷��Լ�, ������ �Լ�)
SELECT ENAME, TO_CHAR(HIREDATE, 'YY-MM-DD DY"����" AM HH:MI:SS') FROM EMP; --������ �Լ�
SELECT SUM(SAL) FROM EMP; -- EMP ���̺��� SAL���� ���� ��� -�׷��Լ�(������ �Լ�)
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; -- �׷��Լ� DEPTNO�� �� �ڷ� �ִ�.

--������ �Լ��� ���� : ���ڰ����Լ�, ����ó���Լ�, ��¥�����Լ�, ����ȯ�Լ�, NULL���� �Լ�(NVL), DECODE�Լ�, ETC...
-- (1)���ڰ��� �Լ�
SELECT ABS(-9) FROM DUAL; --�ƹ� �ǹ� ���� 1��¥�� ���̺� DUAL(���п����Ҷ� �����) : DUAL
--(1)	ABS(x) : ���밪
--(2)	COS(x) : COSINE ���� ��ȯ
--(3)	EXP(x) : e(2.71828183����)�� x��
--��(4)	FLOOR(x) : �Ҽ��� �Ʒ��� ����
--(5)	LOG(x) : log���� ��ȯ
--(6)	POWER(m,n) : m�� n��
--(7)	SIGN(n) : n<0�̸� -1, n=0�̸� 0, n>0�̸� 1�� ��ȯ
--(8)	SIN(x) : SINE�� ��ȯ
--(9)	TAN(x) : tangent�� ��ȯ
--��(10)	ROUND(x) : Ư�� �ڸ������� �ݿø�
--��(11)	ROUND(������, �ݿø��� �Ҽ��� �ڸ���) ; �ݿø��� �ڸ����� ������ ��� -1�� �ʴ���. -2�� �����
--��(12)	TRUNC(x, n):n���� ������ �ڸ��� ���ϸ� ����
--��(13)	MOD(x, n) : x�� n���� ���� ��������

SELECT FLOOR(34.5678) FROM DUAL;-- �Ҽ��� ���ϸ� ����
SELECT FLOOR(34.5678*10)/10 FROM DUAL;
SELECT TRUNC(34.5678,2) FROM DUAL; -- �Ҽ��� ���ڸ����� ����
SELECT TRUNC(156.54, -2) FROM DUAL; 
-- �̸�, SAL(�����ڸ� �������� ���)
SELECT ENAME, TRUNC(SAL, -2) FROM EMP;
-- �ݿø�
SELECT ROUND(34.5678) FROM DUAL; --�Ҽ��� ù°�ڸ����� �ݿø�
SELECT ROUND(34.5678, 2) FROM DUAL;
SELECT ROUND(34.5678, -1) FROM DUAL;
--�̸�, SAL(�����ڸ� �ݿø� ���)
SELECT ENAME, ROUND(SAL, -3) FROM EMP;
-- �ø�
SELECT CEIL(34.5678) FROM DUAL;
SELECT TRUNC(10/4) FROM DUAL;
SELECT POWER(3,2) FROM DUAL;
SELECT MOD(9,2) FROM DUAL; --MOD 9%2�� ������
--Ȧ���޿� �Ի��� �������� ��� �ʵ�
SELECT * FROM EMP
    WHERE MOD(TO_CHAR(HIREDATE, 'MM'), 2) = 1;

-- (2) ���ڰ����Լ�
--(1)	LOWER(str) : �ҹ��ڷ�
--(2)	UPPER(str) : �빮�ڷ�
--(3)	INITCAP(str) : ù ���ڸ� �빮�ڷ� ������ ���ڴ� �ҹ��ڷ�
--(4)	CONCAT(str1, str2) : ���� ���� ||�� ��������� 2���� ���ᰡ��
--(5)	SUBSTR(str, ��������ġ, �����Ұ���) : ���ڸ� �߶� ���� (�ѱ��� 1byte), ��������ġ�� �ε��� �ƴ�
--                   ������ ��ġ�� �����̸� ���������� �ڸ����� ����
--(6)	SUBSTRB(str, ��������ġ,�����Ұ���) : ���ڸ� �߶� ���� (�ѱ��� 2byte)
--(7)	LENGTH(str) : ���ڱ��� (�ѱ��� 1byte)
--(8)	LENGTHB(str) : ���ڱ��� (�ѱ��� 2~3byte)
--(9)	INSTR(str, ã������, ������ġ, ���°�߰� �˻��� Ƚ��) str���� ã�����ڸ� ���° �߰��ϴ���
--(10)	LPAD, RPAD : �Է� ���� ���ڿ��� ��ȣ�� �����Ͽ� Ư�� ������ ���ڿ��� ��ȯ�Ѵ�
--(11)	TRIM : �߶󳻰� ���� ���ڸ� ǥ���Ѵ�
--(12)	CONVERT : CHAR SET�� ��ȯ
--(13)	CHR : ASCII�ڵ� ������ 
--(14)	ASCII : ASCII�ڵ尪�� ���ڷ�
--(15)	REPLACE : ���ڿ����� Ư�����ڸ� ����

SELECT UPPER('ABCabc') FROM DUAL;-- �빮�ڷ�
SELECT LOWER('ABCabc') FROM DUAL;-- �ҹ��ڷ�
-- ù ��°���ڸ� �빮��, �������� �ҹ���
SELECT INITCAP('the soap') FROM DUAL;
-- JOB�� MANAGER�� ������ ��� �ʵ�
SELECT * FROM EMP
    WHERE UPPER(JOB)='MANAGER';
SELECT * FROM EMP
    WHERE LOWER(JOB)='manager';
SELECT EMPNO,INITCAP(ENAME), INITCAP(JOB) FROM EMP;
--A || B || C �� ����� CONCAT(A, B)�� �����ش�. �Ű����� 2���� ����
SELECT CONCAT('ABC','DEF') FROM DUAL;
SELECT CONCAT(CONCAT('ABE','DEF'),'GHI') FROM DUAL;
--XXX�� JOB�̴�.
SELECT CONCAT(CONCAT(ENAME, '�� '), CONCAT(JOB,'�̴�')) TITLE FROM EMP;
-- SUBSTR(str, ������ ��ġ, ������ ����) ù��° ��ġ�� 1���� �����Ѵ�
SELECT SUBSTR('ABCDEFG',3,4) FROM DUAL;
SELECT SUBSTRB('ABCDEFG',1,4.2) FROM DUAL;
SELECT SUBSTR('welcome to Oracle', 3, 2) FROM DUAL;
SELECT SUBSTR('welcome to Oracle', -3, 2) FROM DUAL; -- -���̸� �ڿ��� ���� �����Ѵ�.
SELECT SUBSTR('�շ��̴ٶ����', 3, 5) FROM DUAL;

-- �츮 �ý��� ��¥ ���� : 81/01/02
-- substr�Լ��� �̿��ؼ� ¦�����ڿ� �Ի��� ������ ��� �ʵ带 ���
SELECT * FROM EMP
    WHERE MOD(SUBSTR(HIREDATE, -2,2), 2)=0;
SELECT SUBSTR('�����ͺ��̽�',2,2) FROM DUAL; -- 2��° �ڸ����� 2�ڸ� �����϶�
SELECT SUBSTRB('�����ͺ��̽�',2,2) FROM DUAL; -- 2��° BYTE��ġ���� 2BYTE�̾Ƴ���.

--9���� �Ի��� ����� ��� �ʵ带 ���
SELECT * FROM EMP
    WHERE HIREDATE LIKE '__/09/__'; --LIKE ����
SELECT * FROM EMP
    WHERE SUBSTR(HIREDATE, 4, 2)='09'; --SUBSTR ����
SELECT * FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM')='09'; --TO_CHAR ����
SELECT * FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM')=9;
SELECT SUBSTRB('ABCD',2,4) FROM DUAL; --2��° ��ġ�� ���ں��� 4���� ��� �Ѿ�� ������ ����ϰ� �� 'BCD'
SELECT SUBSTRB('���񾾵�',2,3) FROM DUAL; --2��° BYTE ��ġ���� 3BYTE ���
SELECT SUBSTR('����Ŭ���',2,3) FROM DUAL; -- 2��° ��ġ ���ں��� 3���� : '��Ŭ��'
SELECT SUBSTRB('����Ŭ���',4,5) FROM DUAL;
--LENGTH(����):������ ���� ��, LENGTHB(����):������ BYTE��
SELECT LENGTH('ABCD'), LENGTHB('ABCD') FROM DUAL;
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ') FROM DUAL; --3,9���� �ѱ��� 3BYTE
--INSTR(string, ã�� ����) : string���� ã�� ������ ��ġ
--INSTR(string, ã�� ����, ������ġ) : ���� ��ġ����string���� ã�� ������ ��ġ
--INSTR(string, ã�� ����, ������ġ, K) : ���� ��ġ���� K��° ������ ã�� ������ ��ġ
SELECT INSTR('ABCABCABC','B') FROM DUAL; --2��° B�� ������ 2����
SELECT INSTR('ABCABCABC','B',3) FROM DUAL; -- 3��°���� Bã���� 5����
SELECT INSTR('ABCABCABCABC', 'B',6,2) FROM DUAL; --6��° ��ġ���� 2��°�� ���� B�� ã��
--9���� �Ի��� ������ ��� �ʵ� ���
SELECT * FROM EMP
    WHERE INSTR(HIREDATE, '09')=4;

--LPAD(����,10,'*') --���ڸ� 10�ڸ� Ȯ���ϰ� ���ʿ� '*'�� ä��ϴ�.
SELECT LPAD('ORACLE',20,'#') FROM DUAL; --20���� ��ŭ ����ϴµ� ���ʿ� '#'�� ���
--RPAD(����,20,'#') --���ڸ� 20�ڸ� Ȯ���ϰ� �����ʿ� '#'�� ä��ϴ�.
SELECT LPAD(RPAD('ORACLE',10,'��'),20,'*') FROM DUAL;
SELECT ENAME, LPAD(SAL,6) FROM EMP; --������ ������
--TRIM, LTRIM, RTRIM �����̽� ���ִ� �� ����,������
SELECT TRIM('    ORACLE DB     ') TITLE FROM DUAL;
SELECT LTRIM('    ORACLE DB     '),RTRIM('    ORACLE DB     ') FROM DUAL;
SELECT TRIM('a' FROM 'aaaORACLE DBaaa') FROM DUAL; --���� ������ Ư���� ���ڸ� ���� ���� �̿��Ѵ�.
SELECT TRIM('-' FROM '----WOWWOW--') FROM DUAL;

--REPLACE(����, ������, �ٲܱ���)
SELECT REPLACE('abcabc','a','999') FROM DUAL;

-- źź������
SELECT * FROM EMP;
--	83�⵵�� �Ի��� ������ �˾Ƴ��� ���� SUBSTR �Լ��� �̿��Ͽ� HIREDATE �÷����� ù ���ں��� 2���� �����Ͽ� �� ���� 83������ üũ�ϴ� ������ε� ���� ������ �ϼ���. 
SELECT * FROM EMP
    WHERE SUBSTR(HIREDATE, 1, 2)=83;
SELECT * FROM EMP
    WHERE INSTR(HIREDATE, '83')=1;
SELECT * FROM EMP
    WHERE TO_CHAR(HIREDATE, 'YY')='83';
SELECT * FROM EMP
    WHERE HIREDATE LIKE '%83%';
--	������ �̸��� E�� ������ ����� �˻��� ������ �սô�. SUBSTR �Լ��� �̿��Ͽ� ENAME �÷��� ������ ���� �Ѱ��� �����ؼ� �̸��� E�� ������ ����� �˻��� ������ �Ͻÿ�.
SELECT ENAME FROM EMP
    WHERE SUBSTR(ENAME, -1)='E';
SELECT * FROM EMP
    WHERE ENAME LIKE '%E';
SELECT * FROM EMP
    WHERE INSTR(ENAME, 'E', LENGTH(ENAME))=LENGTH(ENAME);

-- �̸��� E�� ������ ����� �̸�(****E)�� ����ϱ�
SELECT ENAME, LPAD('*',LENGTH(ENAME)-1,'*')||SUBSTR(ENAME,-1,1) FROM EMP
    WHERE SUBSTR(ENAME, -1)='E';
SELECT ENAME, LPAD(SUBSTR(ENAME, -1,1), LENGTH(ENAME),'*') FROM EMP
    WHERE ENAME LIKE '%E';
-- ���, �̸�(S****), ��å, �Ի���(81/**/09)
SELECT EMPNO, SUBSTR(ENAME,1,1)||RPAD('*',LENGTH(ENAME)-1,'*') "ENAME", JOB, TO_CHAR(HIREDATE,'YY/**/DD') FROM EMP;
SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1), LENGTH(ENAME),'*') "ENAME", JOB, RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') FROM EMP;


--	�����, �̸�, ��å(�̸��� ���ڿ� �� ��ŭ�� ǥ��)���� ������ �����͸� ȭ�鿡 LIST
--7369   SMITH   CLERK
--7499   ALLEN   SALES
--7521   WARD   SALE
--7566   JONES   MANAG
SELECT EMPNO, ENAME, SUBSTR(JOB,1,LENGTH(ENAME)) FROM EMP;

	
--	Hiredate�� ���, ������ type�� ��¥ ����������, �ڵ� ����ȯ �Ǿ� ���ڿ� ó�� �Լ��� ���ڿ��� �����Ͽ� ó���� �� �ִ�

	
--	EMP ���̺��� ����̸��� 2�ڸ��� ��µǰ� �������� *�� ���⵵�� ���
SELECT RPAD(SUBSTR(ENAME, 1, 2), LENGTH(ENAME), '*') "ENAME" FROM EMP;
--	1982�� 12��1�� ~1982��12��31�� �Ի��� ����� �̸��� �Ի��Ϸ� ���;��¥���̹��������� �ڵ� ����ȯ
SELECT ENAME, HIREDATE FROM EMP
    WHERE HIREDATE BETWEEN '82/12/01' AND '82/12/31';
SELECT ENAME, HIREDATE FROM EMP
    WHERE HIREDATE LIKE '82/12%';
SELECT ENAME, HIREDATE FROM EMP
    WHERE SUBSTR(HIREDATE, 1,5)='82/12';
SELECT ENAME, HIREDATE FROM EMP
    WHERE INSTR(HIREDATE, '82/12')=1;
-- �̸��� ����° ���ڰ� R�� ����� �̸��� ���
SELECT * FROM EMP
    WHERE SUBSTR(ENAME, 3, 1)='R';
SELECT * FROM EMP
    WHERE ENAME LIKE '__R%';
SELECT * FROM EMP
    WHERE INSTR(ENAME, 'R', 3)=3;
    
--(3) ��¥���� ������ �Լ�
--1.SYSDATE �ý��� ����� ���� ��¥�� ��ȯ�Ѵ�.
--2.MONTHS_BETWEEN �� ��¥ ���̰� �� ���������� ��ȯ�Ѵ�
--3.ADD_MONTHS Ư�� ��¥�� ���� ���� ���Ѵ�
--4.NEXT_DAY(Ư����¥, N����) Ư�� ��¥���� ���ʷ� �����ϴ� ���ڷ� ���� ������ ��¥�� ��ȯ�Ѵ�
--5.LAST_DAY �ش� ���� ������ ��¥�� ��ȯ�Ѵ�
--6.ROUND ���ڷ� ���� ��¥�� Ư�� �������� �ݿø��Ѵ�
--7.TRUNC ���ڷ� ���� ��¥�� Ư�� �������� ������

SELECT SYSDATE "��������" FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY-MM-DD DY"����" HH24:MI:SS') FROM DUAL;
SELECT SYSDATE-1 "����", SYSDATE "����", SYSDATE+1 "����" FROM DUAL; --  -1,+1�ϸ� �������κ��� -24�ð�, +24�ð�
SELECT TO_CHAR(SYSDATE+14, 'YY-MM-DD HH24') FROM DUAL; --������ ����
--�̸�, �Ի���, �ٹ�����
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE)||'��' "�ٹ�����" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE,0)||'��' "�ٹ�����" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE)/365,0)||'��' "�ٹ����" FROM EMP;
--MONTHS_BETWEEN(��¥, ��¥) ; �� ��¥���� ���� ��
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))||'��' "�ٹ�����" FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(HIREDATE, SYSDATE))||'��' "�ٹ�����" FROM EMP; --����� ������.
--ADD_MONTHS(Ư����¥, N) ; Ư�� ��¥���� N���� ��
--ENAME, HIREDATE(�Ի���), �����Ⱓ��������(������ �Ի� �� 6��������)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) "���������� ��" FROM EMP;
--NEXT_DAY(Ư����¥, '��') Ư����¥�� ó�� �����ϴ� ������
SELECT SYSDATE, NEXT_DAY(SYSDATE,'��') FROM DUAL;
--����̸�, �Ի���, �Ի� �� �´� ù �ָ�
SELECT ENAME, HIREDATE, NEXT_DAY(HIREDATE, '��') FROM EMP;
--LAST_DAY(Ư����¥) ; Ư����¥ �ش� ���� ������ ���� ��ȯ
SELECT LAST_DAY(SYSDATE) FROM DUAL; --���� ���
--ENAME, HIREDATE, ���޳�(����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "����" FROM EMP;
SELECT NEXT_DAY(SYSDATE, '��') FROM DUAL;
--ROUND(�ݿø�), TRUNC(����) -YEAR (1��1��), -MONTH(1��), DAY(����� �Ͽ��Ϸ�), DEFAULT(����)
SELECT ROUND(SYSDATE) FROM DUAL;
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL; --�ݿø� ����� 1�� 1��
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; --���� ���� 1�� 1��
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL; --����� 1��
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL; --�̹��� 1��
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL; --����� �Ͽ���
SELECT ROUND(TO_DATE('191226','YYMMDD'), 'DAY') FROM DUAL;
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL; --�̹��� �Ͽ���
SELECT TRUNC(TO_DATE('191226','YYMMDD'), 'DAY') FROM DUAL;
SELECT TO_CHAR(ROUND(SYSDATE),'YY-MM-DD HH24:MI:SS') FROM DUAL; -- DEFAULT �ݿø� ����� 0�� 0�� 0��
SELECT TO_CHAR(TRUNC(SYSDATE),'YY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT HIREDATE, ROUND(HIREDATE, 'DAY') "������Ͽ���" FROM EMP;

--źź������
-- ENAME, �Ի���, �Ի��ϴ��� 1��
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') "�Ի����� 1��" FROM EMP;
--ENAME, �Ի���, �Ի����� �״��� ����(���޳�)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "����" FROM EMP;
--ENAME, �Ի���, ���޳�(25��)
--SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+24 "25�� ���޳�" FROM EMP; ����!!!!!
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9,'MONTH')+24 "25�� ���޳�" FROM EMP;
--ENAME, �Ի���, ���޳�(17��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-1,'MONTH')+16 "17�� ���޳�" FROM EMP;
--SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+16 "16�� ���޳�" FROM EMP; ����!!!!!!!!!!
--ENAME, �Ի���, SAL(����), �̶����� ���� ���� ��
SELECT ENAME, HIREDATE, SAL "����", TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))*SAL "�ѿ���" FROM EMP;
--ENAME, �Ի���, SAL(����), �̶����� ���� ����+COMM ��
SELECT ENAME, HIREDATE, SAL "����",NVL(COMM,0) "��",TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))*SAL "�ѿ���", 
    TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))*(SAL+NVL(COMM,0)) "�ѿ���+��" FROM EMP;
SELECT ENAME, HIREDATE, SAL, NVL(COMM,0) COMM,
    SAL*TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE))+NVL(COMM,0)*(TO_CHAR(SYSDATE,'YY')-TO_CHAR(HIREDATE,'YY')) "�ѱ޿�"
    FROM EMP;
    
--(4) ����ȯ �Լ�(��¥, ����)
-- TO_CHAR(��¥, ����) ��¥�� ���ڷ�
-- YY(�⵵) MM(��) MON(�� �̸�) DD(��) DY(����) HH24(�ð� 24����) AM(����/����) HH(�ð� 12����) MI(��) SS(��)
SELECT ENAME, SAL, TO_CHAR(HIREDATE, 'YY/MM/DD DY AM HH:MI:SS') FROM EMP;
-- ���ϳ��� ���ĺ��̳� Ư������ ��밡�� �ܷ����� ��� ""�ȿ� ������
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY"����" AM HH"��"MI"��"SS"��"') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MM-DD') FROM DUAL;

-- TO_CHAR(����, ����) ���ڸ� ���ڷ�
-- ���� �� 0(�ڸ���, �ڸ����� ���� ������ 0���� ä���) 
--        9(�ڸ���, �ڸ����� ���� ������ ä���� �ʴ´�)
--        L(���� ��ȭ���� ���� : �츮���� �ܺ���)
--        $($��ȭ ���� ����)
--        ,(õ �������� ,�� ���̰� ���� ��
SELECT ENAME, SAL, TO_CHAR(SAL, 'L000,000.0') FROM EMP;
SELECT ENAME, SAL, TO_CHAR(SAL, '$999,999.9') FROM EMP;

-- TO_DATE(����, ����) ���ڸ� ��¥�� '191216' -> ��¥�� '19/12/16' ���� (�׷��� ���ڸ� ���ڷδ� �ȵ�)
-- DATE_FORMET�� �� ���¿��� 81�� 5�� 1�Ϻ��� 83�� 5�� 1�� ���̿� �Ի��� �������� ��� �ʵ�
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('19810501','YYYYMMDD') AND TO_DATE('19830501','YYYYMMDD');

-- 2019,8,1 ����� //������ ��ĥ �Ǿ�����
SELECT TRUNC(SYSDATE-TO_DATE('20190801','YYYY/MM/DD'))+1 "�����" FROM DUAL;
SELECT CEIL(SYSDATE-TO_DATE('20190801','YYYY/MM/DD')) "�����" FROM DUAL;
-- TO_NUMBER(����, ����) ���ڸ� ���ڷ� '9,876' -> 9876
SELECT TO_NUMBER('1,000','9,999')+100 FROM DUAL; --1000�� ����
SELECT TO_NUMBER('1,000','9,999')+1 FROM DUAL; --1000�� ����

--(5) NULL���� �Լ� = NVL(NULL�ϼ��� �ִ� ������, NULL�̸� ��� �� ��) �� �հ� �ڰ� ���� ��ġ�ؾ���
--����̸�, MGR(MGR�� NULL�̸� 'CEO'��� ���)
SELECT ENAME, NVL(TO_CHAR(MGR,'9999'), 'CEO') "����ȣ" FROM EMP;
--����̸�, ����� �̸�(����� �̸��� NULL�̸� 'CEO'��� ���)
SELECT W.ENAME "����̸�", NVL(M.ENAME,'CEO') "����� �̸�" FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
-- (6) DECODE(������, ��1, ���1, ��2, ���2, ��3, ���3,..., ��N,���N,�׿ܰ��)
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;
SELECT JOB, SUM(SAL) FROM EMP GROUP BY JOB;

SELECT ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATIONS','ETC') AS "DNAME"
    FROM EMP;
-- CASE ��
SELECT ENAME, DEPTNO, CASE WHEN DEPTNO=10 THEN 'ACCOUNTING' 
                            WHEN DEPTNO=20 THEN 'RESEARCH'
                            WHEN DEPTNO=30 THEN 'SALES'
                            WHEN DEPTNO=40 THEN 'OPERATIONS'
                            ELSE 'ETC' END AS "DNAME" FROM EMP;
SELECT ENAME, DEPTNO, CASE DEPTNO WHEN 10 THEN 'ACCOUNTING'
                                  WHEN 20 THEN 'RESEARCH'
                                  WHEN 30 THEN 'SALES'
                                  WHEN 40 THEN 'OPERATIONS'
                                  ELSE 'ETC' END AS "DNAME" FROM EMP;
                                  
-- ������ SAL�� �̿��ؼ� ������ SAL�� JOB�� ���� ������ �����̴�. 'ANALYST' 10%�λ� 'SALESMAN' 20%�λ�
--                                                          'MANAGER' 30%�λ� 'CLERK' 40%�λ�
--                                                          �׿ܴ� ��������
SELECT DISTINCT JOB FROM EMP;
-- ���, �̸�, ������ SAL, �λ�� SAL
SELECT EMPNO, ENAME, JOB, SAL, CASE JOB WHEN 'ANALYST' THEN SAL*1.1
                                   WHEN 'SALESMAN' THEN SAL*1.2
                                   WHEN 'MANAGER' THEN SAL*1.3
                                   WHEN 'CLERK' THEN SAL*1.4
                                   ELSE SAL END "�λ�޿�" FROM EMP; --CASE
SELECT EMPNO, ENAME, JOB, SAL, DECODE(JOB, 'ANALYST', SAL*1.1,
                                    'SALESMAN', SAL*1.2,
                                    'MANAGER',SAL*1.3,
                                    'CLERK', SAL*1.4,
                                     SAL ) "�λ�޿�" FROM EMP; --DECODE
--�Ի��� �⵵�� ���� ��
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY') FROM EMP; --'1980'
SELECT ENAME, EXTRACT(YEAR FROM HIREDATE) FROM EMP; -- �⵵�� ���� 1980 ���ڷ� ����
SELECT ENAME, EXTRACT(MONTH FROM HIREDATE) FROM EMP;

--(7) �� ��
-- LEVEL, START WITH, CONNECT BY PRIOR
SELECT LEVEL, LPAD(' ',LEVEL*3)||'>'||ENAME, MGR FROM EMP
    WHERE ENAME!='SCOTT'
    START WITH MGR IS NULL 
    CONNECT BY PRIOR EMPNO=MGR; --�������� �Ʒ������� ���� ����


--<�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;
-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�, �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ������ ����Ͻÿ�.

-- 3. EMP ���̺��� �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.

-- 4. EMP ���̺��� �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ����ϴ� SELECT ������ ����Ͻÿ�.

-- 5. EMP ���̺��� ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ����ϴ� SELECT ������ ����Ͻÿ�.

-- 6. EMP ���̺��� ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.

-- 7. EMP ���̺��� �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ����ϴ� SELECT ������ ����Ͻÿ�.

-- 8. EMP ���̺��� ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ����ϴ� SELECT ������ ����Ͻÿ�.

-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 

-- 10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 

-- 11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
--����.

-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO	 ENAME 	�Ի���
--7369	  SMITH		1980-12-17
--��.

-- 13. ��� ���̺��� �޿��� ���� ���, �̸�, �޿�, ����� �˻��ϴ� SQL ������ �ۼ� �Ͻ� ��. �޿��� 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A

--------�޿���- 0~999 E / 1000~1999 D / 2000~2999 C / 3000~3999 B / 4000�̻� A

-- 14. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)

