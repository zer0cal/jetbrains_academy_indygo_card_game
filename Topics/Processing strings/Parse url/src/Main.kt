fun main() {
    val input = readln()
    val parametersStr = input.split("?").last()
    val parametersList = parametersStr.split("&")
    var password: String = ""
    for (parameter in parametersList) {
        val key = parameter.split("=").first()
        val value = if (parameter.split("=").last() == "") "not found" else parameter.split("=").last()
        println("$key : $value")
        if (key == "pass") password = "password : $value"
    }
    if (password != "") println(password)
}
