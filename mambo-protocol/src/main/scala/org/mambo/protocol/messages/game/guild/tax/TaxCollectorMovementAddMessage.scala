




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TaxCollectorMovementAddMessage extends MessageDeserializer {
  val messageId = 5917

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TaxCollectorMovementAddMessage.messageId

    val informations: TaxCollectorInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeUShort(informations.typeId)
      informations.serialize(buf)
    }

  }

  protected def create(informations: TaxCollectorInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val informations = types.get[TaxCollectorInformations.TypeImpl](buf.readShort());

    create(informations)
  }

}

object TaxCollectorMovementAddMessage extends TaxCollectorMovementAddMessage {
  case class MessageImpl(informations: TaxCollectorInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(informations: TaxCollectorInformations.TypeImpl) = MessageImpl(informations)

  def apply(informations: TaxCollectorInformations.TypeImpl) = create(informations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

