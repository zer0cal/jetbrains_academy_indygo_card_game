data class Student(val name: String, val money: Int) {
    override fun equals(other: Any?): Boolean {
        other as Student
        return name == other.name && other.money < 1500
    }
}
