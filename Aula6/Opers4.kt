
fun op( p:Char , f:(Int,Int)->Int ) {
    println("Operação $p")
	val a = readInt("A")
	val b = readInt("B")
	val res = f(a,b)
	println("$a $p $b = $res")
}

fun main() {
	op('+', {a,b -> a+b} )
	op('-') {a,b -> a-b}
	op('x') { a,b ->
	  println("Multiplicação")
	  a * b
	}
}