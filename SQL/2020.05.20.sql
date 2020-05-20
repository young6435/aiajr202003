-- 2020.05.20

-- 함수

-- 1. 숫자함수.
-- mod : 나머지 구하는 함수.
select mod(10,2)
from dual
;

select mod(sal,3)
from emp
;

-- abs : 절대값 구하는 함수.
select abs(-10) 
from dual
;

select abs(sal) 
from emp
;

-- trunc : 특정 자리수 잘라버린다.
select trunc(3.141592, 2)
from dual
;

select trunc(123.141592, 0)   -- 앞에 정수만 나온다.
from dual
;

select trunc(sal, -2)       -- 음수 쓰면 자리수만큼 0으로 바꾼다.
from emp
;

-- round : 반올림.
select round(3.141592, 3)
from dual
;

select round(123.141592, -2)
from dual
;


-- 2. 날짜함수.
select sysdate
from dual
;

-- TO_CHAR
-- date -> varchar2
select sysdate, to_char(sysdate, 'YYYY.MM.DD')
from dual
;

select ename, to_char(hiredate, 'YYYY.MM.DD') as hiredate
from emp
;

-- 시간표현
select sysdate, to_char(sysdate, 'HH24:MI:SS')
from dual
;

-- 2020.05.20. 11:30
select to_char(sysdate, 'YYYY.MM.DD. HH24:MI')
--select to_char(sysdate, 'YYYY.MM.DD. PMHH24:MI')      -- AM,PM
from dual
;

-- to_char
-- number -> varchar2
select to_char(12500, '000,000')    -- 오른쪽 자리수가 더 많아야 된다. 작으면 오류난다.
from dual
;

select to_char(12500, '0,000,000')
from dual
;

select to_char(12500, '999,999')
from dual
;

select to_char(12500, 'L999,999')       -- 통화표현. 나라마다 통화표현이 다르니까 고객쪽에서 하는게 좋다.
from dual
;

-- 소수점 
select to_char(3.14, '000,000.000')
from dual
;

select to_char(3.14, '999,999.999')
from dual
;

select to_char(3.14, '999,999.9')
from dual
;

select sal, to_char(sal*1000, 'L999,999,999'), to_char(sal*1000*12+nvl(comm,0), 'L999,999,999') as income
from emp
order by income desc
;

-- To_DATE
-- to_date(원본, 패턴)
-- str -> date
select to_date('19810220','YYYYMMDD')
from dual
;

select to_date('1981/02/20','YYYY/MM/DD')
from dual
;

select ename, hiredate
from emp
where hiredate = to_date('1981/02/20', 'YYYY/MM/DD')
;

select sysdate, to_date('20201225','YYYYMMDD'), trunc(to_date('20201225','YYYYMMDD')-sysdate) 
from dual
;

select sysdate, trunc(sysdate-to_date('19850625','YYYYMMDD'))
from dual
;

-- TO_NUMBER
-- to_number(원본, 패턴)
-- str -> number : 산술연산, 관계연산이 목적이다.

select to_number('20,000','999,999') - to_number('10,000','999,999')
from dual
;

-- DECODE 함수 : if switch 구문과 유사
select ename, deptno, 
decode(deptno, 10, 'ACCOUNTING',
                20, 'RESEARCH',
                30, 'SALES',
                40, 'OPERATING'
) as deptname
from emp
;

-- 직급에 따라 급여를 인상하도록 하자. 
-- 직급이 'ANALYST'인 사원은 5%, 
-- 'SALESMAN'인 사원은 10%, 
-- 'MANAGER'인 사원은 15%, 
-- 'CLERK'인사원은 20%인 인상한다.

select ename, job, sal,
decode(job, 'ANALYST', sal+sal*0.05,        -- sal*1.05
            'SALESMAN', sal+sal*0.1,        -- sal*1.1
            'MANAGER', sal+sal*0.15,        -- sal*1.15
            'CLERK', sal+sal*0.2              -- sal*1.2
) as upsal
from emp
;

select ename, deptno, 
case
    when deptno=10 then 'ACCOUNTING'
    when deptno=20 then 'RESEARCH'
    when deptno=30 then 'SALES'
    when deptno=40 then 'OPERATING'
    else 'no name'
end as depnname
from emp;
