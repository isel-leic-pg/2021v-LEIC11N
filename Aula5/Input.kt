


fun readLine(quest:String) :String {
	print("$quest? ")
	return readLine()!!
}	

fun readInt(quest:String) =readLine(quest).toInt()

fun readDouble(quest:String) = readLine(quest).toDouble()
