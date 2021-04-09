
fun op( p:Char ) {
    println("Operação $p")
	val a = readInt("A")
	val b = readInt("B")
	val res = when (p) {
		'+' -> a + b
		'-' -> a - b
		'x' -> a * b
		else -> {
		    println("Operação inválida")
			0    // code smell
		}
	}
	println("$a $p $b = $res")
}

fun main() {
	op('+')
	op('-')
	op('x')
	op('$')
}