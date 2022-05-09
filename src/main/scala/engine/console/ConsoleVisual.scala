package personal.games.moba
package engine.console

import engine.board.Side.{SIDE_1, SIDE_2}
import engine.board.{Area, Board}

object ConsoleVisual {

  def renderBoard(): Unit = {
    for (a <- Board.areas.reverse) {

      val w1Count = a.warriors.count(w => w.side == SIDE_1)
      val w2Count = a.warriors.count(w => w.side == SIDE_2)
      println(s"┌-------------------------------------------┐ ${a.index}")

      if (w2Count > 0 && w1Count > 0) {
        println(s"|--------- W2:$w2Count -----|------- W1:$w1Count ---------|")
      } else if (w2Count > 1 && w1Count == 0) {
        println(s"|-------- W2:$w2Count ------|----------------------|")
      } else if (w2Count == 0 && w1Count > 1) {
        println(s"|--------------------|---------- W1:$w1Count ------|")
      }

      printHeroes(a)
      if (a.tower.nonEmpty) {
        println(s"|------------------ Tower ------------------|")
      }
      if (a.base.nonEmpty) {
        println(s"|------------------ Base -------------------|")
      }
      println(s"└-------------------------------------------┘")
    }
  }

  private def printHeroes(a: Area) = {
    val hero1Count = a.heroes.count(h => h.side == SIDE_1)
    val hero2Count = a.heroes.count(h => h.side == SIDE_2)
    if (hero2Count == 1 && hero1Count == 1) {
      println(s"|-------- H2 ----------|------- H1 ---------|")
    } else if (hero2Count == 1 && hero1Count == 0) {
      println(s"|------ H2 ----------|----------------------|")
    } else if (hero2Count == 0 && hero1Count == 1) {
      println(s"|--------------------|------- H1 -----------|")
    }
  }
}
