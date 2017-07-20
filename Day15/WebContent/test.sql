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


게시판 테이블
create table board(
	num number primary key,
	id  varchar2(10),
	subject varchar2(100),
	content varchar2(1000),
	write_date date default sysdate,
	read_count number default 0
)

자동으로 객체 증가 시켜주는 것
create sequence board_seq
	start with 1
	increment by 1

	
insert into board
values(board_seq.nextval, 'test','안녕하세요','안녕하세요',default,default)

insert into board
values(board_seq.nextval, 'mino','신서유기','송민호굿',default,default)

select * from BOARD;


게시판에 댓글
create table comments(
	comment_num	 number primary key,	-- 댓글번호
	id			varchar2(10),
	content		varchar2(1000),
	write_date	date default sysdate,
	num			number references board(num)		-- 게시판 글번호
)


댓글을 위한 sequence
create sequence comment_seq
	start with 1
	increment by 1

insert into comments values(comment_seq.nextval, 'hodong', '좋아요',default,1);
insert into comments values(comment_seq.nextval, 'jiwon', '싫어요',default,1);
insert into comments values(comment_seq.nextval, 'suguen', '좋아요',default,2);
insert into comments values(comment_seq.nextval, 'kyuhyun', '싫어요',default,2);

select * from board;
select * from comments where num = 1;
