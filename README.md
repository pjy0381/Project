##Project Title
비패밀리 채용(인턴) 과제

##개발 도구

#언어 : JAVA(JDK8 버전)
#IDE : IntelliJ(Gradle 사용)
#DB : MySQL 5.7
#개발 구조: Spring Boot MVC패턴
#그외의 활용 기술 : Ajax, BootStrap, Git, Docker

##실행 가이드

#DB : 테이블 1개 생성 
create table member(
frontSSN varchar(30),
backSSN varchar(30),
email varchar(30),
pwd varchar(30),
phone varchar(30),
age int(5),
primary key(email)
)ENGINE=MYISAM CHARSET=utf8;
#MySQL 포트 : 3306
#서버 포트 : 8080
