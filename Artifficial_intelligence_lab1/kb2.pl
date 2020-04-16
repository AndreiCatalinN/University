kicking(malfoy,harry) :- happy(malfoy), unhappy(harry).
eating(dudley).
unhappy(malfoy).

happy(aunt_petunia) :- happy(dudley).
happy(uncle_vernon) :- happy(dudley), unhappy(harry).
happy(dudley) :- kicking(dudley,harry).
happy(dudley) :- eating(dudley).
