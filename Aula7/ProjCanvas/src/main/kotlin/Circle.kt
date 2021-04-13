import pt.isel.canvas.*

fun main() {
    onStart {
        val cv = Canvas(600,300, WHITE)
        cv.drawCircle(300,150,100,RED)
        cv.drawCircle(50,50,50, GREEN)
        cv.drawCircle(550,250,45, BLACK,10)
        cv.onMouseDown { mouse ->
            println(mouse)
            cv.drawCircle(mouse.x,mouse.y,5, BLACK)
        }
    }
    onFinish {  }
}