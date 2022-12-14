DROP TABLE IF EXISTS tbl_board;
CREATE TABLE tbl_board(
boardId int auto_increment,
teamname varchar (30) not null,
maxpeople number (30) not null,
subscription varchar (256) not null,
template number (2) not null,
primary key(boardId)
);

DROP TABLE IF EXISTS tbl_user;
CREATE TABLE tbl_user(
 userid int auto_increment,
 name varchar (30) not null,
 email varchar (40) not null,
 image varchar (512) not null
);

DROP TABLE IF EXISTS tbl_team;
CREATE TABLE tbl_team (
    teamid int auto_increment,
    userid int (100) not null,
    boardid int (100) not null,
    primary key(teamid),
    foreign key(userid) references tbl_user(userid),
    foreign key(boardid) references tbl_board(boardId)
);

INSERT INTO tbl_user(name,email,image) VALUES('user1', 'user1@gmail.com', '');
INSERT INTO tbl_user(name,email,image) VALUES('user2', 'user2@gmail.com', '');

INSERT INTO tbl_board(teamname, maxpeople, subscription, template) VALUES('team1', 5, 'subscriptions', 1);
INSERT INTO tbl_board(teamname, maxpeople, subscription, template) VALUES('team2', 10, 'subscription', 1);
INSERT INTO tbl_board(teamname, maxpeople, subscription, template) VALUES('team3', 5, 'subscription', 1);
INSERT INTO tbl_board(teamname, maxpeople, subscription, template) VALUES('team4', 5, 'subscription', 1);
INSERT INTO tbl_board(teamname, maxpeople, subscription, template) VALUES('team5', 5, 'subscription', 1);
INSERT INTO tbl_board(teamname, maxpeople, subscription, template) VALUES('team6', 10, 'subscription', 1);
INSERT INTO tbl_board(teamname, maxpeople, subscription, template) VALUES('team7', 5, 'subscription', 1);
INSERT INTO tbl_board(teamname, maxpeople, subscription, template) VALUES('team8', 5, 'subscription', 1);
INSERT INTO tbl_board(teamname, maxpeople, subscription, template) VALUES('team9', 5, 'subscription', 1);
INSERT INTO tbl_board(teamname, maxpeople, subscription, template) VALUES('team10', 3, 'subscription', 1);

INSERT INTO tbl_team(userid, boardid) VALUES(1,1);
INSERT INTO tbl_team(userid, boardid) VALUES(1,2);
INSERT INTO tbl_team(userid, boardid) VALUES(1,7);
