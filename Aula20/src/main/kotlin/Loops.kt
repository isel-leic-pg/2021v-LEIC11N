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

fun findValue(lst:List<Float>, value:Float) :Int {
    for (idx in lst.indices) {
        val elem = lst[idx]
        if (elem == value) return idx
        if (elem > value) return -1
    }
    return -1
}

fun findBinary(lst: List<Float>, value: Float, idxMin:Int=0, idxMax:Int=lst.size-1) :Int {
    if (idxMax < idxMin) return -1
    val idx = (idxMax-idxMin)/2
    if ( value == lst[idx]) return idx
    if ( value < lst[idx]) return findBinary(lst,value,idxMin,idx-1)
    else return findBinary(lst,value,idx+1,idxMax)
}

fun main() {
    val lst = createRandomFloatList(15f, 20f, 10).sorted()
    println(lst)
    println(lst.size)
    val idx = findBinary(lst,17f)
    println(idx)
}