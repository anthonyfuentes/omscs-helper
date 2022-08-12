(ns omscs.cli
  (:require [clojure.string :refer [starts-with?]]))

(defn- update-active-arg
  "Updates :active- argument to a keyword of the given arg name"
  [args-map arg-name]
  (let [arg-key (-> arg-name (subs 1) keyword)]
    (merge args-map {arg-key   ""
                     :active-  arg-key})))

(defn- update-active-value
  "Updates value associated with active arg key"
  [args-map value]
  (let [active-key  (:active- args-map)
        active-val  (get args-map active-key)
        new-val     (if (= "" active-val)
                      value
                      (str active-val " " value))]
    (assoc args-map active-key new-val)))

(defn- update-args-map
  "Updates argument map based on current value being prefixed with '-' or not"
  [args-map current]
  (if (starts-with? current "-")
    (update-active-arg args-map current)
    (update-active-value args-map current)))

(defn args->map
  "Converts CLI args to map w/ flag names as keys
  schema: -a b -c d -> {:a 'b' :c 'd'}"
  [arg-list]
  (let [args-map (reduce
                   update-args-map
                   {:active- nil}
                   arg-list)]
    (dissoc args-map :active-)))
