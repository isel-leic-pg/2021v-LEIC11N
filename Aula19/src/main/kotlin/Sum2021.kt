

data class FindResult(val n1:Int, val n2:Int)

fun findNumbers(ns:List<Int>, condition:(Int,Int)->Boolean) :FindResult? {
    for(idx1 in 0 .. ns.size-2) {
        for(idx2 in idx1+1 .. ns.size-1) {
            if ( condition(ns[idx1], ns[idx2]) )
                return FindResult(ns[idx1], ns[idx2])
        }
    }
    return null
}

fun findNumbers2(ns:List<Int>, condition:(Int,Int)->Boolean) :FindResult? {
    ns.forEachIndexed { idx1,n1 ->
        val idx2 = ns.indexOfLast { condition(n1,it) }
        if (idx2>idx1) return FindResult(n1,ns[idx2])
    }
    return null
}

const val SUM = 2021

fun main() {
  val numbers = readLines().map { it.toInt() }
  val res = findNumbers2(numbers) { a,b -> a+b==SUM }
  if (res!=null) {
      val (n1,n2) = res
      println("$n1 + $n2 == $SUM")
  }

  /*
  var done = false
  var idx1=0
  var idx2=-1
  while( idx1 < numbers.size-1 && !done ) {
      idx2= idx1+1
      while ( idx2 < numbers.size && !done ) {
          if ( numbers[idx1]+numbers[idx2]==2021)
              done = true
          idx2++
      }
      idx1++
  }
  idx1--
  idx2--
  println("${numbers[idx1]} + ${numbers[idx2]} == 2021")
   */
}