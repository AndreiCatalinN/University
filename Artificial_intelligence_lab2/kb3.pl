father(albert,james).
father(james,harry).
father(vernon, dudley).
father(charlie,hermione).
mother(alexa,hermione).
mother(ruth,james).
mother(lili,harry).
mother(petunia, dudley).

wizard(lili).
wizard(ruth).
wizard(albert).

%% X is a wizard if both X's mother and father are wizzards
% wizard(X) :-
% 	father(Y,X),
% 	wizard(Y),
% 	mother(Z,X),
% 	wizard(Z).

wizard(X) :-
	father(Y,X),
	wizard(Y);
	mother(Z,X),
	wizard(Z).

muggle(vernon).
muggle(petunia).
muggle(alexa).
muggle(charlie).

muggle(X) :-
	father(Y,X),
	muggle(Y),
	mother(Z,X),
	muggle(Z).
