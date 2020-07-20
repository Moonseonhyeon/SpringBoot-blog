# 스프링 부트 송금 인출 앱 만들기

## 1. 개발 환경

- Spring Web
- Spring Devtool
- Lombok
- MySQL
- MyBatis

- JSTL
- Tomcat-Embed-Jasper

## 2. 요구사항(기능)

- 송금
- 인출

## 3. 테이블

```sql
create user 'spring'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'spring'@'%';
create database spring;
use spring;
```

```sql
CREATE TABLE account(
	id int auto_increment primary key,
    username varchar(100) unique not null,
    accountNumber varchar(100) not null,
    money int
) engine=InnoDB default charset=utf8;
```

```sql
insert into account(username, accountnumber, money)
values('홍길동', '01022228888', 50000);

insert into account(username, accountnumber, money)
values('장보고', '01044441111', 100000);

commit;
```
