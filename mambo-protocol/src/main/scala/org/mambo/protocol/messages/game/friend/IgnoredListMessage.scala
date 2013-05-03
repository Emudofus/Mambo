




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait IgnoredListMessage extends MessageDeserializer {
  val messageId = 5674

  protected trait Message extends BaseMessage with Serializable {
    val messageId = IgnoredListMessage.messageId

    val ignoredList: Seq[IgnoredInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(ignoredList.length)
      for (entry <- ignoredList) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(ignoredList: Seq[IgnoredInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val ignoredList = {
      val builder = collection.immutable.Seq.newBuilder[IgnoredInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[IgnoredInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(ignoredList)
  }

}

object IgnoredListMessage extends IgnoredListMessage {
  case class MessageImpl(ignoredList: Seq[IgnoredInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(ignoredList: Seq[IgnoredInformations.TypeImpl]) = MessageImpl(ignoredList)

  def apply(ignoredList: Seq[IgnoredInformations.TypeImpl]) = create(ignoredList)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

