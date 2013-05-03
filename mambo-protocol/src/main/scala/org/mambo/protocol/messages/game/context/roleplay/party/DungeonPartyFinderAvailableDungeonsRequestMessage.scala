




















// Generated on 05/03/2013 10:34:46
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DungeonPartyFinderAvailableDungeonsRequestMessage extends MessageDeserializer {
  val messageId = 6240

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DungeonPartyFinderAvailableDungeonsRequestMessage.messageId


    def serialize(buf: Buffer) {
    }

  }

  protected def create(): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {

    create()
  }

}

object DungeonPartyFinderAvailableDungeonsRequestMessage extends DungeonPartyFinderAvailableDungeonsRequestMessage {
  case class MessageImpl() extends Message
  type Target = MessageImpl

  override def create() = MessageImpl()

  def apply() = create()
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

