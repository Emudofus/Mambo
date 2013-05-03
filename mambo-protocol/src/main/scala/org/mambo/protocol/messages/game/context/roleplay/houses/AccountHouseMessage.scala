




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AccountHouseMessage extends MessageDeserializer {
  val messageId = 6315

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AccountHouseMessage.messageId

    val houses: Seq[AccountHouseInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(houses.length)
      for (entry <- houses) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(houses: Seq[AccountHouseInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val houses = {
      val builder = collection.immutable.Seq.newBuilder[AccountHouseInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += AccountHouseInformations.deserialize(buf)
      }
      builder.result()
    }

    create(houses)
  }

}

object AccountHouseMessage extends AccountHouseMessage {
  case class MessageImpl(houses: Seq[AccountHouseInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(houses: Seq[AccountHouseInformations.TypeImpl]) = MessageImpl(houses)

  def apply(houses: Seq[AccountHouseInformations.TypeImpl]) = create(houses)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

