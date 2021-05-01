val VELOCITY_LIMIT = 6
val VELOCITY_RANGE = -VELOCITY_LIMIT..VELOCITY_LIMIT

data class Position(val x:Int, val y:Int)

data class Motion(val dx:Int, val dy:Int)

operator fun Position.plus(m: Motion) = Position( x + m.dx, y + m.dy )

fun Int.reverseIf(condition: Boolean) = if (condition) -this else this

fun Motion.reverseIfCollide(p:Position, xLim:Int, yLim:Int, radius: Int) = Motion(
    dx.reverseIf(dx>0 && p.x > xLim-radius || dx<0 && p.x < radius),
    dy.reverseIf(dy>0 && p.y > yLim-radius || dy<0 && p.y < radius)
)

fun randomMotion() = Motion( VELOCITY_RANGE.random(), VELOCITY_RANGE.random())