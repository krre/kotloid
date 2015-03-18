package kotloid.compiler

import java.io.File

class Lexer(path: String) {
    {
        val text = File(path).readText()
        println(text)
    }
}


