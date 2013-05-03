




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeOnHumanVendorRequestMessage extends MessageDeserializer {
  val messageId = 5772

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeOnHumanVendorRequestMessage.messageId

    val humanVendorId: Int
    val humanVendorCell: Int

    def serialize(buf: Buffer) {
      buf.writeInt(humanVendorId)
      buf.writeInt(humanVendorCell)
    }

  }

  protected def create(humanVendorId: Int, humanVendorCell: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val humanVendorId = buf.readInt()
    val humanVendorCell = buf.readInt()

    create(humanVendorId, humanVendorCell)
  }

}

object ExchangeOnHumanVendorRequestMessage extends ExchangeOnHumanVendorRequestMessage {
  case class MessageImpl(humanVendorId: Int, humanVendorCell: Int) extends Message
  type Target = MessageImpl

  override def create(humanVendorId: Int, humanVendorCell: Int) = MessageImpl(humanVendorId, humanVendorCell)

  def apply(humanVendorId: Int, humanVendorCell: Int) = create(humanVendorId, humanVendorCell)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

