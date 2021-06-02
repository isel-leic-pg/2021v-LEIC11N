import pt.isel.canvas.*

const val HOME_CODE = 36
const val END_CODE = 35
const val PGDOWN_CODE = 34
const val PGUP_CODE = 33

enum class Direction(val dx:Int, val dy:Int, val key:Int) {
    DOWN(0,1,DOWN_CODE), LEFT(-1,0,LEFT_CODE), RIGHT(1,0,RIGHT_CODE), UP(0,-1,UP_CODE),
    LEFT_UP(-1,-1,HOME_CODE), LEFT_DOWN(-1,1,END_CODE),
    RIGHT_UP(1,-1,PGUP_CODE), RIGHT_DOWN(1,1,PGDOWN_CODE)
}

fun directionOf(key :Int) = Direction.values().firstOrNull { it.key==key }

fun Direction?.dx() :Int = this?.dx ?: 0

fun Direction?.dy() = this?.dy ?: 0

fun Int.toSign() = when { this<0 -> -1  this>0 -> +1  else -> 0 }

fun Motion.toDirection() :Direction? {
    val dxu = dx.toSign()
    val dyu = dy.toSign()
    return Direction.values().firstOrNull{ it.dx==dxu && it.dy==dyu }
}
/*= when {
    dx==0 && dy>0 -> Direction.DOWN
    dx==0 && dy<0 -> Direction.UP
    dx>0 && dy==0 -> Direction.RIGHT
    dx<0 && dy==0 -> Direction.LEFT
    dx>0 && dy>0  -> Direction.RIGHT_DOWN
    dx>0 && dy<0  -> Direction.RIGHT_UP
    dx<0 && dy>0  -> Direction.LEFT_DOWN
    dx<0 && dy<0  -> Direction.LEFT_UP
    else -> null
}*/