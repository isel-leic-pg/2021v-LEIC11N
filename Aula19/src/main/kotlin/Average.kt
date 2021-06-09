

fun main() {
    println("Média = ${readLines()
        .map { it.toInt() }
        .average()}")

    /*
    val lines = readLines()
    val numbers = lines.map { it.toInt() }
    var sum = 0
    numbers.forEach { sum += it }
    val avg = sum.toFloat() / numbers.size
    println("Média = $avg")
    println("Média = ${numbers.average()}")
    */
}