-- You can use this file to load seed data into the database using SQL statements
INSERT INTO USER (USERID, USERNAME) VALUES (1,'DEMO_USER1');
INSERT INTO USER (USERID, USERNAME) VALUES (2,'DEMO_USER2');
INSERT INTO ROLE (ROLEID, NAME) VALUES (1,'DEMO_ROLE1');
INSERT INTO ROLE (ROLEID, NAME) VALUES (2,'DEMO_ROLE2');
INSERT INTO USER_ROLE VALUES (1,1);
INSERT INTO USER_ROLE VALUES (2,1);
INSERT INTO USER_ROLE VALUES (2,2);