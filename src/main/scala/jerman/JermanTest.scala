package jerman

import scala.io.Source


object JermanTest extends App with KeywordMapper with Arm{
  val is = getClass().getResourceAsStream("/Beispiel.jerman")

  val source = Source.fromInputStream(is)
  val res =  source.getLines().map(replaceLine(_) + "\n").mkString


  println(res);
}


