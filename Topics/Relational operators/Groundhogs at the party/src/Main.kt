const val MAX_WEEKDAY = 20
const val MIN_WEEKDAY = 10
const val MAX_WEEKEND = 25
const val MIN_WEEKEND = 15

fun main() {
    val peanutButterCups = readln().toInt()
    val isWeekend = readln().toBoolean()
    if (isWeekend) {
        println("${peanutButterCups in MIN_WEEKEND..MAX_WEEKEND}")
    } else {
        println("${peanutButterCups in MIN_WEEKDAY..MAX_WEEKDAY}")
    }
}