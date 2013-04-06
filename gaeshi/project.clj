(let [config (load-file "../config.clj")
      dev-deps [['speclj (:speclj-version config)]
                ['gaeshi/gaeshi-dev (:version config)]]]

  (defproject gaeshi/gaeshi (:version config)
    :description "Runtime library for Gaeshi, a Clojure framework for Google App Engine apps."
    :license {:name "The MIT License"
              :url "file://LICENSE"
              :distribution :repo
              :comments "Copyright (c) 2011-2012 Micah Martin All Rights Reserved."}
    :repositories {"releases" "http://gaeshi-mvn.googlecode.com/svn/trunk/releases/"}
    :dependencies [[org.clojure/clojure "1.5.1"]
                   ;;[joodo ~(:joodo-version config)]
                   [ring/ring-jetty-adapter "1.1.7"]
                   [chee "1.1.2"]
                   [com.google.appengine/appengine-api-1.0-sdk ~(:gae-version config)]]
    :profiles {:dev {:dependencies ~dev-deps}}
    :plugins ~dev-deps
    :test-paths ["spec/"]
    )
  )
