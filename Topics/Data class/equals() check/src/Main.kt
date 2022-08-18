data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        other as Client
        return name == other.name && age == other.age
    }
}

fun main() {
    val firstClient: Client = Client(name = readln(), age = readln().toInt(), balance = readln().toInt())
    val secondClient: Client = Client(name = readln(), age = readln().toInt(), balance = readln().toInt())
    println(firstClient == secondClient)
}