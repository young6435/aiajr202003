-- 2020.05.26. 화요일.


-----------------------------------------------------------------------

-- DML

-----------------------------------------------------------------------

drop table dept01;


create table dept01                 -- 껍데기 만든다.
as
select * from dept where 1<0
;


desc dept01;

select * from dept01;

----------------------------------------------------------------------

-- 새로운 부서 정보를 입력 : 행단위 입력
-- insert into 테이블이름 (입력하고자 하는 컬럼들) values (데잍들)
-- 입력 컬럼의 순서와 입력데이터의 순서는 같아야 한다.


insert into dept01 (deptno, dname, loc) values(10,'MARKETING', 'SEOUL'); 

insert into dept01 VALUES (20,'DESIGN','PUSAN');            --dept가 3개 컬럼인데 그거 3개 다쓸꺼면 생략가능하다.

insert into dept01 (loc, deptno, dname) values('LONDON',30, 'SALES');       -- 입력순서 바꿔도 되는데, 뒤에것도 순서 맞춰야 된다.

insert into dept01 (deptno, dname) values (40,'DEV');       -- loc 가 null 이다.


desc dept01;
select * from dept01;



------------------------------------------------------------------------------------------


create table dept02(            -- 껍데기 만든다.
    deptno number(2) not null,
    dname varchar2(20) not null,
    loc varchar2(20) default 'SEOUL'
);

insert into dept02 (deptno, dname, loc) values(10,'MARKETING', 'SEOUL'); 

insert into dept02 (deptno, dname) values (40,'DEV');


-- null 값 입력

insert into dept02 (deptno, dname, loc) values(20,'MARKETING', null);   -- 명시적으로 null 써도 된다.

insert into dept02 (deptno, dname, loc) values(30,'MARKETING', '');     -- null 값이다. 


-- 오류

insert into dept02 (deptno, dname) values(40, 'DEV', 'PUSAN');           -- 개수가 안맞는다.

insert into dept02 (deptno, dname, loc) values(10,'MARKETING');          -- 개수가 안맞는다.

insert into dept02 values(40,'MARKETING');       --앞에꺼 3개 뒤에꺼 2개    -- 개수가 안맞는다.    



select * from dept02;

drop table dept02;



--------------------------------------------------------------------------------------------








