(ns omscs.core
  (:require [omscs.cli :as cli]
            [omscs.config :as conf]
            [omscs.course-schedule :as sched]))

(defn -main
  [& args]
  (let [args-map (cli/args->map args)]
    (-> (:term args-map)
        sched/goto-term-course-search
        sched/search-for-omscs-courses
        (sched/open-o01-course-pages (:courses conf/all)))))
