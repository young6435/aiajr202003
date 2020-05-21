-- 2020.05.20. 수요일.

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
select trunc(3.141592, 2)       -- 3.14
from dual
;

select trunc(123.141592, 0)   -- 123    앞에 정수만 나온다.
from dual
;

select trunc(sal, -2)      -- 2975 => 2900 -- 음수 쓰면 자리수만큼 0으로 바꾼다.
from emp                   -- 1250 => 1200
;



-- round : 반올림.

select round(3.141592, 3)       -- 3.142
from dual
;

select round(123.141592, -2)    -- 100
from dual
;

select round(12345, -2)         -- 12300
from dual
;



-- 2. 날짜함수.

select sysdate
from dual
;

-- TO_CHAR
-- date -> varchar2
select sysdate, to_char(sysdate, 'YYYY.MM.DD')      -- 2020.05.21
from dual
;

select ename, to_char(hiredate, 'YYYY.MM.DD') as hiredate
from emp
;


-- 시간표현

select sysdate, to_char(sysdate, 'HH24:MI:SS')     -- 20/05/21 19:26:26
from dual
;

-- 2020.05.20. 11:30
select to_char(sysdate, 'YYYY.MM.DD. HH24:MI')
--select to_char(sysdate, 'YYYY.MM.DD. PMHH24:MI')      -- AM,PM 오전,오후 한글로 뜬다.
from dual
;

-- to_char
-- number -> varchar2
select to_char(12500, '000,000')    -- 오른쪽 자리수가 더 많아야 된다. 작으면 오류난다.
from dual                           -- 012,500
;

select to_char(12500, '0,000,000')     -- 0,012,500
from dual
;

select to_char(12500, '999,999')        -- 12,500
from dual
;

select to_char(12500, 'L999,999')       -- 통화표현. 나라마다 통화표현이 다르니까 고객쪽에서 하는게 좋다.
from dual                               -- $12500
;


-- 소수점 

select to_char(3.14, '000,000.000')      -- 000,003.140
from dual
;

select to_char(3.14, '999,999.999')     -- 3.140
from dual
;

select to_char(3.14, '999,999.9')       -- 3.1
from dual
;

select sal, to_char(sal*1000, 'L999,999,999'), to_char(sal*1000*12+nvl(comm,0), 'L999,999,999') as income
from emp
order by income desc
;

-- To_DATE
-- to_date(원본, 패턴)
-- str -> date

select to_date('19810220','YYYYMMDD')       -- 81/02/20 ??
from dual
;

select to_date('1981/02/20','YYYY/MM/DD')   -- 81/02/20
from dual
;

select ename, hiredate
from emp
where hiredate = to_date('1981/02/20', 'YYYY/MM/DD')
;

select sysdate, to_date('20201225','YYYYMMDD'), trunc(to_date('20201225','YYYYMMDD')-sysdate)
from dual                                       -- trunc가 소수점 날린다. 정수만 나온다. 
;

select sysdate, trunc(sysdate-to_date('19850625','YYYYMMDD'))
from dual
;

-- TO_NUMBER                -- 문자를 숫자로 바꾼다.
-- to_number(원본, 패턴)
-- str -> number : 산술연산, 관계연산이 목적이다.

select to_number('20,000','999,999') - to_number('10,000','999,999')        -- 10000
from dual
;


----------------------------------------------------

-- DECODE 함수 : if switch 구문과 유사

select ename, deptno, 
decode(deptno, 10, 'ACCOUNTING',      -- deptno 가 10이면 ACCOUNTING 이라고 부른다.
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

-------------------------------------------------------------

-- 그룹함수 (집합함수)      -- null값은 제외하고 한다.

-- sum, avg, count, max, min

-- sum(컬럼명) : 해당 컬럼의 데이터들의 합 반환
-- 매월 지급되는 급여의 총 합

select sum(sal) as totalsal                   -- null 값 무시.
from emp
;

select to_char(sum(sal)*1000, 'L999,999,999') as totalsal 
from emp
;

select sum(comm)
from emp
;


-- avg(컬럼명) : 해당 컬럼의 데이터들의 평균값을 반환.

select avg(sal)         
from emp
;

select trunc(avg(sal))      -- 정수 나온다.         
from emp
;

select avg(comm)
from emp
;


-- max, min : 해당 컬럼의 데이터중에서 최대값, 최소값을 반환.

select max(sal), min(sal), max(comm), min(comm)         -- null값 무시.
from emp
;


-- count(컬럼명 or *) : 행(row) 의 개수를 반환.       -- null값 무시.

select count(*)     -- 14 , 행이 14개다.
from emp
;

select count(comm)      -- null 을 포함하는 행은 개수로 포함하지 않는다.     -- null값 무시.
from emp                -- 4 나온다.  14개중에 4개 빼고 null이다.
;

select count(job)
from emp
;

select distinct job     -- 5개 나온다. 중복되는거 빼고 나온다.
from emp
order by job
;

select count(distinct job)      -- 5개 나온다.
from emp
order by job
;


-- group by 절 : 특정 컬럼으로 그룹핑 해준다.

select deptno       -- 부서번호로 묶는다.
from emp
group by deptno
;

select job      -- 직급별로 묶는다.
from emp
group by job
;


-- 소속 부서별 
-- 평균 급여 구하는 예제.

--select deptno, round(avg(sal),0)
select deptno, round(avg(sal))      -- 정수 나온다.
from emp
group by deptno
;

-- 소속 부서별
-- 최대 급여와 최소 급여를 구하자.

select deptno, max(sal), min(sal)
from emp
group by deptno
;


-- 부서별로
-- 사원 수와 커미션을 받는 사원들의 수를 계산하자.

select deptno, count(*), count(comm)        --  count(*)  : 사원수
from emp
where comm <> 0         -- 300, 500, 1400, 0  4명 있다. null 값은 제외한다.
group by deptno         
;



-- 부서별 
-- 평균 급여가 2000 이상인(HAVING) 
-- 부서번호와 부서별 평균 급여를 출력.

select deptno, avg(sal), count(*), count(comm), sum(comm)
from emp
GROUP by deptno
having avg(sal)>=2000               -- where는 row를 찾는다.  -- having 집합으로 나누어져있는 결과를 가지고 구한다.
;

-- 직급별, 지표 출력.

select job, count(*) as "직급별 인원",        -- 한글처리할때는 큰따옴표.
            sum(sal) as "직급별 월 총 급여",
            trunc(avg(sal)) as "직급별 월 평균 급여",
            nvl(sum(comm), 0) as "부서별 수령 커미션 총 합",
            max(sal) as "직급별 최고 급여 금액"
from emp
group by job  -- 직급별이니까 job으로 묶는다.
--having count(*) >= 2      -- 직급의 인원이 2명 이상인 직급.
having avg(sal) >= 2000 and count(*) > 1
;


select deptno, job
from emp
group by deptno, job
order by job
;