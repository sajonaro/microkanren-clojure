(ns minikanren.main)


;; unification operator
;; ===


;; interface clojure -- kanren
;; ( run 1 [q]
;;   (== q 5))

;; logical form 1
;; (run 1 [q] 
;;   (fresh [x y] (== x 5))



(defn  hw []
  (println "Hello, World!"))  


(defn -main []
   (#(println "Hello, World!")))
