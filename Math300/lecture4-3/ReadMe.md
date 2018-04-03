STMath 300 Lesson 3: Propositional Logic
===

Definition:

- Proposition is a claim that is objectively true or false
- eg
	+ Statement:
		+ `3|12`
    + There are infinitely many primes 
    + 2+2 = 5
    + Every even integer `>2` is the sum of 2 primes.
	+ Not a statement:
		+ `3/12`
    + Are there infinitely many primes?
    + Seattle is a nice place to live. (subjective) 
    + The statement is false. (paradox)
- Compund Statements:
  + are obtained by combining multiple statements. some basic operations are:
  
  1. let `p` be a statement, then, the negation of `p`, denoted `~p`, is the statement with the opposite truth value.
    + Some textbooks may use alternative notations:
      * `NOT p`, `symbol p`

            ||||
          |:---:|:---:|:---:|
          ||||
          ||||
          ||||
          ||||

  2. let `p` and `q` be statements. The _**conjunction**_ of `p` and `q`, denoted `p up triangle q`, is true only when both `p` and `q` are true.
            |p|q|p AND q|
            |:---:|:---:|:---:|
            |T|T|T|
            |T|F|F|
            |F|T|F|
            |F|F|F|
  3. Let `p` and `q` be statements. The disjnction of `p` and q, denoted by `p` down karat q, is true whenever at least one of `p` Or `q` is true.
  
            |p|q|p OR q|
            |:---:|:---:|:---:|
            |T|T|T|
            |T|F|T|
            |F|T|T|
            |F|F|F|
    Note: This is not an "exclusive or" statement -- it is true when both `p` and `q` are true.
     
  4. A conditional statement, written `p->q`, is one of the form "if `p`, then `q`". This statement is true except if `p` is true and `q` is false.
  
            |p|q|p->q|
            |:---:|:---:|:---:|
            |T|T|T|
            |T|F|T|
            |F|T|T|
            |F|F|T|
            
            eg. Let `p` be the statement "A shape is a square"
                Let `q` be the statement "A shape has four sides"
                
                  - `p->q` is true whenever:
                    + a shape is a square (`p` is true) and it has four sides (`q` is true)
                    + a shape is not a square (`p` is false) and it has any number of sides.
                      * This implies that if `p` is false, it doesn't matter if `q` is false, the statement that `p` implies `q` is still true.
                  - It would be false if:
                    + a shape is a square, `p` is true, but it does not have four sides, `q` is false.
            
            Conditional statements are expressed verbally in many ways, including:
              1. if p, then q: 
                + "If a shape is square, it has 4 sides"
              2. q, if p:      
                + "A shape has 4 sides, if it is a square"
              3. `p` only if q:
                + "a shape is a square only if it has 4 sides"
              4. `p` is sufficient for q:
                + it is sufficient, for a shape to have four sides, for that shape to be a square"
              5. `q` is necessary for p:
                + "it is necessary, for a shape to be a square, for it to have four sides."
              6. p implies q:
                + 
              7. 
    
  5. a `biconditional statement` is one fof the form:
    + "`p` if and only if (iff) `q`"
    + if is true when bot `p AND q` are true, or both are false.
    
          |p|q|p<->q|
          |:---:|:---:|:---:|
          |T|T|T|
          |T|F|F|
          |F|T|F|
          |F|F|T|
          
    - Also phrased as  "p is equivalent to q" or "p is necessary and sufficient for q"
      + eg. a is congruent to b for mod n if and only if they have the same remainder when divided by n.
        * p: a is congruent to b for mod n
        * q: they have the same remainder when divided by n.
      
      Key point: (p<->q) <-> [(p->q) AND (q->p)]
      
      to prove this forally, we use a truth table.
      
          |p|q|p->q|q->p|(p->q)AND(q->p|
          |:---:|:---:|:---:|:---:|:---:|
          |T|T|T|T|T|
          |T|F|F|T|F|
          |F|T|T|F|F|
          |F|F|T|T|T|
          
          
          since the truth values of  (p->q) AND ()
          
          - In the context of conditional statements, we also have the following terms:
          given p->q:
            1. the converse of the statement is  `q->p`
            2. the inverse of the statement is `~p->~q`
            3. the contrapositive of the statement is `~q->~p`
          
          _**Exercise**_: in calc 1, we learn that:
            "let `f` be a differentiable function. if `a` is a local minimm of `f(x)`, then `f'(a) = 0.`"
            
            write out the converse, inverse, and contrapositive statements. 
              + let: p = "`a` is a ocal minimum of `f(x)`"
              + let: q = "`f'(a) = 0`"
              + given: p -> q
              + converse:
                * q -> p
                * if `f'(a) = 0`, then `a` is a local minimum of `f(x)`.
              + inverse:
              + ~p -> q
                * if `a` is not a local minimum of `f(x)`, then `f'(a) != 0`.
              + contrapositive:
              + ~p -> ~q
                * if `a` is not a local minimum of `f(x)`, then `f'(a) != 0`.

              Which of these are also true?
                + the contrapositive is true.
              
              In general, it is always true that `~q -> ~p` whenever `p -> q`.
              
              proof:
              
                  |p|q|~p|~q|~q->~p|
                  |:---:|:---:|:---:|:---:|:---:|
                  |T|T|F|F|T|
                  |T|F|F|T|F|
                  |F|T|T|F|T|
                  |F|F|T|T|T|
                  
                Note however:
                
                  |p|q|q->p|
                  |:---:|:---:|:---:|
                  |T|T|T|
                  |T|F|T|
                  |T|F|T|
                  |F|T|F|
                  
              The equivalence of a statement with its contrapositive is the basis for proof by contraposition.
                + ie., to prove p->q, we can instead prove ~q->~p, since the statements are equivalent.
                + eg: Consider the claim:
                  * Letting `n` be an integer:
                  * if n^2 is even, then n is even.
                  * identify p,q:
                    - p = n^2 is even
                    - q = n is even
                    - The contrapositive is:
                      + if n is odd, then n^2 is odd
                      + where `~q = n is odd`, and` ~p = n^2 is odd`.
                      + this can be proven easily using a direct method:
                        * n = 2r+1 => n^2 = 4r^2 +4r + 1 = 2(2r^2 + 2r)+1
                        * where we can see that if j = 2r^2 + 2r; then 2j+1 will always be odd.

### 1.3 Tautologies and contradictions.

- A compound statement that is always true is a tautology.
- a compound statement that is always false is a contradiction.
  + eg., 
    * p OR ~p is a tautology 
    * p AND ~p is a contradiction
    
    |p|~p|p OR ~p|p AND ~p|
    |:---:|:---:|:---:|:---:|
    |T|F|T|F|
    |F|T|T|F|
    
- Some useful tautologies can be found as follows:
  + Some useful tautologies (from textbook page 25)
    1. c) [(p->q) AND p] -> q (Modus Ponens) -- the proof that proves by affirming
          
          | p | q | p->q | (p->q) AND p |[(p->q)andp]->q |
          |:---:|:---:|:---:|:---:|:---:|
          |T|T|T|T|T|
          |T|F|F|F|T|
          |F|T|T|F|T|
          |F|F|T|F|T|
              
       d) [(p->q)AND~q]->~p (Modus Tollens) -- the proof that proves by denying
       
       e) ~(p OR q) <-> ~p AND ~q
                                  \
                                    DeMorgan's Laws       
                                  /
       f) ~(q AND q) <-> ~p or ~q
       g) ~(p -> q) <-> p AND ~q
                                                  \
                                                    Additional negation laws                                  
                                                  /
       h) ~(p <-> q) <-> ([p AND ~q] OR [q AND ~p])
       m) (~p -> [q AND ~q]) -> p  -- proof by contradiction
       
    We also have laws such as:
    
    2.
      f)  p OR (q AND r) <-> (p AND q) AND (p OR r) -- distribution law
      
      Proof:
            
            |p|q|r||q AND r|p OR (q AND r)||p OR q|p OR r| (p OR q) AND (p OR r)|
            |:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
            |t|t|t||t|t||t|t|t|
            |t|t|f||f|t||t|t|t|
            |t|f|t||f|t||t|t|t|
            |t|f|f||f|t||t|t|t|
            |f|t|t||t|t||t|t|t|
            |f|t|f||f|f||t|f|t|
            |f|f|t||f|f||f|t|t|
            |f|f|f||f|f||f|f|t|
            
Lecture end

Due Thursday april 4, 2018, is assignment #1.            
