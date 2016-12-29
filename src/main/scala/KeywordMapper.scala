/**
  * Created by cbannes on 29.12.16.
  */
trait KeywordMapper {
  val adjectiveSuffix = "(e|(es)){0,1}\\s"
  val typeSuffix = "(?=(\\s|\\[\\]|\\.\\.\\.))"
  val keywordsMap = Map(
    "Packet(?=\\s)" -> "package",
    "gibzurück(?=\\s)" -> "return",
    "Klasse(?=[{,\\s])" -> "class",
    "dies." -> "this.",
    "System.aus.druckzl\\(" -> "System.out.println(",

    //types
    s"Zeichenkette$typeSuffix" -> "String",
    s"Ganzzahl$typeSuffix" -> "int",
    s"Doppel$typeSuffix" -> "double",
    s"Gleitkommazahl$typeSuffix" -> "float",
    s"Zeichen$typeSuffix" -> "char",
    s"Lang$typeSuffix" -> "long",
    s"Leere$typeSuffix" -> "void",


    //adjectives
    s"öffentlich$adjectiveSuffix" -> "public ",
    s"statisch$adjectiveSuffix" -> "static ",
    s"final$adjectiveSuffix" -> "final ",
    s"geschützt$adjectiveSuffix" -> "protected",
    s"neu$adjectiveSuffix" -> "new ",
    "(?<=\\s)haupt(?=[(,\\s])" -> "main");

  def replaceLine(line:String) =
    line.split("\"").zipWithIndex.map(tuple => if(tuple._2 % 2 == 1) "\""+tuple._1+"\"" else replaceKeywords(tuple._1)) mkString

  def replaceKeywords(line: String): String =
    keywordsMap.foldLeft(line) { case (line, (k,v)) => line.replaceAll(k,v) }
}
