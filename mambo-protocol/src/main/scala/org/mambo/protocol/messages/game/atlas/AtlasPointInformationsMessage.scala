




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AtlasPointInformationsMessage extends MessageDeserializer {
  val messageId = 5956

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AtlasPointInformationsMessage.messageId

    val theType: AtlasPointsInformations.TypeImpl

    def serialize(buf: Buffer) {
      theType.serialize(buf)
    }

  }

  protected def create(theType: AtlasPointsInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val theType = AtlasPointsInformations.deserialize(buf)

    create(theType)
  }

}

object AtlasPointInformationsMessage extends AtlasPointInformationsMessage {
  case class MessageImpl(theType: AtlasPointsInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(theType: AtlasPointsInformations.TypeImpl) = MessageImpl(theType)

  def apply(theType: AtlasPointsInformations.TypeImpl) = create(theType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

