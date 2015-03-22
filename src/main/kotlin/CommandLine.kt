package org.kotloid

import java.io.File

fun main(args: Array<String>) {
    if (args.count() == 1) {
        compileFile(args[0])
    } else if (args.count() == 4) {
        if (args[0] == "-s") {
            if (args[2] == "-o") {
                compileDirectory(args[1], args[3])
            }
        }
    }
}

fun compileFile(inputPath: String, outputPath: String = "") {
    val kotlinFilePath = if (outputPath.isEmpty()) {
        File(inputPath).directory.path + File.separator + File(inputPath).name.replace("kdml", "kt")
    } else {
        outputPath
    }

    val ktFile = File(kotlinFilePath)
    ktFile.getParentFile().mkdirs()
    ktFile.createNewFile()

    val kdmlText = File(inputPath).readText()
    ktFile.writeText(kdmlText)
}

fun compileDirectory(inputPath: String, outputPath: String) {
    deleteDirectory(File(outputPath))
    for (file in File(inputPath).listFiles()) {
        val kotlinFilePath = outputPath + File.separator + file.name.replace("kdml", "kt")
        compileFile(file.path, kotlinFilePath)
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