




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PaddockPropertiesMessage extends MessageDeserializer {
  val messageId = 5824

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PaddockPropertiesMessage.messageId

    val properties: PaddockInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeUShort(properties.typeId)
      properties.serialize(buf)
    }

  }

  protected def create(properties: PaddockInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val properties = types.get[PaddockInformations.TypeImpl](buf.readShort());

    create(properties)
  }

}

object PaddockPropertiesMessage extends PaddockPropertiesMessage {
  case class MessageImpl(properties: PaddockInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(properties: PaddockInformations.TypeImpl) = MessageImpl(properties)

  def apply(properties: PaddockInformations.TypeImpl) = create(properties)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

