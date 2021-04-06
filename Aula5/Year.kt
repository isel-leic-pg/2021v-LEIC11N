
// Ler o valor do ano e indicar se é bisexto
fun main() {
	val year = readInt("Ano")
	val month = readInt("Mês(1..12)")
	val bisexto = year%4==0 && year%100!=0 || year%400==0 
	//val days = 365 + if (bisexto) 1 else 0
	if (bisexto)
		println("O ano $year é bisexto")
	println("O ano $year tem ${if (bisexto) 366 else 365} dias")
	val days = when (month) {
	  2 -> if (bisexto) 29 else 28
	  4,6,9,11 -> 30
	  else -> 31
	}
	println("O mês $month tem $days dias")
}