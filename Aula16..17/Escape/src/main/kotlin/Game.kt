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
data class Game(val hero:Actor, val stepAnim:Int=0, val robots:List<Actor>, val junks:List<Position>)

fun Game.jumpHero() =
    Actor( (ALL_POSITION - hero.position - robots.map{ it.position } - junks).random(), null )

fun Game.move(key: KeyEvent): Game {
    if (key.char=='*') return copy( hero = jumpHero() )
    val dir = directionOf(key.code) ?: return this
    val pos = hero.position + dir
    if ( ! pos.isValid() || robots.any { it.position==pos }  ) return this
    val afterRobots = robots.moveTo(pos)
    return Game( Actor(pos,dir), STEPS_ANIM , afterRobots , junks  )
}

fun Game.collisions() :Game {
    val garbage = robots.map { it.position }.repeated() + junks
    val afterRobots = robots.filter { r -> r.position !in garbage }
    return copy( robots = afterRobots, junks = garbage )
}

fun List<Actor>.moveTo( p:Position ) :List<Actor> =
    map{ r ->
        val dir = (p - r.position).toDirection()
        if (dir==null) r else Actor( r.position+dir , dir)
    }

fun createGame() :Game {
    val hero = Actor(Position(GRID_WIDTH / 2, GRID_HEIGHT / 2), null)
    val robots = createRobots(hero.position)
    return Game(hero, robots = robots, junks = emptyList() )
}

