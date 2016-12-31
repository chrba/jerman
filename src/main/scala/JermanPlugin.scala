import java.nio.file.Path

 trait JermanPlugin extends ARM {
  self: KeywordMapper with JermanFileLocator =>

  def compile(src:Path, dest:Path):List[Path] = {
      find(src) foreach { jermanFile =>
         using(io.Source.fromFile(jermanFile.toFile.getAbsolutePath)) { source =>
            //open new file and write it line by line
         }
      }

    ???
  }
}
