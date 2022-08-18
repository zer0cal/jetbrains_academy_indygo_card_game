const val TARGET = 20
fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val sumAB = a + b
    val sumAC = a + c
    val sumBC = b + c
    print(sumAB == TARGET || sumAC == TARGET || sumBC == TARGET)
}