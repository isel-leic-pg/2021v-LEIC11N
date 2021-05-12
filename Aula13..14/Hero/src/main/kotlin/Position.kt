
data class Position(val x:Int, val y:Int)

operator fun Position.plus( dir :Direction ) = Position( x + dir.dx() , y + dir.dy() )

fun Position.isValid() = x in 0 until GRID_WIDTH && y in 0 until GRID_HEIGHT