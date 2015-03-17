package kotloid.test.compiler

import kotloid.compiler.AmlObject

fun main(args: Array<String>) {
    val amlPath = System.getProperty("user.dir") + "/src/test/aml/MainActivity.aml"
    val obj = AmlObject(amlPath)
}
