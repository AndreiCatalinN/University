drop table player_dim;
drop table team_dim;
drop table tournament_dim;
drop table date_dim;
drop table fact_table;

Create Table player_dim(
team_sk integer primary key,
team_name varchar(100)
);

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