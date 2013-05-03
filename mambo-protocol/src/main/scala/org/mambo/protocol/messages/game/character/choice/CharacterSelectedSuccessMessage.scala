




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterSelectedSuccessMessage extends MessageDeserializer {
  val messageId = 153

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharacterSelectedSuccessMessage.messageId

    val infos: CharacterBaseInformations.TypeImpl

    def serialize(buf: Buffer) {
      infos.serialize(buf)
    }

  }

  protected def create(infos: CharacterBaseInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val infos = CharacterBaseInformations.deserialize(buf)

    create(infos)
  }

}

object CharacterSelectedSuccessMessage extends CharacterSelectedSuccessMessage {
  case class MessageImpl(infos: CharacterBaseInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(infos: CharacterBaseInformations.TypeImpl) = MessageImpl(infos)

  def apply(infos: CharacterBaseInformations.TypeImpl) = create(infos)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

