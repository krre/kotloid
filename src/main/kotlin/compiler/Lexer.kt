package kotloid.compiler

import java.io.File

public class Lexer(path: String) {
    init {
        val text = File(path).readText()
        println(text)
    }
}


