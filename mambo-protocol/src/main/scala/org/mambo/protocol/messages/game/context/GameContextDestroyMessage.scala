




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameContextDestroyMessage extends MessageDeserializer {
  val messageId = 201

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameContextDestroyMessage.messageId


    def serialize(buf: Buffer) {
    }

  }

  protected def create(): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {

    create()
  }

}

object GameContextDestroyMessage extends GameContextDestroyMessage {
  case class MessageImpl() extends Message
  type Target = MessageImpl

  override def create() = MessageImpl()

  def apply() = create()
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

