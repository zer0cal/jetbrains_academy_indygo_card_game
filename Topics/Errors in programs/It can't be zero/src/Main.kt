fun main() {
    val line1: Int = readln()!!.toInt() ?: return
    val line2: Int = readln()!!.toInt() ?: return

    val product = line1 * line2
    if (product == 0) {
        println("It can't be zero!")
    } else {
        println(product)
    }
}