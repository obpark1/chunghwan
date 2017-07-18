create table users(
id 		varchar2(10) primary key,
pw		varchar2(10),
name 	varchar2(10),
profile	varchar2(15),
reg_date date default sysdate
);

insert into users values
('song','1234','송하윤','song.jpg',default);

회원가입, 로그인, 로그아웃, 리스트, 리스트에서 상세정보 보기