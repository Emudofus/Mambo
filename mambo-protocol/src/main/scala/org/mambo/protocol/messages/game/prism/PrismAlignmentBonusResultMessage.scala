




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismAlignmentBonusResultMessage extends MessageDeserializer {
  val messageId = 5842

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismAlignmentBonusResultMessage.messageId

    val alignmentBonus: AlignmentBonusInformations.TypeImpl

    def serialize(buf: Buffer) {
      alignmentBonus.serialize(buf)
    }

  }

  protected def create(alignmentBonus: AlignmentBonusInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val alignmentBonus = AlignmentBonusInformations.deserialize(buf)

    create(alignmentBonus)
  }

}

object PrismAlignmentBonusResultMessage extends PrismAlignmentBonusResultMessage {
  case class MessageImpl(alignmentBonus: AlignmentBonusInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(alignmentBonus: AlignmentBonusInformations.TypeImpl) = MessageImpl(alignmentBonus)

  def apply(alignmentBonus: AlignmentBonusInformations.TypeImpl) = create(alignmentBonus)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

