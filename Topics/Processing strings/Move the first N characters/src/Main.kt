fun main() {
    val input = readln()
    val s = input.split(" ").first()
    val n = input.split(" ").last().toInt()
    if (n > s.length) {
        println(s)
    } else {
        println("${s.substring(n)}${s.substring(0,n)}")
    }
}