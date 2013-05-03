




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ProtocolRequired extends MessageDeserializer {
  val messageId = 1

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ProtocolRequired.messageId

    val requiredVersion: Int
    val currentVersion: Int

    def serialize(buf: Buffer) {
      buf.writeInt(requiredVersion)
      buf.writeInt(currentVersion)
    }

  }

  protected def create(requiredVersion: Int, currentVersion: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val requiredVersion = buf.readInt()
    val currentVersion = buf.readInt()

    create(requiredVersion, currentVersion)
  }

}

object ProtocolRequired extends ProtocolRequired {
  case class MessageImpl(requiredVersion: Int, currentVersion: Int) extends Message
  type Target = MessageImpl

  override def create(requiredVersion: Int, currentVersion: Int) = MessageImpl(requiredVersion, currentVersion)

  def apply(requiredVersion: Int, currentVersion: Int) = create(requiredVersion, currentVersion)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

