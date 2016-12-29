



//This is complete Jerman compiler. 
//It is one of the shortest compiler the world has ever seen

object JermanParser extends App {

  val keywordsMap = Map(
    "Packet " -> "package ",
    "öffentlich " -> "public ",
    "öffentliche " -> "public ",
    "öffentliches " -> "public ",
    "Klasse" -> "class",
    "Zeichenkette" -> "String",
    "dies." -> "this.",
    "statisch " -> "static ",
    "statische " -> "static ",
    "statisches " -> "static ",
    "gibzurück " -> "return ",
    "Leere " -> "void ",
    "finale " -> "final ",
    "finales " -> "final ",
     "geschützt" -> "protected");

  val is = getClass().getResourceAsStream("Beispiel.jerman")
  val source = io.Source.fromInputStream(is);


  def replaceKeywords(line: String): String = {
    keywordsMap.foldLeft(line) { case (line, (k,v)) => line.replaceAll(k,v) } + "\n"
  }

  //val res = source.getLines().map(line => replaceKeywords(line)).mkString
 
  val res = source.getLines().map(line => {
	line.split("\"").zipWithIndex.map(tuple => if(tuple._2 % 2 == 1) tuple._1 else replaceKeywords(tuple._1))
  })
  println(res);
}
