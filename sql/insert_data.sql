insert into Users(UserID, NickName, Credits,FileNumber,Status,UserType)
	values ("2012141463036","test",100,10,1,1),("2012141463045","database",20,10,1,1),("2012141463054","Example",3,33,1,1);
insert into File(FileName,AuthorID,UploadTime,Size,Institute,Grade,CourseName,Description) values
("A","2012141463036",now(),0,"SoftwareEngineering","2012","slp","this is asshole"),
("B","2012141463045",now(),0,"SoftwareEngineering","2012","database","this is asshole"),
("C","2012141463054",now(),0,"SoftwareEngineering","2012","Network","this is asshole"),
("D","2012141463036",now(),0,"SoftwareEngineering","2012","os","this is asshole"),
("E","2012141463045",now(),0,"SoftwareEngineering","2012","������ƻ���","this is asshole"),
("F","2012141463054",now(),0,"SoftwareEngineering","2012","�����߼�","this is asshole"),
("G","2012141463036",now(),0,"SoftwareEngineering","2012","���������","this is asshole"),
("H","2012141463045",now(),0,"SoftwareEngineering","2012","�������ʵ��","this is asshole"),
("I","2012141463054",now(),0,"SoftwareEngineering","2012","��ɢ��ѧ","this is asshole"),
("J","2012141463036",now(),0,"SoftwareEngineering","2012","�ߵ���ѧ","this is asshole"),
("k","2012141463045",now(),0,"SoftwareEngineering","2012","���Դ���","this is asshole"),
("L","2012141463054",now(),0,"SoftwareEngineering","2012","����ԭ��","this is asshole");
insert into Comment(CommentID,FileID,Content,Comment_time)values
(1,1,"very good",now()),
(2,1,"fuck",now()),
(3,1,"so so",now());
