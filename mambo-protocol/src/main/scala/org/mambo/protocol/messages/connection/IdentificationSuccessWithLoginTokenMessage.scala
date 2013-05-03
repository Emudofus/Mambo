




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait IdentificationSuccessWithLoginTokenMessage extends IdentificationSuccessMessage {
  override val messageId = 6209

  protected trait Message extends IdentificationSuccessMessage.Message with Serializable {
    override val messageId = IdentificationSuccessWithLoginTokenMessage.messageId

    val loginToken: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(loginToken)
    }

  }

  protected def create(hasRights: Boolean, wasAlreadyConnected: Boolean, login: String, nickname: String, accountId: Int, communityId: Byte, secretQuestion: String, subscriptionEndDate: Double, accountCreation: Double, loginToken: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
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
    val loginToken = buf.readString()

    create(hasRights, wasAlreadyConnected, login, nickname, accountId, communityId, secretQuestion, subscriptionEndDate, accountCreation, loginToken)
  }

}

object IdentificationSuccessWithLoginTokenMessage extends IdentificationSuccessWithLoginTokenMessage {
  case class MessageImpl(hasRights: Boolean, wasAlreadyConnected: Boolean, login: String, nickname: String, accountId: Int, communityId: Byte, secretQuestion: String, subscriptionEndDate: Double, accountCreation: Double, loginToken: String) extends Message
  type Target = MessageImpl

  override def create(hasRights: Boolean, wasAlreadyConnected: Boolean, login: String, nickname: String, accountId: Int, communityId: Byte, secretQuestion: String, subscriptionEndDate: Double, accountCreation: Double, loginToken: String) = MessageImpl(hasRights, wasAlreadyConnected, login, nickname, accountId, communityId, secretQuestion, subscriptionEndDate, accountCreation, loginToken)

  def apply(hasRights: Boolean, wasAlreadyConnected: Boolean, login: String, nickname: String, accountId: Int, communityId: Byte, secretQuestion: String, subscriptionEndDate: Double, accountCreation: Double, loginToken: String) = create(hasRights, wasAlreadyConnected, login, nickname, accountId, communityId, secretQuestion, subscriptionEndDate, accountCreation, loginToken)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

