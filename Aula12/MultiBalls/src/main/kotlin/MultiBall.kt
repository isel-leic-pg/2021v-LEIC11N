import pt.isel.canvas.*

private fun Canvas.drawBalls(bs :List<Ball>) {
    erase()
    bs.forEach {  b ->
        val color = b.motion.toColor()
        drawCircle(b.position.x, b.position.y, b.radius, color)
    }
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
        var balls: List<Ball> = listOf()
        cv.drawBalls(balls)
        cv.onTimeProgress(20) {
            balls = balls.map { it.move(cv.width,cv.height) }
            cv.drawBalls(balls)
            cv.drawText(10,30,"${balls.size}")
        }
        cv.onKeyPressed {
            if (it.code== ESCAPE_CODE) cv.close()
            if (it.char=='b')
                balls = balls + Ball( Position(100,150), Motion(+2,+2) ,RADIUS)
            if (it.char=='r')
                balls = balls.filter{  !(it.motion.dx>=0 && it.motion.dy<=0) }
        }
        cv.onMouseDown { me ->
            val clicked = balls.filter {  distance(it.position, Position(me.x,me.y)) < it.radius  }
            balls = balls - clicked

        }
    }
    onFinish { println("Bye") }
}