




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait IdentificationSuccessMessage extends MessageDeserializer {
  val messageId = 22

  protected trait Message extends BaseMessage with Serializable {
    val messageId = IdentificationSuccessMessage.messageId

    val hasRights: Boolean
    val wasAlreadyConnected: Boolean
    val login: String
    val nickname: String
    val accountId: Int
    val communityId: Byte
    val secretQuestion: String
    val subscriptionEndDate: Double
    val accountCreation: Double

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, hasRights)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, wasAlreadyConnected)
      buf.writeUByte(flag1.toShort)
      buf.writeString(login)
      buf.writeString(nickname)
      buf.writeInt(accountId)
      buf.writeByte(communityId)
      buf.writeString(secretQuestion)
      buf.writeDouble(subscriptionEndDate)
      buf.writeDouble(accountCreation)
    }

  }

  protected def create(hasRights: Boolean, wasAlreadyConnected: Boolean, login: String, nickname: String, accountId: Int, communityId: Byte, secretQuestion: String, subscriptionEndDate: Double, accountCreation: Double): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val hasRights = BooleanByteWrapper.getFlag(flag1, 0)
    val wasAlreadyConnected = BooleanByteWrapper.getFlag(flag1, 1)
    val login = buf.readString()
    val nickname = buf.readString()
    val accountId = buf.readInt()
    val communityId = buf.readByte()
    val secretQuestion = buf.readString()
    val subscriptionEndDate = buf.readDouble()
    val accountCreation = buf.readDouble()

    create(hasRights, wasAlreadyConnected, login, nickname, accountId, communityId, secretQuestion, subscriptionEndDate, accountCreation)
  }

}

object IdentificationSuccessMessage extends IdentificationSuccessMessage {
  case class MessageImpl(hasRights: Boolean, wasAlreadyConnected: Boolean, login: String, nickname: String, accountId: Int, communityId: Byte, secretQuestion: String, subscriptionEndDate: Double, accountCreation: Double) extends Message
  type Target = MessageImpl

  override def create(hasRights: Boolean, wasAlreadyConnected: Boolean, login: String, nickname: String, accountId: Int, communityId: Byte, secretQuestion: String, subscriptionEndDate: Double, accountCreation: Double) = MessageImpl(hasRights, wasAlreadyConnected, login, nickname, accountId, communityId, secretQuestion, subscriptionEndDate, accountCreation)

  def apply(hasRights: Boolean, wasAlreadyConnected: Boolean, login: String, nickname: String, accountId: Int, communityId: Byte, secretQuestion: String, subscriptionEndDate: Double, accountCreation: Double) = create(hasRights, wasAlreadyConnected, login, nickname, accountId, communityId, secretQuestion, subscriptionEndDate, accountCreation)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

