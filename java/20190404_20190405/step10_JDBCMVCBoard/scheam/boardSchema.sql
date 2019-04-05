drop table board;

create table board(
	board_no int primary key, --�۹�ȣ
	subject varchar2(30) not null, --����
	writer varchar2(20) not null,--�ۼ���
	content varchar2(50) not null, -- ����
	board_date date not null -- �ۼ���
);  --��Ʈ+x


--������ ����� ���� ���� �ο�(system���������� ����)
grant  create sequence  to scott;

drop sequence board_seq;
  
--������ �����
create sequence board_seq1 nocache; 


select * from board;

commit

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq1.nextval, 'db����', '������', '�볭��', sysdate)




