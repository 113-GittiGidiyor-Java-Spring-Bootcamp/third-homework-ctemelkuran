DROP TABLE IF EXISTS COURSE;
create table COURSE (
                        course_code VARCHAR(50),
                        course_name VARCHAR(50),
                        credit_score INT
);
insert into COURSE (course_code, course_name, credit_score) values ('FH664', 'stable', 10);
insert into COURSE (course_code, course_name, credit_score) values ('NZ162', 'heuristic', 9);
insert into COURSE (course_code, course_name, credit_score) values ('DH068', 'Exclusive', 10);
insert into COURSE (course_code, course_name, credit_score) values ('ET449', 'Operative', 7);
insert into COURSE (course_code, course_name, credit_score) values ('WT152', 'Exclusive', 7);
insert into COURSE (course_code, course_name, credit_score) values ('TS607', 'needs-based', 7);
insert into COURSE (course_code, course_name, credit_score) values ('KV366', 'bandwidth-monitored', 6);
insert into COURSE (course_code, course_name, credit_score) values ('VW818', 'solution-oriented', 6);
insert into COURSE (course_code, course_name, credit_score) values ('RU557', 'standardization', 8);
insert into COURSE (course_code, course_name, credit_score) values ('LD688', 'Multi-tiered', 9);

DROP TABLE IF EXISTS STUDENT;

create table STUDENT (
                         name VARCHAR(50),
                         birthDate DATE,
                         address VARCHAR(50),
                         gender VARCHAR(50)
);

insert into STUDENT (name, birthDate, address, gender) values ('Aurelie Jaffrey', '2001-10-29', 'Västervik', 'Male');
insert into STUDENT (name, birthDate, address, gender) values ('Michaelina Heathcott', '2010-09-26', 'Aţ Ţurrah', 'Female');
insert into STUDENT (name, birthDate, address, gender) values ('Terra Bettington', '2016-01-01', 'Serra', 'Female');
insert into STUDENT (name, birthDate, address, gender) values ('Saunders Baldrick', '1997-03-10', 'Houston', 'Male');
insert into STUDENT (name, birthDate, address, gender) values ('Nikoletta O''Codihie', '2014-10-26', 'Salavat', 'Male');
insert into STUDENT (name, birthDate, address, gender) values ('Brew Gawen', '1998-05-17', 'Solnechnogorsk', 'Male');
insert into STUDENT (name, birthDate, address, gender) values ('Grier Saynor', '2007-12-14', 'Burtunay', 'Male');
insert into STUDENT (name, birthDate, address, gender) values ('Dinnie Arias', '2021-07-21', 'Rada Tilly', 'Female');
insert into STUDENT (name, birthDate, address, gender) values ('Michal Routhorn', '1995-12-07', 'Ilyich', 'Female');
insert into STUDENT (name, birthDate, address, gender) values ('Rik Prince', '1997-11-16', 'Sobral', 'Male');
