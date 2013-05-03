




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TitlesAndOrnamentsListMessage extends MessageDeserializer {
  val messageId = 6367

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TitlesAndOrnamentsListMessage.messageId

    val titles: Seq[Short]
    val ornaments: Seq[Short]
    val activeTitle: Short
    val activeOrnament: Short

    def serialize(buf: Buffer) {
      buf.writeUShort(titles.length)
      for (entry <- titles) {
        buf.writeShort(entry)
      }
      buf.writeUShort(ornaments.length)
      for (entry <- ornaments) {
        buf.writeShort(entry)
      }
      buf.writeShort(activeTitle)
      buf.writeShort(activeOrnament)
    }

  }

  protected def create(titles: Seq[Short], ornaments: Seq[Short], activeTitle: Short, activeOrnament: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val titles = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val ornaments = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val activeTitle = buf.readShort()
    val activeOrnament = buf.readShort()

    create(titles, ornaments, activeTitle, activeOrnament)
  }

}

object TitlesAndOrnamentsListMessage extends TitlesAndOrnamentsListMessage {
  case class MessageImpl(titles: Seq[Short], ornaments: Seq[Short], activeTitle: Short, activeOrnament: Short) extends Message
  type Target = MessageImpl

  override def create(titles: Seq[Short], ornaments: Seq[Short], activeTitle: Short, activeOrnament: Short) = MessageImpl(titles, ornaments, activeTitle, activeOrnament)

  def apply(titles: Seq[Short], ornaments: Seq[Short], activeTitle: Short, activeOrnament: Short) = create(titles, ornaments, activeTitle, activeOrnament)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

