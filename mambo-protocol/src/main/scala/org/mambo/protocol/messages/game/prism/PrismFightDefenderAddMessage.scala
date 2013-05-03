




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismFightDefenderAddMessage extends MessageDeserializer {
  val messageId = 5895

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismFightDefenderAddMessage.messageId

    val fightId: Double
    val fighterMovementInformations: CharacterMinimalPlusLookAndGradeInformations.TypeImpl
    val inMain: Boolean

    def serialize(buf: Buffer) {
      buf.writeDouble(fightId)
      fighterMovementInformations.serialize(buf)
      buf.writeBoolean(inMain)
    }

  }

  protected def create(fightId: Double, fighterMovementInformations: CharacterMinimalPlusLookAndGradeInformations.TypeImpl, inMain: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readDouble()
    val fighterMovementInformations = CharacterMinimalPlusLookAndGradeInformations.deserialize(buf)
    val inMain = buf.readBoolean()

    create(fightId, fighterMovementInformations, inMain)
  }

}

object PrismFightDefenderAddMessage extends PrismFightDefenderAddMessage {
  case class MessageImpl(fightId: Double, fighterMovementInformations: CharacterMinimalPlusLookAndGradeInformations.TypeImpl, inMain: Boolean) extends Message
  type Target = MessageImpl

  override def create(fightId: Double, fighterMovementInformations: CharacterMinimalPlusLookAndGradeInformations.TypeImpl, inMain: Boolean) = MessageImpl(fightId, fighterMovementInformations, inMain)

  def apply(fightId: Double, fighterMovementInformations: CharacterMinimalPlusLookAndGradeInformations.TypeImpl, inMain: Boolean) = create(fightId, fighterMovementInformations, inMain)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

