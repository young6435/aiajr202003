-- 2020.05.27. 수요일.



----------------------------------------------------------------------

-- 테이블의 내용을 수정하기 위한 update 문.



drop table emp01;

create table emp01      -- 복사해서 테이블 생성한다.
as
select * from emp
;


-- 컬럼의 데이터 변경(수정)
-- update 테이블이름 set 컬럼이름1=값, 컬럼이름2=값, ... where 행을 찾는 조건식.
-- where 절이 없는 경우 테이블의 모든 행이 영향을 받는다.

select * from emp01;


-- 1. 모든 사원의 부서번호를 30번으로 수정한다.

update emp01
set deptno = 30
;


-- 2. 모든 사원의 급여를 10% 인상시킨다.

update emp01
set sal = sal + (sal * 0.1)     -- sal * 1.1
;


-- 3. 모든 사원의 입사일을 오늘로 수정한다.

update emp01
set hiredate = sysdate
;

rollback;       -- 방금 전꺼 저장되기 전으로 되돌린다.

commit;

-------------------------------------------------------------------------

-- where 조건절 써서 update 하기.



select * from emp01 where deptno = 10;

select * from emp01;


-- 1. 부서번호가 10번인 사원의 
-- 부서번호를 30번으로 수정합시다.

update emp01
set deptno = 30
where deptno = 10
;


-- 2. 급여가 3000 이상인 사원만 
-- 급여를 10% 인상합시다.

update emp01
set sal = sal * 1.1
where sal >=3000
;


-- 3. 1987년에 입사한 사원의 
-- 입사일을 오늘로 수정합시다. 
-- 사원의 입사일을 오늘로 수정한 후에 테이블 내용을 살펴봅시다.

select * from emp01
--where hiredate between '1987/01/01' and '1987/12/31'      -- 둘중에 아무거나 쓴다.
where substr(hiredate, 0, 2)='87'
;

update emp01
set hiredate = sysdate
where substr(hiredate, 0, 2)='87'
;

---------------------------------------------------------------------

-- 테이블에서 2개이상의 컬럼값 변경.


-- 1.SCOTT 사원의 
-- 부서번호는 10번으로, 
-- 직급은 MANAGER로 한꺼번에 수정하도록 합시다.

update emp01
set deptno=10, job='MANAGER'
where ename='SCOTT'
;

select * from emp01 where ename='SCOTT';


-- 2.SCOTT 사원의 
-- 입사일자는 오늘로, 
-- 급여를 50 으로 커미션을 4000 으로 수정합시다.

update emp01
set hiredate = sysdate, sal=50, comm=4000
where ename='SCOTT'
;


