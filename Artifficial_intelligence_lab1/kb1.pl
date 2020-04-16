
wizard(harry).
wizard(ron).
wizard(hermione).

evilwizard(voldemort).
evilwizard(lestrange).
evilwizard(lucius).

muggle(uncle_vernon).
muggle(aunt_petunia).
muggle(dudley).

chases(crookshanks,scabbards).
chases(Evil, Wiz):- evilwizard(Evil), wizard(Wiz).
protects(Wiz, Mug):- wizard(Wiz), muggle(Mug).
