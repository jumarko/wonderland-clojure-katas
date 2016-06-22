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

(defn- translate-char [operation first-char second-char]
  (char-value
   (mod  (operation
          (num-value first-char)
          (num-value second-char)) 26)))

(defn- encode-char [keyword-char word-char]
  (translate-char + keyword-char word-char))

(defn- decode-char [keyword-char encoded-char]
  (translate-char - encoded-char keyword-char))

(defn- decipher-char [encoded-char word-char]
  (translate-char - encoded-char word-char))

(defn- translate [translate-char-fn keyword message]
  (let [message-size (count message)
        keyword-chars (take message-size (cycle keyword))
        translated-chars (map translate-char-fn keyword-chars  message)]
    (apply str translated-chars)))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Public
(defn encode [keyword message]
  (translate encode-char keyword message))

(defn decode [keyword encrypted-message]
  (translate decode-char keyword encrypted-message))

(defn decipher [cipher message]
  (let [full-length-keyword (translate decipher-char cipher message)]
    ;; TODO we need to cut the reamining chars from full-length-keyword to get simple keyword
    full-length-keyword))
