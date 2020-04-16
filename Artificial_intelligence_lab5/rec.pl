path(a, b).
path(b, c).
path(c, d).
path(d, e).
path(a, d).

has_service(c, pub).
has_service(e, hospital).


can_get(X, Y):-
  path(X, Y);
  path(X, Z),can_get(Z, Y).

has_access(X, Y):-
  has_service(X, Y);
  can_get(X, Z), has_service(Z, Y).

is_in(jane, ella).
is_in(ella, dora).
is_in(dora, cathy).
is_in(cathy, bella).
is_in(bella, anna).

contains(X, Y):-
  is_in(Y, X);
  is_in(Y, Z), contains(X,Z).
