fun isVowel(letter: Char): Boolean {
    return letter in "AEIOUaeiou"
}

fun main() {
    val letter = readLine()!!.first()

    println(isVowel(letter))
}