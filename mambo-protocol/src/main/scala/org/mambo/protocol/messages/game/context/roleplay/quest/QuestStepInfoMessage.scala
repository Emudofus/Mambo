




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait QuestStepInfoMessage extends MessageDeserializer {
  val messageId = 5625

  protected trait Message extends BaseMessage with Serializable {
    val messageId = QuestStepInfoMessage.messageId

    val infos: QuestActiveInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeUShort(infos.typeId)
      infos.serialize(buf)
    }

  }

  protected def create(infos: QuestActiveInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val infos = types.get[QuestActiveInformations.TypeImpl](buf.readShort());

    create(infos)
  }

}

object QuestStepInfoMessage extends QuestStepInfoMessage {
  case class MessageImpl(infos: QuestActiveInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(infos: QuestActiveInformations.TypeImpl) = MessageImpl(infos)

  def apply(infos: QuestActiveInformations.TypeImpl) = create(infos)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

