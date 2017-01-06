package jerman

import java.io.File


trait Transpiler extends JermanTranspiler  with JermanFileLocator with KeywordMapper {
  def compileAll(src:File, dest:File):Seq[File] = {
    find(src.toPath) map { jermanFile =>
      compile(jermanFile, dest.toPath).toFile
    }
  }
}
