import pt.isel.canvas.*

const val VIRUS_SIDE = 64
const val GRID_WIDTH = 12
const val GRID_HEIGHT = 10

data class Virus(val x:Int, val y:Int)

fun Canvas.drawVirus(v:Virus) {
    erase()
    drawGrid()
    drawImage("Virus.png", v.x*VIRUS_SIDE, v.y*VIRUS_SIDE, VIRUS_SIDE, VIRUS_SIDE)
}


fun main() {
    onStart {
        val cv = Canvas(GRID_WIDTH*VIRUS_SIDE,GRID_HEIGHT*VIRUS_SIDE, BLACK)
        var virus = Virus(GRID_WIDTH/2,GRID_HEIGHT/2)
        cv.drawVirus(virus)
        cv.onKeyPressed { ke ->
            virus = virus.move(ke.code)
            cv.drawVirus(virus)
        }
    }
    onFinish {  }
}

fun Virus.move(key: Int): Virus = when {
    key==UP_CODE && y>0                 -> Virus(x,y-1)
    key==DOWN_CODE && y<GRID_HEIGHT-1   -> Virus(x,y+1)
    key==LEFT_CODE && x>0               -> Virus(x-1,y)
    key==RIGHT_CODE && x<GRID_WIDTH-1   -> Virus(x+1,y)
    else -> this
}

fun Canvas.drawGrid() {
    (VIRUS_SIDE..width step VIRUS_SIDE).forEach { x ->
        drawLine(x, 0, x, height, WHITE, 1)
    }
    (VIRUS_SIDE..height step VIRUS_SIDE).forEach { y ->
        drawLine(0, y, width, y, WHITE, 1)
    }
}