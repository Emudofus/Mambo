




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TaxCollectorAttackedResultMessage extends MessageDeserializer {
  val messageId = 5635

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TaxCollectorAttackedResultMessage.messageId

    val deadOrAlive: Boolean
    val basicInfos: TaxCollectorBasicInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeBoolean(deadOrAlive)
      basicInfos.serialize(buf)
    }

  }

  protected def create(deadOrAlive: Boolean, basicInfos: TaxCollectorBasicInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val deadOrAlive = buf.readBoolean()
    val basicInfos = TaxCollectorBasicInformations.deserialize(buf)

    create(deadOrAlive, basicInfos)
  }

}

object TaxCollectorAttackedResultMessage extends TaxCollectorAttackedResultMessage {
  case class MessageImpl(deadOrAlive: Boolean, basicInfos: TaxCollectorBasicInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(deadOrAlive: Boolean, basicInfos: TaxCollectorBasicInformations.TypeImpl) = MessageImpl(deadOrAlive, basicInfos)

  def apply(deadOrAlive: Boolean, basicInfos: TaxCollectorBasicInformations.TypeImpl) = create(deadOrAlive, basicInfos)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

