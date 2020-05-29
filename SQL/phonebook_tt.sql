-- 2020.05.26. 화요일.



-- phonebook DDL
-- ===== 전화번호 부( Contact )

-- 대리키 : 일련번호 -> pbIdx ==> PK 기본키로 만들기 위한 목적

-- 이름, 전화번호, 주소, 이메일 <- 기본정보

-- 주소값과 이메일은 입력이 없을 때 기본값 입력

-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능

------ 선택 정보
-- 전공, 학년

-- 회사이름, 부서이름, 직급

-- 모임이름, 닉네임

drop table phonebook;


------------------------------------------------------------------------------

-- 테이블 레벨 제약 정의

create table phonebook(
    pbidx number(4),                -- 기본키, 대리키
    pbname varchar2(10) not null,   -- 이름
    pbnumber varchar(13) not null,  -- 전화번호
    pbaddr varchar(50) default '입력 없음'  not null,    -- 주소 default
    pbmail varchar2(50) default '입력 없음' not null,   -- 이메일 default
    pbtype varchar2(10) not null,   -- 친구 타입
    pbmajor varchar2(20),           -- 전공
    pbgrade number(1),              -- 학년
    pbcomName varchar2(50),         -- 회사이름    
    pbcomDept varchar2(50),         -- 부서이름
    pbcomJob varchar2(20),          -- 직급
    pbcafeName varchar2(50),        -- 동호회이름
    pbcafeNickname varchar2(50),    -- 닉네임
    
    constraint pb_pbidx_pk PRIMARY KEY (pbidx),         -- phonebook 을 pb로 쓴거다.
    CONSTRAINT pb_pbtype_ck check (pbtype in ('univ', 'com', 'cafe') ),
    constraint pb_pbgrade_ck check (pbgrade between 1 and 4) -- 1,2,3,4
);

---------------------------------------------------------------------------------

-- 컬럼 레벨 제약 정의

create table phonebook(
    pbidx number(4) constraint pb_pbidx_pk PRIMARY KEY,                -- 기본키
    pbname varchar2(10) not null,   -- 이름
    pbnumber varchar(13) not null,  -- 전화번호
    pbaddr varchar(50) default '입력 없음'  not null,    -- 주소
    pbmail varchar2(50) default '입력 없음' not null,   -- 이메일
    pbtype varchar2(10) not null 
    CONSTRAINT pb_pbtype_ck 
        check (pbtype in ('univ', 'com', 'cafe') ),   -- 친구 타입
    pbmajor varchar2(20),           -- 전공
    pbgrade number(1) 
    constraint pb_pbgrade_ck 
    check (pbgrade between 1 and 4),              -- 학년
    pbcomName varchar2(50),         -- 회사이름    
    pbcomDept varchar2(50),         -- 부서이름
    pbcomJob varchar2(20),          -- 직급
    pbcafeName varchar2(50),        -- 동호회이름
    pbcafeNickname varchar2(50)    -- 닉네임    
    
);

-----------------------------------------------------------------

-- 사용자 정의 제약조건을 저장하는 딕셔너리 테이블
desc user_constraints;
select * from user_constraints where table_name='PHONEBOOK';

-----------------------------------------------------------------


-----------------------------------------------------------------

-- 정보 입력 SQL 작성

-----------------------------------------------------------------

desc phonebook;

select * from phonebook;

TRUNCATE TABLE phonebook;       -- 5행있으면 5행 다 날라간다.


-- 기본정보 입력

insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype)
values 
(1, 'scott', '010-9999-1234', 'SEOUL', 'scott@gmail.com', 'univ')
;


-- default 입력 처리 pbaddr, pbemail

insert into phonebook 
(pbidx, pbname, pbnumber, pbtype)
values 
(2, 'king', '010-7777-3333', 'univ')
;


-- 학교 친구 정보 입력

insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbmajor, pbgrade)
values 
(3, 'son', '010-3333-1111', '서울', 'son@gmail.com', 'univ', 'computer', 1)
;


-- 회사 친구 정보 입력 

insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbcomname, pbcomdept, pbcomjob)
values 
(4, '박지성', '010-1234-0000', '런던', 'ji@gmail.com', 'com', 'NAVER', 'SEARCH', 'PROGRAMER')
;


-- 모임 친구 정보 입력

insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbcafename, pbcafenickname)
values 
(5, 'Rain', '010-1111-2222', 'SEOUL', 'rain@gmail.com', 'cafe', 'Campping', 'FirstCamp')
;

desc phonebook;

select * from phonebook;



------------------------------------------------------------------------

-- 정보 출력 질의 

------------------------------------------------------------------------

-- 1. 기본 정보 출력 질의

select pbidx, pbname, pbnumber from phonebook;

select * from phonebook;

-- 2. 대학 친구 정보 출력 질의

select pbname, pbnumber, pbmajor, pbgrade, pbtype from phonebook where pbtype='univ';


-- 3. 회사 친구 정보 출력 질의

select pbname, pbnumber, pbcomname, pbcomdept, pbcomjob, pbtype from phonebook where pbtype='com';


-- 4. 모임 친구 정보 출력 질의


select pbname, pbnumber, pbcafename, pbcafenickname, pbtype from phonebook where pbtype='cafe';



---------------------------------------------------------------------------------------


-- phonebook 테이블명세서 DDL : 2020.05.26

drop table phoneInfo_basic;         -- 외래키 때문에 phoneInfo_univ 하고 phoneInfo_com 지운다음에 phoneInfo_basic 지워야된다.
drop table phoneInfo_univ; 
drop table phoneInfo_com;

create table phoneInfo_basic (
    idx number(6),
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20),
    fr_address VARCHAR2(20),
    fr_regdate date default sysdate,    
    constraint pb_idx_pk primary key(idx)    
);
 
 
create table phoneInfo_univ (
    idx number(6),
    fr_u_major varchar2(20) default 'N' not null,
    fr_u_year number(1) default 1 not null,
    fr_ref number(6),
    constraint pu_idx_pk primary key(idx),
    constraint pu_fr_u_year_ck check (fr_u_year between 1 and 4),   -- 대학교 4학년까지니까.
    --constraint pu_fr_ref_fk foreign key(fr_ref) REFERENCES phoneInfo_basic(idx)  
    constraint pu_fr_ref_fk foreign key(fr_ref) REFERENCES phoneInfo_basic(idx) on delete CASCADE  
);
 
create table phoneInfo_com(
    idx number(6),
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6),
    constraint pc_idx_pk primary key(idx),
    constraint pc_fr_ref_fk foreign key(fr_ref) REFERENCES phoneInfo_basic(idx) on delete CASCADE  
);

---------------------------------------------------------------------------------

-- 입력 DML

---------------------------------------------------------------------------------

-- 학교 친구 정보 입력 순서
-- 1. 기본 친구 정보 테이블 데이터 입력
-- 2. 학교 친구 정보 테이블 데이터 입력
insert into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) 
VALUES (1, '박지성', '010-9999-0000', 'park@gmail.com', 'London')
;

insert into phoneinfo_univ          
values (1, 'computer', 1, 1)      -- phoneinfo_univ 컬럼 4개다.
;                                 -- 이거 2개가 들어가야 학교 친구 정보 저장된거다. 박지성 앞에있는 1번이 여기 끝에 1번으로 외래키로 들어온다.
                                  -- (첫번째등록, 전공컴퓨터, 1학년, 외래키1번연결)


-- sequence
insert into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) 
VALUES (PB_BASIC_IDX_SEQ.nextval, '박지성', '010-9999-0000', 'park@gmail.com', 'London')
;

insert into phoneinfo_univ 
values (PB_UNIV_IDX_SEQ.nextval, 'computer', 1, pb_basic_idx_seq.currval)
;

-----------------------------------------

select * from phoneinfo_basic;

select * from phoneinfo_univ;

-------------------------------------------


-- 회사 친구 정보 입력 순서
-- 1. 기본 친구 정보 테이블 데이터 입력
-- 2. 회사 친구 정보 테이블 데이터 입력
insert into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) 
VALUES (2, '손흥민', '010-7777-5555', 'son@gmail.com', 'London')
;

insert into phoneinfo_com       -- phoneinfo_com 컬럼 3개다.
values (1, 'NAVER', 2)          -- 이거 2개가 들어가야 회사 친구 정보 저장된거다. 손흥민 앞에있는 2번이 여기 끝에 2번으로 외래키로 들어온다.
;                               -- (첫번째등록, 회사이름, 외래키2번연결)   



-- sequence
insert into phoneinfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address) 
VALUES (PB_BASIC_IDX_SEQ.nextval, '손흥민', '010-7777-5555', 'son@gmail.com', 'London')
;

insert into phoneinfo_com 
values (PB_COM_IDX_SEQ.nextval, 'NAVER', PB_BASIC_IDX_SEQ.currval)
;



-----------------------------------------------------------
select * from phoneinfo_basic;

select * from phoneinfo_com;

select * from phoneinfo_univ;

--------------------------------------------------------

---------------------------------------------------------------------------------

-- 친구 정보 출력 질의

---------------------------------------------------------------------------------

-- 1. 전체 친구 목록 출력 : 테이블 3개 JOIN
select * 
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
--where pb.idx=pu.fr_ref and pb.idx=pc.fr_ref
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
;


-- 2. 학교 친구 목록 출력
select * 
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref
;


-- 3. 회사 친구 목록 출력
select * 
from phoneinfo_basic pb, phoneinfo_com pc
where pb.idx=pc.fr_ref
;



-----------------------------------------------------------------

-- 수정을 위한 SQL (phonebook 이용)        2020.05.27. 수요일.

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



-------------------------------------------------------------------------------

-- view 생성

-------------------------------------------------------------------------------

create or replace view emp_hir_view
as
select empno, ename, hiredate
from emp
order by hiredate asc
;


-- view 생성.

--1. pb_all_view

select * 
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
;

create or replace view pb_all_view 
as
select   
        pb.fr_name,             -- 중복되는거 때문에(idx), *하면 안된다. 그래서 하나씩 나열한다.
        pb.fr_phonenumber, 
        pb.fr_email, 
        pb.fr_address, 
        pb.fr_regdate,
        pc.fr_c_company,
        pu.fr_u_major, 
        pu.fr_u_year        
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc 
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
;


select * from pb_all_view;



--2. pb_com_view

select * from phoneinfo_basic pb, phoneinfo_com pc
where pb.idx=pc.fr_ref
;

create or replace view pb_com_view
as
select 
        pb.fr_name,  
        pb.fr_phonenumber, 
        pb.fr_email, 
        pb.fr_address, 
        pb.fr_regdate,
        pc.fr_c_company
from phoneinfo_basic pb, phoneinfo_com pc
where pb.idx=pc.fr_ref
;

select * from pb_com_view;


--3. pb_univ_view

select * from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref
;

create or replace view pb_univ_view
as
select 
        pb.fr_name,  
        pb.fr_phonenumber, 
        pb.fr_email, 
        pb.fr_address, 
        pb.fr_regdate,
        pu.fr_u_major, 
        pu.fr_u_year
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref
;

select * from pb_univ_view;



-----------------------------------------------------------------------------

-- sequence 생성

------------------------------------------------------------------------------

-- 1. basic 테이블 seq

create sequence pb_basic_idx_seq
start with 0
minvalue 0
;               -- 1씩 증가가 default.


-- 2. com 테이블 seq

create sequence pb_com_idx_seq start with 0 minvalue 0; 

-- 3. univ 테이블 seq

create sequence pb_univ_idx_seq start with 0 minvalue 0; 




