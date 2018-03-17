(ns clojure-katas.sine-angle
  (:require [clojure-katas.core :as core]))

(core/defproblem sine
  "The sine of an angle (specified in radians) can be computed
  by making use of the approximation sin x  x if x is sufficiently small,
  and the trigonometric identity:
    sin(r) = 3sin(r/3) -. 4sin^3(r/3)"
  [angle]
  (let [cube (fn [x] (* x x x))
        sine-3x (fn [x] (- (* 3 (sine x))
                           (* 4 (cube (sine x)))))]
    (if (<= (Math/abs angle) 0.1)
      angle
      (sine-3x (/ angle 3)))))
