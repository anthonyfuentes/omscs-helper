(ns omscs.config-test
  (:require [clojure.test :refer [deftest testing is]]
            [omscs.config :as sut]))

(deftest args->map-test
  (testing "returns URL with matching key"
    (let [result (sut/get-url :home-page {:urls {:home-page "https://example.com"}})]
      (is (= "https://example.com" result)))))
