(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [m] (< m n)))

(defn equal-to [n]
  (fn [m] (== m n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn my-some [pred a-seq]
  (reduce #(or %1 %2) (concat (map pred a-seq) [false])))

(defn my-every? [pred a-seq]
  (reduce #(and %1 %2) (concat (map pred a-seq) [true])))

(defn blank? [string]
  (my-every? whitespace? string))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (my-every? (partial has-award? book) awards))

(defn prime? [n]
  (let [pred (fn [m] (= 0 (mod n m)))]
    (not (some pred (range 2 n)))))
