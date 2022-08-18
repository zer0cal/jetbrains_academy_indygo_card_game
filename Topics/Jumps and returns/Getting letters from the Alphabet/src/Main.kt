fun main() {
    val input = readln()
    val alphabet: String = "abcdefghijklmnopqrstuvwxyz"
    for (char in alphabet) {
        when ("$char") {
            input -> return
            else -> print(char)
        }
    }
}