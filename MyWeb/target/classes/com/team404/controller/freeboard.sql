create table freeboard(
    bno number(10,0),
    title varchar2(300) not null,
    writer varchar2(50) not null,
    content varchar2(2000) not null,
    regdate date default sysdate, --현재시간
    updatedate date default sysdate
);

alter table freeboard add CONSTRAINT freeboard_pk PRIMARY KEY (bno);

create SEQUENCE freeboard_seq INCREMENT BY 1 start with 1 NOCACHE;

select * from freeboard order by bno desc;
select * from freeboard where bno=1;
update freeboard set writer='hi', title='hi', content='hi' where bno = 13;
delete freeboard where bno = 10;
commit;

insert into freeboard(bno,title,writer,content) values (FREEBOARD_SEQ.nextval,'ㅎㅎ','admin6','test6');
insert into freeboard(bno,title,writer,content) values (FREEBOARD_SEQ.nextval,'ㅋㅋ','admin7','test7');
insert into freeboard(bno,title,writer,content) values (FREEBOARD_SEQ.nextval,'ㄷㄷ','admin8','test8');
insert into freeboard(bno,title,writer,content) values (FREEBOARD_SEQ.nextval,'ㅂㅂ','admin9','test9');
insert into freeboard(bno,title,writer,content) values (FREEBOARD_SEQ.nextval,'ㅇㅇ','admin0','test0');

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
         --where writer like '%admin%' --이 형식은 이클립스에서 적용할 수 없다
         where content like '%' || test || '%' --이러한 형식으로 문자열로 조합해줘야한다 
         order by bno desc)
)where rn > 0 and rn <= 10;



