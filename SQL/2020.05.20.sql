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

select to_char(12500, 'L999,999')       -- 통화표현.
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