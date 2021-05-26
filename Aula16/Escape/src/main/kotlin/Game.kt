import pt.isel.canvas.*

const val CELL_SIDE = 64
const val GRID_WIDTH = 12
const val GRID_HEIGHT = 10

const val STEPS_ANIM = 8
const val SPRITE_DIV = 64

/**
 * Represents the virus position.
 * @property position final cell position
 * @property stepAnim step of animation (0->final position; STEPS_ANIM->start position)
 * @property dir direction of animation
 */
data class Game(val hero:Actor, val stepAnim:Int =0, val robots:List<Actor>)

fun Game.move(key: KeyEvent): Game {
    if (key.char=='*') return copy( hero = Actor(randomPosition(hero.position),null) )
    val dir = directionOf(key.code) ?: return this
    val pos = hero.position + dir
    if ( robots.any { it.position==pos } ) return this
    return if ( pos.isValid() ) copy(hero = Actor(pos,dir), stepAnim=STEPS_ANIM ) else this
}

fun createGame() :Game {
    val hero = Actor(Position(GRID_WIDTH / 2, GRID_HEIGHT / 2), null)
    return Game(hero, robots = createRobots(hero.position) )
}

