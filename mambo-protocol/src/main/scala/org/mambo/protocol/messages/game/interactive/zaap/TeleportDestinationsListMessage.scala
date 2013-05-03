




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TeleportDestinationsListMessage extends MessageDeserializer {
  val messageId = 5960

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TeleportDestinationsListMessage.messageId

    val teleporterType: Byte
    val mapIds: Seq[Int]
    val subAreaIds: Seq[Short]
    val costs: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeByte(teleporterType)
      buf.writeUShort(mapIds.length)
      for (entry <- mapIds) {
        buf.writeInt(entry)
      }
      buf.writeUShort(subAreaIds.length)
      for (entry <- subAreaIds) {
        buf.writeShort(entry)
      }
      buf.writeUShort(costs.length)
      for (entry <- costs) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(teleporterType: Byte, mapIds: Seq[Int], subAreaIds: Seq[Short], costs: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val teleporterType = buf.readByte()
    val mapIds = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val subAreaIds = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val costs = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(teleporterType, mapIds, subAreaIds, costs)
  }

}

object TeleportDestinationsListMessage extends TeleportDestinationsListMessage {
  case class MessageImpl(teleporterType: Byte, mapIds: Seq[Int], subAreaIds: Seq[Short], costs: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(teleporterType: Byte, mapIds: Seq[Int], subAreaIds: Seq[Short], costs: Seq[Short]) = MessageImpl(teleporterType, mapIds, subAreaIds, costs)

  def apply(teleporterType: Byte, mapIds: Seq[Int], subAreaIds: Seq[Short], costs: Seq[Short]) = create(teleporterType, mapIds, subAreaIds, costs)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

