
fun opPlus() {
    println("Operação +")
	val a = readInt("A")
	val b = readInt("B")
	val res = a + b
	println("$a + $b = $res")
}

fun opMinus() {
    println("Operação -")
	val a = readInt("A")
	val b = readInt("B")
	val res = a - b
	println("$a - $b = $res")
}

fun opMultiply() {
    println("Operação x")
	val a = readInt("A")
	val b = readInt("B")
	val res = a * b
	println("$a x $b = $res")
}

fun main() {
	opPlus()
	opMinus()
	opMultiply()
}