import pt.isel.canvas.*

//data class Direction(val dx:Int, val dy:Int)

enum class Direction(val dx:Int, val dy:Int, val key:Int) {
    DOWN(0,1,DOWN_CODE), LEFT(-1,0,LEFT_CODE), RIGHT(1,0,RIGHT_CODE), UP(0,-1,UP_CODE)
}

fun directionOf(key :Int) = Direction.values().firstOrNull { it.key==key }
/*
when (key) {
    UP_CODE -> Direction.UP
    DOWN_CODE -> Direction.DOWN
    LEFT_CODE -> Direction.LEFT
    RIGHT_CODE -> Direction.RIGHT
    else -> null
}*/

fun Direction?.dx() :Int = this?.dx ?: 0
/*
    when (this) {
    Direction.LEFT -> -1
    Direction.RIGHT -> 1
    else -> 0
}*/

fun Direction?.dy() = this?.dy ?: 0