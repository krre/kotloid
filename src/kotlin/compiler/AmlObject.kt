package kotloid.compiler

import java.io.File

public class AmlObject(amlFile: String) {
    {
        val text = File(amlFile).readText()
        println(text)
    }
}



