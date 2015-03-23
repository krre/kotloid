package org.kotloid

import java.io.File

fun compileFile(inputPath: String, outputPath: String) {
    val ktFile = File(outputPath)
    ktFile.getParentFile().mkdirs()
    ktFile.createNewFile()

    val kdmlText = File(inputPath).readText()
    ktFile.writeText(kdmlText)
}

fun compileDirectory(inputPath: String, outputPath: String) {
    deleteDirectory(File(outputPath))
    for (file in File(inputPath + File.separator + "kdml").listFiles()) {
        val ktFilePath = outputPath + File.separator + file.name.replace("kdml", "kt")
        compileFile(file.path, ktFilePath)
    }
}

fun deleteDirectory(path: File) {
    if (path.exists()) {
        for (file in path.listFiles()) {
            if (file.isDirectory()) {
                deleteDirectory(file)
            } else {
                file.delete()
            }
        }
    }
}