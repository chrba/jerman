package jerman
import java.io.File
import java.nio.file._


trait JermanFileLocator {
  def findFlat(dir:Path):List[Path] = dir.toFile.listFiles().toList filter (file => isJermanFile(file)) map {_.toPath}

  def isJermanFile(file: File): Boolean = {
    !file.isDirectory && file.getName.endsWith(".jerman")
  }

  def find(dir:Path):List[Path] = {
    val dirsAndFiles = dir.toFile.listFiles().partition(_.isDirectory)
    dirsAndFiles._1.flatMap(dir => find(dir.toPath)).toList :::
      dirsAndFiles._2.filter(file => isJermanFile(file)).map(_.toPath).toList
  }
}
