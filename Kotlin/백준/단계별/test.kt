fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el ): List<List<T>> {
    return if(sub.isEmpty()) listOf(fin)
        else sub.flatMap { permutation(el, fin + it, sub - it) }
}

fun <T> combination(el: List<T>, limit: Int = el.size, fin: List<T> = listOf(), index: Int = 0): List<List<T>> {
	return if (fin.size >= limit) {
		listOf(fin)
	} else {
		el.slice(index until el.size).flatMapIndexed { i: Int, t: T -> combination(el, limit, fin + t, index + i + 1) }
	}
}