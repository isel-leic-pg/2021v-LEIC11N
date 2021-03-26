
fun main() {
  print("Letra minuscula? ")
  val letter = readLine()!!.trim()[0]
  val upper = letter-('z'-'Z')
  println("Maiuscula = $upper")
}