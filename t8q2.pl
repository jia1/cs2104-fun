:- use_module(library(clpfd)).

puzzle([T1A,T1O,T4H]) :-
    Answers = [
        T1A,T1H,T1O,
        T2A,T2H,T2O,
        T3A,T3H,T3O,
        T4A,T4H,T4O
        ],
    
    right_triangle(T1A,T1O,T1H),
    right_triangle(T2A,T2O,T2H),
    right_triangle(T3A,T3O,T3H),
    right_triangle(T4A,T4O,T4H),

    (T1H #= T2A; T1H #= T2O),
    (T2H #= T3A; T2H #= T3O),
    (T3H #= T4A; T3H #= T4O),
    
    label(Answers)
    .
    
right_triangle(A,O,H) :-
    A*A + O*O #= H*H,
    0 #< A, A #< 100, A #=< H,
    0 #< O, O #< 100, O #=< H,
    0 #< H, H #< 100
    .
