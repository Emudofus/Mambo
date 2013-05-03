




















// Generated on 05/03/2013 10:34:30
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ConsoleCommandsListMessage extends MessageDeserializer {
  val messageId = 6127

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ConsoleCommandsListMessage.messageId

    val aliases: Seq[String]
    val arguments: Seq[String]
    val descriptions: Seq[String]

    def serialize(buf: Buffer) {
      buf.writeUShort(aliases.length)
      for (entry <- aliases) {
        buf.writeString(entry)
      }
      buf.writeUShort(arguments.length)
      for (entry <- arguments) {
        buf.writeString(entry)
      }
      buf.writeUShort(descriptions.length)
      for (entry <- descriptions) {
        buf.writeString(entry)
      }
    }

  }

  protected def create(aliases: Seq[String], arguments: Seq[String], descriptions: Seq[String]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val aliases = {
      val builder = collection.immutable.Seq.newBuilder[String]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readString()
      }
      builder.result()
    }
    val arguments = {
      val builder = collection.immutable.Seq.newBuilder[String]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readString()
      }
      builder.result()
    }
    val descriptions = {
      val builder = collection.immutable.Seq.newBuilder[String]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readString()
      }
      builder.result()
    }

    create(aliases, arguments, descriptions)
  }

}

object ConsoleCommandsListMessage extends ConsoleCommandsListMessage {
  case class MessageImpl(aliases: Seq[String], arguments: Seq[String], descriptions: Seq[String]) extends Message
  type Target = MessageImpl

  override def create(aliases: Seq[String], arguments: Seq[String], descriptions: Seq[String]) = MessageImpl(aliases, arguments, descriptions)

  def apply(aliases: Seq[String], arguments: Seq[String], descriptions: Seq[String]) = create(aliases, arguments, descriptions)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

