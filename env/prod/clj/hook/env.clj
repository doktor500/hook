(ns hook.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "service started successfully"))
   :stop
   (fn []
     (log/info "service has shut down successfully"))
   :middleware identity})
