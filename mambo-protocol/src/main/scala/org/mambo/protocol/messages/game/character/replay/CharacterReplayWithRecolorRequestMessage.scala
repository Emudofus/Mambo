




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterReplayWithRecolorRequestMessage extends CharacterReplayRequestMessage {
  override val messageId = 6111

  protected trait Message extends CharacterReplayRequestMessage.Message with Serializable {
    override val messageId = CharacterReplayWithRecolorRequestMessage.messageId

    val indexedColor: Seq[Int]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(indexedColor.length)
      for (entry <- indexedColor) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(characterId: Int, indexedColor: Seq[Int]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val characterId = buf.readInt()
    val indexedColor = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(characterId, indexedColor)
  }

}

object CharacterReplayWithRecolorRequestMessage extends CharacterReplayWithRecolorRequestMessage {
  case class MessageImpl(characterId: Int, indexedColor: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(characterId: Int, indexedColor: Seq[Int]) = MessageImpl(characterId, indexedColor)

  def apply(characterId: Int, indexedColor: Seq[Int]) = create(characterId, indexedColor)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

