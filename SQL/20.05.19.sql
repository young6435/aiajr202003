-- 2020.05.19. 화요일.

-- 특정 데이터를 축출하기 : where 절을 이용.
-- select 컬럼명 from 테이블 이름 where 조건(true/false)

-- 전체 사원중의 월 급여가 3000 이상인 사원의 이름리스트.
select ename, sal
from emp
where sal >= 3000
;

-- 전체 사원중 10번 부서의 소속 사원의 이름과 직급을 출력.
select ename, job
from emp
where deptno=10
;


-- 컬럼의 값과 일치 여부 확인 : =
select *
from emp
where deptno=10
;

-- 문자열 표현 : ''   => 작은따옴표로 묶는다.
select *
from emp
where job='MANAGER'     --manager 쓰면 안나온다. 문자열(데이터)은 대소문자 구분.
;

select *
from emp
where ename='SCOTT'     --scott 쓰면 안나온다. 문자열(데이터)은 대소문자 구분.
;

select *
from emp
where hiredate='80-12-17'       -- 날짜를 비교할때 => '' 작은 따옴표를 이용한다.
;


-- 논리 연산자 : and 
-- 10번 부서 소속인 사원들 중에서 => and
-- 직급이 MANAGER인 사람을 검색하여 
-- 사원명, 부서번호, 직급을 출력하려고 한다면 
-- 조건1 : 10번 부서 소속 => deptno=10
-- 조건2 : job ='MANAGER'


select * --ename, deptno, job
from emp
where deptno=10 and job='MANAGER'
;

-- 논리 연산자 : or
-- 10번 부서에 소속된 사원이거나 => or
-- 직급이 MANAGER인 사람을 검색하여 
-- 사원명, 부서번호, 직급을 출력합시다.
-- 조건1 : 10번 부서 소속 => deptno=10
-- 조건2 : job ='MANAGER'


select ename, deptno, job
from emp
where deptno=10 or job='MANAGER'
;


-- 논리 연산자 : not
-- 부서번호가 10번이 아닌 사원의 
-- 사원이름, 부서번호, 직급을 출력.

select *
from emp                          -- not 표현 하는게 3개다.     
--where not deptno != 10 
--where not deptno <> 10 
where not deptno=10       
;

-- 범위 연산 : 논리연산자의 사용 and.
-- 2000에서 3000 사이의 급여를 받는 사원의 정보를 출력.

select *
from emp
where sal>=2000 and sal<=3000
;


-- 범위 연산자 : 컬럼명 between A and B => A 이상 B 이하.
-- 2000에서 3000 사이의 급여를 받는 사원의 정보를 출력.

select *
from emp
where sal BETWEEN 2000 and 3000
;

-- 2000을 초과 하고 3000 미만의 급여를 받는 사원.
-- sal>2000 and sal<3000
-- sal between 2001 and 2999


select *
from emp
--where sal>2000 and sal<3000
where sal BETWEEN 2001 and 2999
;


-- 1987년 입사자 리스트를 출력.
select *
from emp
--where hiredate>'1982-01-01'
--where hiredate>='1981-01-01' and hiredate<='1981-12-31'
where hiredate not between '1981-01-01' and '1981-12-31'
;


-- or 연산을 간소화 시키는 in 연산자.
-- 컬럼 이름 in(데이터, 데이터, 데이터...)
-- 컬럼=데이터1 or 컬럼=데이터2 or 컬럼=데이터3 or ...

-- 커미션이 300 이거나 500 이거나 1400 인 사원을 
-- 검색하기 위해서 IN 연산자를 사용.

select *
from emp
--where comm=300 or comm=500 or comm=1400
--where comm in(300, 500, 1400)
where comm not in(300, 500, 1400)
;


-- 패턴 검색 : like 연산자.
-- 컬럼이름 like 패턴.
-- 패턴 : %, _
-- % => 0개이상 문자열이 가능하다.
-- 'S%': S로 시작하는 문자열.
-- '%S': S로 끝나는 문자열.
-- '%S%': S를 포함하는 문자열.

-- 이름이 S로 시작하는 사원의 리스트.
select *
from emp
-- where ename like 'S'  --그냥 이름이 S찾는거랑 똑같다.
-- where ename like '%IN'   --이름이 'IN'으로 끝나는사람 찾는다.
--where ename like '%A%'   --중간에 'A'들어가는 사람 찾는다.
where ename like 'S%'
;


-- _ => 1개의 자리수에 어떠한 문자가 와도 가능하다.
select *
from emp
--where ename like '_A%'    -- 이름 2번째가 A
--where ename like '__A%'     -- 이름 3번째가 A
--where ename like '%E_'      -- 이름 뒤에서 2번째가 E
where ename not like '%A%'      -- A를 포함하지 않는 이름
;

-- null 값 확인을 위한 연산자 : is null, in not null
-- 컬럼명 in null : 해당 컬럼의 값이 null인경우 true
-- 컬럼명 is not null : 해당 컬럼의 값이 null이 아닌경우 true

select ename, comm
from emp
--where comm is null
where comm is not null
;


-- row의 정렬
-- 오름차순 : 작은쪽에서 => 큰쪽, asc(생략가능, 기본 값)
-- 내림차순 : 큰쪽에서 => 작은쪽, desc(명시적 사용)
select ename, sal, hiredate, comm
from emp
where empno>0   -- 조건 그냥 임의로 준다.
--order by ename asc  --문자의 오름차순.
--order by ename   --문자의 오름차순 asc 생략가능.
--order by ename desc  --문자의 내림차순.
--order by sal asc        -- 숫자의 오름차순.
--order by sal desc        -- 숫자의 내림차순.
--order by hiredate asc     -- 날짜의 오름차순.
--order by hiredate desc      -- 날짜의 내림차순. 최근날짜가 위로
--order by comm asc         -- null의 오름차순.
order by comm desc          -- null의 내림차순.
;

select ename, sal
from emp
order by sal desc, ename asc
;

select ename, deptno
from emp
order by deptno, ename      -- 기본이 오름차순이다. 
;


-- work2 할때 필요하다.
select * from tab;
desc book;
desc customer;
desc orders;
select * from book;
select * from customer;
select * from orders;
