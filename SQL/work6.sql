1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
(5) 박지성이구매한
    도서의출판사수

select * from orders;
select * from customer;
select * from book;



select count(publisher)         --me
from book b
where bookid in (select bookid 
                from orders o, customer c 
                where o.custid = c.custid and c.name='박지성');   
                
                

select count(distinct b.publisher)          -- 같은 출판사의 책을 구매할수있다.   --join 사용
from customer c, orders o, book b
where c.custid = o.custid and o.bookid = b.bookid
and c.name='박지성'
;



-- 박지성이 구매한 도서 id
select distinct o.bookid
from orders o, customer c
where o.custid = c.custid and c.name = '박지성'
;


select count(publisher)
from book 
where bookid in (select distinct o.bookid
                from orders o, customer c
                where o.custid = c.custid and c.name = '박지성')
;



(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이

select * from orders;
select * from customer;
select * from book;


select b.bookname, abs(b.price-o.saleprice) as pricegap         --me
from book b, orders o
where o.custid = (select c.custid
                from customer c
                where c.name='박지성')
                and b.bookid = o.bookid;


select b.bookname, abs(b.price-o.saleprice) as pricegap         --join
from orders o, customer c, book b
where c.custid = o.custid and o.bookid = b.bookid
and c.name = '박지성';
;


select b.bookname, b.price, b.price-o.saleprice as pricegap
from orders o, book b
where o.bookid = b.bookid
and custid=(select custid from customer where name='박지성')
;

select custid from customer where name='박지성';

(7) 박지성이구매하지않은
    도서의이름

select * from orders;
select * from customer;
select * from book;


select bookname         --me
from book
where bookid not in (select bookid
                    from orders o, customer c
                    where o.custid = c.custid
                    and c.name = '박지성');
                        
 
select *                        -- 서브쿼리
from orders o, customer c
where o.custid = c.custid and c.name = '박지성';



select bookname, bookid
from book
where bookid  not in (select o.bookid
from orders o, customer c
where o.custid = c.custid and c.name = '박지성') 
; 
 

2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.

(8) 주문하지않은고객의이름(부속질의사용)

select * from orders;
select * from customer;
select * from book;


select name             --me
from customer
where custid not in ( select custid 
                        from orders );
                        

select *                        -- outer join
from orders o, customer c
where o.custid(+) = c.custid        -- null값이 있더라도 회원을 표현 한다.
;


select c.name                        -- outer join
from orders o, customer c
where o.custid(+) = c.custid  
and o.orderid is null
;


select distinct custid from orders;     -- 구매한 회원.

select name
from customer
where custid not in(select distinct custid from orders)
;


                        

(9) 주문금액의총액과주문의평균금액

select * from orders;
select * from customer;
select * from book;

select sum(saleprice) as total, avg(saleprice) as avgsalprice       --me
from orders
;


select sum(saleprice), avg(saleprice)
from orders
;



(10) 고객의 이름과
     고객별 구매액


select c.name, sum(saleprice)
from orders o, customer c
where o.custid = c.custid
group by c.name
;




(11) 고객의 이름과 고객이 구매한도서목록

select c.name, b.bookname
from book b, orders o, customer c
where b.bookid = o.bookid and o.custid = c.custid
;




(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
;

SELECT MAX(B.PRICE-O.SALEPRICE)
FROM ORDERS O, BOOK B
WHERE O.BOOKID=B.BOOKID
;


SELECT B.BOOKNAME, B.PRICE-O.SALEPRICE
FROM ORDERS O, BOOK B
WHERE O.BOOKID=B.BOOKID
AND PRICE-SALEPRICE=(
    SELECT MAX(B.PRICE-O.SALEPRICE)
    FROM ORDERS O, BOOK B
    WHERE O.BOOKID=B.BOOKID
)
;





(13) 도서의 판매액 평균보다
     자신의 구매액평균이 더 높은 고객의이름
;

select avg(saleprice) from orders;


select c.name, avg(saleprice)
from orders o, customer c
where o.custid =c.custid
group by c.name
having avg(saleprice)>(select avg(saleprice) from orders)        -- 평균구매액
;


3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
;

select b.publisher
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
and c.name ='박지성'
;



select *
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
and b.publisher in(select distinct b.publisher
                    from orders o, customer c, book b
                    where o.custid = c.custid and o.bookid = b.bookid
                    and c.name ='박지성')
and c.name !='박지성'
;

(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
;

select c.name, count(distinct publisher)
from orders o, customer c, book b
where o.custid=c.custid and o.bookid =b.bookid
group by c.name
having count(distinct publisher) >=2
;