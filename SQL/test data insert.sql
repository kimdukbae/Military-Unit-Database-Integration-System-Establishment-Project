insert into class values('�̵',408000);
insert into class values('�Ϻ�',441000);
insert into class values('��',488000);
insert into class values('����',540000);
insert into class values('�ϻ�',1555000);
insert into class values('�߻�',1710000);
insert into class values('���',2120000);

insert into position values('101','����');
insert into position values('201','����');
insert into position values('301','������');
insert into position values('401','��ź�');
insert into position values('501','�����뺴');
insert into position values('601','�庴');

//�δ� ���̺��� �δ��� �Ӽ� ��������
insert into company values('2918','2���','�籸', '�籸', '��', '5000');
insert into company values('1816','3���','ö��', 'ö��', '��', '7000');
insert into company values('1817','�װ�������ɺ�','��⵵ �ϳ�', '����', '��', '3000');
insert into company values('1803','�庴��','����', '����', '��', '1000');

insert into physical values(1,'1��',65,60,13,16);
insert into physical values(2,'Ư��',105,84,12,20);
insert into physical values(3,'2��',54,67,14,14);
insert into physical values(4,'3��',45,55,15,11);


insert into medical values(1,'�λ�X', null, 'X');
insert into medical values(2,'���� �δ�', to_date('2019/05/05','yyyy/mm/dd'), '�ϵ����� �̼�');
insert into medical values(3,'�α��� ��ħ', to_date('2019/04/30','yyyy/mm/dd'), '���� ������');
insert into medical values(4,'�λ�X', null, 'X');

insert into train values('�ѹ̿�������','2918','2019/07/03','2019/07/08','�籸');
insert into train values('KCTC','1816','2019/08/14','2019/08/18','��õ');
insert into train values('RCT','1816','2019/09/01','2019/09/07','ö��');
insert into train values('��������Ʒ�','1817','2019/11/11','2019/11/12','��õ');
insert into train values('����','1803','2019/06/06','2019/06/12','����');

insert into soldat values('201512918','���ȣ','��','����', '95/08/22','010-5104-0882','����','2918','101','����','2018/08/02','2020/05/01',1,1);
insert into soldat values('201511816','������','����','����', '95/08/03','010-8703-2174','����','1816','301','����','2018/05/10','2020/02/09',2,2);
insert into soldat values('201511817','������','�̵','����', '95/09/12','010-9653-5847','����','1817','501','����','2018/06/28','2020/03/27',3,3);
insert into soldat values('201511803','������','�Ϻ�','����', '94/07/20','010-2033-8327','����','1803','601','����','2018/08/08','2020/05/07',4,4);

insert into family values('201512918','��浿', '010-2424-1515', '�ƹ���');
insert into family values('201511816','�����', '010-2468-1357', '�ƹ���');
insert into family values('201511817','������', '010-8513-5600', '��Ӵ�');
insert into family values('201511803','�����', '010-7381-6191', '�ƹ���');

insert into vacation values('19-1001','201511803','�ܹ�', '2019/06/14','2019/06/15');
insert into vacation values('19-1002','201511816','�ް�', '2019/07/11','2019/07/25');
insert into vacation values('19-1003','201511817','�ް�', '2019/06/28','2019/07/05');
insert into vacation values('19-1004','201512918','����', '2019/06/21','2019/06/21');

insert into benefit values('������ ��ȭ', '�̵', '�ź������ް� + 1��2��');
insert into benefit values('������ ����', '����', 'PX��ǰ 20% ����');


insert into equipment values('KA-101', '1816', '���䳪', 2, '�����');
insert into equipment values('K-1212', '2918', 'K2 ����', 20, 'ȭ��');
insert into equipment values('K-1111', '2918', 'K1 ����', 15, 'ȭ��');
insert into equipment values('KM167', '1817', '��ĭ��', 6, '�����');
insert into equipment values('KA-501', '1803', '���� ����Ʈ��', 10, '�����');

alter table oil drop constraint oil_pk;
alter table oil drop column oil_time;
alter table oil
add constraint oil_pk PRIMARY KEY(oil_date, oil_trader);
insert into oil values(to_date('2019/06/06 11:50:00','yyyy/mm/dd hh24:mi:ss'), '201511816', '����������', 20, 210, '����');
insert into oil values('2019/05/30','201511817', '������ ����', 30, 300, '�ֹ���');
insert into oil values('2019/05/30','201511803', '���� ����', 25, 125, '����');

alter table duty modify(d_worktime VARCHAR2(20));
insert into duty values('���ٹ�', '201512918','2019/06/05','13:00 ~ 15:00' ,'�ʼ�');
insert into duty values('���ٹ�', '201511816','2019/06/05', '09:00 ~ 11:00','������');
insert into duty values('CCTV�ٹ�', '201511817','2019/06/06', '16:00 ~ 18:00' ,'����������');
insert into duty values('FDC�ٹ�', '201511803','2019/06/06' , '01:00 ~ 03:00','����������');


insert into facility values('ǲ����', '201511816');
insert into facility values('ü����', '201511817');
insert into facility values('�뷡��', '201511803');
insert into facility values('����', '201512918');


commit;

