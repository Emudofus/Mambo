




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameContextRefreshEntityLookMessage extends MessageDeserializer {
  val messageId = 5637

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameContextRefreshEntityLookMessage.messageId

    val id: Int
    val look: EntityLook.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeInt(id)
      look.serialize(buf)
    }

  }

  protected def create(id: Int, look: EntityLook.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val look = EntityLook.deserialize(buf)

    create(id, look)
  }

}

object GameContextRefreshEntityLookMessage extends GameContextRefreshEntityLookMessage {
  case class MessageImpl(id: Int, look: EntityLook.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(id: Int, look: EntityLook.TypeImpl) = MessageImpl(id, look)

  def apply(id: Int, look: EntityLook.TypeImpl) = create(id, look)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

