insert into Users(UserID, NickName, Credits,FileNumber,Status,UserType)
	values ("2012141463036","test",100,10,1,1),("2012141463045","database",20,10,1,1),("2012141463054","Example",3,33,1,1);
insert into File(FileName,AuthorID,UploadTime,Size,Institute,Grade,CourseName,Description) values
("A","2012141463036",now(),0,"SoftwareEngineering","2012","slp","this is asshole"),
("B","2012141463045",now(),0,"SoftwareEngineering","2012","database","this is asshole"),
("C","2012141463054",now(),0,"SoftwareEngineering","2012","Network","this is asshole"),
("D","2012141463036",now(),0,"SoftwareEngineering","2012","os","this is asshole"),
("E","2012141463045",now(),0,"SoftwareEngineering","2012","程序设计基础","this is asshole"),
("F","2012141463054",now(),0,"SoftwareEngineering","2012","数字逻辑","this is asshole"),
("G","2012141463036",now(),0,"SoftwareEngineering","2012","计算机导论","this is asshole"),
("H","2012141463045",now(),0,"SoftwareEngineering","2012","软件开发实践","this is asshole"),
("I","2012141463054",now(),0,"SoftwareEngineering","2012","离散数学","this is asshole"),
("J","2012141463036",now(),0,"SoftwareEngineering","2012","高等数学","this is asshole"),
("k","2012141463045",now(),0,"SoftwareEngineering","2012","线性代数","this is asshole"),
("L","2012141463054",now(),0,"SoftwareEngineering","2012","编译原理","this is asshole");
insert into Comment(CommentID,FileID,Content,Comment_time)values
(1,1,"very good",now()),
(2,1,"fuck",now()),
(3,1,"so so",now());
