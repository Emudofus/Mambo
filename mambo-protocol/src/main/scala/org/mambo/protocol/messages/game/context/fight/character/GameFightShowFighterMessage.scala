




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightShowFighterMessage extends MessageDeserializer {
  val messageId = 5864

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightShowFighterMessage.messageId

    val informations: GameFightFighterInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeUShort(informations.typeId)
      informations.serialize(buf)
    }

  }

  protected def create(informations: GameFightFighterInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val informations = types.get[GameFightFighterInformations.TypeImpl](buf.readShort());

    create(informations)
  }

}

object GameFightShowFighterMessage extends GameFightShowFighterMessage {
  case class MessageImpl(informations: GameFightFighterInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(informations: GameFightFighterInformations.TypeImpl) = MessageImpl(informations)

  def apply(informations: GameFightFighterInformations.TypeImpl) = create(informations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

