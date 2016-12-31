import java.io.PrintWriter
import java.nio.file.Path


trait JermanCompiler extends ARM {
  this: KeywordMapper =>
  def compile(jermanFile:Path, destDir:Path) = {
    using(io.Source.fromFile(jermanFile.toFile.getAbsolutePath)) {
      source =>
        val p = new PrintWriter(destDir.resolve(jermanFile.toFile.getName).toFile.getName)
        source.getLines.foreach {line =>
          p.write(replaceLine(line) + "\n" mkString)
        }

    }

  }
}
