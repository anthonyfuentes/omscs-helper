(ns omscs.course-schedule
  (:require [etaoin.api :as e]
            [omscs.config :as conf]))

(defn goto-term-course-search
  "Navigates to GT schedule of classes for given term"
  [term-name]
  (let [driver            (e/chrome)
        term-select-query {:name "p_term"}]
    (doto driver
      (e/go (conf/get-url :schedule-of-classes))
      (e/wait-visible term-select-query)
      (e/select term-select-query term-name)
      (e/click {:value "Submit"}))
    driver))

(defn search-for-omscs-courses
  "Searches for CS courses provided via Online campus"
  [driver]
  (let [subject-select-query  {:id "subj_id"}
        campus-select-query   {:id "camp_id"}]
    (doto driver
      (e/wait-visible subject-select-query)
      (e/select subject-select-query "Computer Science")
      (e/wait-visible campus-select-query)
      (e/select campus-select-query "Online")
      (e/click {:value "Class Search"})))
  driver)

(defn open-o01-course-pages
  "Opens pages for given courses"
  [driver courses]
  (e/wait-visible driver
                  {:tag :h5 :fn/has-text "2022 Ellucian Company"})
  (dorun
    (for [course courses]
      (e/middle-click-on driver
                         {:tag :a :fn/has-text (str course " - O01")})))
  driver)
