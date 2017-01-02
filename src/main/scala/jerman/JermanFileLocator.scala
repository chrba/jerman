package jerman
import java.nio.file._
import scala.collection.JavaConverters._

/**
  * Created by cbannes on 02.01.17.
  */
trait JermanFileLocator {
  def find(dir:Path):List[Path] =
      Files.walk(dir)
          .filter(Files.isRegularFile(_))
            .iterator().asScala.toList
}
