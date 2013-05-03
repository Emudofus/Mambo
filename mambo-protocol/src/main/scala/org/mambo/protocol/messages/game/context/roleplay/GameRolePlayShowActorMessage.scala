




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayShowActorMessage extends MessageDeserializer {
  val messageId = 5632

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayShowActorMessage.messageId

    val informations: GameRolePlayActorInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeUShort(informations.typeId)
      informations.serialize(buf)
    }

  }

  protected def create(informations: GameRolePlayActorInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val informations = types.get[GameRolePlayActorInformations.TypeImpl](buf.readShort());

    create(informations)
  }

}

object GameRolePlayShowActorMessage extends GameRolePlayShowActorMessage {
  case class MessageImpl(informations: GameRolePlayActorInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(informations: GameRolePlayActorInformations.TypeImpl) = MessageImpl(informations)

  def apply(informations: GameRolePlayActorInformations.TypeImpl) = create(informations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

