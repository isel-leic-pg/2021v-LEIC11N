import pt.isel.canvas.*

const val CELL_SIDE = 128
const val GRID_WIDTH = 6
const val GRID_HEIGHT = 5

const val STEPS_ANIM = 8
const val SPRITE_DIV = 64

/**
 * Represents the virus position.
 * @property position final cell position
 * @property stepAnim step of animation (0->final position; STEPS_ANIM->start position)
 * @property dir direction of animation
 */
data class Hero(val position:Position, val stepAnim:Int =0, val dir:Direction?=null)

fun Canvas.drawArena(hero:Hero) {
    erase()
    drawGrid()
    drawHero(hero)
}

fun Canvas.drawHero(hero: Hero) {
    val x = hero.position.x * CELL_SIDE - hero.stepAnim * (CELL_SIDE / STEPS_ANIM) * hero.dir.dx()
    val y = hero.position.y * CELL_SIDE - hero.stepAnim * (CELL_SIDE / STEPS_ANIM) * hero.dir.dy()
    val xSprite = hero.stepAnim % 4
    val ySprite = when (hero.dir) {
        Direction.DOWN, null -> 0
        Direction.LEFT, Direction.LEFT_UP, Direction.LEFT_DOWN -> 1
        Direction.RIGHT, Direction.RIGHT_UP, Direction.RIGHT_DOWN -> 2
        Direction.UP -> 3
    }
    drawImage("Hero.png|${xSprite * SPRITE_DIV},${ySprite * SPRITE_DIV},64,64", x, y, CELL_SIDE, CELL_SIDE)
}

fun main() {
    //ALL_POSITION.forEach { println(it) }
    onStart {
        val cv = Canvas(GRID_WIDTH*CELL_SIDE,GRID_HEIGHT*CELL_SIDE, BLACK)
        var hero = Hero( Position(GRID_WIDTH/2,GRID_HEIGHT/2) )
        cv.drawArena(hero)
        cv.onKeyPressed { ke:KeyEvent ->
            hero = hero.move(ke)
            cv.drawArena(hero)
        }
        cv.onTimeProgress(50) {
            if (hero.stepAnim > 0) {
                hero = hero.copy(stepAnim = hero.stepAnim - 1)
                cv.drawArena(hero)
            }
        }
    }
    onFinish {  }
}

fun Hero.move(key: KeyEvent): Hero {
    if (key.char=='*') return Hero( randomPosition(position) )
    val dir = directionOf(key.code) ?: return this
    val pos = position + dir
    return if ( pos.isValid() ) Hero(pos,STEPS_ANIM,dir) else this
}


fun Canvas.drawGrid() {
    (CELL_SIDE..width step CELL_SIDE).forEach { x ->
        drawLine(x, 0, x, height, WHITE, 1)
    }
    (CELL_SIDE..height step CELL_SIDE).forEach { y ->
        drawLine(0, y, width, y, WHITE, 1)
    }
}