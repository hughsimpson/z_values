(ns z_values.main
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io])
  (:gen-class))
;;define 'sum' function
(defn sum [seq] (reduce #(+ %1 %2) seq))
;;z-value function
(defn z_values [seq]
  (let [mean                          (/ (sum seq) (count seq))
        squared_difference_from_mean  (map #(* (- %1 mean) (- %1 mean)) seq)
        variance                      (/ (sum squared_difference_from_mean) (- (count seq) 1))
        standard_deviation            (Math/sqrt variance)] ;; _sample_ standard deviation
    (map #(/ (- % mean) standard_deviation) seq)))
;;raw data
(def data
  (with-open [in-file (io/reader "resources/dummyData.csv")]
    (doall
      (csv/read-csv in-file))))
;; value seqs
(def lengths (map #(let [[x _] %] (Double/parseDouble x)) (rest data)))
(def widths (map #(let [[_ x] %] (Double/parseDouble x)) (rest data)))
;; write to csv
(defn write [seq]
  (with-open [out-file (io/writer "resources/out-file2.csv")]
    (csv/write-csv out-file
      seq)))
;; main function
(defn -main []
  (write
    (map vector (z_values lengths) (z_values widths))))