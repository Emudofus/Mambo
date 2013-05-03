




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MapComplementaryInformationsWithCoordsMessage extends MapComplementaryInformationsDataMessage {
  override val messageId = 6268

  protected trait Message extends MapComplementaryInformationsDataMessage.Message with Serializable {
    override val messageId = MapComplementaryInformationsWithCoordsMessage.messageId

    val worldX: Short
    val worldY: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(worldX)
      buf.writeShort(worldY)
    }

  }

  protected def create(subAreaId: Short, mapId: Int, subareaAlignmentSide: Byte, houses: Seq[HouseInformations.TypeImpl], actors: Seq[GameRolePlayActorInformations.TypeImpl], interactiveElements: Seq[InteractiveElement.TypeImpl], statedElements: Seq[StatedElement.TypeImpl], obstacles: Seq[MapObstacle.TypeImpl], fights: Seq[FightCommonInformations.TypeImpl], worldX: Short, worldY: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val subAreaId = buf.readShort()
    val mapId = buf.readInt()
    val subareaAlignmentSide = buf.readByte()
    val houses = {
      val builder = collection.immutable.Seq.newBuilder[HouseInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[HouseInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val actors = {
      val builder = collection.immutable.Seq.newBuilder[GameRolePlayActorInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[GameRolePlayActorInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val interactiveElements = {
      val builder = collection.immutable.Seq.newBuilder[InteractiveElement.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[InteractiveElement.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val statedElements = {
      val builder = collection.immutable.Seq.newBuilder[StatedElement.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += StatedElement.deserialize(buf)
      }
      builder.result()
    }
    val obstacles = {
      val builder = collection.immutable.Seq.newBuilder[MapObstacle.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += MapObstacle.deserialize(buf)
      }
      builder.result()
    }
    val fights = {
      val builder = collection.immutable.Seq.newBuilder[FightCommonInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += FightCommonInformations.deserialize(buf)
      }
      builder.result()
    }
    val worldX = buf.readShort()
    val worldY = buf.readShort()

    create(subAreaId, mapId, subareaAlignmentSide, houses, actors, interactiveElements, statedElements, obstacles, fights, worldX, worldY)
  }

}

object MapComplementaryInformationsWithCoordsMessage extends MapComplementaryInformationsWithCoordsMessage {
  case class MessageImpl(subAreaId: Short, mapId: Int, subareaAlignmentSide: Byte, houses: Seq[HouseInformations.TypeImpl], actors: Seq[GameRolePlayActorInformations.TypeImpl], interactiveElements: Seq[InteractiveElement.TypeImpl], statedElements: Seq[StatedElement.TypeImpl], obstacles: Seq[MapObstacle.TypeImpl], fights: Seq[FightCommonInformations.TypeImpl], worldX: Short, worldY: Short) extends Message
  type Target = MessageImpl

  override def create(subAreaId: Short, mapId: Int, subareaAlignmentSide: Byte, houses: Seq[HouseInformations.TypeImpl], actors: Seq[GameRolePlayActorInformations.TypeImpl], interactiveElements: Seq[InteractiveElement.TypeImpl], statedElements: Seq[StatedElement.TypeImpl], obstacles: Seq[MapObstacle.TypeImpl], fights: Seq[FightCommonInformations.TypeImpl], worldX: Short, worldY: Short) = MessageImpl(subAreaId, mapId, subareaAlignmentSide, houses, actors, interactiveElements, statedElements, obstacles, fights, worldX, worldY)

  def apply(subAreaId: Short, mapId: Int, subareaAlignmentSide: Byte, houses: Seq[HouseInformations.TypeImpl], actors: Seq[GameRolePlayActorInformations.TypeImpl], interactiveElements: Seq[InteractiveElement.TypeImpl], statedElements: Seq[StatedElement.TypeImpl], obstacles: Seq[MapObstacle.TypeImpl], fights: Seq[FightCommonInformations.TypeImpl], worldX: Short, worldY: Short) = create(subAreaId, mapId, subareaAlignmentSide, houses, actors, interactiveElements, statedElements, obstacles, fights, worldX, worldY)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

