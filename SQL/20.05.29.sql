-- 과제


-- 1번
create table MEMBER(
    idx number(6),
    id varchar2(20),                             -- 회원아이디, 기본키
    name varchar2(20) not null,               -- 이름 ,not null
    password varchar2(20) not null,              -- 비밀번호, not null
    photo_name varchar2(20),                   -- 사진이름
    regday varchar2(20) default sysdate,        -- 가입일 default

    constraint MEMBER_id_pk primary key (id)
);    

drop table MEMBER;




-- 2번
create index MEMBER_name_index on MEMBER (name);







-- 3번
create or replace view member_view
as
select
    m. id ,             -- 회원아이디
    m. name,            -- 사진정보
    m. photo_name       -- 이름
from MEMBER m
;



drop view member_view;
    

select * from emp;

