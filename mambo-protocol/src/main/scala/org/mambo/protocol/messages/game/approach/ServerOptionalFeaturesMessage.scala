




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ServerOptionalFeaturesMessage extends MessageDeserializer {
  val messageId = 6305

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ServerOptionalFeaturesMessage.messageId

    val features: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeUShort(features.length)
      for (entry <- features) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(features: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val features = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(features)
  }

}

object ServerOptionalFeaturesMessage extends ServerOptionalFeaturesMessage {
  case class MessageImpl(features: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(features: Seq[Short]) = MessageImpl(features)

  def apply(features: Seq[Short]) = create(features)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

