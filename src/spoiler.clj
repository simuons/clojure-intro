(ns spoiler)

;; Spoiler alert:
;;
;;  This namespace contains solutions for Fibonacci numbers
;;
;;  |
;;  |
;;  |
;;  |
;;  |
;;  |
;;  |
;;  |
;;  V
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;;
;; You were warned!
;;
;;

; Consumes stack
(defn fibonacci [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (fibonacci (- n 1))
            (fibonacci (- n 2)))))

; Tail-recursion
(defn fibonacci [n]
  (letfn [(acc [current next n]
            (if (zero? n)
              current
              (acc next (+ current next) (dec n))))]
    (acc 0N 1N n)))

; Self-recursion
(defn fibonacci [n]
  (letfn [(acc [current next n]
            (if (zero? n)
              current
              (recur next (+ current next) (dec n))))]
    (acc 0N 1N n)))

; Self-recursion with loop
(defn fibonacci [n]
  (loop [current 0N next 1N n n]
    (if (zero? n)
      current
      (recur next (+ current next) (dec n)))))

; Uses fibonacci-seq
(defn fibonacci [n] (nth (fibonacci-seq) n))

; lazy-seq
(defn fibonacci-seq
  ([]
   (concat [0 1] (fibonacci-seq 0N 1N)))
  ([a b]
   (let [n (+ a b)]
     (lazy-seq
       (cons n (fibonacci-seq b n))))))

; lazy seq with buil-in functions
(defn fibonacci-seq [] (map first (iterate (fn [[a b]] [b (+ a b)]) [0N 1N])))
