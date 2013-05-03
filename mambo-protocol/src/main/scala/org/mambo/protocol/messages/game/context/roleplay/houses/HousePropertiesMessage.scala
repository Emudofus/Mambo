




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HousePropertiesMessage extends MessageDeserializer {
  val messageId = 5734

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HousePropertiesMessage.messageId

    val properties: HouseInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeUShort(properties.typeId)
      properties.serialize(buf)
    }

  }

  protected def create(properties: HouseInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val properties = types.get[HouseInformations.TypeImpl](buf.readShort());

    create(properties)
  }

}

object HousePropertiesMessage extends HousePropertiesMessage {
  case class MessageImpl(properties: HouseInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(properties: HouseInformations.TypeImpl) = MessageImpl(properties)

  def apply(properties: HouseInformations.TypeImpl) = create(properties)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

