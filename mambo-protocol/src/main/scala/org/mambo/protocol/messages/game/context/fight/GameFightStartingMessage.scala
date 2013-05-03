




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightStartingMessage extends MessageDeserializer {
  val messageId = 700

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightStartingMessage.messageId

    val fightType: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(fightType)
    }

  }

  protected def create(fightType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightType = buf.readByte()

    create(fightType)
  }

}

object GameFightStartingMessage extends GameFightStartingMessage {
  case class MessageImpl(fightType: Byte) extends Message
  type Target = MessageImpl

  override def create(fightType: Byte) = MessageImpl(fightType)

  def apply(fightType: Byte) = create(fightType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

