(ns hook.core.routes
  (:require
    [compojure.api.sweet     :refer [defroutes GET]]
    [ring.util.http-response :refer [created]]))

(defroutes api-routes
  (GET "/index" {body :body}
    (created {:status "OK"})))
