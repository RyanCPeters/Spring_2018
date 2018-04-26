STMath 300 Test 1 Practice and Review
===

### My description of converse, inverse, contrapositive, and contradiction:

Given the statement `p -> q`

- converse statement:
  + `q -> p`
- inverse statement:
  + `~p -> ~q`
- contrapositive statement:
  + `~q -> ~p`
- contradiction of statement:
  + `~p -> q`
    * Proven if we can arrive at a statement that shows:
      - `(~p -> (q AND ~q)) -> p`
      - In English: "If not-p then q and not-q, a contradiction, thus p"


### Practice Problems
All sample problems are from textbook

- p. 11 {3,4,5}

3. For the following pairs of integers a and b with b > 0, find the quotient q and the remainder r with 0 <= r < b as specified by the Division Algorithm.
  (a) `a = 142, b = 15`
  (b) `a = 20, b = 7`
  (c) `a = -212, b = 8`
4. In terms of the definition of congruence modulo n, explain why 17 congruent to 53 mod 12.
  
  17 congruent to 53%12 means that they both have the same remainder when divided by 12.
  
5. Compute the residue a mod n (see Definition 0.14 and Example 0.15).
  (a) `9 mod 10` = 9 || -1 
  (b) `25 mod 2` = 1 || -1
  (c) `169 mod 13` => (130%13 + 39%13)%13 = (10 + 3)%13 = 13%13 = 0
  (d) `-10 mod 3` = 2 || -1 
  (e) `1,234,679,123,007,221 mod 2` = 1 || -1

- p. 22-23  {3, 4, 6, 7}

3. Negate each of the following statements.
  (a) `A positive number is larger than zero.`
  (b) `If today is Saturday, then I do not have to go to work.`
  (c) `Dogs can bark and cats can climb trees.`
  (d) `If x^2 - 9 = 0, then either x = 3 or x = -3.`
  (Note: The difficulties of negating compound statements will be vastly simplified by the tautologies studied in the next section!)
4. For the conditional statements given below, give the converse, the inverse, and the contrapositive.
  (a) `If I do not get to class on time, then I will not be allowed to take the exam.`
  (b) `I will return the calls and dictate the letter when I arrive at the office.`
  (c) `If (x + 1)(x - 4) = 0, then x = -1 or x = 4.`
  (d) `If my weight drops below 170 pounds, then I will eat 2 cheeseburgers and a chocolate cake.`
6. Construct truth tables for the following compound statements.
  (a) `p OR (~p AND q)`
  (b) `~(p -> q) AND q`
  (c) `(p AND ~q) OR (p AND q)`
  (d) `[~(p OR ~r) AND (q OR p)] -> p`
7. For integers x and y, find the inverse, the converse, the contrapositive, and the negation of each of the following statements.
  (a) `If x = 3, then x^4 = 81.`
  (b) `If x < 0, then x 6= -4.`
  (c) `If x is odd and y is even, then xy is even.`
  (d) `If x^2 = x, then either x = 0 or x = 1.`
  (e) `If xy 6= 0, then x 6= 0 and y 6= 0.`

- p. 29 {1-6}

1. Use a truth table to prove part 1c of Theorem 1.22 is a tautology.
`    [(p -> q) AND p] -> q ` (Modus Ponens)

2. Use a truth table to prove part 1h of Theorem 1.22 is a tautology.
`    ~(p<->q)<->{[p AND (~q)] OR [q AND (~p)]}`

3. Use a truth table to prove part 2d of Theorem 1.22 is a tautology.
`    [(p ! q) ^ (q ! r)] ! (p ! r) ` (Transitive Property)

4. Use a truth table to prove part 1 of Theorem 1.23 is a contradiction.
`    (p -> q) AND [p AND (~q)]`

5. Use the appropriate tautologies from Theorem 1.22 to negate the following statements:
  (a) `A foot has 12 inches and a yard has three feet.`
  (b) `Either I will get a job or I will not be able to pay my bills.`
  (c) `If I study, then I will do well in this course.`
  (d) `If x^2 - 5x + 6 = 0, then x - 3 = 0 or x - 2 = 0.`
  (e) `An integer m is odd if and only if m2 is odd.`
  
  
6. Verify that the following logical expressions are tautologies.
  (a) `[(~p) AND (p OR q)] -> q`
  (b) `[(p -> q) AND (~q)] -> (~p)`
  (c) `[(~p) -> (q AND (~q)] -> p`

- p. 32-33 1, 4

1. Use Fact 1.30 and tautologies from Threorem 1.22 to write useful negations of the following quantified statements.
  (a) `All cows eat grass.`
  (b) `There exists at least one real number x such that x^2 = 9.`
  (c) `There is a car that is blue and weighs less than 4000 pounds.`
  (d) `There is no real number x such that x^2 = -1.`
  (e) `Some students attend night school.`
  (f) `No children are allowed in this building.`
  (g) `There is some number that is both odd and even.`
  (h) `Every math book is either white or hard to read.`
  (i) `All college students are math or engineering majors.`
  (j) `For all real numbers x, if x is positive, then -x is negative.`
  (k) `Some cars are red, and all students take math.`
  (l) `There is no real number x that makes the sentence "x^2 = -1" true.`
  (m) `There are some people who go to school in the morning and work in the afternoons.`
  (n) `Not all numbers are rational and positive.`
  
  
4. Consider the proposition
  "For every real number x; there is a real number y such that 2^y = x:" 
  In symbols, this statement can be denoted by (8x 2 R)(9y 2 R)(2y = x): This statement would be negated, using Fact 1.30, as follows:  (8x 2 R)(9y 2 R)(2y = x) , (9x 2 R)[ (9y 2 R)(2y = x)] , (9x 2 R)(8y 2 R)[ (2y = x)], (9x 2 R)(8y 2 R)(2y 6= x)
  This, then, can be converted to English as
  \There exists a real number x such that for every real number y, 2y 6= x."
  This example illustrates what you are to do in the following two problems.
  32
  (a) (A real example from abstract algebra) A group G is cyclic provided that there
  is a member a of G such that for each member g of G, there is an integer n such
  that an = g.
  i. Express the definition of cyclic group using the condensed quantifier notation
  as above.
  ii. Explain in a useful way, using an English sentence, what it means to say that
  a group G is not cyclic.
  (b) (A real example from analysis) A sequence fxng is a Cauchy sequence provided
  that for each  > 0, there is a natural number N such that if m; n > N, then
  jxn - xmj < .
  i. Express the definition of Cauchy Sequence using the symbolic notation as
  above. (Hint: There are three quantifiers here; one is implicit.)
  ii. Without using any negative words, state an English sentence for what it
  means to say that fxng is not a Cauchy sequence.

- p. 40 5-7

5. Prove or disprove: For every integer n, if 4|(n^2 - 1), then 4|(n - 1).


6. Let m,n IN Z. Prove that if 3!|m and 3!|n, then 3|(m^2 - n^2).
      Hint: It will help to consider cases based on what the remainders are.
      
      
7. Let n IN Z. Prove that 3|(2n^2 + 1) if and only if 3!|n.


- p. 161 1, 2

1. Use mathematical induction to prove each of the following propositional functions is true for all n >= r, where r is the smallest nonnegative integer for which the statement is true.
  (a) 2 + 4 + 6 + ... + 2n = n(n + 1)
  (b) 1 + 3 + 5 + ... + (2n - 1) = n^2
  (c) 1^2 + 22 + 32 + ... + n^2 = n(n + 1)(2n + 1)/6
  (d) 13 + 23 + 33 + ... + n^3 =
  n^2(n + 1)2
  4
  (e) 12 - 22 + 32 - 42 + ... + (-1)n-1n^2 = (-1)n-1n(n + 1)
  2
  (f) 1 + 2 + 22 + ... + 2n = 2n+1 - 1
  (g) 3j(n^3 - n) 8n  1.
  (h) 3 + 3  5 + 3  52 + ... + 3  5n =
  3(5n+1 - 1)
  4
  (i) 3j(n^3 + 2n)
  (j) 5j(n^5 - n)
  (k) 6j(n^3 - n)
  (l) 21|(4^(n+1) + 5^(2n-1)
  (m) 9j(10n + 3  4n+2 + 5)
  (n) 64j(9n - 8n - 1)
  (o) 8j(32n - 1)

2. A sequence is dened recursively by
x^1 = 1;
x^2 = 2; and
xn = x_(n-1) + 2x_(n-2) for n >= 3:
Conjecture a formula for xn and use the 2nd Principle of Mathematical Induction to
prove your conjecture is correct.

- I also highly recommend reviewing Quizzes 1{6 and Assignments 1{3. Everything that appears on those quizzes and assignments is potentially examinable.
