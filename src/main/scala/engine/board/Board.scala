package personal.games.moba
package engine.board

import engine.board.Side.{SIDE_1, SIDE_2}

import scala.collection.mutable.ListBuffer

object Board {

  val areas: ListBuffer[Area] =
    ListBuffer(
      Area(1, ListBuffer(new Hero(SIDE_1)), Some(new Base(SIDE_1)), Some(new Tower(SIDE_1)), ListBuffer()),
      Area(2, ListBuffer(), warriors = ListBuffer(new Warrior(SIDE_1), new Warrior(SIDE_1),new Warrior(SIDE_2))),
      Area(3, ListBuffer(), warriors = ListBuffer(new Warrior(SIDE_1))),
      Area(4, ListBuffer(), warriors = ListBuffer(new Warrior(SIDE_2), new Warrior(SIDE_2))),
      Area(5, ListBuffer(new Hero(SIDE_2)), Some(new Base(SIDE_2)), Some(new Tower(SIDE_2)), ListBuffer()),
      // 0 = out of board
      Area(0, ListBuffer(), warriors = ListBuffer()),
    )


  def getHeroArea(side: Side.Value): Area = {
    areas.filter(area => area.heroes.exists(hero => hero.side == side)).head
  }

  def moveHero(side: Side.Value, moveTo: Int) = {
    val currentArea = getHeroArea(side)
    val hero = getHero(side, currentArea)
    println(s"Moving Hero from area ${currentArea.index} to $moveTo")

    currentArea.heroes -= hero
    val newArea = getAreaWithIndex(moveTo)
    newArea.heroes += hero
  }

  private def getAreaWithIndex(moveTo: Int): Area = {
    val requestedArea = areas.filter(area => area.index == moveTo)
    if (requestedArea.nonEmpty) {
      requestedArea.head
    } else {
      println("Bad Area entered, returning 0")
      areas.filter(area => area.index == 0).head
    }
  }

  private def getHero(side: Side.Value, area: Area) = {
    area.heroes.filter(hero => hero.side == side).head
  }
}
