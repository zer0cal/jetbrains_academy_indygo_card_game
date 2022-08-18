fun main() {
    val class1 = readln().toUShort()
    val class2 = readln().toUShort()
    val class3 = readln().toUShort()
    val class1Desks = class1 / 2u + class1 % 2u
    val class2Desks = class2 / 2u + class2 % 2u
    val class3Desks = class3 / 2u + class3 % 2u
    val totalDesks = class1Desks + class2Desks + class3Desks
    println(totalDesks)
}