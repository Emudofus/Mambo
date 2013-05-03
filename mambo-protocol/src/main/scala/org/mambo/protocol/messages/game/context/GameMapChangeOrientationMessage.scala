




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameMapChangeOrientationMessage extends MessageDeserializer {
  val messageId = 946

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameMapChangeOrientationMessage.messageId

    val orientation: ActorOrientation.TypeImpl

    def serialize(buf: Buffer) {
      orientation.serialize(buf)
    }

  }

  protected def create(orientation: ActorOrientation.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val orientation = ActorOrientation.deserialize(buf)

    create(orientation)
  }

}

object GameMapChangeOrientationMessage extends GameMapChangeOrientationMessage {
  case class MessageImpl(orientation: ActorOrientation.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(orientation: ActorOrientation.TypeImpl) = MessageImpl(orientation)

  def apply(orientation: ActorOrientation.TypeImpl) = create(orientation)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

