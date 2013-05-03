




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MapComplementaryInformationsDataMessage extends MessageDeserializer {
  val messageId = 226

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MapComplementaryInformationsDataMessage.messageId

    val subAreaId: Short
    val mapId: Int
    val subareaAlignmentSide: Byte
    val houses: Seq[HouseInformations.TypeImpl]
    val actors: Seq[GameRolePlayActorInformations.TypeImpl]
    val interactiveElements: Seq[InteractiveElement.TypeImpl]
    val statedElements: Seq[StatedElement.TypeImpl]
    val obstacles: Seq[MapObstacle.TypeImpl]
    val fights: Seq[FightCommonInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeShort(subAreaId)
      buf.writeInt(mapId)
      buf.writeByte(subareaAlignmentSide)
      buf.writeUShort(houses.length)
      for (entry <- houses) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
      buf.writeUShort(actors.length)
      for (entry <- actors) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
      buf.writeUShort(interactiveElements.length)
      for (entry <- interactiveElements) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
      buf.writeUShort(statedElements.length)
      for (entry <- statedElements) {
        entry.serialize(buf)
      }
      buf.writeUShort(obstacles.length)
      for (entry <- obstacles) {
        entry.serialize(buf)
      }
      buf.writeUShort(fights.length)
      for (entry <- fights) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(subAreaId: Short, mapId: Int, subareaAlignmentSide: Byte, houses: Seq[HouseInformations.TypeImpl], actors: Seq[GameRolePlayActorInformations.TypeImpl], interactiveElements: Seq[InteractiveElement.TypeImpl], statedElements: Seq[StatedElement.TypeImpl], obstacles: Seq[MapObstacle.TypeImpl], fights: Seq[FightCommonInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
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

    create(subAreaId, mapId, subareaAlignmentSide, houses, actors, interactiveElements, statedElements, obstacles, fights)
  }

}

object MapComplementaryInformationsDataMessage extends MapComplementaryInformationsDataMessage {
  case class MessageImpl(subAreaId: Short, mapId: Int, subareaAlignmentSide: Byte, houses: Seq[HouseInformations.TypeImpl], actors: Seq[GameRolePlayActorInformations.TypeImpl], interactiveElements: Seq[InteractiveElement.TypeImpl], statedElements: Seq[StatedElement.TypeImpl], obstacles: Seq[MapObstacle.TypeImpl], fights: Seq[FightCommonInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(subAreaId: Short, mapId: Int, subareaAlignmentSide: Byte, houses: Seq[HouseInformations.TypeImpl], actors: Seq[GameRolePlayActorInformations.TypeImpl], interactiveElements: Seq[InteractiveElement.TypeImpl], statedElements: Seq[StatedElement.TypeImpl], obstacles: Seq[MapObstacle.TypeImpl], fights: Seq[FightCommonInformations.TypeImpl]) = MessageImpl(subAreaId, mapId, subareaAlignmentSide, houses, actors, interactiveElements, statedElements, obstacles, fights)

  def apply(subAreaId: Short, mapId: Int, subareaAlignmentSide: Byte, houses: Seq[HouseInformations.TypeImpl], actors: Seq[GameRolePlayActorInformations.TypeImpl], interactiveElements: Seq[InteractiveElement.TypeImpl], statedElements: Seq[StatedElement.TypeImpl], obstacles: Seq[MapObstacle.TypeImpl], fights: Seq[FightCommonInformations.TypeImpl]) = create(subAreaId, mapId, subareaAlignmentSide, houses, actors, interactiveElements, statedElements, obstacles, fights)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

