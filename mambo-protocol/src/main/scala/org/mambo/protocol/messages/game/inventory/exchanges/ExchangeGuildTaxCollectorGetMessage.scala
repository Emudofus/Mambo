




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeGuildTaxCollectorGetMessage extends MessageDeserializer {
  val messageId = 5762

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeGuildTaxCollectorGetMessage.messageId

    val collectorName: String
    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short
    val userName: String
    val experience: Double
    val objectsInfos: Seq[ObjectItemQuantity.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeString(collectorName)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
      buf.writeString(userName)
      buf.writeDouble(experience)
      buf.writeUShort(objectsInfos.length)
      for (entry <- objectsInfos) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(collectorName: String, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, userName: String, experience: Double, objectsInfos: Seq[ObjectItemQuantity.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val collectorName = buf.readString()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()
    val userName = buf.readString()
    val experience = buf.readDouble()
    val objectsInfos = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItemQuantity.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItemQuantity.deserialize(buf)
      }
      builder.result()
    }

    create(collectorName, worldX, worldY, mapId, subAreaId, userName, experience, objectsInfos)
  }

}

object ExchangeGuildTaxCollectorGetMessage extends ExchangeGuildTaxCollectorGetMessage {
  case class MessageImpl(collectorName: String, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, userName: String, experience: Double, objectsInfos: Seq[ObjectItemQuantity.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(collectorName: String, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, userName: String, experience: Double, objectsInfos: Seq[ObjectItemQuantity.TypeImpl]) = MessageImpl(collectorName, worldX, worldY, mapId, subAreaId, userName, experience, objectsInfos)

  def apply(collectorName: String, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short, userName: String, experience: Double, objectsInfos: Seq[ObjectItemQuantity.TypeImpl]) = create(collectorName, worldX, worldY, mapId, subAreaId, userName, experience, objectsInfos)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

