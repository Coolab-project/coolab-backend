DROP TABLE IF EXISTS tbl_board;
CREATE TABLE tbl_board(
boardId int auto_increment,
title varchar (30) not null,
content varchar (30) not null,
name varchar (30) not null,
primary key(boardId)
);

DROP TABLE IF EXISTS tbl_user;
CREATE TABLE tbl_user(
 userid int auto_increment,
 name varchar (30) not null,
 email varchar (40) not null,
 image varchar (512) not null
);

INSERT INTO tbl_user(name,email,image) VALUES('user1', 'user1@gmail.com', '');

INSERT INTO tbl_board(title, content, name) VALUES('title1', 'content1', 'name1');
INSERT INTO tbl_board(title, content, name) VALUES('title2', 'content2', 'name2');
INSERT INTO tbl_board(title, content, name) VALUES('title3', 'content3', 'name3');
INSERT INTO tbl_board(title, content, name) VALUES('title4', 'content4', 'name4');
INSERT INTO tbl_board(title, content, name) VALUES('title5', 'content5', 'name5');
INSERT INTO tbl_board(title, content, name) VALUES('title6', 'content6', 'name6');
INSERT INTO tbl_board(title, content, name) VALUES('title7', 'content7', 'name7');
INSERT INTO tbl_board(title, content, name) VALUES('title8', 'content8', 'name8');

