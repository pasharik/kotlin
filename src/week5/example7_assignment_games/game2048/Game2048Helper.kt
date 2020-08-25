package week5.example7_assignment_games.game2048

/*
 * This function moves all the non-null elements to the beginning of the list
 * (by removing nulls) and merges equal elements.
 * The parameter 'merge' specifies the way how to merge equal elements:
 * it returns a new element that should be present in the resulting list
 * instead of two merged elements.
 *
 * If the function 'merge("a")' returns "aa",
 * then the function 'moveAndMergeEqual' transforms the input in the following way:
 *   a, a, b -> aa, b
 *   a, null -> a
 *   b, null, a, a -> b, aa
 *   a, a, null, a -> aa, a
 *   a, null, a, a -> aa, a
 *
 * You can find more examples in 'TestGame2048Helper'.
*/
fun <T : Any> List<T?>.moveAndMergeEqual(merge: (T) -> T): List<T> =
        this.filterNotNull().let {
            mutableListOf<T>().apply {
                var j = 0
                while (j < it.size) {
                    if ((j + 1) < it.size && it[j] == it[j + 1]) {
                        add(merge(it[j]))
                        j++
                    } else {
                        add(it[j])
                    }
                    j++
                }
            }
        }
