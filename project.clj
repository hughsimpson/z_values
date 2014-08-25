(defproject z_values "0.1.0-SNAPSHOT"
  :description "Calculate z-values"
  :url "http://github.com/hughsimpson/z_values.git"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main z_values.main
  :dependencies [[org.apache.commons/commons-lang3 "3.0"]
                 [org.clojure/data.csv "0.1.2"]
                 [org.clojure/core.typed "0.2.44"]])