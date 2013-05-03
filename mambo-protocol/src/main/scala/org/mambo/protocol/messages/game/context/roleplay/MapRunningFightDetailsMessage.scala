




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MapRunningFightDetailsMessage extends MessageDeserializer {
  val messageId = 5751

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MapRunningFightDetailsMessage.messageId

    val fightId: Int
    val names: Seq[String]
    val levels: Seq[Short]
    val teamSwap: Byte
    val alives: Seq[Boolean]

    def serialize(buf: Buffer) {
      buf.writeInt(fightId)
      buf.writeUShort(names.length)
      for (entry <- names) {
        buf.writeString(entry)
      }
      buf.writeUShort(levels.length)
      for (entry <- levels) {
        buf.writeShort(entry)
      }
      buf.writeByte(teamSwap)
      buf.writeUShort(alives.length)
      for (entry <- alives) {
        buf.writeBoolean(entry)
      }
    }

  }

  protected def create(fightId: Int, names: Seq[String], levels: Seq[Short], teamSwap: Byte, alives: Seq[Boolean]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readInt()
    val names = {
      val builder = collection.immutable.Seq.newBuilder[String]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readString()
      }
      builder.result()
    }
    val levels = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val teamSwap = buf.readByte()
    val alives = {
      val builder = collection.immutable.Seq.newBuilder[Boolean]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readBoolean()
      }
      builder.result()
    }

    create(fightId, names, levels, teamSwap, alives)
  }

}

object MapRunningFightDetailsMessage extends MapRunningFightDetailsMessage {
  case class MessageImpl(fightId: Int, names: Seq[String], levels: Seq[Short], teamSwap: Byte, alives: Seq[Boolean]) extends Message
  type Target = MessageImpl

  override def create(fightId: Int, names: Seq[String], levels: Seq[Short], teamSwap: Byte, alives: Seq[Boolean]) = MessageImpl(fightId, names, levels, teamSwap, alives)

  def apply(fightId: Int, names: Seq[String], levels: Seq[Short], teamSwap: Byte, alives: Seq[Boolean]) = create(fightId, names, levels, teamSwap, alives)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

