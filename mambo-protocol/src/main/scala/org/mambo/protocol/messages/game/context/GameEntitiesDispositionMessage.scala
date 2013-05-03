




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameEntitiesDispositionMessage extends MessageDeserializer {
  val messageId = 5696

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameEntitiesDispositionMessage.messageId

    val dispositions: Seq[IdentifiedEntityDispositionInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(dispositions.length)
      for (entry <- dispositions) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(dispositions: Seq[IdentifiedEntityDispositionInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dispositions = {
      val builder = collection.immutable.Seq.newBuilder[IdentifiedEntityDispositionInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += IdentifiedEntityDispositionInformations.deserialize(buf)
      }
      builder.result()
    }

    create(dispositions)
  }

}

object GameEntitiesDispositionMessage extends GameEntitiesDispositionMessage {
  case class MessageImpl(dispositions: Seq[IdentifiedEntityDispositionInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(dispositions: Seq[IdentifiedEntityDispositionInformations.TypeImpl]) = MessageImpl(dispositions)

  def apply(dispositions: Seq[IdentifiedEntityDispositionInformations.TypeImpl]) = create(dispositions)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

