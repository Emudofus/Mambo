




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TaxCollectorAttackedMessage extends MessageDeserializer {
  val messageId = 5918

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TaxCollectorAttackedMessage.messageId

    val firstNameId: Short
    val lastNameId: Short
    val worldX: Short
    val worldY: Short
    val mapId: Int
    val subAreaId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(firstNameId)
      buf.writeShort(lastNameId)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeInt(mapId)
      buf.writeShort(subAreaId)
    }

  }

  protected def create(firstNameId: Short, lastNameId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val firstNameId = buf.readShort()
    val lastNameId = buf.readShort()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val mapId = buf.readInt()
    val subAreaId = buf.readShort()

    create(firstNameId, lastNameId, worldX, worldY, mapId, subAreaId)
  }

}

object TaxCollectorAttackedMessage extends TaxCollectorAttackedMessage {
  case class MessageImpl(firstNameId: Short, lastNameId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) extends Message
  type Target = MessageImpl

  override def create(firstNameId: Short, lastNameId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = MessageImpl(firstNameId, lastNameId, worldX, worldY, mapId, subAreaId)

  def apply(firstNameId: Short, lastNameId: Short, worldX: Short, worldY: Short, mapId: Int, subAreaId: Short) = create(firstNameId, lastNameId, worldX, worldY, mapId, subAreaId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

