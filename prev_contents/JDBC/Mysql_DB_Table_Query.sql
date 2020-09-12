create database People;
SHOW DATABASES;
use people;
show tables;

create table NOTICE(
ID INT,
TITLE VARCHAR(100),
WRITER_ID VARCHAR(50),
CONTENT TEXT,
REGDATE timestamp,
HIT INT,
FILES VARCHAR(1000)
);

CREATE TABLE COMMENT(
ID INT,
CONTENT VARCHAR(2000),
REGDATE TIMESTAMP,
WRITER_ID VARCHAR(50),
NOTICE_ID INT
);

CREATE TABLE ROLE(
ID VARCHAR(50),
DISCRIPTION VARCHAR(500)
);

CREATE TABLE MEMBER_ROLE(
MEMVER_ID VARCHAR(50),
ROLE_ID VARCHAR(50)
);

CREATE TABLE `MEMBER`(
ID VARCHAR(50),
PWD VARCHAR(50),
NAME VARCHAR(50),
GENDER CHAR(2),
BIRTHDAY CHAR(10)
);

set SQL_SAFE_UPDATES = 0;
DELETE FROM notice WHERE id =1;
DELETE FROM notice WHERE id =2;
DELETE FROM notice WHERE id =3;

insert into notice values(1, 'JDBC란 무엇인가?','nana','무엇일까?과연',now(), 3,'');
insert into notice values(2, 'JDBC 드라이버 다운로드 방법','YJ','방법은 추후 업로드 예정',now(), 10,'');
insert into notice values(3, '파라미터를 가지는 문장 실행하기','Dragon','이것도 추후',now(), 7,'');
insert into notice values(4, 'JSP에서 JDBC사용하기 공부완료','YJ2','공부했어요',now(), 13,'');
insert into notice values(5, 'Service 계층 추가하기','Kim','확인해보기',now(), 23,'');
insert into notice values(6, '6번째 게시글','Lucas','으앙',now(), 3,'');
insert into notice values(7, '더이상 쓸말이 없다.','Really','H',now(), 3,'');

desc notice;
select * from notice;