package jerman
import java.io.PrintWriter
import java.nio.file._

/**
  * Created by cbannes on 02.01.17.
  */
trait JermanCompiler {
  this: KeywordMapper =>

  def toJavaFileName(jermanFile:Path) =
    jermanFile.toFile.getName.replaceAll(".jerman", ".java")


  def compile(jermanFile:Path, destDir:Path):Path = {
      val source = io.Source.fromFile(jermanFile.toFile.getAbsolutePath)
      val outFile = destDir.resolve(toJavaFileName(jermanFile))
      val writer = new PrintWriter(outFile.toFile.getAbsolutePath)

      source.getLines.foreach { line =>
        writer.write(replaceLine(line) + "\n" mkString)
      }
      source.close()
      writer.close()

      outFile
   }


}
