(ns typed.test.example
  (:import (clojure.lang Seqable))
  (:require [typed.core :refer [ann inst cf fn> pfn>]]
            [clojure.repl :refer [pst]]
            [analyze.core :refer [ast]]))

(ann test1 (All [x y] [x y -> x]))
(defn test1 [a b]
  a)

(test1 1 2)

; c.c/map needs work
;(ann test2 (All [y] 
;                [(Seqable y) -> (Seqable (U true false))]))
;(defn test2 [a]
;  ((inst map (U true false) Any) number? a))

(ann use-map [(HMap {:a Number}) -> Number])
(defn use-map [a]
  (get a :a))

(use-map {:a 1})

;(ann rest-arg1 [Number * -> Number])
;(defn rest-arg1 [& ns]
;  (+ (first ns)))
