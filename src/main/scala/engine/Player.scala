package personal.games.moba
package engine

import engine.board.Side
import engine.console.ConsoleVisual

abstract class Player(var side: Side.Value) {

  def doTurn(): Unit = {
    attackByTowers()
    hireWarriors()
    doActions()
    buy()
    discardAndDraw()
  }

  def doActions()

  def doHeroAction(actionIndex: Int): Unit = {
    ConsoleVisual.renderBoard()
  }

  def attackByTowers()

  def hireWarriors()

  def buy(): Any = {

  }

  def discardAndDraw(): Unit

  def doWarriorAction(warriorActionIndex: Int): Unit
}
