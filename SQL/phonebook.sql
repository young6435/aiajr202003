-- 2020.05.26.  화요일.


--------------------------------------------------------------------------------

-- 전화번호 관리 프로그램

--------------------------------------------------------------------------------

-- 이름, 전화번호, 생일, 이메일
-- 전공, 학년
-- 부서이름, 직급
-- 동호회 이름, 닉네임
-- 대리키 : 일련번호 -> pIdx               -- 대리키 만드는 이유 : pk기본키로 만들기 위한 목적

-- 전화번호 부(Contact)

-- 이름쓸때 언더바 되도록이면 쓰지 말자.
---------------------------------------------------------------------------------

--  컬럼 제약 조건

create table phonebook(
    pidx number(6) constraint phonebook_pidx_pk primary key,         --기본키
    pbname number(10) not null,                              --이름
    pbnumber varchar2(13) not null,                         --전화번호      -- 13 or 11(하이픈 빼고).
    pbadress varchar2(50) default '입력정보없음' not null,       --주소
    pbemail varchar2(50) default '입력정보없음' not null,         --이메일
    --regdate date default sysdate,
    pbtype varchar2(10) constraint phonebook_pbtype_ck check (pbtype in('univ','com','cafe')),
    pbmajor varchar2(20),     --전공
    pbgrade number(1),     --학년
    pbcomname varchar2(20),   --회사이름
    pbdeptname varchar2(20),  --부서이름
    pbcomjob varchar2(20),       --직급
    pbcafename varchar2(20),     --동호회이름 
    pbnickname varchar2(20)      --닉네임
    
);

-----------------------------------------------------------------

-- 사용자 정의 제약조건을 저장하는 딕셔너리 테이블
desc user_constraints;
select * from user_constraints where table_name='PHONEBOOK';

----------------------------------------------------------------



drop table phonebook;

----------------------------------------

-- 테이블 제약 조건


create table phonebook(
    pidx number(6),         --기본키
    pbname number(6) not null,                              --이름
    pbnumber varchar2(20) not null,                         --전화번호
    pbadress varchar2(20) default '입력정보없음' not null,       --주소
    pbemail varchar2(20) default '입력정보없음' not null,         --이메일
    --regdate date default sysdate,
    pbtype varchar2(10),        --친구타입
    pbmajor varchar2(20),     --전공
    pbgrade number(1),     --학년
    pbcomname varchar2(20),   --회사이름
    pbdeptname varchar2(20),  --부서이름
    pbcomjob varchar2(20),       --직급
    pbcafename varchar2(20),     --동호회이름 
    pbnickname varchar2(20),      --닉네임
    
    constraint phonebook_pidx_pk primary key(pidx),
    constraint phonebook_pbtype_ck check (pbtype in('univ','com','cafe'))
    
);



drop table phonebook;



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


drop table phoneinfo_com;




