
fun op( p:Char , f:(Int,Int)->Int ) {
    println("Operação $p")
	val a = readInt("A")
	val b = readInt("B")
	val res = f(a,b)
	println("$a $p $b = $res")
}

fun plus(a:Int,b:Int) = a + b
fun minus(a:Int,b:Int) = a - b
fun times(a:Int,b:Int) = a * b

fun main() {
	op('+',::plus)
	op('-',::minus)
	op('x',::times)
}