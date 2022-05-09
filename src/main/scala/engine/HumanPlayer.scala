package personal.games.moba
package engine

import engine.board.Side.SIDE_1
import engine.board.{Board, Side}

import scala.io.StdIn.readLine

class HumanPlayer(side: Side.Value) extends Player(side) {

  var allDone = false

  def setAllDone(allDone: Boolean): Unit = {
    this.allDone = allDone
  }

  def isNotAllDone(): Boolean = !allDone

  override def attackByTowers() = {

  }

  override def hireWarriors() = {


  }

  override def buy(): Unit = {
    while (true) {
      println("Choose cards on market 1-5, 0 to end.")
      val cardIndex = readPlayerInput
      if (cardIndex == 0)
        return
    }
  }


  override def discardAndDraw(): Unit = {

  }

  override def doHeroAction(actionIndex: Int): Unit = {
    actionIndex match {
      case 1 =>
        println("Enter area index move to: ")
        val moveToIndex = readPlayerInput
        Board.moveHero(side, moveToIndex)
      case 2 =>
      case 3 =>
      case 4 =>
      case 5 =>
      case 6 =>
      case 7 =>
      case _ => println("Wrong number")
    }
    super.doHeroAction(actionIndex)
  }

  override def doWarriorAction(warriorActionIndex: Int): Unit = {

  }

  override def doActions(): Unit = {
    while (true) {
      print("Please do the action, type index: 1. Hero Action, 2. Warriors action, 3. End Turn. Buying ")
      val actionIndex = readPlayerInput
      if (doActions(actionIndex)) return
    }
  }

  private def doActions(actionIndex: Int): Boolean = {
    actionIndex.toInt match {
      case 1 =>
        println("Choose hero actions: " +
          "1. Move, " +
          "2. Take card, trash on market, " +
          "3. Play action card, " +
          "4. Attack using attack card " +
          "5. Train " +
          "6. Heal 7 hp, " +
          "0. To get back")
        val heroActionIndex = readPlayerInput
        doHeroAction(heroActionIndex)
      case 2 =>
        println("Choose warrior actions: " +
          "1. Move, " +
          "2. Attack")
        val warriorActionIndex = readPlayerInput
        doWarriorAction(warriorActionIndex)
      case 3 =>
        return true
      case _ => println("Wrong number")
    }
    false
  }

  private def readPlayerInput: Int = {
    val userInput = readLine()
    if (userInput.nonEmpty && Character.isDigit(userInput.charAt(0)))
      userInput.toDouble.toLong.toInt
    else {
      -1
    }
  }
}
