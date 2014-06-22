(ns data-structures.sandbox)

;; SEQ IN SEQ OUT

; 1/ Shorter seq from a longer seq

; distinct => takes coll. returns a lazy seq with the duplicates removed.
(distinct [1 2 2 3 4 5])

; filter => takes a function and coll. Iterates coll passing each argument into the function, returns a lazy seq of the arguments for which the function returns true.
; the opposite of [remove]
(filter #(> % 3) [1 2 3 4 5])

; remove => the opposite of [filter]
(remove #(> % 3) [1 2 3 4 5])

; for => ugly python-like list comprehension

; keep => takes function, collection. returns a lazy sequence of non-nil results of (f item)
; passes 1 argument into the function (item)
(keep #(if (even? %) % nil) (range 1 10))

; keep-indexed => same as keep...
; passes 2 arguments into the function (index, item)
(keep-indexed #(if (even? %1) %2 nil) [:a :b :c :d])

; 2/ Longer seq from a shorter seq

; cons => returns a new seq with x as the first element
(cons 15 [:a :b :c])

; concat => merges colls together into one seq
(concat [1 2 3] {:a "b" :b "c"})
(concat [1 2 3] [4 5 6] #{11})

; lazy-cat
(lazy-cat (range 10) [11 12 13])

; mapcat => maps over a collection applying function to each item. It then concats the mapped values together in a lazy-seq.
; 2 arguments. function and collection.
; The map function needs to return a collection
(mapcat reverse [[5 6 7] [1 2 3] [4 12 8]])

; cycle => returns an infinite sequence of cycling through the items in the collection
; takes a collection
(take 100 (cycle [1 2 3]))

; interleave => returns a lazy seq of the first item in each collection then the second etc...
; needs at least 2 arguments
; the return value is one large lazy seq
(interleave [10 20 30] [:a :b :c] ["jordan" "shaun" "tyler"])

; interpose => returns a lazy seq of all items in the collection interleaved with a collection of the separator
; (seperator collection)
(interpose "," ["jordan" "shaun" "tyler"])

; 3/ Seq with head items missing

; rest => returns the collection without the first item
; this is good for recursive looping
(rest [1 2 3])

; next => same things as [rest]
; use rest
(next [1 2 3])

; fnext => gets the second item ... (first (next) %)
(fnext [[1 2 3] [4 5 6]])

; nnext... (next (next %))
; third ... end
(nnext [1 2 3 4 5])

; drop => removes the first *number* in a collection
; (number collection)
(drop 5 (range 10))

; drop-while => removes the first n items while the function is true
; (predicate collection)
(drop-while #(> 10 %) (range 100))

; nthnext => drops the first n number of arguments
(nthnext [1 2 3 4 5 6 7 8 9 10] 7)
(drop 7 [1 2 3 4 5 6 7 8 9 10])

; 4/ Seq with tail items missing

; take => opposite of [drop]
(take 5 (range 10))

; take-nth => really cool, take every nth
(take-nth 5 (range 100))

; take-while => opposite of drop-while, take until false
(take-while #(> 10 %) (range 100))

; butlast => everything in the collection but the last item
(butlast [1 2 3 4 5])

; drop-last => everything in the collection but the last n items
; (number collection)
(drop-last 85 (range 100))

; 5/ Rearragnement of a seq

; 6/ Create nested seqs

; 7/ Process each item in a seq

;; USING SEQ

; 1/ Extract specific numbered item from a seq

; 2/ Construct a collection from a seq

; 3/ Pass items of a seq as arguments to a function

; 4/ Compute a boolean from a seq

; 5/ Search a seq using a predicate

; 6/ Force evaluation of lazy seqs

; 7/ Check if lazy seqs have been realized

;; CREATING A SEQ

; 1/ Lazy seq from collection

; 2/ Lazy seq from producer function

; 3/ Lazy seq from constant

; 4/ Lazy seq from other objects
