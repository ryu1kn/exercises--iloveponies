(ns recursion)

(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll)
       (product (rest coll)))))

;   (product [1 2 4])
; = (product (cons 1 (cons 2 (cons 4 '()))))
; = (* 1 (product (cons 2 (cons 4 '()))))
; = (* 1 (* 2 (product (cons 4 '()))))
; = (* 1 (* 2 (* 4 (product '()))))
; = (* 1 (* 2 (* 4 1)))
; = (* 1 (* 2 4))
; = (* 1 8)
; = 8

(defn singleton? [coll]
  (let [r (rest coll)]
    (and (empty? r) (not= r coll))))

(defn at-most-one? [coll] (empty? (rest coll)))

(defn my-last [coll]
  (if (at-most-one? coll)
    (first coll)
    (my-last (rest coll))))

(defn max-element [a-seq]
  (let [fst (first a-seq)]
    (if (at-most-one? a-seq)
      fst
      (max fst (max-element (rest a-seq))))))

(defn not-longer? [seq-1 seq-2]
  (let [rest1 (rest seq-1)
        rest2 (rest seq-2)]
    (or
      (empty? rest1)
      (if (empty? rest2)
        false
        (not-longer? rest1 rest2)))))

(defn seq-max [seq-1 seq-2]
  (if (not-longer? seq-1 seq-2) seq-2 seq-1))

(defn longest-sequence [a-seq]
  (let [fst (first a-seq)]
    (if (at-most-one? a-seq)
      fst
      (seq-max fst (longest-sequence (rest a-seq))))))

(defn my-filter [pred? a-seq]
  (if (empty? a-seq) a-seq
    (let [h (first a-seq)
          r (my-filter pred? (rest a-seq))]
      (if (pred? h) (cons h r) r))))

(defn sequence-contains? [elem a-seq]
  :-)

(defn my-take-while [pred? a-seq]
  [:-])

(defn my-drop-while [pred? a-seq]
  [:-])

(defn seq= [a-seq b-seq]
  :-)

(defn my-map [f seq-1 seq-2]
  [:-])

(defn power [n k]
  :-)

(defn fib [n]
  :-)

(defn my-repeat [how-many-times what-to-repeat]
  [:-])

(defn my-range [up-to]
  [:-])

(defn tails [a-seq]
  [:-])

(defn inits [a-seq]
  [:-])

(defn rotations [a-seq]
  [:-])

(defn my-frequencies-helper [freqs a-seq]
  [:-])

(defn my-frequencies [a-seq]
  [:-])

(defn un-frequencies [a-map]
  [:-])

(defn my-take [n coll]
  [:-])

(defn my-drop [n coll]
  [:-])

(defn halve [a-seq]
  [:-])

(defn seq-merge [a-seq b-seq]
  [:-])

(defn merge-sort [a-seq]
  [:-])

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])

