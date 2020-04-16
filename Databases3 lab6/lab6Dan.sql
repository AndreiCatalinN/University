/* Golf DB 1 and DB 2*/
drop table results1;
drop table results2;
drop table players1;
drop table players2;
drop table team1;
drop table team2;
drop table tournament1;
drop table tournament2;

select * from team1;
select * from team2;
select * from players1;
select * from players2;
select * from tournament1;
select * from tournament2;
select * from results1;
select * from results2;


SELECT DATEPART(DAY, CURRENT_TIMESTAMP) from sys.dual;

	
EXTRACT(DAY FROM date);







Create Table Team1(
Team_id integer primary key,
Team_name varchar(100)
);

Create Table Team2(
Team_id integer primary key,
Team_name varchar(100)
);

Create Table Players1(
p_id integer primary key,
p_name varchar(50),
p_sname varchar(50),
team_id integer,
constraint fk_team_1 foreign key (team_id) references team1
);

Create Table Players2(
p_id integer primary key,
p_name varchar(50),
p_sname varchar(50),
team_id integer,
constraint fk_team_2 foreign key (team_id) references team2
);

Create Table Tournament1(
T_id integer primary key,
t_descriprion varchar(100),
t_date date,
Total_price float
);

Create Table Tournament2(
T_id integer primary key,
t_descriprion varchar(100),
t_date date,
Total_price float
);

Create Table Results1(
t_id integer,
p_id integer,
rank integer,
price float,
CONSTRAINT  FK_player1 FOREIGN KEY (p_id) REFERENCES players1,
CONSTRAINT  FK_tournament1 FOREIGN KEY (t_id) REFERENCES tournament1,
CONSTRAINT PK_Results1 PRIMARY KEY (t_id,p_id)
);

Create Table Results2(
t_id integer,
p_id integer,
rank integer,
price float,
CONSTRAINT  FK_player2 FOREIGN KEY (p_id) REFERENCES players2,
CONSTRAINT  FK_tournament2 FOREIGN KEY (t_id) REFERENCES tournament2,
CONSTRAINT PK_Results2 PRIMARY KEY (t_id,p_id)
);

/* END ER DIAGRAM */


/* data */
INSERT INTO TEAM1 (TEAM_ID, TEAM_NAME) VALUES (1, 'USA');
INSERT INTO TEAM1 (TEAM_ID, TEAM_NAME) VALUES (2, 'AUSTRALIA');
INSERT INTO TEAM1 (TEAM_ID, TEAM_NAME) VALUES (3, 'UK');
INSERT INTO TEAM1 (TEAM_ID, TEAM_NAME) VALUES (4, 'IRELAND');

INSERT INTO TEAM2 (TEAM_ID, TEAM_NAME) VALUES (1, 'UK');
INSERT INTO TEAM2 (TEAM_ID, TEAM_NAME) VALUES (2, 'IRELAND');
INSERT INTO TEAM2 (TEAM_ID, TEAM_NAME) VALUES (3, 'USA');
INSERT INTO TEAM2 (TEAM_ID, TEAM_NAME) VALUES (4, 'ITALY');



INSERT INTO PLAYERS1 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (1, 'Tiger', 'Woods', 1);
INSERT INTO PLAYERS1 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (2, 'Mary', 'Smith', 2);
INSERT INTO PLAYERS1 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (3, 'Mark', 'Deegan', 2);
INSERT INTO PLAYERS1 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (4, 'James', 'Bryan', 3);
INSERT INTO PLAYERS1 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (5, 'John', 'McDonald', 1);
INSERT INTO PLAYERS1 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (6, 'Mario', 'Baggio', 1);

INSERT INTO PLAYERS2 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (2, 'Tiger', 'Woods', 3);
INSERT INTO PLAYERS2 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (1, 'John', 'McDonald', 3);
INSERT INTO PLAYERS2 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (3, 'Jim', 'Burke', 3);
INSERT INTO PLAYERS2 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (4, 'Paul', 'Bin', 3);
INSERT INTO PLAYERS2 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (5, 'Peter', 'Flynn', 3);
INSERT INTO PLAYERS2 (P_ID, P_NAME, P_SNAME, TEAM_ID) VALUES (6, 'Martha', 'Ross', 4);


INSERT INTO TOURNAMENT1 (T_ID, T_DESCRIPRION, TOTAL_PRICE,t_date) VALUES (1, 'US Open', 1700000,'01-jan-2014');
INSERT INTO TOURNAMENT1 (T_ID, T_DESCRIPRION, TOTAL_PRICE,t_date) VALUES (2, 'British Open', 7000000,'01-apr-2014');
INSERT INTO TOURNAMENT1 (T_ID, T_DESCRIPRION, TOTAL_PRICE,t_date) VALUES (3, 'Italian Open', 2000000,'11-mar-2014');
INSERT INTO TOURNAMENT1 (T_ID, T_DESCRIPRION, TOTAL_PRICE,t_date) VALUES (4, 'Irish Open', 300000,'21-jul-2014');

INSERT INTO TOURNAMENT2 (T_ID, T_DESCRIPRION, TOTAL_PRICE,t_date) VALUES (1, 'Dutch Open', 1700000,'22-nov-2014');
INSERT INTO TOURNAMENT2 (T_ID, T_DESCRIPRION, TOTAL_PRICE,t_date) VALUES (2, 'French Open', 7000000,'17-dec-2014');
INSERT INTO TOURNAMENT2 (T_ID, T_DESCRIPRION, TOTAL_PRICE,t_date) VALUES (3, 'Spanish Open', 2000000,'03-mar-2014');
INSERT INTO TOURNAMENT2 (T_ID, T_DESCRIPRION, TOTAL_PRICE,t_date) VALUES (4, 'Chiinese Open', 300000,'15-jul-2014');
INSERT INTO TOURNAMENT2 (T_ID, T_DESCRIPRION, TOTAL_PRICE,t_date) VALUES (5, 'Dubai Open', 600000,'10-aug-2014');
INSERT INTO TOURNAMENT2 (T_ID, T_DESCRIPRION, TOTAL_PRICE,t_date) VALUES (6, 'US Master', 1000000,'10-jul-2014');


INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (1, 1, 1, 10000);
INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (1, 2, 2, 20000);
INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (2, 2, 4, 1000);
INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (3, 2, 3, 10000);
INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (3, 1, 2, 1100);
INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (4, 6, 3, 6000);
INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (4, 2, 2, 9000);
INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (4, 1, 1, 10000);
INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (3, 5, 2, 9500);
INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (4, 5, 4, 10000);
INSERT INTO RESULTS1 (T_ID, P_ID, RANK, PRICE) VALUES (2, 5, 7, 100);

INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (1, 1, 1, 1000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (1, 2, 3, 2000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (2, 2, 1, 6000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (3, 2, 3, 17000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (3, 1, 12, 1100);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (4, 6, 10, 8000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (4, 2, 2, 12000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (4, 1, 3, 10000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (3, 5, 1, 9000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (4, 5, 5, 1000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (2, 5, 3, 1000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (5, 5, 3, 8000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (5, 2, 2, 16000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (5, 1, 1, 20000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (6, 1, 3, 2000);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (6, 5, 2, 9400);
INSERT INTO RESULTS2 (T_ID, P_ID, RANK, PRICE) VALUES (6, 4, 1, 12000);



/*
1 euro = 1.3 $
1. Create an SQL script to create the following dimensional
model 
*/

Create Table team_dim(
team_sk integer primary key,
team_name varchar(100)
);

Create Table tournament_dim(
tournament_sk integer primary key,
tournament_desc varchar(100),
total_price float
);


Create Table date_dim(
date_sk integer primary key,
day integer,
week integer,
month integer,
quarter integer,
year integer,
day_of_week integer
);


create table fact_table(
player_sk integer,
team_sk integer,
tournament_sk integer,
date_sk integer,
rank integer,
price integer,
FOREIGN KEY (player_sk) REFERENCES player_dim(player_sk),
FOREIGN KEY (team_sk) REFERENCES team_dim(team_sk),
FOREIGN KEY (tournament_sk) REFERENCES tournament_dim(tournament_sk),
FOREIGN KEY (date_sk) REFERENCES date_dim(date_sk)
);

drop sequence seq_player;
CREATE SEQUENCE  seq_player
MINVALUE 1
START WITH 1
INCREMENT BY 1;

drop sequence seq_team;
CREATE SEQUENCE seq_team
MINVALUE 1
START WITH 1
INCREMENT BY 1;

drop sequence seq_tournament;
CREATE SEQUENCE seq_tournament
MINVALUE 1
START WITH 1
INCREMENT BY 1;

drop sequence seq_date;
CREATE SEQUENCE seq_date
MINVALUE 1
START WITH 1
INCREMENT BY 1;

/*staging*/

drop table player_stage;
drop table temp;
Create Table player_stage(
player_id integer,
player_name varchar(100),
db_source integer,
player_sk integer
);

-- insert player1    
insert into player_stage(player_id, player_name) 
select p_id, p_name || ' ' || p_sname from players1;
update player_stage set db_source=1;

-- insert player2
insert into player_stage(player_id, player_name) 
select p_id, p_name || ' ' || p_sname from players2;
update player_stage set db_source=2
where db_source is null;


create table temp as
select player_id,player_name,db_source, Dense_rank() Over(order by player_name) as p_sk from player_stage ;

select * from temp;


-- delete all the duplicates
DELETE FROM
  temp
WHERE
  rowid NOT IN
  (
    SELECT
      min(rowid)
    FROM
      temp
    GROUP BY
      player_name,
      p_sk);
drop table player_dim;

select * from player_dim;

create table player_dim as 
select player_name, p_sk from temp;


Create Table player_dim(
player_sk integer primary key,
player_name varchar(100)
);
delete from temp
where  player_name in (
   select min(player_name) from temp
    group by(player_name)
    having count(player_name) > 1
);

drop table team_stage;
Create Table team_stage(
team_id integer,
team_name varchar(100),
db_source integer,
sk integer,
PRIMARY KEY (team_id, db_source)
);

drop table tournament_stage;
Create Table tournament_stage(
tournament_id integer,
tournament_description varchar(100),
tournament_price integer,
db_source integer,
sk integer,
PRIMARY KEY (tournament_id, db_source)
);


--declare
--    count_players1 integer;
--    count_players2 integer;
--    count_team1 integer;
--    count_team2 integer;
--    count_tournament1 integer;
--    count_tournament2 integer;
--    i integer;
--    duplicate_names varchar2(100);
--begin
----    select count(*) into count_players1 from players1;
----    select count(*) into count_players2 from players2;
----    select count(*) into count_team1 from team1;
----    select count(*) into count_team2 from team2;
----    select count(*) into count_tournament1 from tournament1;
----    select count(*) into count_tournament2 from tournament2;

-- insert player1    
insert into player_stage(player_id, player_name,player_sk) 
select p_id, p_name || ' ' || p_sname,Dense_rank() Over(order by player_name) from players1;
update player_stage set db_source=1;

-- insert player2
insert into player_stage(player_id, player_name) 
select p_id, p_name || ' ' || p_sname from players2;
update player_stage set db_source=2
where db_source is null;
--end;
--/


-- insert player
insert into player_stage(player_id, player_name) 
select p_id, p_name || ' ' || p_sname from players1;
update player_stage set db_source=1;

-- insert player2
insert into player_stage(player_id, player_name) 
select p_id, p_name || ' ' || p_sname from players2;
update player_stage set db_source=2
where db_source is null;

update player_stage set sk=seq_player.nextval
where player_name in 
    (select player_name from player_stage
    group by(player_name)
    having count(player_name) > 1);


select * from player_stage;



select * from temp;
select player_id,player_name,db_source, Dense_rank() Over(order by player_name) as p_sk from player_stage;

create table temp as
select player_id,player_name,db_source, Dense_rank() Over(order by player_name) as p_sk from player_stage ;

drop table temp;
insert into temp values(
select player_id,player_name,db_source, Dense_rank() Over(order by player_name) as p_sk from player_stage);

