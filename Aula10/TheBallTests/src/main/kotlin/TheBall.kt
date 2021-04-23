import pt.isel.canvas.*

private fun Canvas.drawBall(b: Ball) {
    erase()
    val color = b.motion.toColor()
    drawCircle(b.position.x, b.position.y ,b.radius ,color)
}

private fun Motion.toColor() = when {
    dx >= 0 && dy <= 0 -> RED
    dx >= 0 && dy >= 0 -> GREEN
    dx <= 0 && dy >= 0 -> BLACK
    else -> BLUE
}

fun main() {
    onStart {
        val cv = Canvas(400,300, CYAN)
        var ball = Ball( Position(100,150), Motion(+2,+2) ,RADIUS)
        cv.drawBall(ball)
        cv.onTimeProgress(20) {
            ball = ball.move(cv.width,cv.height)
            cv.drawBall(ball)
        }
        cv.onKeyPressed {
            ball = ball.processKey(it.char).processCursor(it.code)
            if (it.code== ESCAPE_CODE) cv.close()
        }
        cv.onMouseDown { ball = ball.copy( position = Position(it.x, it.y)) }
    }
    onFinish { println("Bye") }
}