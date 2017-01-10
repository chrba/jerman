package jerman

/**
  * Created by cbannes on 29.12.16.
  */
trait KeywordMapper {
  val adjectiveSuffix = "(e|(er)|(es)){0,1}\\s"
  val typeSuffix = "(?=(\\s|\\[\\]|\\.\\.\\.))"
  val obrace = "(\\s)*($|\\{)"

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
    s"dann(?=$obrace)" -> "else",
    " implementiert(?=\\s)" -> " implements",
    " erweitert(?=\\s)" -> " extends",
    " instanzvon(?=\\s)" -> " instanceof",
    " Fall(?=\\s)" -> " case",



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
    "(?<=\\s)haupt(?=[(,\\s])" -> "main");

  def replaceLine(line:String) =
    line.split("\"").zipWithIndex.map(tuple => if(tuple._2 % 2 == 1) "\""+tuple._1+"\"" else replaceKeywords(tuple._1)) mkString

  def replaceKeywords(line: String): String =
    keywordsMap.foldLeft(line) { case (line, (k,v)) => line.replaceAll(k,v) }
}

/*

assert***	default	goto*		synchronized
	do	if	private	this
break		implements	protected	throw
	else	import	public	throws
case	enum****	instanceof	return	transient
catch	extends		try
		interface
	finally		strictfp**	volatile
const*		native	super	while
*/