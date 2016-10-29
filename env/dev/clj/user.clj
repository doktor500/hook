(ns user
  (:require [mount.core :as mount]
            hook.core))

(defn start []
  (mount/start-without #'hook.core/repl-server))

(defn stop []
  (mount/stop-except #'hook.core/repl-server))

(defn restart []
  (stop)
  (start))
