(ns hook.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [hook.layout :refer [error-page]]
            [hook.core.routes :refer [api-routes]]
            [compojure.route :as route]
            [hook.env :refer [defaults]]
            [mount.core :as mount]
            [hook.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'api-routes
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "not found"})))))

(def hook-app (middleware/wrap-base #'app-routes))
(defn app [] hook-app)
