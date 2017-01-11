package jerman


trait KeywordMapper {
  val adjectiveSuffix = "(e|(er)|(es)){0,1}\\s"
  val typeSuffix = "(?=(\\s|\\[\\]|\\.\\.\\.))"
  val obrace = "(\\s)*($|\\{)"
  val orbrace = "(\\s)*\\("
  val start = "(?<=(\\s+|^|\\(|,))"

  val keywordsMap = Map(
    "Packet(?=\\s)" -> "package",
    "gibzurück(?=\\s)" -> "return",
    "Klasse(?=[{,\\s])" -> "class",
    "Schnittstelle(?=[{,\\s])" -> "interface",
    "dies." -> "this.",
    "System.aus.druckzl\\(" -> "System.out.println(",
    "fortsetzen" -> "continue",
    "für(?=(\\s)*(\\())" -> "for",
    "schalte(?=(\\s)*(\\())" -> "switch",
    "wenn(?=(\\s)*(\\())" -> "if",
    "implementiert(?=\\s)" -> "implements",
    "erweitert(?=\\s)" -> "extends",
    "instanzvon(?=\\s)" -> " instanceof",
    "Fall(?=\\s)" -> " case",

    s"dann(?=$obrace)" -> "else",
    s"versuch(?=$obrace)" -> "try",
    s"endlich(?=$obrace)" -> "finally",
    s"tue(?=$obrace)" -> "do",

    s"fang(?=$orbrace)" -> "catch",
    s"während(?=$orbrace)" -> "while",

    "importiere " -> "import " ,
    "breche(?=(\\s+|;))" -> "break",
    "wirf " -> "throw ",

    //types
    s"Zeichenkette$typeSuffix" -> "String",
    s"Ganzzahl$typeSuffix" -> "int",
    s"Doppel$typeSuffix" -> "double",
    s"Gleitkommazahl$typeSuffix" -> "float",
    s"Zeichen$typeSuffix" -> "char",
    s"Lang$typeSuffix" -> "long",
    s"Leere$typeSuffix" -> "void",
    s"Bool$typeSuffix" -> "boolean",
    s"Byte$typeSuffix" -> "byte",
    s"Kurz$typeSuffix" -> "short",


    //adjectives
    s"sychnronisiert$adjectiveSuffix" -> "synchronized ",
    s"flüchtig$adjectiveSuffix" -> "volatile ",
    s"vorübergehend$adjectiveSuffix" -> "transient ",
    s"abstrakt$adjectiveSuffix" -> "abstract ",
    s"öffentlich$adjectiveSuffix" -> "public ",
    s"statisch$adjectiveSuffix" -> "static ",
    s"final$adjectiveSuffix" -> "final ",
    s"geschützt$adjectiveSuffix" -> "protected ",
    s"neu$adjectiveSuffix" -> "new ",
    "haupt(?=[(,\\s])" -> "main").map {case (a,b) => start + a -> b}

  def replaceLine(line:String) =
    line.split("\"").zipWithIndex.map(tuple => if(tuple._2 % 2 == 1) "\""+tuple._1+"\"" else replaceKeywords(tuple._1)) mkString

  def replaceKeywords(lineWithComments: String): String = {
    val line = stripComment(lineWithComments)
    keywordsMap.foldLeft(line) { case (line, (k, v)) => line.replaceAll(k, v) }
  }

  def stripComment(line:String) = {
    val idx = line.indexOfSlice("//")
    if(idx > -1) line.slice(0, idx)
    else line
  }
}
