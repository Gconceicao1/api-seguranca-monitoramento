INSERT INTO USER_FORUM(name,email,password) values('userTest1', 'userEmail1@email.com','$2a$10$EuTXt/iMgbTTqB.LZd4wqOAyrKMYxoUH2HaLvI9F/Xm5RHgel4hKq');
INSERT INTO USER_FORUM(name,email,password) values('userTest2', 'userEmail2@email.com','$2a$10$EuTXt/iMgbTTqB.LZd4wqOAyrKMYxoUH2HaLvI9F/Xm5RHgel4hKq');
INSERT INTO USER_FORUM(name,email,password) values('userTest3', 'userEmail3@email.com','123456');
INSERT INTO USER_FORUM(name,email,password) values('userTest4', 'userEmail4@email.com','123456');

INSERT INTO COURSE(name,category) values('Spring boot','programação');
INSERT INTO COURSE(name,category) values('HTML 5','front-end');

INSERT INTO PROFILE(Name) values('adm');

INSERT INTO TOPIC(title,message,creation_date,status,user_id,course_id) values('dúvida1','erro ao criar projeto','2020-10-10 18:00:00','NOT_SOLVED', 1,1);
INSERT INTO TOPIC(title,message,creation_date,status,user_id,course_id) values('dúvida2','erro ao complilar','2020-10-11 19:00:00','NOT_ANSWERED', 1,1);
INSERT INTO TOPIC(title,message,creation_date,status,user_id,course_id) values('dúvida3','Tag HTML - BR','2020-10-10 20:00:00', 'NOT_ANSWERED',1,2);
INSERT INTO TOPIC(title,message,creation_date,status,user_id,course_id) values('dúvida4','Tag HTML P','2020-10-10 20:00:00', 'NOT_ANSWERED',2,2);
INSERT INTO TOPIC(title,message,creation_date,status,user_id,course_id) values('dúvida5','Tag HTML HR','2020-10-10 20:00:00', 'NOT_ANSWERED',3,2);
INSERT INTO TOPIC(title,message,creation_date,status,user_id,course_id) values('dúvida6','Tag HTML DIV','2020-10-10 20:00:00', 'NOT_ANSWERED',4,2);
INSERT INTO TOPIC(title,message,creation_date,status,user_id,course_id) values('dúvida7','Tag HTML SPAN','2020-10-10 20:00:00', 'NOT_ANSWERED',1,2);
INSERT INTO TOPIC(title,message,creation_date,status,user_id,course_id) values('dúvida8','Tag HTML INPUT','2020-10-10 20:00:00', 'NOT_ANSWERED',2,2);
INSERT INTO TOPIC(title,message,creation_date,status,user_id,course_id) values('dúvida9','Tag HTML VIDEO','2020-10-10 20:00:00', 'NOT_ANSWERED',3,2);
INSERT INTO TOPIC(title,message,creation_date,status,user_id,course_id) values('dúvida9','Tag HTML IMG','2020-10-10 20:00:00', 'NOT_ANSWERED',3,2);


insert into ANSWER(creation_date,message,solution,topic,author_id) values('2020-10-15 19:00:00', 'Mete um else que resolve', 0, 1,2);
insert into ANSWER(creation_date,message,solution,topic,author_id) values('2020-10-15 19:00:00', 'Manda um print do codigo1', 0, 1,2);
insert into ANSWER(creation_date,message,solution,topic,author_id) values('2020-10-15 19:00:00', 'Manda um print do codigo2', 0, 1,3);
insert into ANSWER(creation_date,message,solution,topic,author_id) values('2020-10-15 19:00:00', 'Manda um print do codigo3', 0, 1,4);
insert into ANSWER(creation_date,message,solution,topic,author_id) values('2020-10-15 19:00:00', 'Manda um print do codigo', 0, 1,1);
