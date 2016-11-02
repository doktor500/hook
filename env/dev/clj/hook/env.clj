(ns hook.env
  (:require
    [selmer.parser         :as parser]
    [clojure.tools.logging :as log]
    [hook.dev-middleware   :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "service started successfully using the development profile"))
   :stop
   (fn []
     (log/info "service has shut down successfully"))
   :middleware wrap-dev})
