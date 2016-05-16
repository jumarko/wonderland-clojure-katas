(ns alphabet-cipher.coder)

(defn- num-value [ch]
  (- (int ch) (int \a)))

(defn- char-value [num]
  (char (+ num (int \a))))


;;; Motivation:
;;; a -> 0
;;; b -> 1
;;; ...
;;; z -> 25
;;; => mod 26

(defn encode-char [keyword-char word-char]
  (char-value
   (mod  (+
          (num-value keyword-char)
          (num-value word-char)) 26)))


(defn encode [keyword message]
  (let [message-size (count message)
        keyword-chars (take message-size (cycle keyword))
        encoded-chars (map encode-char keyword-chars  message)]
    (apply str encoded-chars)
    ))

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")
