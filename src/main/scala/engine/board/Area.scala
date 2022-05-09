package personal.games.moba
package engine.board

import scala.collection.mutable.ListBuffer

case class Area(index: Int,
                var heroes: ListBuffer [Hero],
                var base: Option[Base] = None,
                var tower: Option[Tower] = None,
                var warriors: ListBuffer [Warrior])
