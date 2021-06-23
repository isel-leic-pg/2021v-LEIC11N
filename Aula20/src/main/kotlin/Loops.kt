import kotlin.random.Random

fun createFloatList(min:Float, max:Float, delta:Float) :List<Float> {
    val size = ((max-min)/delta).toInt()
    return (0 .. size).map { min + it * delta }
    /*
    val lst = mutableListOf<Float>()
    var value = min
    while ( value <= max ) {
        lst += value
        value += delta
    }
    return lst
     */
}


fun createRandomFloatList(min:Float, max:Float, size:Int) :List<Float> {
    val lst = mutableListOf<Float>()
    repeat(size) {
        lst += Random.nextFloat()*(max-min)+min
    }
    return lst
}

// n! -> n * (n-1) * (n-2) * (n-3)!
// n! -> n * (n-1) * (n-2) * ... * 1

fun factorial(n :Int) :Long = if (n==0) 1 else n * factorial(n-1)

fun factorialI(n :Int) :Long {
    var r = 1L
    for( v in 1..n ) r *= v
    return r
}


// List<T>  ->  emptyList ||  T , List<T>
fun findValueR(lst:List<Float>, value:Float, idxMin:Int=0) :Int = when {
    idxMin>=lst.size -> -1
    lst[idxMin] == value -> idxMin
    else -> findValueR( lst, value, idxMin+1)
}

fun findValue(lst:List<Float>, value:Float) :Int {
    for (idx in lst.indices) {
        val elem = lst[idx]
        if (elem == value) return idx
        //if (elem > value) return -1
    }
    return -1
}

fun findBinary(lst: List<Float>, value: Float, idxMin:Int=0, idxMax:Int=lst.size-1) :Int {
    if (idxMax < idxMin) return -1
    val idx = (idxMax+idxMin)/2
    return when {
        value == lst[idx] -> idx
        value < lst[idx] -> findBinary(lst, value, idxMin, idx - 1)
        else  -> findBinary(lst, value, idx + 1, idxMax)
    }
}

fun findBinaryI(lst: List<Float>, value: Float) :Int {
    var idxMin = 0
    var idxMax = lst.size-1
    while ( idxMin <= idxMax ) {
        val idx = (idxMax+idxMin)/2
        val elem = lst[idx]
        if ( elem == value ) return idx
        if ( value < elem ) idxMax = idx-1
        else idxMin = idx+1
    }
    return -1
}

fun min(lst: List<Float>) :Float {
   var m = lst.first()
   for( idx in 1 until lst.size ) {
       if ( lst[idx] < m )
           m = lst[idx]
   }
   return m
}

fun idxMin(lst: List<Float>) :Int {
    var idxM = 0
    for( idx in 1 until lst.size ) {
        if ( lst[idx] < lst[idxM] )
            idxM = idx
    }
    return idxM
}

fun sort(lst:List<Float>) :List<Float> {
    val l = lst.toMutableList()
    val res = mutableListOf<Float>()
    while ( l.isNotEmpty() ) {
        val idx = idxMin(l)
        res.add( l[idx] )
        l.removeAt( idx )
    }
    return res
}

fun main() {
    val lno = createFloatList(15f, 20f, 0.5f).shuffled()
    println(lno)
    val lo = sort(lno)
    println(lo)
    /*
    println( factorial(20) )
    val lst = createRandomFloatList(15f, 20f, 10)
    println(lst)
    println(lst.size)
    val idx = findBinary(lst,lst[3])
    println(idx)
     */
}