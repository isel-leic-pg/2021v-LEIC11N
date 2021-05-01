fun main() {
    var x :Int? = null
    println(x)
    x = 10
    println(x)

    fx()
}

fun fx() {
    print("Line? ")
    val maybeLine = readLine()
    println(maybeLine)

    val len:Int = maybeLine?.length ?: 0
    println(len)

    println(maybeLine?.toUpperCase())
}