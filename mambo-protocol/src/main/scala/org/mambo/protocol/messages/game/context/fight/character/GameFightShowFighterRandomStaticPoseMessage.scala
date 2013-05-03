




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightShowFighterRandomStaticPoseMessage extends GameFightShowFighterMessage {
  override val messageId = 6218

  protected trait Message extends GameFightShowFighterMessage.Message with Serializable {
    override val messageId = GameFightShowFighterRandomStaticPoseMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val informations = types.get[GameFightFighterInformations.TypeImpl](buf.readShort());

    create(informations)
  }

}

object GameFightShowFighterRandomStaticPoseMessage extends GameFightShowFighterRandomStaticPoseMessage {
  case class MessageImpl(informations: GameFightFighterInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(informations: GameFightFighterInformations.TypeImpl) = MessageImpl(informations)

  def apply(informations: GameFightFighterInformations.TypeImpl) = create(informations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

