/*
path to my mongo file
load('S:\\Scoala\\Facultate\\Anul 4\\advanced databases\\labs\\lab8\\mongo.js')
db.c16733435_teams.drop()
db.c16733435_teams.find().pretty()
*/
/*
1. create  a collections called your_student_id_teams
and insert the documents about teams and football
players contained in this file
*/
var teams = [
  {
    team_id: "eng1",
    date_founded: new Date("Oct 04, 1896"),
    league: "Premier League",
    points: 62,
    name: "Manchester United",
    players: [
      { p_id: "Rooney", goal: 85, caps: 125, age: 28 },
      { p_id: "Scholes", goal: 15, caps: 225, age: 28 },
      { p_id: "Giggs", goal: 45, caps: 359, age: 38 }
    ]
  },

  {
    team_id: "eng2",
    date_founded: new Date("Oct 04, 1899"),
    league: "Premier League",
    points: 52,
    name: "Arsenal",
    players: [
      { p_id: "Mata", goal: 5, caps: 24, age: 27 },
      { p_id: "Bergkamp", goal: 95, caps: 98, age: 48 }
    ]
  },
  {
    team_id: "eng3",
    date_founded: new Date("Oct 04, 1912"),
    league: "Premier League",
    points: 65,
    name: "Chelsea",
    players: [
      { p_id: "Costa", goal: 15, caps: 25, age: 28 },
      { p_id: "Ivanov", goal: 5, caps: 84, age: 28 },
      { p_id: "Drogba", goal: 105, caps: 125, age: 35 }
    ]
  },
  {
    team_id: "spa1",
    date_founded: new Date("Oct 04, 1912"),
    league: "La Liga",
    points: 80,
    name: "Barcelona",
    players: [
      { p_id: "Messi", goal: 195, caps: 189, age: 30 },
      { p_id: "Valdes", goal: 0, caps: 158, age: 27 },
      { p_id: "Iniesta", goal: 72, caps: 25, age: 31 },
      { p_id: "Pique", goal: 9, caps: 201, age: 38 }
    ]
  },
  {
    team_id: "spa2",
    date_founded: new Date("Nov 04, 1914"),
    league: "La Liga",
    points: 72,
    name: "Real Madrid",
    players: [
      { p_id: "Ronaldo", goal: 135, caps: 134, age: 28 },
      { p_id: "Bale", goal: 75, caps: 45, age: 27 },
      { p_id: "Marcelo", goal: 11, caps: 25, age: 31 },
      { p_id: "Benzema", goal: 125, caps: 95, age: 22 }
    ]
  },
  {
    team_id: "spa3",
    date_founded: new Date("Oct 04, 1912"),
    league: "La liga",
    points: 68,
    name: "Valencia",
    players: [
      { p_id: "Martinez", goal: 26, caps: 54, age: 21 },
      { p_id: "Aimar", goal: 45, caps: 105, age: 29 }
    ]
  },
  {
    team_id: "ita1",
    date_founded: new Date("Oct 04, 1922"),
    league: "Serie A",
    points: 69,
    name: "Roma",
    players: [
      { p_id: "Totti", goal: 198, caps: 350, age: 35 },
      { p_id: "De Rossi", goal: 5, caps: 210, age: 30 },
      { p_id: "Gervinho", goal: 43, caps: 57, age: 24 }
    ]
  },
  {
    team_id: "ita2",
    date_founded: new Date("Oct 04, 1899"),
    league: "Serie A",
    points: 52,
    name: "Juventus",
    players: [
      { p_id: "Buffon", goal: 0, caps: 225, age: 37 },
      { p_id: "Pirlo", goal: 45, caps: 199, age: 35 },
      { p_id: "Pogba", goal: 21, caps: 42, age: 20 }
    ]
  },
  {
    team_id: "ita3",
    date_founded: new Date("Oct 04, 1911"),
    league: "Serie A",
    points: 62,
    name: "AC Milan",
    players: [
      { p_id: "Inzaghi", goal: 115, caps: 189, age: 35 },
      { p_id: "Abbiati", goal: 0, caps: 84, age: 24 },
      { p_id: "Van Basten", goal: 123, caps: 104, age: 35 }
    ]
  },
  {
    team_id: "ita4",
    date_founded: new Date("Oct 04, 1902"),
    league: "Serie A",
    points: 71,
    name: "Inter Milan",
    players: [
      { p_id: "Handanovic", goal: 0, caps: 51, age: 29 },
      { p_id: "Cambiasso", goal: 35, caps: 176, age: 35 },
      { p_id: "Palacio", goal: 78, caps: 75, age: 31 }
    ]
  }
];

var data = db.c16733435_teams.insert(teams);

//print the output of the queries on the server
function result(res) {
  print(tojson(res));
}

print(tojson("1 print all the data in the c16733435_teams"));
db.c16733435_teams
  .find()
  .pretty()
  .forEach(result);

/* 2. insert two new players
    - add a player to the Man. Utd. team.
    Player id:  Keane, 44 yers old, 326 caps, 33 goals.
    - add a player to the AC Milan team.
    Player id:  Kaka, 32 yers old, 112 caps, 53 goals.
*/
print(tojson("2 insert two new players"));
var new_player1 = { p_id: "keane", goal: 33, caps: 326, age: 44 };
var new_player2 = { p_id: "kaka", goal: 53, caps: 112, age: 32 };

db.c16733435_teams.update(
  { name: "Manchester United" },
  { $push: { players: new_player1 } }
);
db.c16733435_teams.update(
  { name: "AC Milan" },
  { $push: { players: new_player2 } }
);

//display new players
db.c16733435_teams
  .find({ name: "Manchester United" })
  .pretty()
  .forEach(result);
db.c16733435_teams
  .find({ name: "AC Milan" })
  .pretty()
  .forEach(result);

//3. find oldest team
print(tojson("3 find oldest team"));
db.c16733435_teams
  .find()
  .sort({ date_founded: 1 })
  .limit(1)
  .pretty()
  .forEach(result);

//4 update Real Madrid players goals by 3
print(tojson("4 update all goals for each player by 3 for Real Madrid"));

db.c16733435_teams.update(
  { name: "Real Madrid" },
  { $inc: { "players.$[].goal": 3 } }
);
db.c16733435_teams.find({ name: "Real Madrid" }).forEach(result);

//6. update the points of Arsenal to be equal to the point of Barcelona
print(
  tojson("6 update the points of Arsenal to be equal to the point of Barcelona")
);
db.c16733435_teams.find({ name: "Barcelona" }).forEach(function(element1) {
  var points = element1.points;
  print(element1.points);
  db.c16733435_teams.update({ name: "Arsenal" }, { $set: { points: points } });
});

db.c16733435_teams
  .find({ name: "Arsenal" })
  .pretty()
  .forEach(result);
db.c16733435_teams
  .find({ name: "Barcelona" })
  .pretty()
  .forEach(result);

//8. list the total point by league
print(tojson("8 list the total point by league"));
cursor = db.c16733435_teams
  .aggregate([
    { $unwind: "$league" },
    { $group: { _id: "$league", sum: { $sum: "$points" } } }
  ])
  .forEach(result);
