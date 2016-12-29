


object JermanParser extends App with KeywordMapper{

  val is = getClass().getResourceAsStream("Beispiel.jerman")
  val source = io.Source.fromInputStream(is);
  val res = source.getLines().map(replaceLine(_) + "\n").mkString
  println(res);
}
