import pt.isel.canvas.*

fun start() {
    println("Start")
    Canvas(400,200, CYAN)
    Canvas(100,50, RED)
}

fun main() {
    println("Begin")
    onStart(::start)
    onFinish {
        println("Finish")
    }
    println("End")
}