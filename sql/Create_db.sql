drop table Users cascade;
drop table File  cascade;
drop table Comment cascade;
drop table count cascade;
CREATE TABLE Users
(
UserID VARCHAR(15) PRIMARY KEY,
NickName VARCHAR(15),
Credits INT,
FileNumber INT,
Status	INT,
UserType INT 
);
CREATE TABLE File
(
FileID INT(10) PRIMARY KEY AUTO_INCREMENT,
FileName VARCHAR(20),
AuthorID VARCHAR(15),
UploadTime DATETIME,
DownloadNum INT DEFAULT 0,
Size Long,
Praise INT DEFAULT 0,
Criticize INT DEFAULT 0,
Institute VARCHAR(30),
Grade INT,
CourseName VARCHAR(10),
Description VARCHAR(200),
CONSTRAINT fk_file_user FOREIGN KEY(AuthorID) REFERENCES Users(UserID)
);
CREATE table Comment
(
CommentID INT(10) PRIMARY KEY AUTO_INCREMENT,
FileID INT,
Content VARCHAR(100),
Comment_time DATETIME,
CONSTRAINT fk_comment_file FOREIGN KEY(FileID) REFERENCES File(FileID)
);
CREATE table count
(
number int PRIMARY KEY AUTO_INCREMENT,
);