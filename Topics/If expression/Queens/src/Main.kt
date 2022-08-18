
import java.util.Scanner
import kotlin.math.abs
fun main() {
    val sc = Scanner(System.`in`)
    val firstX = sc.nextInt()
    val firstY = sc.nextInt()
    val secondX = sc.nextInt()
    val secondY = sc.nextInt()
    println(
        if (abs(firstX - secondX) == abs(firstY - secondY)) {
            "YES"
        } else if (abs(firstX - secondX) == 0) {
            "YES"
        } else if (abs(firstY - secondY) == 0) {
            "YES"
        } else {
            "NO"
        }
    )
}