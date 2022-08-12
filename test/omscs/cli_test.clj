(ns omscs.cli-test
  (:require [clojure.test :refer [deftest testing is]]
            [omscs.cli :as sut]))

(deftest args->map-test
  (testing "returns empty map if args list is empty"
    (let [result (sut/args->map (list))]
      (is (= {} result))))
  (testing "returns expected map for single-value args "
    (let [result (sut/args->map (list "-argA" "Ay!" "-argB" "Bee?"))]
      (is (= {:argA "Ay!" :argB "Bee?"} result))))
  (testing "correctly concatenates multi part values"
    (let [result (sut/args->map (list "-argA" "Two" "parts"))]
      (is (= {:argA "Two parts"} result)))))
