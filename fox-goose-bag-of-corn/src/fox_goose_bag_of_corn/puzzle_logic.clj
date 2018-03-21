(ns fox-goose-bag-of-corn.puzzle-logic
  (:require [clojure.core.logic :as l]))

(def start-pos [[[:fox :goose :corn :you] [:boat] []]])

(defn river-crossing-plan []
  "The idea of safe crossing plain is as follows:
   - take goose to the other side and leave it there
   - take fox to the other side, leave it there, but take goose back to the first bank to make it safe
   - take corn to the other side to make it safe and leave goose on the first bank
   - finally go back and take goose once again to the other side -> all pieces are now on the other side of river"
  [
   [[:fox :goose :corn :you] [:boat] []]
   [[:fox :corn] [:boat :you :goose] []]
   [[:fox :corn] [:boat] [:you :goose]]
   [[:fox :corn ] [:boat :you] [:goose]]
   [[:fox :corn :you] [:boat] [:goose]]
   [[:corn] [:boat :you :fox] [:goose]]
   [[:corn] [:boat] [:goose :you :fox]]
   [[:corn] [:boat :you :goose] [:fox]]
   [[:corn :you :goose] [:boat] [:fox]]
   [[:goose] [:boat :you :corn] [:fox]]
   [[:goose] [:boat] [:fox :you :corn]]
   [[:goose] [:boat :you] [:fox :corn]]
   [[:goose :you] [:boat] [:fox :corn]]
   [[] [:boat :you :goose] [:fox :corn]]
   [[] [:boat] [:fox :corn :you :goose]]
   ])
