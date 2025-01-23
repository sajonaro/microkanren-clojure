### About

Adaptation in Clojure of [W.Byrd's and Co. paper](http://webyrd.net/scheme-2013/papers/HemannMuKanren2013.pdf) about µKanren (`microKanren`) -  a subset of [miniKanren](https://minikanren.org/) focused on core relational programming operators and devoid of functions pertaining rather to the end-user's purview.

### 101 on µKanren 

A microKanren program is a sequence of `goals` , each `goal` can either `succed` or `fail`. The result of a µKanren program
is a stream of satisfying states, i.e. such that make `succed` all `goals`. 

#### Goals constructors

In µKanren there are 4 primitive
`goal` constructors:
 - `unification` constructor: `===`   
 
    ```clojure
    ;; the goal `succeds` if A is `unified` with B
    (=== A B)
    ```
 - binary conjunction: `conj`
     ```clojure
    ;; .. of the goals A and B, resulting in a goal that succeds if both A and B succed
    (conj 
        A
        B)
    ```

 - binary disjunction: `disj`
     ```clojure
    ;; .. of the goals A and B, resulting in a goal that succeds if either A or B succeds
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


### Useful scripts
- install clojure-cli
    ```bash
    $ curl -L -O https://github.com/clojure/brew-install/releases/latest/download/linux-install.sh  \
        chmod +x linux-install.sh  \
        sudo ./linux-install.sh
    ```
- run 
    ```bash
    $ clj -M -m microkanren.main
    ```


