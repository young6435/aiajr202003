-- 2020.05.27. 수요일.

----------------------------------------------------------------------

-- DML

----------------------------------------------------------------------

-- 테이블의 내용을 수정하기 위한 update 문.



drop table emp01;       -- 테이블 삭제.

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

---------------------------------------------------------------------------

-- 서브쿼리를 이용한 데이터 수정하기

-- 1. 20번 부서의 지역명을 
--    40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다.

update dept01
set loc=(
    select loc from dept01 where deptno=40
)
where deptno=20
;

rollback;


drop table dept01;


create table dept01
as
select * from dept
;


select * from dept01;

-----------------------------------------------------------------------------

-- 서브쿼리를 이용한 두 개의 데이터 한꺼번에 변경하기.


-- 부서번호가 20인 부서의 
-- 부서명과 지역명을 
-- 부서번호가 40번인 부서와 동일하게 변경하도록 해 봅시다.


-- 1개씩 2개 한거.
update dept01
set dname=(select dname from dept01 where deptno=40),
loc=(select loc from dept01 where deptno=40)
where deptno=20
;


-- 한번에 2개 한거.
update dept01
set (dname, loc)=(select dname, loc from dept01 where deptno=40) 
where deptno=20
;


select * from dept01;


----------------------------------------------------------------------

-- 불필요한 행을 삭제하는 delete 문.       -- 삭제조건을 pk쪽으로 잡아서 한다.


-- delete from 테이블명 where 행을 찾을 조건식
-- where 절이 없으면 모든행에 영향을 준다.


-- 부서 테이블의 모든 행을 삭제합시다.

delete from dept01;



select * from dept01;

rollback;



-- 1. 부서 테이블에서 30번 부서만 삭제.

delete from dept01 where deptno=30;



-- 2. 사원 테이블에서 
-- 부서명이 SALES인 사원을 모두 삭제.

select deptno from dept where dname='SALES';

select * from emp01;

delete from emp01 where deptno=(
    select deptno from dept where dname='SALES'
)
;



-----------------------------------------------------------------

-- 수정을 위한 SQL (phonebook 이용)        -- phonebook 자료에도 있다.

-----------------------------------------------------------------

-- 1. 회사친구의 정보 변경. (기본정보 + 회사정보 수정)

-- a. 기본정보 수정.

update phoneinfo_basic
set fr_name='SCOTT',                        
    fr_phonenumber='010-5436-1235', 
    fr_address='SEOUL', 
    fr_email='scott@gmail.com'
where idx=2                            -- 이름은 겹칠수 있으니까.
;

-- b. 회사정보 수정.

update phoneinfo_com
set fr_c_company='KAKAO'
where fr_ref=2
;







-- 2. 학교 친구의 정보 변경. (기본정보 + 학교정보 수정)

-- a. 기본정보 수정.

update phoneinfo_basic
set fr_name='KING',                        
    fr_phonenumber='010-2323-1235', 
    fr_address='SEOUL', 
    fr_email='king@gmail.com'
where idx=1                             -- 이름은 겹칠수 있으니까.
;

-- b. 학교정보 수정.

update phoneinfo_univ
set fr_u_major='DATA',
    fr_u_year=3         -- 3학년.
where fr_ref=1;



select * from phoneinfo_basic;

select * from phoneinfo_com;

select * from phoneinfo_univ;





-----------------------------------------------------------------

-- 삭제를 위한 SQL

-----------------------------------------------------------------

-- 1. 학교 친구 정보를 삭제.

delete from phoneinfo_com where fr_ref=1;
delete from phoneinfo_univ where fr_ref=1;

delete from phoneinfo_basic where idx=1;        -- on delete cascade 썼다.


-- 2. 회사 친구 정보를 삭제.

delete from phoneinfo_com where fr_ref=2;
delete from phoneinfo_univ where fr_ref=2;

delete from phoneinfo_basic where idx=2;         -- on delete cascade 썼다.




select * from phoneinfo_basic;

select * from phoneinfo_com;

select * from phoneinfo_univ;


-----------------------------------------------------------------------

-- 외래키 설정시 부모의 행이 삭제 될 때 설정.
-- references phoneinfo_basic(idx) on delete 설정옵션
-- no action : 모두 삭제 불가.
-- cascade (중요) : 참조를 하고 있는 자식 테이블의 모든 행도 삭제
-- set null (중요) : 참조를 하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 null로 변경.
-- set default : 참조를 하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 기본값으로 변경.
