enum class DaysOfTheWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

fun main() {
    for (weekDay in DaysOfTheWeek.values()) {
        println(weekDay)
    }
}