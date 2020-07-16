create table freeboard(
    bno number(10,0),
    title varchar2(300) not null,
    writer varchar2(50) not null,
    content varchar2(2000) not null,
    regdate date default sysdate, --����ð�
    updatedate date default sysdate
);

alter table freeboard add CONSTRAINT freeboard_pk PRIMARY KEY (bno);

create SEQUENCE freeboard_seq INCREMENT BY 1 start with 1 NOCACHE;

select * from freeboard order by bno desc;
select * from freeboard where bno=1;
update freeboard set writer='hi', title='hi', content='hi' where bno = 13;
delete freeboard where bno = 10;
commit;

insert into freeboard(bno,title,writer,content) values (FREEBOARD_SEQ.nextval,'����','admin6','test6');
insert into freeboard(bno,title,writer,content) values (FREEBOARD_SEQ.nextval,'����','admin7','test7');
insert into freeboard(bno,title,writer,content) values (FREEBOARD_SEQ.nextval,'����','admin8','test8');
insert into freeboard(bno,title,writer,content) values (FREEBOARD_SEQ.nextval,'����','admin9','test9');
insert into freeboard(bno,title,writer,content) values (FREEBOARD_SEQ.nextval,'����','admin0','test0');

select count(*) from freeboard;

select * 
from(select rownum as rn,
            bno,
            title,
            writer,
            content,
            regdate,
            updatedate
    from(select *
         from freeboard
         --where title like '%4%'
         --where writer like '%admin%' --�� ������ ��Ŭ�������� ������ �� ����
         where content like '%' || test || '%' --�̷��� �������� ���ڿ��� ����������Ѵ� 
         order by bno desc)
)where rn > 0 and rn <= 10;



