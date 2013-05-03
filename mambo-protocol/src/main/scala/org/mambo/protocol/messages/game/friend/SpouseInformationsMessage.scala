




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SpouseInformationsMessage extends MessageDeserializer {
  val messageId = 6356

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SpouseInformationsMessage.messageId

    val spouse: FriendSpouseInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeUShort(spouse.typeId)
      spouse.serialize(buf)
    }

  }

  protected def create(spouse: FriendSpouseInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spouse = types.get[FriendSpouseInformations.TypeImpl](buf.readShort());

    create(spouse)
  }

}

object SpouseInformationsMessage extends SpouseInformationsMessage {
  case class MessageImpl(spouse: FriendSpouseInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(spouse: FriendSpouseInformations.TypeImpl) = MessageImpl(spouse)

  def apply(spouse: FriendSpouseInformations.TypeImpl) = create(spouse)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

