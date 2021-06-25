import pt.isel.canvas.*

fun main(args: Array<String>) {
    println("Hello ${args.size}")
    onStart{
        val cv = Canvas(400,300, BLACK)
        cv.drawCircle(200,150,100, YELLOW,5)
        args.forEachIndexed { idx, it ->
            cv.drawText(50,50*idx +50,it, WHITE)
        }
    }
    args.forEach(::println)
    onFinish {  }
}

/*
fun main() {
    //val l :MutableList<Int> = mutableListOf(32,27,58,98)
    //val l :List<Int> = listOf(32,27,58,98)
    //val l :Array<Int> = arrayOf(32,27,58,98)
    val l = Array(10) {  it  }
    l.forEachIndexed{ idx, elem ->
        println("[$idx] -> $elem")
    }
    l[2] = 150
    //l.add(202)
    println("---------")
    for( idx in l.indices )
        println("[$idx] -> ${l[idx]}")
}
 */