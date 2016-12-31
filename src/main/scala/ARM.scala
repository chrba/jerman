import java.nio.file.{Files, Path}
import java.util.Comparator

import scala.io.BufferedSource

/**
  * Auto clean directory after usage
  */
trait ARM {
  def autoClean(dir:Path, f: Path => Unit) {
    try {
      f(dir)
    }
    finally {
      Files.walk(dir)
        .sorted(Comparator.reverseOrder())
        .forEach(p => Files.delete(p))
    }
  }

  def using[S,T](file:S{def close()})(f: S => T ) : T = {
    try {
      f(file)
    }
    finally {
      file.close()
    }
  }

}