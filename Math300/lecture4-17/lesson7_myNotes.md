Lesson 7: Chapter 2, Set Theory stuffs
STMath 300


Defn:
- Set
  + A set is a collection of distinct elements (objects). We typically denote them with upper case letters.
  + We use the notation: 
    * x IN S OR x NIN S to indicate that x is or is not an element of the set S
  + Sets can be specified in a few ways:
    1. Listing elements:
      - eg., 
        + S = {a,b,c}
        + S = { a,b,c,...,x,y,z}
        + S = {1,1,2,3,5,8,13,...}
          * Note: Bad notation would be something like, S = {1,2,...} where it is ambiguous what the pattern is
        + S = {...,-3,-2,-1,0,1,2,3,...}
    2. Defining statement:
      - eg., 
        + S = {x IN R | 1 <= x =3}
                 ^    ^      ^
          Universe "SuchThat"Defining statement
        + S = { x IN R^n | Ax\` = 0\`} // Null space from Lin. Alg.
          * Let x\` denote the vector x, and 0\` denote the the zero vector
        + S = {x IN Z | x = 2n+1, n IN Z} // odd numbers
          * = {2n+1 | n IN Z}
        +  The elements of S are drawn from some larget set (R, R^n, Z) -- This is called the **Universal set**, denoted `U`
          * Note that in general, the elements of a set are not ordered
            - eg., {1,2,3} = {3,1,2}
        + Formally, When we write `A = B`, we are saying 
          * For all x IN U, x IN A IFF x IN B
        + If `A != B`
          * There exists an x IN U, ((X IN A) AND (X !IN B)) OR ((x !IN A) AND (x IN B))
        + Any set A cosisting of some (or all) of the elements of U is a subset of U, denoted:
          * Ac U.
        + Given two sets, A and B, that are subsets of U, we can also say that 
          * AcB IFF
            - for all x IN U, x IN A then x IN B.
            - and x !IN B then x !IN A.
        + and so, `A` c`B` iff
          * There exists `x IN U`, `x IN A AND x !IN B`.
        + The notationcindicates that equality is possible
          * i.e. `A`c`A`.
        + to exclude this possibility, we use A C B (proper subset)
        + From the above definitions, note that
          * `A = B` iff `A`c`B` and `B`c`A`.
        + This property, called double inclusion, is very useful when proving that two sets are equal.
    3.  Finally, we define the empty set, denoted `0/`, or `{}`, to be the set that contains no elements.
      - Note that, by definition, `0/`c`A` for any set `A` (including `0/`), beause the statement: `x IN 0/` then `x IN A` is "vacuously true" for any set A.
      - _**Set Operations**_:
        + Let AcU, BcU, then:
          1. The union of A and B, denoted AuB, is defined as
            - AuB = {x IN U | x IN A OR x IN B}
              + The element, x, that is in A and/or B
          2. The intersection of A and B, denoted AnB is:
            - AnB = {x IN U | x IN A AND x IN B}
              + The element, x, that is in A AND B
          3. The complement of A, denoted `A_` (written as A with a bar over it, like the mean of A), is:
            - `A_` = { x IN U | x !IN A}
              + The element(s), x, that is anywhere but in A
          4. The complement of A relative to B (set difference), denoted A\B or A-B, is:
            - A\B = { x IN U | x IN A AND x !IN B}

---
Proving Statements involving sets:
---

Example 1:

- If AcB, Then `B_`c`A_`.
    * observe that we are given that A is a subset of B.
    * And that we want to prove that B-compliment is a subset of A-compliment
  + Sketch a venndiagram to help get a mental reference to what is going on:
    * See the instructor's diagram from the notes for today's lesson.
      - That diagram shows that the area outside of A is smaller than the area outside of B

How do we prove it?

**To prove ScT, we use an _element chasing argument_**

  1. Start with an arbitrary x IN S
  2. Apply some sequence of logic to show that x IN T
  3. Conclude that ScT

I this example, we want to prove that B-comp  is a subset of A-comp.

So:

- Let x IN `B_`, then x !IN B. (now we need to show that x can in-turn be in `A_` but not in A)
  + Since AcB, this implies that x !IN A as well. Therefore x IN `A_`.
    * Thus we have proven that `B_`c`A_`, Whenever `A`c`B`.

Example 2: Prove or disprove:

Universal set `(AuB)_` = `A_`u`B_`
- draw a venn diagram -- does the statement seem true?
- if so, try to prove it, if not, proveide a counter-example (eg., with U = {1,2,3,4,5})


Example 3: Prove that `(AuB)_` = `A_`n`B_`.

To prove that two sets S and T are equal, we can use one of two arguments:

  1. **Double inclusion**: Show that ScT and TcS. (Two element-chasing proofs)
    - "<=" let x IN `(AuB)_`. then x !IN AuB. Since x !IN AuB, we conclude that x !IN A, and x !IN B. So, x IN `A_`, and x IN `B_`. So x IN `A_`n`B_`.
      + Thus we prove that `(AuB)_` c`A_`n`B_` 
    - ">=" Let x IN `A_`n`B_`. Then, x !in A and x !IN B. Since x !IN A and x !IN B, x !IN AuB. 
      + Thus we prove that x !IN `(AuB)_`.
    - Thus we prove that `A_`n`B_` = `(AuB)_`.
  2. Membership Equivilance:
    - Show that the conditions for membership in both sets are equivielent, using propositional logic.
```
       `(AuB)_` = { x IN U | x !IN AuB } (Definition of compliment)
                = { x IN U | ~(x IN A OR x IN B)} Definition of union (u)
                = { x IN U | x!IN A AND x !IN B} DeMorgan's Law.
                = { x IN U | x IN `A_` AND x IN `B_`} definition of compliment
                = `A_`n`B_`.                          definition of intersection (n)
                
```
    - Pros:
      + Is more compact when the same argument can be used in both directions.
    - Cons:
      + Won't work if a different argument is needed.


Example 4: Prove that `A`c`B` iff AnB = A.

![See diagram of instructors notes for A as a subset of B]()

Important: We need to prove:
                          
  1. If AcB, then AnB = A -> (AnB)cA
                          -> Ac(AnB)
  2. If AnB=A, Then AcB

Proof 
=> 
- Let AcB, and let x IN (AnB). Since x IN (AnB), x IN A. Thus we  have Proven (AnB)cA.
- Now, let x IN A. Since AcB, it follows that x IN B as well. Since x IN A and x IN B, it follows that x IN (AnB).
  + Thus we have proven Ac(AnB)
- So if AcB, then A=AnB (by double inclusion)

<= 
- Let AnB=A,and let x IN A. since A=AnB, x IN (AnB). Therefore x IN B.
  + Thus we Prove AcB.
  
This concludes the proof.
