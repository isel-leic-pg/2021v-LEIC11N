import pt.isel.canvas.*

fun main() {
    onStart {
        val cv = Canvas(600,300, CYAN)
        var x = 100
        cv.drawCircle(x,150,50,RED)
        cv.onTimeProgress(20) {
            //println(it)
            x = x+2
            cv.erase()
            cv.drawCircle(x,150,50,RED)
        }
    }
    onFinish {  }
}