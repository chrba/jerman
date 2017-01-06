package jerman

import scala.io.Source


object JermanTest extends App with KeywordMapper with Arm{
  val is = getClass().getResourceAsStream("Beispiel.jerman")

  val res = using(Source.fromInputStream(is)) { source =>
    source.getLines().map(replaceLine(_) + "\n").mkString
  }

  println(res);
}


