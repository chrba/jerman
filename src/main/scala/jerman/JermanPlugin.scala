package jerman
import java.io.File

/**
  * Created by cbannes on 02.01.17.
  */
trait JermanPlugin {
  self: JermanCompiler with JermanFileLocator =>

  def compileAll(src:File, dest:File):Seq[File] = {
    find(src.toPath) map { jermanFile =>
      compile(jermanFile, dest.toPath).toFile
    }
  }
}

object JermanPlugin  {
  def apply() = new JermanPlugin with JermanCompiler with JermanFileLocator with KeywordMapper
}