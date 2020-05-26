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
    CONSTRAINT pb_type_ck check (pbtype in ('univ', 'com', 'cafe') ),
    constraint pb_grade_ck check (pbgrade between 1 and 4) -- 1,2,3,4
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
    CONSTRAINT pb_type_ck 
        check (pbtype in ('univ', 'com', 'cafe') ),   -- 친구 타입
    pbmajor varchar2(20),           -- 전공
    pbgrade number(1) 
    constraint pb_grade_ck 
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




-------------------------------------------------------------------------
---------------------------------------------------------------------------------------

-- phonebook 테이블명세서 DDL : 2020.05.26

drop table phoneInfo_basic;
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
    constraint pu_fr_u_year_ck check (fr_u_year between 1 and 4),
    constraint pu_fr_ref_fk foreign key(fr_ref) REFERENCES phoneInfo_basic(idx)    
);
 
create table phoneInfo_com(
    idx number(6),
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6),
    constraint pc_idx_pk primary key(idx),
    constraint pc_fr_ref_fk foreign key(fr_ref) REFERENCES phoneInfo_basic(idx)  
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
values (1, 'NAVER', 2)          -- 이거 2개가 들어가야 회사 친구 정보 저장된거다. 손흥민 앞에있는 1번이 여기 끝에 1번으로 외래키로 들어온다.
;                                   

-----------------------------------------------------------
select * from phoneinfo_basic;

select * from phoneinfo_com;

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
