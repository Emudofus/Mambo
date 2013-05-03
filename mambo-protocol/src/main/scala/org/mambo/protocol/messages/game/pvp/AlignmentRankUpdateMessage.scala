




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AlignmentRankUpdateMessage extends MessageDeserializer {
  val messageId = 6058

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AlignmentRankUpdateMessage.messageId

    val alignmentRank: Byte
    val verbose: Boolean

    def serialize(buf: Buffer) {
      buf.writeByte(alignmentRank)
      buf.writeBoolean(verbose)
    }

  }

  protected def create(alignmentRank: Byte, verbose: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val alignmentRank = buf.readByte()
    val verbose = buf.readBoolean()

    create(alignmentRank, verbose)
  }

}

object AlignmentRankUpdateMessage extends AlignmentRankUpdateMessage {
  case class MessageImpl(alignmentRank: Byte, verbose: Boolean) extends Message
  type Target = MessageImpl

  override def create(alignmentRank: Byte, verbose: Boolean) = MessageImpl(alignmentRank, verbose)

  def apply(alignmentRank: Byte, verbose: Boolean) = create(alignmentRank, verbose)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

