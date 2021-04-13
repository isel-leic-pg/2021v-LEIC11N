
data class Time(val h:Int=0, val m:Int=0, val s:Int =0)

// fun toTime(secs :Int) = Time(secs / 3600, secs % 3600 / 60, secs % 60)
fun Int.toTime() = Time(this / 3600, this % 3600 / 60, this % 60)

//fun toText(tm :Time) = "${tm.h}:${tm.m}:${tm.s}"
fun Time.toText() = "$h:$m:$s"

fun main() {
    /*
    val tm = Time(2,31,4)
    println("${tm.h}:${tm.m}:${tm.s}")
    println(tm)
    */
    val secs = readInt("Total em segundos")
    println("$secs= ${secs.toTime().toText()}")
}