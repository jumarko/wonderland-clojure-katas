(ns wonderland-number.finder)

(defn- hasAllTheSameDigits? [n1 n2]
  (let [s1 (set (str n1))
        s2 (set (str n2))]
    (= s1 s2)))

(defn wonderland-number []
  ;; calculate me
  (first (filter #(and (hasAllTheSameDigits? % (* % 2))
                       (hasAllTheSameDigits? % (* % 3))
                       (hasAllTheSameDigits? % (* % 4))
                       (hasAllTheSameDigits? % (* % 5))
                       (hasAllTheSameDigits? % (* % 6))
                       ) (range 100000 200000))))

(wonderland-number)
