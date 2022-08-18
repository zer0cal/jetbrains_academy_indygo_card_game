fun main() {
    val first: Int = readln()!!.toInt()
    val second: Int = readln()!!.toInt()
    if (second == 0) println("Division by zero, please fix the second argument!")
    else print(first / second)
}