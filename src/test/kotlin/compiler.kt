package kotloid.test.compiler

import kotloid.compiler.AmlObject
import java.io.File

fun main(args: Array<String>) {
    val amlPath = System.getProperty("user.dir") + File.separator + "src" + File.separator +
            "test" + File.separator + "aml" + File.separator + "MainActivity.aml"
    val obj = AmlObject(amlPath)
}
