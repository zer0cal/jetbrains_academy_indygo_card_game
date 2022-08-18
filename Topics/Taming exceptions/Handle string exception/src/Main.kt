fun main() {
    val index: Int = readLine()!!.toInt()
    val word: String = readLine()!!
    if (index >= word.length || index < 0) println("There isn't such an element in the given string, please fix the index!")
    else println(word[index])
}