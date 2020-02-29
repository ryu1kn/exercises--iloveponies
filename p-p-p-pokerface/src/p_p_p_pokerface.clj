(ns p-p-p-pokerface)

(def rank-chars {\T 10, \J 11, \Q 12, \K 13, \A 14})

(defn rank [card]
  (let [[r _] card]
    (Integer/valueOf
      (str (if (Character/isDigit r) r (rank-chars r))))))

(defn suit [card]
  (let [[_ s] card] (str s)))

(defn pair? [hand]
  (= 2 (apply max (vals (frequencies (map rank hand))))))

(defn three-of-a-kind? [hand]
  (= 3 (apply max (vals (frequencies (map rank hand))))))

(defn four-of-a-kind? [hand]
  (= 4 (apply max (vals (frequencies (map rank hand))))))

(defn flush? [hand]
  (= 5 (apply max (vals (frequencies (map suit hand))))))

(defn full-house? [hand]
  (= [2 3] (sort (vals (frequencies (map rank hand))))))

(defn two-pairs? [hand]
  (= [1 2 2] (sort (vals (frequencies (map rank hand))))))

(defn within-4? [ranks]
  (= 4 (- (apply max ranks) (apply min ranks))))

(defn five-steps? [ranks]
  (and (= 5 (count ranks))
    (or
      (within-4? ranks)
      (within-4? (replace {14 1} ranks)))))

(defn straight? [hand]
  (let [ranks (keys (frequencies (map rank hand)))]
    (five-steps? ranks)))

(defn straight-flush? [hand]
  (and (straight? hand) (flush? hand)))

(defn high-card? [hand] true)

(defn value [hand]
  (let [checker #{[high-card? 0]
                  [pair? 1]
                  [two-pairs? 2]
                  [three-of-a-kind? 3]
                  [straight? 4]
                  [flush? 5]
                  [full-house? 6]
                  [four-of-a-kind? 7]
                  [straight-flush? 8]}]
    (apply max
      (map #(second %) (filter #((first %) hand) checker)))))
