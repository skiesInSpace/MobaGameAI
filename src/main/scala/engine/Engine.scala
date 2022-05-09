package personal.games.moba
package engine

import engine.board.Board

import personal.games.moba.engine.board.Side.{SIDE_1, SIDE_2}
import personal.games.moba.engine.console.ConsoleVisual

object Engine {

  val board = Board
  var haveWinner = false

  def setHaveWinner(haveWinner: Boolean): Unit = {
    this.haveWinner = haveWinner
  }

  def doPlayerTurns(player1: Player, player2: Player): Any = {
    ConsoleVisual.renderBoard()
    for (roundCounter <- Range(0, 9)) {
      println("----- START OF TURN " + roundCounter + " -----")
      player1.doTurn()
      player2.doTurn()
      println("----- END OF TURN " + roundCounter + " -----")
      if (haveWinner) {
        return
      }
    }
  }

  def run: Unit = {
    val humanPlayer = new HumanPlayer(SIDE_1)
    val computerPlayer = new ComputerPlayer(SIDE_2)
    doPlayerTurns(computerPlayer, humanPlayer)
    print("Congrats, the end!")
  }
}
