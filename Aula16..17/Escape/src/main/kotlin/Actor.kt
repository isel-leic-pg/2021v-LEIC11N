

data class Actor(val position: Position, val dir:Direction?)


fun createRobots(exclude:Position) =  (ALL_POSITION-exclude).shuffled().take(10).map { Actor(it,null) }
/*:List<Actor> {
    var robots = emptyList<Actor>()
    var all = ALL_POSITION - exclude
    (0 until 10).forEach {
        val pos = all.random()
        all = all - pos
        robots = robots + Actor( pos,null)
    }
    return robots
}*/