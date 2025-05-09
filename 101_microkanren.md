### Concise introduction into µKanren 

Source - excellent (clear and concise) paper "Logic Programming in Scheme" by Nils M Holm


### Definitions:

[microKanren program]()
-  is a sequence of `goals` , each goal can either `succeed` or `fail`. The result of a µKanren program is a stream of satisfying states, i.e. such that make succeed all goals.  

[goal]()
- is a building block of minikanren program
    ```clojure
    ;; e.g. the goal 'appendo' succeeds because 
    ;; if we append `(a) and `(b) we get `(a b) 
    (run* [] (
        appendo
           ’(a)
           ’(b)
           ’(a b)))
    ``` 

In µKanren there are 4 primitive `goal` constructors

[unification]() constructor: `===`   
- When two `atoms` are passed to ===, it succeeds if the atoms are equal.
When a `variable` is passed to ===, the variable is `bound` to the other
argument: 
    ```clojure
    ;; the goal `succeeds` when A is `unified` with B
    (=== A B)
    ```
[binary conjunction](): `conj`
    
```clojure
   ;; .. of the goals A and B, resulting in a goal that succeeds if both A and B succeed
   (conj 
     A
     B)
```

 - binary disjunction: `disj`
     ```clojure
    ;; .. of the goals A and B, resulting in a goal that succeeds if either A or B succeed
    (disj 
        A
        B)
    ```
 - operator `fresh`:
     
     ```clojure
     ;; creates a fresh (i.e. new) logic variable X
     ;; accepts unary function fn_X: i.e. fn[X]( expression_with_X)
     ;; where variable X is a fresh logic variable bound to 
     ;; expression_with_X expression,
     ;; expression_with_X evaluates to a goal.
     (fresh fn_X)
     ```
