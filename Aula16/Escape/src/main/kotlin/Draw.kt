import pt.isel.canvas.Canvas
import pt.isel.canvas.WHITE

fun Canvas.drawArena(game: Game) {
    erase()
    drawGrid()
    drawActor(game.hero,"hero",game.stepAnim)
    game.robots.forEach {
        drawActor(it, "robot", game.stepAnim)
    }
}

private fun Canvas.drawActor(actor: Actor, imageName:String, stepAnim: Int) {
    val x = actor.position.x * CELL_SIDE - stepAnim * (CELL_SIDE / STEPS_ANIM) * actor.dir.dx()
    val y = actor.position.y * CELL_SIDE - stepAnim * (CELL_SIDE / STEPS_ANIM) * actor.dir.dy()
    val xSprite = stepAnim % 4
    val ySprite = when (actor.dir) {
        Direction.DOWN, null -> 0
        Direction.LEFT, Direction.LEFT_UP, Direction.LEFT_DOWN -> 1
        Direction.RIGHT, Direction.RIGHT_UP, Direction.RIGHT_DOWN -> 2
        Direction.UP -> 3
    }
    drawImage("$imageName|${xSprite * SPRITE_DIV},${ySprite * SPRITE_DIV},64,64", x, y, CELL_SIDE, CELL_SIDE)
}

private fun Canvas.drawGrid() {
    (CELL_SIDE..width step CELL_SIDE).forEach { x ->
        drawLine(x, 0, x, height, WHITE, 1)
    }
    (CELL_SIDE..height step CELL_SIDE).forEach { y ->
        drawLine(0, y, width, y, WHITE, 1)
    }
}