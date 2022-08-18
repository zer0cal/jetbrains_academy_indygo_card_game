fun main() {
    val input = readln()
    println(isInRainbow(input))
}

enum class RainbowColors {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun isInRainbow(color: String): Boolean {
    for (rainbowColor in RainbowColors.values()) {
        if (rainbowColor.name == color.uppercase()) return true
    }
    return false
}