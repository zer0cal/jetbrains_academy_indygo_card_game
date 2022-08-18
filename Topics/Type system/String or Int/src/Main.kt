fun isNumber(input: String): Any {
    try {
        return input.toInt()
    }
    catch (e: Exception) {
        return input
    }
}