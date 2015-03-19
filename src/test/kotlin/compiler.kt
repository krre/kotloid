package kotloid.test.compiler

import java.io.File
import kotloid.compiler.Lexer
import kotloid.compiler.Parser

fun main(args: Array<String>) {
    val amlPath = System.getProperty("user.dir") + File.separator + "src" + File.separator +
            "test" + File.separator + "kdml" + File.separator + "MainActivity.kdml"


    val lexer = Lexer(amlPath)
    val parser = Parser(lexer)
    val ast = parser.parse()

}
