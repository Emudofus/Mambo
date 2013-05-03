




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameDataPlayFarmObjectAnimationMessage extends MessageDeserializer {
  val messageId = 6026

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameDataPlayFarmObjectAnimationMessage.messageId

    val cellId: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeUShort(cellId.length)
      for (entry <- cellId) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(cellId: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val cellId = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(cellId)
  }

}

object GameDataPlayFarmObjectAnimationMessage extends GameDataPlayFarmObjectAnimationMessage {
  case class MessageImpl(cellId: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(cellId: Seq[Short]) = MessageImpl(cellId)

  def apply(cellId: Seq[Short]) = create(cellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

