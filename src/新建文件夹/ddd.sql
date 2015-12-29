SELECT `tb_user`.`id`,
    `tb_user`.`name`,
    `tb_user`.`sex`,
    `tb_user`.`account`
FROM `lanqiao`.`tb_user`;


insert into tb_user values(1,'sw','男',1);

select * from tb_user;

alter table tb_user change account account_id int;
alter table account_tb drop id;

alter table tb_account add password varchar(100) not null default '12345678';
alter table tb_account change password passwords varchar(100) not null default '12345678';
alter table tb_account add power int not null default 2;
alter table tb_account add account_id varchar(45) not null;
alter table tb_account change id id int not null auto_increment;
alter table tb_account drop id;

insert into tb_account (account_id, passwords, power)values('user1','12345678',2);

alter table user_tb change accunt_id account_id varchar(45) not null;
alter table user_tb change accunt_id account_id varchar(45) not null;

ALTER TABLE `lanqiao`.`user_tb` 
ADD CONSTRAINT `user_account`
  FOREIGN KEY (account_id)
  REFERENCES `lanqiao`.`account_tb` (name)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
alter table user_tb change age age int not null default 20;
insert into account_tb (name, password)values('sw','1231');
insert into user_tb (name,age,sex,account_id)values('ee','15','男','sw');

insert into account_tb (name, password)values('admin','admin');
insert into user_tb (name,age,sex,account_id)values('天王','10000','男','admin');

select * from user_tb;
select * from account_tb;
select account_tb.name, account_tb.password, user_tb.name, user_tb.sex, user_tb.age from user_tb inner join account_tb on user_tb.account_id = account_tb.name;

select s.Name,C.Cname from student_course as sc left join student as s on s.Sno=sc.Sno left join course as c on c.Cno=sc.Cno;

select account_tb.name, account_tb.password, account_tb.power ,user_tb.name, user_tb.sex, user_tb.age from 
		user_tb inner join account_tb on user_tb.account_id = account_tb.name;
        
        

select * from account_tb;
insert into account_tb (name, password, power)values('1', '1', 2); insert into user_tb (name, sex, age, account_id)values('1', '1', 20, '1');