(ns hook.config
  (:require [cprop.core :refer [load-config]]
            [cprop.source :as source]
            [mount.core :refer [args defstate]]
            [selmer.parser :as parser]
            [clojure.tools.logging :as log]))

(defstate env :start (load-config
                       :merge
                       [(args)
                        (source/from-system-props)
                        (source/from-env)]))
