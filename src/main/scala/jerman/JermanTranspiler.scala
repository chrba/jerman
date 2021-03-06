package jerman
import java.io.{File, PrintWriter}
import java.nio.file._


trait JermanTranspiler {
  this: KeywordMapper =>

  def toJavaFileName(jermanFile:Path) =
    jermanFile.toFile.getName.replaceAll(".jerman", ".java")


  def compile(jermanFile:Path, destDir:Path):Path = {
      val source = io.Source.fromFile(jermanFile.toFile.getAbsolutePath)
      val outFile = destDir.resolve(toJavaFileName(jermanFile))
      outFile.getParent.toFile.mkdirs()
      val writer = new PrintWriter(outFile.toFile.getAbsolutePath)

      source.getLines.foreach { line =>
        writer.write(replaceLine(line) + "\n" mkString)
      }
      source.close()
      writer.close()

      outFile
   }

}
