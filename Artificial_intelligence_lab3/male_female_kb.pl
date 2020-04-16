male(paul).
male(albert).
male(vernon).
male(james).
male(dudley).
male(harry).
female(helen).
female(ruth).
female(petunia).
female(lili).

parent_of(paul, petunia).
parent_of(helen, petunia).
parent_of(paul, lili).
parent_of(helen, lili).

parent_of(vernon, dudley).
parent_of(petunia, dudley).

parent_of(albert,james).
parent_of(ruth,james).

parent_of(james, harry).
parent_of(lili, harry).

father_of(Father, Child) :- male(Father), parent_of(Father,Child).
mother_of(Mother, Child) :- female(Mother), parent_of(Mother,Child).

% grandfather_of(X, harry).
grandfather_of(Grandfather, Child) :-
    father_of(Father, Child),
    father_of(Grandfather, Father);
    mother_of(Mother, Child),
    father_of(Grandfather, Mother).

% grandmother_of(X, harry).
grandmother_of(Grandmother, Child) :-
    mother_of(Mother, Child),
    mother_of(Grandmother, Mother);
    father_of(Father, Child),
    mother_of(Grandmother, Father).

% sister_of(lili, X).
sister_of(Sister, Person) :-
    female(Sister),
    parent_of(X, Sister),
    parent_of(X, Person),
    Sister \= Person.

% aunt_of(X, harry).
aunt_of(Aunt, Child) :-
    parent_of(Parent, Child),
    sister_of(Aunt, Parent).

% uncle_of(X, harry).
uncle_of(Uncle, Child) :-
    aunt_of(Aunt, Child),
    parent_of(Aunt, X),
    parent_of(Uncle, X),
    Aunt \= Uncle.

% 1. aunt_of(X, harry).
% 2. grandmother_of(X, harry).
% 2. grandfather_of(X, harry).
% 3. grandfather_of(paul, X).
% 3. grandmother_of(helen, X).
% 4. sister_of(X, james).
