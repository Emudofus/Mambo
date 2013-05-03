




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TaxCollectorMovementMessage extends MessageDeserializer {
  val messageId = 5633

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TaxCollectorMovementMessage.messageId

    val hireOrFire: Boolean
    val basicInfos: TaxCollectorBasicInformations.TypeImpl
    val playerName: String

    def serialize(buf: Buffer) {
      buf.writeBoolean(hireOrFire)
      basicInfos.serialize(buf)
      buf.writeString(playerName)
    }

  }

  protected def create(hireOrFire: Boolean, basicInfos: TaxCollectorBasicInformations.TypeImpl, playerName: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val hireOrFire = buf.readBoolean()
    val basicInfos = TaxCollectorBasicInformations.deserialize(buf)
    val playerName = buf.readString()

    create(hireOrFire, basicInfos, playerName)
  }

}

object TaxCollectorMovementMessage extends TaxCollectorMovementMessage {
  case class MessageImpl(hireOrFire: Boolean, basicInfos: TaxCollectorBasicInformations.TypeImpl, playerName: String) extends Message
  type Target = MessageImpl

  override def create(hireOrFire: Boolean, basicInfos: TaxCollectorBasicInformations.TypeImpl, playerName: String) = MessageImpl(hireOrFire, basicInfos, playerName)

  def apply(hireOrFire: Boolean, basicInfos: TaxCollectorBasicInformations.TypeImpl, playerName: String) = create(hireOrFire, basicInfos, playerName)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

