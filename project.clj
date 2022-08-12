(defproject omscs "0.1.0-SNAPSHOT"
  :repl-options {:init-ns omscs.core}
  :main omscs.core
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [etaoin "1.0.38"]]
  :profiles {:dev {:plugins [[com.jakemccrary/lein-test-refresh "0.25.0"]]}})
