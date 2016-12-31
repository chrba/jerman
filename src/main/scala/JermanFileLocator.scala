import java.nio.file.{Files, Path}
import scala.collection.JavaConverters._

trait JermanFileLocator {
  def find(dir:Path):List[Path] =
      Files.walk(dir)
          .filter(Files.isRegularFile(_))
            .iterator().asScala.toList
}
