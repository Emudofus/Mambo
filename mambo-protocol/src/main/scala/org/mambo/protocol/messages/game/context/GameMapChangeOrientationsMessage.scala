




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameMapChangeOrientationsMessage extends MessageDeserializer {
  val messageId = 6155

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameMapChangeOrientationsMessage.messageId

    val orientations: Seq[ActorOrientation.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(orientations.length)
      for (entry <- orientations) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(orientations: Seq[ActorOrientation.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val orientations = {
      val builder = collection.immutable.Seq.newBuilder[ActorOrientation.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ActorOrientation.deserialize(buf)
      }
      builder.result()
    }

    create(orientations)
  }

}

object GameMapChangeOrientationsMessage extends GameMapChangeOrientationsMessage {
  case class MessageImpl(orientations: Seq[ActorOrientation.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(orientations: Seq[ActorOrientation.TypeImpl]) = MessageImpl(orientations)

  def apply(orientations: Seq[ActorOrientation.TypeImpl]) = create(orientations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

