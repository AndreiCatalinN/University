
isa(sam, seal).
isa(seal, seacreature).
isa(penguin, seacreature).
isa(bob, penguin).
isa(opus, penguin).
isa(tweety, canary).
isa(ken, canary).
isa(penguin, bird).
isa(canary, bird).

hasfeature(canary, flys).
hasfeature(bird, feathers).
hasfeature(bird, wings).
hasfeature(seacreature, swims).
hasfeature(penguin, walks).

species(X, Y):-
  isa(X, Z),
  isa(Y, Z),
    X \= Y.

hasproperty(X,Y):-
  % base case
  isa(X, Z),
  hasfeature(Z, Y);
  % recursion
  isa(X, Z),
  hasproperty(Z, Y).

  % tests
  % isa(bob, penguin).
  % species(bob, opus).
  % species(bob, tweety).
  % hasproperty(bob, X).
  % hasproperty(ken, X).
