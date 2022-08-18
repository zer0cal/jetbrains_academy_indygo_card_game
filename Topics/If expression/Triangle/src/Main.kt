fun main() {
    val a = readln().toUInt()
    val b = readln().toUInt()
    val c = readln().toUInt()
    println(if (a + b > c && a + c > b && b + c > a) "YES" else "NO")
}