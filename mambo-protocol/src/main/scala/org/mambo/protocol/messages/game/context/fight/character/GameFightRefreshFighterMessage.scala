




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightRefreshFighterMessage extends MessageDeserializer {
  val messageId = 6309

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightRefreshFighterMessage.messageId

    val informations: GameContextActorInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeUShort(informations.typeId)
      informations.serialize(buf)
    }

  }

  protected def create(informations: GameContextActorInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val informations = types.get[GameContextActorInformations.TypeImpl](buf.readShort());

    create(informations)
  }

}

object GameFightRefreshFighterMessage extends GameFightRefreshFighterMessage {
  case class MessageImpl(informations: GameContextActorInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(informations: GameContextActorInformations.TypeImpl) = MessageImpl(informations)

  def apply(informations: GameContextActorInformations.TypeImpl) = create(informations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

