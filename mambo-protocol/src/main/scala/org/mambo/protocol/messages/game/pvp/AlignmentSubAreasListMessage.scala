




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AlignmentSubAreasListMessage extends MessageDeserializer {
  val messageId = 6059

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AlignmentSubAreasListMessage.messageId

    val angelsSubAreas: Seq[Short]
    val evilsSubAreas: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeUShort(angelsSubAreas.length)
      for (entry <- angelsSubAreas) {
        buf.writeShort(entry)
      }
      buf.writeUShort(evilsSubAreas.length)
      for (entry <- evilsSubAreas) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(angelsSubAreas: Seq[Short], evilsSubAreas: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val angelsSubAreas = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val evilsSubAreas = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(angelsSubAreas, evilsSubAreas)
  }

}

object AlignmentSubAreasListMessage extends AlignmentSubAreasListMessage {
  case class MessageImpl(angelsSubAreas: Seq[Short], evilsSubAreas: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(angelsSubAreas: Seq[Short], evilsSubAreas: Seq[Short]) = MessageImpl(angelsSubAreas, evilsSubAreas)

  def apply(angelsSubAreas: Seq[Short], evilsSubAreas: Seq[Short]) = create(angelsSubAreas, evilsSubAreas)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

