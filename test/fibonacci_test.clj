(ns fibonacci-test
  (:require [clojure.test :refer :all]
            [fibonacci :refer :all]))

(deftest fibonacci-numbers

  (testing "nth fibonacci"
    (is (= (fibonacci 0) 0))
    (is (= (fibonacci 1) 1))
    (is (= (fibonacci 2) 1))
    (is (= (fibonacci 9) 34))
    (is (= (fibonacci 20) 6765))
    (is (= (fibonacci 300) 222232244629420445529739893461909967206666939096499764990979600N)))

  (testing "fibonacci sequence"
    (is (= (take 10 (fibonacci-seq)) '(0 1 1 2 3 5 8 13 21 34)))))
