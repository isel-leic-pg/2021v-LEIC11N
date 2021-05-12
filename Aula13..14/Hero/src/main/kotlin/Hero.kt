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
    val ySprite = (hero.dir ?: Direction.DOWN).ordinal
    drawImage("Hero.png|${xSprite * SPRITE_DIV},${ySprite * SPRITE_DIV},64,64", x, y, CELL_SIDE, CELL_SIDE)
}


fun main() {
    onStart {
        val cv = Canvas(GRID_WIDTH*CELL_SIDE,GRID_HEIGHT*CELL_SIDE, BLACK)
        var hero = Hero( Position(GRID_WIDTH/2,GRID_HEIGHT/2) )
        cv.drawArena(hero)
        cv.onKeyPressed { ke ->
            hero = hero.move(ke.code)
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

fun Hero.move(key: Int): Hero {
    val dir = directionOf(key) ?: return this
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