fun main() {
    val input: String = readln()
    loop@for (char: Char in input) {
        if (char in listOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')) {
            println(char)
            break@loop
        }
    }
}