1. Basic Properties

  - `p<->p `
  - `[~(~p)]<->p `
  - `[(p ! q) AND p] ! q `
    + Modus Ponens
  - `[(p ! q) AND (~q)] ! (~p) `
    + Modus Tolle
  - `~(p OR q)<->[(~p) AND (~q)] `
    + DeMorgan's L
  - `~(p AND q)<->[(~p) OR (~q)] `
    + DeMorgan's Law
  - `~(p ! q)<->[p AND (~q)] `
  - `~(p<->q)<->{[p AND (~q)] OR [q AND (~p)]} `
  - `(p OR q)<->[(~p) ! q] `
  - `(p ! q)<->[(~q) ! (~p)] `
    + Contraposition
  - `[(~p) ! (~q)]<->(q ! p) `
  - `[(p ! q) AND (q ! p)]<->(p<->q) `
  - `{(~p) ! [q AND (~q)]} ! p `
  - `(p<->q) ! [(r AND p) ! (r AND q)] `
  - `(p<->q) ! [(r OR p)<->(r OR q)] `

2. Additional Laws
  - `(p<->q)<->(q<->p) `
    +  Symmetric Property
  - `(p AND q)<->(q AND p) `
    +  Commutative Property
  - `(p OR q)<->(q OR p) `
    +  Commutative Property
  - `[(p ! q) AND (q ! r)] ! (p ! r) `
    +  Transitive Property
  - `[(p<->q) AND (q<->r)] ! (p<->r) `
    +  Transitive Property
  - `[p OR (q AND r)]<->[(p OR q) AND (p OR r)] `
    +  Distributive Property
  - `[p AND (q OR r)]<->[(p AND q) OR (p AND r)] `
    +  Distributive Property
  - `[p OR (q OR r)]<->[(p OR q) OR r] `
    +  Associative Property
  - `[p AND (q AND r)]<->[(p AND q) AND r] `
    +  Associative Property


```

p<->p
[~(~p)]<->p
[(p!q):AND:p]!q
[(p!q):AND:(~q)]!(~p)
~(p:OR:q)<->[(~p):AND:(~q)]
~(p:AND:q)<->[(~p):OR:(~q)]
~(p!q)<->[p:AND:(~q)]
~(p<->q)<->{[p:AND:(~q)]:OR:[q:AND:(~p)]}
(p:OR:q)<->[(~p)!q]
(p!q)<->[(~q)!(~p)]
[(~p)!(~q)]<->(q!p)
[(p!q):AND:(q!p)]<->(p<->q)
{(~p)![q:AND:(~q)]}!p
(p<->q)![(r:AND:p)!(r:AND:q)]
(p<->q)![(r:OR:p)<->(r:OR:q)]
(p<->q)<->(q<->p)
(p:AND:q)<->(q:AND:p)
(p:OR:q)<->(q:OR:p)
[(p!q):AND:(q!r)]!(p!r)
[(p<->q):AND:(q<->r)]!(p<->r)
[p:OR:(q:AND:r)]<->[(p:OR:q):AND:(p:OR:r)]
[p:AND:(q:OR:r)]<->[(p:AND:q):OR:(p:AND:r)]
[p:OR:(q:OR:r)]<->[(p:OR:q):OR:r]
[p:AND:(q:AND:r)]<->[(p:AND:q):AND:r]

```