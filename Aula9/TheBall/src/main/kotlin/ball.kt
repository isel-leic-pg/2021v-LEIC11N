import pt.isel.canvas.DOWN_CODE
import pt.isel.canvas.LEFT_CODE
import pt.isel.canvas.RIGHT_CODE
import pt.isel.canvas.UP_CODE

private val RADIUS_LIMITS = 10..120
const val RADIUS = 50

data class Ball(val position:Position, val motion:Motion, val radius:Int)

fun Ball.move(xLimit:Int, yLimit:Int) :Ball {
    val pos = position + motion
    return Ball( pos, motion.reverseIfCollide(pos,xLimit,yLimit,radius), radius )
}

fun Ball.processKey(key: Char) = when {
    key=='r' && radius>RADIUS_LIMITS.first -> copy( radius = radius -1 )
    key=='R' && radius<RADIUS_LIMITS.last -> copy( radius = radius +1 )
    key=='m' -> copy( motion = randomMotion() )
    key=='s' -> copy( motion = Motion(0,0) )
    else -> this
}

fun Ball.processCursor(code:Int) :Ball {
    val (x,y) = position
    return copy ( position = when (code) {
        UP_CODE -> Position(x,y-1)
        DOWN_CODE -> position.copy(y=y+1)
        LEFT_CODE -> position + Motion(-1,0)
        RIGHT_CODE -> Position(x+1,y)
        else -> position
    } )
}
