




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameContextMoveElementMessage extends MessageDeserializer {
  val messageId = 253

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameContextMoveElementMessage.messageId

    val movement: EntityMovementInformations.TypeImpl

    def serialize(buf: Buffer) {
      movement.serialize(buf)
    }

  }

  protected def create(movement: EntityMovementInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val movement = EntityMovementInformations.deserialize(buf)

    create(movement)
  }

}

object GameContextMoveElementMessage extends GameContextMoveElementMessage {
  case class MessageImpl(movement: EntityMovementInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(movement: EntityMovementInformations.TypeImpl) = MessageImpl(movement)

  def apply(movement: EntityMovementInformations.TypeImpl) = create(movement)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

