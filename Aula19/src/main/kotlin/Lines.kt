
fun numberOfLines() :Int {
    var number = 0
    while ( readLine() !=null ) number++
    return number
}

fun readLines() :List<String> {
    var lines = emptyList<String>()
    var line = readLine()
    while( line != null ) {
        lines = lines + line
        line = readLine()
    }
    return lines
}

fun readLines2() :List<String> {
    var lines = emptyList<String>()
    while( true )
        lines = lines + (readLine() ?: return lines)
}

fun main() {
    readLines2().forEach(::println)
    //val lines :List<String> = readLines()
    //lines.forEach(::println)

    //val lst = listOf("abc","xpto","pg")
    // for (s in lst) {

    //fun fx(s:String) { println(s) }  // (String)->Unit
    //val fx = { s:String -> println(s) }
    //val fx :(String)->Unit = ::println
    //lst.forEach(::println)
    /*
    var numberOfLines = 0
    while( readLine()!=null )
        numberOfLines++
    println("Número de linhas = $numberOfLines")
     */
    //println("Número de linhas = ${numberOfLines()}")
}


// C:> kotlin LinesKt < Lusiadas.txt