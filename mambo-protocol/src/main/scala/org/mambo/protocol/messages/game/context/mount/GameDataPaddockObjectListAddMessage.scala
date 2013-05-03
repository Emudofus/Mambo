




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameDataPaddockObjectListAddMessage extends MessageDeserializer {
  val messageId = 5992

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameDataPaddockObjectListAddMessage.messageId

    val paddockItemDescription: Seq[PaddockItem.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(paddockItemDescription.length)
      for (entry <- paddockItemDescription) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(paddockItemDescription: Seq[PaddockItem.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val paddockItemDescription = {
      val builder = collection.immutable.Seq.newBuilder[PaddockItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += PaddockItem.deserialize(buf)
      }
      builder.result()
    }

    create(paddockItemDescription)
  }

}

object GameDataPaddockObjectListAddMessage extends GameDataPaddockObjectListAddMessage {
  case class MessageImpl(paddockItemDescription: Seq[PaddockItem.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(paddockItemDescription: Seq[PaddockItem.TypeImpl]) = MessageImpl(paddockItemDescription)

  def apply(paddockItemDescription: Seq[PaddockItem.TypeImpl]) = create(paddockItemDescription)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

