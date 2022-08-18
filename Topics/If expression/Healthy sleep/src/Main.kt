fun main() {    
    val a = readln().toUByte()
    val b = readln().toUByte()
    val h = readln().toUByte()
    println(
        if (h in a..b) {
            "Normal"
        } else if (h < a) {
            "Deficiency"
        } else {
            "Excess"
        }
    )
}