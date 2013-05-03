




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SpellForgottenMessage extends MessageDeserializer {
  val messageId = 5834

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SpellForgottenMessage.messageId

    val spellsId: Seq[Short]
    val boostPoint: Short

    def serialize(buf: Buffer) {
      buf.writeUShort(spellsId.length)
      for (entry <- spellsId) {
        buf.writeShort(entry)
      }
      buf.writeShort(boostPoint)
    }

  }

  protected def create(spellsId: Seq[Short], boostPoint: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spellsId = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val boostPoint = buf.readShort()

    create(spellsId, boostPoint)
  }

}

object SpellForgottenMessage extends SpellForgottenMessage {
  case class MessageImpl(spellsId: Seq[Short], boostPoint: Short) extends Message
  type Target = MessageImpl

  override def create(spellsId: Seq[Short], boostPoint: Short) = MessageImpl(spellsId, boostPoint)

  def apply(spellsId: Seq[Short], boostPoint: Short) = create(spellsId, boostPoint)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

