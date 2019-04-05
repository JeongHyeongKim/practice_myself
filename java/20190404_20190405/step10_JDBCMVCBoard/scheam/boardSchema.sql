drop table board;

create table board(
	board_no int primary key, --글번호
	subject varchar2(30) not null, --제목
	writer varchar2(20) not null,--작성자
	content varchar2(50) not null, -- 내용
	board_date date not null -- 작성일
);  --알트+x


--시퀀스 만들기 전에 권한 부여(system계정에서만 가능)
grant  create sequence  to scott;

drop sequence board_seq;
  
--시퀀스 만들기
create sequence board_seq1 nocache; 


select * from board;

commit

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq1.nextval, 'db수업', '장희정', '잼난다', sysdate)




