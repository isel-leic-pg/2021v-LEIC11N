import pt.isel.canvas.*

const val RADIUS = 50

data class Ball(val x:Int, val y:Int, val dx:Int, val dy:Int, val radius:Int)

fun moveBall(xLimit:Int, yLimit:Int, b:Ball) :Ball {
    val x = b.x + b.dx
    val y = b.y + b.dy
    return Ball(
        x, y,
        if ( x in b.radius..xLimit-b.radius ) b.dx else -b.dx,
        if ( y in b.radius..yLimit-b.radius ) b.dy else -b.dy,
        b.radius
    )
}

fun drawBall(c :Canvas, b: Ball) {
    c.erase()
    c.drawCircle(b.x, b.y ,b.radius ,RED)
}

/*
fun Ball.copy( x:Int=this.x , y:Int=this.y, dx:Int=this.dx, dy:Int=this.dy, radius:Int=this.radius) =
    Ball(x,y,dx,dy,radius)
*/

fun processKey(key:Char, b:Ball) :Ball {
    return when (key) {
        'r' -> b.copy( radius = b.radius-1 )
        'R' -> b.copy( radius = b.radius+1 )
        else -> b
    }
}

fun main() {
    onStart {
        val cv = Canvas(400,300, CYAN)
        var ball = Ball(100,150,+2,+2,RADIUS)
        drawBall(cv,ball)
        cv.onTimeProgress(20) {
            ball = moveBall(cv.width,cv.height,ball)
            drawBall(cv,ball)
        }
        cv.onKeyPressed {
            ball = processKey(it.char,ball)
        }
    }
    onFinish {  }
}