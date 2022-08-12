(ns omscs.config
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]))

(def all
  "Loads all config from /config.edn"
  (->> "config.edn"
       slurp
       edn/read-string))

(defn get-url
  "Gets URL for given key from config"
  ([url-key]
   (get-url url-key all))
  ([url-key config]
   (->> config :urls url-key)))
