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