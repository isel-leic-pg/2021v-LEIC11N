
val PI = 3.14159

fun circleArea(radius:Double) = PI * radius * radius

fun main() {
	val r = readDouble("Raio")
	val area = circleArea(r)
	println("Área = $area")
}