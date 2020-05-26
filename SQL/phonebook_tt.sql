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
    pbaddr varchar(50) default '입력 없음'  not null,    -- 주소
    pbmail varchar2(50) default '입력 없음' not null,   -- 이메일
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



create table phoneinfo_basic(
    idx number(6),
    fr_name varchar(20) not null,
    fr_phonenumber varchar(20) not null,
    fr_email varchar(20),
    fr_adress varchar(20),
    fr_redgate date default sysdate,
    
    constraint phoneinfo_basic_idx_pk primary key(idx)
);


drop table phoneinfo_basic;


create table phoneinfo_univ(
    idx number(6),
    fr_u_major varchar2(20) default 'N' not null,
    fr_u_year number(1)  default 1 not null,
    fr_ref number(6) not null,
    
    constraint phoneinfo_univ_idx_pk primary key(idx),
    constraint phoneinfo_univ_fr_u_year_ck check (fr_u_year>0 and fr_u_year<5),
    constraint phoneinfo_univ_fr_ref_fk foreign key(fr_ref) REFERENCES phoneinfo_basic(idx)
);


drop table phoneinfo_univ;


create table phoneinfo_com(
    idx number(6),
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6) not null,
    
    constraint phoneinfo_com_idx_pk primary key(idx),
    constraint phoneinfo_com_fr_ref_fk foreign key(fr_ref) REFERENCES phoneinfo_basic(idx)
);


select * from phoneinfo_com;

drop table phoneinfo_com;


---------------------------------------------------------------------------------------

--1. 기본정보 입력
insert into PHONEINFO_BASIC
(IDX, FR_NAME, FR_PHONENUMBER, FR_EMAIL, FR_ADDRESS)
values
(1, 'son', '010-1111-1111', 'SEOUL', 'son@naver.com');

--2. 회사 정보 입력
insert into PHONEINFO_COM
(IDX, FR_C_COMPANY, FR_REF)
values
(1 ,'비트캠프', 1)
;

--3. 학교 정보 입력
insert into PHONEINFO_UNIV
(IDX, FR_U_MAJOR, FR_U_YEAR, FR_REF)
values
(1, '', 2, 1);

