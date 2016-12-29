import org.scalatest.{FlatSpec, Matchers}


class JermanParserTest extends FlatSpec with Matchers with KeywordMapper {

  "Klasse" should "be translated to class" in {
    replaceLine("Klasse{") should be ("class{")
    replaceLine("Klasse {") should be ("class {")
    replaceLine("Klasse ") should be ("class ")
    replaceLine("Klasse\n") should be ("class\n")

  }
  it should "not be translated inside variable name" in {
    replaceLine("meineKlasse") should be ("meineKlasse")
    replaceLine("Klassetest") should be ("Klassetest")
  }

  "Type" should "be translated to java type" in {
    replaceLine("Ganzzahl ") should be ("int ")
    replaceLine("Ganzzahl[]") should be ("int[]")
    replaceLine("Ganzzahl []") should be ("int []")

  }
  it should "not be translated inside variable name" in {
    replaceLine("meineGanzzahl") should be ("meineGanzzahl")
  }


  "Haupt" should "translated to main" in {
    replaceLine(" Haupt ") should be (" main ")
    replaceLine(" Haupt(") should be (" main(")
  }
  it should "not be translated inside name" in {
    replaceLine("meineHauptMethode") should be ("meineHauptMethode")
  }


  "Names" should "not be translated inside String" in {
    replaceLine("Zeichenkette s = \"Zeichenkette Haupt Ganzzahl Doppel\";") should be ("String s = \"Zeichenkette Haupt Ganzzahl Doppel\";")
  }

  "Main method" should "be replaced with java main method" in {
    val mainMethod = "öffentlich statische Leere Haupt(Zeichenkette[] args) {"
    replaceLine(mainMethod) should be ("public static void main(String[] args) {")
  }

  "Adjectives" should "translate e.g. statisch" in {
    replaceLine("öffentlich statisch ") should be ("public static ")
  }
  it should "translate e.g. statische" in {
    replaceLine("öffentlich statische ") should be ("public static ")

  }
  it should "translate e.g. statisches" in {
    replaceLine("öffentlich statisches ") should be ("public static ")

  }
}
