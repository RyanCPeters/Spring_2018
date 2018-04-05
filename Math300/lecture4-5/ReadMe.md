Lesson 4: Propositional Logic Contd.
===

Qualifiers
---

Often, the truth of a laim depdns on the value of some variable. Such claims are called _**propositional functions**_.

- eg. Let p(x) be the claim `x^3 >= 0`, `x IN R`.

to make this into a statement, we can add one of two **qualifiers**:

1. The **existential quantifier** denoted by a backwards capital `E`, I'll type it `EQ` here, states that _there exists_ an `x` for which the statement is true. 
  + eg.  `EQx IN R`, `x^3 >= 0`
    * "There exists a real number `x`, such that `x^3 >= 0`"
    * This is now a true statement. (true when `x >= 0`)    
2. The **Universal quantifier**, denoted by the upside down A, states that p(x) is true _for all_ values of `x` ...
  +  eg.
    *  Zx IN R, x^3 >= 0
      -  "For all real numbers x > =0"
    *  Note that the truth value of a quantified statement may depend on which values of x are possible. (Universe of discourse). in the two statements above, the universe was R.
    *  Note that
      -  Ax IN N, x^3 >= 0 is true
      -  eg.
        +  Ex IN R, x^2+1 = 0 is false
        +  Ex IN C, x^2+1 = 0 is true (i^2 = -1)
      +  Often, we have more than one quantifier attached to a statement. eg.
      1. Ax IN R, Ey IN R, x>= y
      2. Ey IN R, Ax IN R, x>= y
      3. Ax IN R, Ey IN R [y^3 = x AND (Az IN R, z^3 = x -> z = y)] 
      For all x IN R, there exists a y IN R such that y^3 - x and for all z IN R, if z^3 -x, then z - y
      "Every Real number x has a unique cube root"
        + exercise:
          * State in english what each of these statements is saying
          * Is each statement true or false.
      4. formal definition of a limit.
        + (lim x->a of f(x) - L ) <-> (A sigma > 0, E delta > 0, Ax IN R, |x-a| < delta -> |f(x)-L| < sigma )
          
Negating Quantified Statements
---

eg., Consider the statement "All Canadians(c) speak French"

- [Ax IN c, x speaks French]; "Ex In c, x does not speak French" => "There exists a Canadian who does not speak French"

In general,
  
  1. `~[Ax, p(x)] <-> [Ex, ~p(x)]` -- notice that by changing the universal quantifier to an existential quantifier, the negation becomes localized to the operation component.
  2. `~[Ex, p(x)] <-> [Ax, ~p(x)]` -- notice that the same conversion will result in the same transportation of the negation.

eg 1: `~[Ey IN R, Ax IN R, x>=y] <-> Ay IN R, Ex IN R, x < y` => "For all y IN R, there exists x IN R such that x < y" [True]

eg 2: `~[Ax, Ey | (y^3=x) AND (Az IN R, z^3=x -> z=y)] <-> [Ex, Ay | ~(y^3=x) OR (~(Ez IN R), (z^3=x) AND ~(z=y))]`

                                                                  |_______|    |_____________________________|
                                                                      ^                      ^
                                                                 No existence          No uniqueness
                                                                 
                                                                 
Exercise:

- Try negating the definition of a limit:
  + Ae > 0, Ed > 0, ... 



\{1.5 Methods of proof:

- We have seen:
  + direct proof
  + proof by contrapositoin
  + proof of biconditional statements
- we now introduce:
  + **Proof by contradiction**.
    * Suppose we want to prove statement p.
    * Assume that p is false (`~p` is true), and then show that this leads to a contradiction. If we arrive at a contradiction, this implies that `p` can't be false.
      - Tautology `[~p -> [q AND ~q]] -> p`
      - eg. let `x IN R`, `x>0`. Then `x + 1/x >= 2`
      - This statement could be written:
        + `Ax > 0`, `x + 1/x >=2` or, `Ax In R`, `x>0 -> x+1/x >= 2`
      - The negation of the statement is:
        + `Ex > o`, `x+1/x < 2` or `Ex IN R`, `x>0 AND x+1/x<2`
      - So, to prove by contradiction, we assume that there exists a positive real number x such that `x+1/x<2`
        + lets make this easier to work with!! multiply both sides by x: `x^2+1<2x` (recall x > 0) so, `x^2-2x+1<0 => (x-1)^2<0` <--- oops, looks like that can't be true :)
        + This is a contradiction since `(x-1)^2 >0` for all `x IN R`; Therefor, by contradiction, `x+1/x >= 2` for all `x>0`.

Note that the following are not valid proovs fo the statement:
1. Assume by contradiction that `x>0` and `x+1/x <2`.
  + This statement is clearly false since, for example, if `x = 2`, then `2+1/2 > 2`. Proof By Contradiction, it must be true that `x+1/x>=2`
    * this is not valid because the negation of the original statement is of the form `Ex>0, x+1/x<2`. Providing a single counter-example does not disprove the existence of such an x.
2. Suppose that `x+1/x >=2`,`x>0` (the original statement); `x^2 +1 >=2x`; `x^2-2x+1>=0`; `(x-1)^2>=0`;
  + This is always true, so the original statement is true as well.
    * This is not a valid proof because it is possible to start with a false statement and arrive at a true one.
    * This does not establish that the original statement was true.
      - eg. `0 = 2`; `-1 = 1`; `(-1)^2 = 1^2`; `1=1`; naughty, naughty...

Note that existentially quantified statements can't be disproven by a counterexample.
- However, Universally quantified statements can be disproven in this way.
  + eg. prove or disprove: `An IN N`, `3^n +2` is a prime.
    * disprove by using negation: `En IN N`, `~(3^n +2)` is prime.
      - see that:
       
          |n|3^n + 2|
          |:---:|:---:|
          |1| 5|
          |2| 11|
          |3| 29|
          |4| 83|
          |5| 245|
  + eg. Prove by contradiction: if `a,b,c IN Z` such that `a^2+b^2=c^2`, then onf of a or b must be even.
    * `A a,b,c IN Z, a^2+b^2 = c^2 -> 2|a OR 2|b`; `E a,b,c IN Z, a^2+b^2 = c^2 AND [2~|a AND 2~|b]`
      - in other words, assume that E odd integers a&b such that `a^2+b^2 = c^2`; let `a = 2q +1` and `b=2r+1`;
      - then `a^2+b^2 = 4q^2+4q+1+4r^2+4r+1 = 2[2q^2+2r^2+2q+2r+1] = 4[q^2+r^2+q+r=+2`;
        + proven if a^2+b^2 = c^2, c^2 must be even.
        + it follows that c is even, so c = 2s, s IN Z; c^2 = 4s^2;
          * This implies that 4|c^2, but the statement that a^2+b^2 = 4(q^2 + r^2 + q + r)+2 implies that 4~|(a^2 + b^2)
        + Therefore, by contradiction, there do not exist odd integers a and b, such that a^2+b^2 = c^2; So, one of a or b must be divisible by 2.
  + eg. Euclid's proof that there are infinitely many prime numbers.
    * By contradiction, assume that there are finitely many primes; implies that we could list them off, ie., {p1 =2, p2 =3, ... , pn};
      - Let `q = p1*p2*p3*...*pn + 1`. Then, q must be composite, since it isn't prime;
      - Therefor, it must be possible to express `q` as a product of primes; This implies that `q` is divisible by at least one prime.
        + But, this is a contradiction... since `q` is congruent to `1 mod p_k` for `k = 1,2,..,n`;
        + Therefor, there must be infinitely many primes.
          * Q.E.D.
