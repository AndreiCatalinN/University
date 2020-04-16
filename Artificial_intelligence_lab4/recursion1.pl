female(helen).
female(ruth).
female(petunia).
female(lili).

male(paul).
male(albert).
male(vernon).
male(james).
male(dudley).
male(harry).

parent_of(paul,petunia).
parent_of(helen,petunia).
parent_of(paul,lili).
parent_of(helen,lili).
parent_of(albert,james).
parent_of(ruth,james).
parent_of(petunia,dudley).
parent_of(vernon,dudley).
parent_of(lili,harry).
parent_of(james,harry).

%paul is an ancestor of harry
ancestor_of(X, Y) :-
  parent_of(X, Y).

ancestor_of(X, Y) :-
  parent_of(X, Z),
  ancestor_of(Z, Y).


% father_of(james, X).
father_of(Father, Child) :-
  male(Father),
  parent_of(Father, Child).

% mother_of(Y, X).
mother_of(Mother, Child) :-
  female(Mother),
  parent_of(Mother, Child).

% grandfather_of(X, Y).
grandfather_of(Grandfather, Child):-
  male(Grandfather),
  parent_of(Grandfather, X),
  parent_of(X, Child).

% grandmother_of(X, Y).
grandmother_of(Grandmother, Child):-
  female(Grandmother),
  parent_of(Grandmother, X),
  parent_of(X, Child).

sibling_of(X, Y) :-
  parent_of(Parent, X),
  parent_of(Parent, Y),
  X \= Y.

aunt_of(Sister, Person) :-
  female(Sister),
  sibling_of(Sister, X),
  parent_of(X, Person).

uncle_of(Brother, Person) :-
  male(Brother),
  sibling_of(Brother, X),
  parent_of(X, Person).

ancestor_of(X,Y) :-
  parent_of(X,Z),
  ancestor_of(Z,Y).


  % 1. aunt_of(X, harry).
  % 2. grandmother_of(X, harry).
  % 2. grandfather_of(X, harry).
  % 3. grandfather_of(paul, X).
  % 3. grandmother_of(helen, X).
  % 4. sibling_of(X, james).
