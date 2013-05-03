




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ZaapListMessage extends TeleportDestinationsListMessage {
  override val messageId = 1604

  protected trait Message extends TeleportDestinationsListMessage.Message with Serializable {
    override val messageId = ZaapListMessage.messageId

    val spawnMapId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(spawnMapId)
    }

  }

  protected def create(teleporterType: Byte, mapIds: Seq[Int], subAreaIds: Seq[Short], costs: Seq[Short], spawnMapId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
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
    val spawnMapId = buf.readInt()

    create(teleporterType, mapIds, subAreaIds, costs, spawnMapId)
  }

}

object ZaapListMessage extends ZaapListMessage {
  case class MessageImpl(teleporterType: Byte, mapIds: Seq[Int], subAreaIds: Seq[Short], costs: Seq[Short], spawnMapId: Int) extends Message
  type Target = MessageImpl

  override def create(teleporterType: Byte, mapIds: Seq[Int], subAreaIds: Seq[Short], costs: Seq[Short], spawnMapId: Int) = MessageImpl(teleporterType, mapIds, subAreaIds, costs, spawnMapId)

  def apply(teleporterType: Byte, mapIds: Seq[Int], subAreaIds: Seq[Short], costs: Seq[Short], spawnMapId: Int) = create(teleporterType, mapIds, subAreaIds, costs, spawnMapId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

