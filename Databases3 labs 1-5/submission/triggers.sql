drop table matches;
drop table teams;
drop table euroleague;
drop table logteam;
drop sequence seq_match;

create table teams(
team_name varchar2(50) primary key,
team_country varchar2(50),
CONSTRAINT CHK_country CHECK
(team_country in ('England','Spain'))
);

CREATE SEQUENCE seq_match
MINVALUE 1
START WITH 1
INCREMENT BY 1;


create table Matches(
match_id number(5) primary key ,
teamA_name varchar2(50),
teamB_name varchar2(50),
Goal_A NUMBER(2) default 0,
Goal_B NUMBER(2) default 0,
Competition varchar2(50),
FOREIGN KEY(teamA_name) REFERENCES teams(team_name),
FOREIGN KEY(teamB_name) REFERENCES teams(team_name),
CONSTRAINT CHK_goals CHECK(goal_A >= 0 and goal_B >=0 ),
CONSTRAINT CHK_Competition CHECK 
(Competition in ('Champions League','Europa League',
                    'Premier League', 'La Liga'))
);

create table EuroLeague(
team_name varchar2(50) primary key,
points NUMBER(2),
goals_scored NUMBER(2),
goals_conceded NUMBER(2),
difference NUMBER(2)
);

create table logteam(
timestamp DATE
);

/*
a) Using a trigger, log into a table LOGTEAM the 
timestamps of all the insertions in the table TEAMS.
b) Create a trigger that, every time a new team is 
inserted in the table TEAMS, inserts the name of the
team in the EUROLEAGUE table if the team is not already
there. Set points and goals to zero. You can extend 
trigger at point a) instead of creating a new trigger.
*/
create or replace trigger team_timestamps after insert on teams
for each row
begin
    insert into logteam values(sysdate);
    insert into euroleague values(:new.team_name,0,0,0,0);
end;
/

insert into teams values('Arsenal','England');
insert into teams values('Manchester United','England');
insert into teams values('Chelsea','England');
insert into teams values('Everton','England');
insert into teams values('Barcelona','Spain');
insert into teams values('Real Madrid','Spain');
insert into teams values('Atletico Madrid','Spain');
insert into teams values('Sevilla','Spain');
commit;
/*
c) Using a trigger, check that, if a match has 
Premier League or La Liga for competition, the
country of the two teams is correct (both England 
for Premier League and both Spain for La Liga). If not, 
the match cannot be inserted into the table MATCHES.
*/
create or replace trigger check_match_competition 
before insert on matches
for each row
declare 
    newA varchar2(50);
    newB varchar2(50);
    team_a_country varchar2(50);
    team_b_country varchar2(50);
    competition varchar(50);
begin
    select :new.teama_name into newA from dual;
    select :new.teamb_name into newB from dual;
    
    select team_country into team_a_country from teams
    where newA like team_name;
    
    select team_country into team_B_country from teams
    where newB like team_name;
    
    select :new.competition into competition from dual;
    
    if competition like 'La Liga' and
        (team_a_country != 'Spain' or
        team_b_country != 'Spain')
    then
        Raise_application_error(-20001, 
        'The insert is not possible. Both teams have to be from Spain for La Liga matches');              
    end if;
    
    if competition like 'Premier League' and
        (team_a_country != 'England' or
        team_b_country != 'England')
    then
        Raise_application_error(-20002, 
        'The insert is not possible. Both teams have to be from Englang for Premier League matches');              
    end if;
end;
/

/* 
d) Using a trigger, check that a team has no more 
than 4 matches in the table MATCHES.
*/
create or replace trigger trigger_check_no_of_matches 
before insert or update on matches
for each row
declare
    count_matches_a integer;
    count_matches_b integer;
begin
    select count(*) into count_matches_a from matches
    where :new.teama_name like teama_name or
          :new.teama_name like teamb_name;
          
    select count(*) into count_matches_b from matches
    where :new.teamb_name like teama_name or
          :new.teamb_name like teamb_name;
    
    if count_matches_a > 3 then
        Raise_application_error(-20003, 
        'No more matches can be added. ' || :new.teama_name
        || 'has 4 matches already.');  
    end if;
    if count_matches_b > 3 then
        Raise_application_error(-20004, 
        'No more matches can be added. ' || :new.teamb_name
        || 'has 4 matches already.');  
    end if;
end;
/

/*
e) Using a trigger (you can extend trigger d ),
update the EUROLEAGUE table by adding three points
to the winning team, 1 point to each team in case 
of a draw, and by updating goals scored, conceded 
and the goal difference. Note that the league table
is for all the teams and competitions
*/
create or replace trigger trigger_update_euro_league
after insert or update on matches
for each row
declare
    teamA varchar2(50);
    teamB varchar2(50);
begin
    select :new.teamA_name into teama from dual;
    select :new.teamb_name into teamb from dual;
    
    -- goals scored, conceded, difference
    update euroleague set 
    goals_scored= goals_scored+ :new.goal_A,
    goals_conceded= goals_conceded+ :new.goal_B,
    difference = goals_scored - goals_conceded
    where team_name = teamA;
    
    update euroleague set 
    goals_scored= goals_scored+ :new.goal_B,
    goals_conceded= goals_conceded+ :new.goal_A,
    difference = goals_scored - goals_conceded
    where team_name = teamB;
    
    -- points
    if :new.goal_A > :new.goal_B then
        update euroleague set points= points+3
        where team_name = teamA;
    elsif :new.goal_A < :new.goal_B then
        update euroleague set points= points+3
        where team_name = teamB;
    else
        update euroleague set points= points+1
        where team_name = teama;
        update euroleague set points= points+1
        where team_name = teamB;
    end if;
end;
/

insert into matches values
(seq_match.nextval, 'Arsenal', 'Manchester United', 2, 0,'Premier League');

insert into matches values
(seq_match.nextval, 'Arsenal', 'Barcelona', 2, 2,'Champions League');

insert into matches values
(seq_match.nextval, 'Barcelona', 'Arsenal', 2, 3,'Europa League');

insert into matches values
(seq_match.nextval, 'Arsenal', 'Sevilla', 1, 2,'Europa League');

-- is not in the table
insert into matches values
(seq_match.nextval, 'Arsenal', 'Chelsea', 1, 1,'Premier League');

insert into matches values
(seq_match.nextval, 'Real Madrid', 'Sevilla', 3, 2,'La Liga');

insert into matches values
(seq_match.nextval, 'Real Madrid', 'Barcelona', 1, 3,'La Liga');

insert into matches values
(seq_match.nextval, 'Barcelona', 'Real Madrid', 3, 1,'La Liga');

insert into matches values
(seq_match.nextval, 'Sevilla', 'Real Madrid', 2, 4,'La Liga');

-- is not in the table
insert into matches values
(seq_match.nextval, 'Chelsea', 'Real Madrid', 2, 0,'Champions League');
commit;

select teama_name, team_country from matches
join teams on matches.teama_name like teams.team_name;

select * from teams;
select * from logteam;
select * from euroleague;
select * from matches;






