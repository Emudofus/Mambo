




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameContextMoveMultipleElementsMessage extends MessageDeserializer {
  val messageId = 254

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameContextMoveMultipleElementsMessage.messageId

    val movements: Seq[EntityMovementInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(movements.length)
      for (entry <- movements) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(movements: Seq[EntityMovementInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val movements = {
      val builder = collection.immutable.Seq.newBuilder[EntityMovementInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += EntityMovementInformations.deserialize(buf)
      }
      builder.result()
    }

    create(movements)
  }

}

object GameContextMoveMultipleElementsMessage extends GameContextMoveMultipleElementsMessage {
  case class MessageImpl(movements: Seq[EntityMovementInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(movements: Seq[EntityMovementInformations.TypeImpl]) = MessageImpl(movements)

  def apply(movements: Seq[EntityMovementInformations.TypeImpl]) = create(movements)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

