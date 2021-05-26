import pt.isel.canvas.*

fun main() {
    onStart {
        val cv = Canvas(GRID_WIDTH * CELL_SIDE, GRID_HEIGHT * CELL_SIDE, BLACK)
        var game = createGame()
        cv.drawArena(game)
        cv.onKeyPressed { ke: KeyEvent ->
            game = game.move(ke)
            cv.drawArena(game)
        }
        cv.onTimeProgress(50) {
            if (game.stepAnim > 0) {
                game = game.copy(stepAnim = game.stepAnim - 1)
                cv.drawArena(game)
            }
        }
    }
    onFinish { }
}