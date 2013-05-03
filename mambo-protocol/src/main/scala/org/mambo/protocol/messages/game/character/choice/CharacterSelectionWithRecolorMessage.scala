




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterSelectionWithRecolorMessage extends CharacterSelectionMessage {
  override val messageId = 6075

  protected trait Message extends CharacterSelectionMessage.Message with Serializable {
    override val messageId = CharacterSelectionWithRecolorMessage.messageId

    val indexedColor: Seq[Int]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(indexedColor.length)
      for (entry <- indexedColor) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(id: Int, indexedColor: Seq[Int]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val indexedColor = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(id, indexedColor)
  }

}

object CharacterSelectionWithRecolorMessage extends CharacterSelectionWithRecolorMessage {
  case class MessageImpl(id: Int, indexedColor: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(id: Int, indexedColor: Seq[Int]) = MessageImpl(id, indexedColor)

  def apply(id: Int, indexedColor: Seq[Int]) = create(id, indexedColor)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

