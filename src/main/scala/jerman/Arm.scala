package jerman
import java.nio.file._
import java.io.File
import java.util.Comparator


trait Arm {
  def deleteRecursive(dir:File): Unit = {
    dir.listFiles().foreach(file => {
      if(!file.isDirectory) file.delete()
      else deleteRecursive(file)
    })
  }

  def autoClean(dir:Path, f: Path => Unit) {
    try {
      f(dir)
    }
    finally {
      deleteRecursive(dir.toFile)
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
