Lesson 1: Intro to proofs and number theory
===

Definitions
---

- Theory
  + Idea/belief -- not necessarily proven
  + proven
  + Broad idea in mathematics
    * Examples: Elimination Theory, Theory of relativity, Theory of Evolution, Theory of gravity, Quantum/String theory
  + Best explanation for observed/experimental results
  + May not be possible to prove to be conclusively true.
- Theorem
  + More substantial than a theory
  + an assertion that can be used in proving other ideas
    * Examples: Pythagorean Theorem, Fundamental Theorem of Calculus(FToC)
  + A statement/result that can be proven, based on logic/axioms/previous results
- Proof
  + An argument based on logic which conclusively demonstrates the truth or falsehood of a statement.
  + in principle, all proofs of the theorems emerge from axioms (fundamental building blocks) that are accepted to be true.

#### To prove something, we need to work with :
- axioms
- definitions
- logic
- mathematical concepts such as numbers, sets, relations, and functions

#### Some important sets(collections) of numbers include:

- Natural numbers 
  + `N = {1,2,3,4,5,6,....}`
- Integers
  + `Z = {...,-3,-2,-1,0,1,2,3,...}`
- Rationals
  + `Q = {x|x = p/q, p,q∈ Z, q!=0}`
  + where `|` == "such that"
  + where `∈` int `x∈ y` == `x` is an element of the set `y`
- Real
  + R = points on the line from -inf to inf
      = numbers with a (possibly infinite) decimal expansion
      = union of rational numbers & irrational numbers
- Complex
  + ¢ = {z|z=a+bi, a,b∈ R, i^2 = -1}

A basic building of any proof is the statement (proposition).
A statement is a claim that is objectively true, or false.

Examples:
---
1. if `m` and `n` are odd integers, then `m*n` is also odd.
2. if `n^2` is an even integer, then `n` must also be even (whenever `nE Z`)
3. let `n∈ N`  then `sum(i=1;n -> i^2 = 1+4+9+...+n^2 = n*(n+1)*(2n+1)/6`
4. There are infinitely many prime numbers in N.
5. Let `a,b,c,n∈ N`. Then, the equations `a^n + b^n = c^n` has no solutions if `n > 2`
  + called Fermat's last theorem
6. Every even integer larger than 2, can be expressed as the sum of two prime numbers.
  + eg: `100 = 97+3 = 11+89`
  + Goldback's Conjecture
    * Conjecture is a result we believe to be true, but we can't conclusively prove to be true yet.
  
  
  
Exercise
---

Prove Statement `1` from above:

- given `m` and `n` as odd values, `m^2` should be odd, and `n^2` should be odd, and `m^2 * n^2` should still be odd.
  + for `m = 3; n = 5;` `m^2 = 9; n^2 = 25; m*n = 15; m^2 * n^2 = 9*25 = 225`
    * `m = 3 = 2*1+1; n = 5 = 2*2+1`
    * other answers:
    * if (m/2)~∈ N...

What do we need?

- Definitions: odd, even, prime, etc.
- Axioms: what is already known to be true?
- Methods: what kind of argument is actually valid?

Basic Number Theory:
---

#### Axioms
We accept (w/o proof) the following statements:

- let `{a,b,c}∈ Z` then:

1. `(a+b)∈ Z`
2. `-aE Z`
3. `(ab)∈ Z`
4. `a+b = b+a` -- commutativity
5. `ab = ba` -- commutativity
6. `(a+b)+c = a+(b+c)` -- associativity
7. `0+a = a`
8. `a+(-a) = 0`
9. `a(b+c) = ab+ac` -- distributivity

other well-known facts can be derived from the above list.

- eg. 
  + `(a - b)∈ Z` follows from 1 & 2.
  + `(abc)∈ Z` follows from 3 (applied twice)
  + `a*0 = 0` follows from 8 & 9
    * `a*0 = a(b-b) = ab - ab = 0`
    
   
We also introduce the following definitions:

1. An integer, `n`, is even if there exists an integer, `r`, such that `n = 2r`
2. similarly, `n` is odd if there exists `r∈ Z` such that `n = 2r + 1`
3. Let `{ab}∈ Z`, with `a != 0`. We say that `a` divides `b`, written `a|b`, 
  - if there exists `q∈ Z` such that `aq = b`. `a` is a factor of `b`
  - `b` is a multiple of `a`.
    + eg. `13|52` is true since `13*4 = 52`, but 3/52 is not true since there is no integer `a` such that `3*q - 52`
    + we write `3+52`
      * Note `13|15` is _**NOT**_ the same as `13/52`
4. we can now prove statement 1 from before

- let `m` and `n` be odd.
  + Then `m = 2r+1;` for some `r∈ Z`
  + and  `n = 2s+1;` for some `s∈ Z`
- So, `mn = (2r+1)(2s+1)`
  + `mn = 4rs+2s+2r+1 = 2(2rs+s+r)+1`
  + since `(2rs+s+r)∈ Z`, `mn` is odd.
  + do the little square, aka tombstone, and optionally do the Q.E.D.
  
This was an example of what's called a _**direct proof**_

- Begin with the hypothesis: (`m` and `n` are odd).
- apply definitions, axioms, & previously proven results in sequence to show that the conclusion (`mn` is odd) is always true.

Sometimes direct proofs aren't convenient.

Example; it is easy to prove the following directly:
- "if `n` is even, then `n^2` is also even" (try it!)
- what about the _converse_ statement:
  +  "every integer `n`, if `n^2` is even, then `n` is also even." (is this true?)
  +  if we try to prove this directly:
    *  `n^2` is even, so `n^2=24` for some `rE Z` 
    *  `n = +_ sqrt(2r)` ... 

End of lecture 


See canvas for homework, due by Thursday is a take home quiz 
