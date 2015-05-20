(ns intro
  (:require [clojure.repl :refer :all]))

;; function(arg1, arg2, arg3) -> (function args1, arg2, arg3) -> (function arg1 arg2 arg3)

(def forms
  {
   :nil         nil
   :boolean     true
   :long        42
   :double      42.0
   :big-integer 42N
   :big-decimal 42M
   :ratio       1/3
   :character   \p
   :string      "Quick Brown Fox"
   :regex       #"[\w\d]+"
   :keyword     :quick-brown-fox
   :symbol      contains?                                   ; cannot start with a number but can consist of alphanumeric characters, plus +, -, *, /, !, ?, ., and _
   :vector      [1 1 2 3 5 8 13 21]
   :list        (:quick :brown :fox)
   :map         {:name "Alan" :age 42}
   :set         #{1 2 3}
   :var         (def answer 42)
   :function    (fn [arg & rest] "42")
   :function'   #(.toUpperCase %)})                         ;  %, %n, %&

; REPL

(doc identity)
(find-doc #"\?$")
(source identity)

(str *1 *2 *3)
(pst *e 5)

; Functions

(fn [name] (str "Hello " name))

(def greeting (fn [name] (str "Hello " name)))

(defn greeting [name]
  (str "Hello " name))

(defn greeting
  ([] (greeting "incognito"))
  ([name] (str "Hello " name)))

(defn make-greater [prefix] #(str prefix ", " %))
(def aloha (make-greater "Aloha"))
(aloha "Kimona")

; Flow Control

(if (even? 42) "truthy" "falsy")

(do (println "side-effect") (str "result"))

(when true (println "exec") (str "x"))

(when-not false (println "exec") (str "x"))

(cond
  (> 0 1) "ans1"
  (< 0 1) "ans2"
  :else "otherwise")

(loop [result [] x 5]
  (if (zero? x)
    result
    (recur (conj result x) (dec x))))

(defn countdown [result x]
  (if (zero? x)
    result
    (recur (conj result x) (dec x))))

; Destructuring

(defn greet-author [author] (str "Hello," (:first-name author)))
(defn greet-author [{fname :first-name}] (str "Hello, " fname))

(let [[x y] [1 2 3]]
  [x y])

(let [[_ _ z] [1 2 3]]
  z)

(let [[a b c & d :as e] [1 2 3 4 5 6 7]]
  [a b c d e])

(let [[[x1 y1] [x2 y2]] [[1 2] [3 4]]]                      ; Can be nested
  [x1 y1 x2 y2])

(let [[a b & c :as str] "asdjhhfdas"]                       ; Strings work too
  [a b c str])

(let [{a :a, b :b, c :c, :as m :or {a 2 b 3}} {:a 5 :c 6}]  ; Maps
  [a b c m])

(let [{:keys [a b c] :or {a 2 b 3}} {:a 5 :c 6}]            ; :keys shorthand
  [a b c])
