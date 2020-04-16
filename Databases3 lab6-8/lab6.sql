/*dimensional model---------------------------------------------------*/
DROP TABLE fact_table;

DROP TABLE player_dim;

DROP TABLE team_dim;

DROP TABLE tournament_dim;

DROP TABLE date_dim;

CREATE TABLE player_dim
  (
     player_sk   INTEGER PRIMARY KEY,
     player_name VARCHAR(100)
  );

CREATE TABLE team_dim
  (
     team_sk   INTEGER PRIMARY KEY,
     team_name VARCHAR(100)
  );

CREATE TABLE tournament_dim
  (
     tournament_sk   INTEGER PRIMARY KEY,
     tournament_desc VARCHAR(100),
     total_price     FLOAT
  );

CREATE TABLE date_dim
  (
     date_sk     INTEGER PRIMARY KEY,
     day         INTEGER,
     week        INTEGER,
     month       INTEGER,
     quarter     INTEGER,
     year        INTEGER,
     day_of_week INTEGER
  );

CREATE TABLE fact_table
  (
     player_sk     INTEGER,
     team_sk       INTEGER,
     tournament_sk INTEGER,
     date_sk       INTEGER,
     rank          INTEGER,
     price         INTEGER,
     FOREIGN KEY (player_sk) REFERENCES player_dim(player_sk),
     FOREIGN KEY (team_sk) REFERENCES team_dim(team_sk),
     FOREIGN KEY (tournament_sk) REFERENCES tournament_dim(tournament_sk),
     FOREIGN KEY (date_sk) REFERENCES date_dim(date_sk)
  );


/*staging----------------------------------------------------------------*/
DROP TABLE player_stage;

DROP TABLE team_stage;

DROP TABLE tournament_stage;

DROP TABLE date_stage;

DROP TABLE fact_stage;

CREATE TABLE player_stage
  (
     player_id   INTEGER,
     player_name VARCHAR(100),
     team_id     INTEGER,
     db_source   INTEGER,
     sk          INTEGER
  );

CREATE TABLE team_stage
  (
     team_id   INTEGER,
     team_name VARCHAR(100),
     db_source INTEGER,
     sk        INTEGER
  );

CREATE TABLE tournament_stage
  (
     t_id          INTEGER,
     t_description VARCHAR(100),
     t_date        DATE,
     t_price       INTEGER,
     db_source     INTEGER,
     sk            INTEGER
  );

CREATE TABLE date_stage
  (
     day         INTEGER,
     month       INTEGER,
     year        INTEGER,
     week        INTEGER,
     quarter     INTEGER,
     day_of_week INTEGER,
     db_source   INTEGER,
     sk          INTEGER
  );

CREATE TABLE fact_stage
  (
     p_id          INTEGER,
     t_id          INTEGER,
     rank          INTEGER,
     price         INTEGER,
     db_source     INTEGER,
     player_sk     INTEGER,
     team_sk       INTEGER,
     tournament_sk INTEGER,
     date_sk       INTEGER
  );

-- Create player stage   -----------------------------------------------------
-- insert player1
INSERT INTO player_stage
            (player_id,
             player_name,
             team_id)
SELECT p_id,
       p_name
       || ' '
       || p_sname,
       team_id
FROM   players1;

UPDATE player_stage
SET    db_source = 1;

-- insert player2
INSERT INTO player_stage
            (player_id,
             player_name,
             team_id)
SELECT p_id,
       p_name
       || ' '
       || p_sname,
       team_id
FROM   players2;

UPDATE player_stage
SET    db_source = 2
WHERE  db_source IS NULL;

CREATE TABLE temp AS
  SELECT player_id,
         player_name,
         team_id,
         db_source,
         Dense_rank()
           over (
             ORDER BY player_name) SK
  FROM   player_stage;

DROP TABLE player_stage;

CREATE TABLE player_stage AS
  SELECT *
  FROM   temp;

DROP TABLE temp;

--create team stage  -----------------------------------------------------
-- insert team1
INSERT INTO team_stage
            (team_id,
             team_name)
SELECT team_id,
       team_name
FROM   team1;

UPDATE team_stage
SET    db_source = 1;

-- insert team2
INSERT INTO team_stage
            (team_id,
             team_name)
SELECT team_id,
       team_name
FROM   team2;

UPDATE team_stage
SET    db_source = 2
WHERE  db_source IS NULL;

CREATE TABLE temp AS
  SELECT team_id,
         team_name,
         db_source,
         Dense_rank()
           over (
             ORDER BY team_name) SK
  FROM   team_stage;

DROP TABLE team_stage;

CREATE TABLE team_stage AS
  SELECT * 
  FROM   temp;

DROP TABLE temp;

--create tournament stage  -----------------------------------------------------
-- insert tournament1
INSERT INTO tournament_stage
            (t_id,
             t_description,
             t_date,
             t_price)
SELECT t_id,
       t_description,
       t_date,
       total_price
FROM   tournament1;

UPDATE tournament_stage
SET    db_source = 1;

-- insert tournament2
INSERT INTO tournament_stage
            (t_id,
             t_description,
             t_date,
             t_price)
SELECT t_id,
       t_description,
       t_date,
       1.3 * total_price
FROM   tournament2;

UPDATE tournament_stage
SET    db_source = 2
WHERE  db_source IS NULL;

CREATE TABLE temp AS
  SELECT t_id,
         t_description,
         t_date,
         t_price,
         db_source,
         Dense_rank()
           over (
             ORDER BY t_description) SK
  FROM   tournament_stage;

DROP TABLE tournament_stage;

CREATE TABLE tournament_stage AS
  SELECT *
  FROM   temp;

DROP TABLE temp;

UPDATE tournament_stage
SET    t_description = 'Chinese Open'
WHERE  t_description LIKE 'Chiinese Open';

-- date stage -----------------------------------------------------
INSERT INTO date_stage
            (day,
             month,
             year,
             week,
             quarter,
             day_of_week)
SELECT Cast(To_char(t_date, 'DD') AS INTEGER)   AS day,
       Cast(To_char(t_date, 'MM') AS INTEGER)   AS month,
       Cast(To_char(t_date, 'YYYY') AS INTEGER) AS year,
       Cast(To_char(t_date, 'WW') AS INTEGER)   AS week,
       Cast(To_char(t_date, 'Q') AS INTEGER)    AS quarter,
       Cast(To_char(t_date, 'D') AS INTEGER)    AS day_of_week
FROM   tournament1;

UPDATE date_stage
SET    db_source = 1;

INSERT INTO date_stage
            (day,
             month,
             year,
             week,
             quarter,
             day_of_week)
SELECT Cast(To_char(t_date, 'DD') AS INTEGER)   AS day,
       Cast(To_char(t_date, 'MM') AS INTEGER)   AS month,
       Cast(To_char(t_date, 'YYYY') AS INTEGER) AS year,
       Cast(To_char(t_date, 'WW') AS INTEGER)   AS week,
       Cast(To_char(t_date, 'Q') AS INTEGER)    AS quarter,
       Cast(To_char(t_date, 'D') AS INTEGER)    AS day_of_week
FROM   tournament2;

UPDATE date_stage
SET    db_source = 2
WHERE  db_source IS NULL;

DROP SEQUENCE seq_date;

CREATE SEQUENCE seq_date
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1;

UPDATE date_stage
SET    sk = seq_date.NEXTVAL;

-- fact stage ----------------------------------------------------
-- insert results 1
INSERT INTO fact_stage
            (p_id,
             t_id,
             rank,
             price,
             player_sk,
             tournament_sk,
             date_sk,
             team_sk)
SELECT r1.p_id,
       r1.t_id,
       r1.rank,
       r1.price,
       player.sk,
       tournament.sk,
       date_stage.sk,
       team.sk
FROM   results1 r1
       join player_stage player
         ON r1.p_id = player.player_id
            AND player.db_source = 1
       join tournament_stage tournament
         ON r1.t_id = tournament.t_id
            AND tournament.db_source = 1
       join date_stage
         ON date_stage.year = Cast(To_char(tournament.t_date, 'YYYY') AS INTEGER
                              )
            AND date_stage.month = Cast(To_char(tournament.t_date, 'MM') AS
                                        INTEGER)
            AND date_stage.day = Cast(To_char(tournament.t_date, 'DD') AS
                                      INTEGER)
            AND date_stage.db_source = 1
       join team_stage team
         ON player.team_id = team.team_id
            AND team.db_source = 1;

UPDATE fact_stage
SET    db_source = 1;

-- insert results2
INSERT INTO fact_stage
            (p_id,
             t_id,
             rank,
             price,
             player_sk,
             tournament_sk,
             date_sk,
             team_sk)
SELECT r2.p_id,
       r2.t_id,
       r2.rank,
       1.3 * r2.price,
       player.sk,
       tournament.sk,
       date_stage.sk,
       team.sk
FROM   results2 r2
       join player_stage player
         ON r2.p_id = player.player_id
            AND player.db_source = 2
       join tournament_stage tournament
         ON r2.t_id = tournament.t_id
            AND tournament.db_source = 2
       join date_stage
         ON date_stage.year = Cast(To_char(tournament.t_date, 'YYYY') AS INTEGER
                              )
            AND date_stage.month = Cast(To_char(tournament.t_date, 'MM') AS
                                        INTEGER)
            AND date_stage.day = Cast(To_char(tournament.t_date, 'DD') AS
                                      INTEGER)
            AND date_stage.db_source = 2
       join team_stage team
         ON player.team_id = team.team_id
            AND team.db_source = 2;

UPDATE fact_stage
SET    db_source = 2
WHERE  db_source IS NULL;

SELECT *
FROM   fact_stage;

--  add to dimensional model --------------------------------------------------
INSERT INTO player_dim
            (player_sk,
             player_name)
SELECT DISTINCT sk,
                player_name
FROM   player_stage
ORDER  BY sk;

INSERT INTO team_dim
            (team_sk,
             team_name)
SELECT DISTINCT sk,
                team_name
FROM   team_stage
ORDER  BY sk;

INSERT INTO tournament_dim
            (tournament_sk,
             tournament_desc,
             total_price)
SELECT DISTINCT sk,
                t_description,
                t_price
FROM   tournament_stage
ORDER  BY sk;

INSERT INTO date_dim
            (date_sk,
             day,
             month,
             year,
             week,
             quarter,
             day_of_week)
SELECT DISTINCT sk,
                day,
                month,
                year,
                week,
                quarter,
                day_of_week
FROM   date_stage
ORDER  BY sk;

INSERT INTO fact_table
            (player_sk,
             team_sk,
             tournament_sk,
             date_sk,
             rank,
             price)
SELECT player_sk,
       team_sk,
       tournament_sk,
       date_sk,
       rank,
       price
FROM   fact_stage;

select * from player_dim;
select * from team_dim;
select * from tournament_dim;
select * from date_dim;
select * from fact_table;

/*next batch*/

insert into players1 values (7, 'Alan', 'Parker', 1);
insert into players1 values (8, 'Martha', 'Bag', 2);

insert into tournament1(t_id, t_description, total_price)
values (5, 'Saudi Open', 500000);

insert into results1(t_id, p_id, rank, price)
values (5, 1, 1, 60000);
insert into results1(t_id, p_id, rank, price)
values (5, 7, 5, 20000);
insert into results1(t_id, p_id, rank, price)
values (2, 8, 3, 1000);
