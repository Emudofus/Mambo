




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChallengeDungeonStackedBonusMessage extends MessageDeserializer {
  val messageId = 6151

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChallengeDungeonStackedBonusMessage.messageId

    val dungeonId: Int
    val xpBonus: Int
    val dropBonus: Int

    def serialize(buf: Buffer) {
      buf.writeInt(dungeonId)
      buf.writeInt(xpBonus)
      buf.writeInt(dropBonus)
    }

  }

  protected def create(dungeonId: Int, xpBonus: Int, dropBonus: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val dungeonId = buf.readInt()
    val xpBonus = buf.readInt()
    val dropBonus = buf.readInt()

    create(dungeonId, xpBonus, dropBonus)
  }

}

object ChallengeDungeonStackedBonusMessage extends ChallengeDungeonStackedBonusMessage {
  case class MessageImpl(dungeonId: Int, xpBonus: Int, dropBonus: Int) extends Message
  type Target = MessageImpl

  override def create(dungeonId: Int, xpBonus: Int, dropBonus: Int) = MessageImpl(dungeonId, xpBonus, dropBonus)

  def apply(dungeonId: Int, xpBonus: Int, dropBonus: Int) = create(dungeonId, xpBonus, dropBonus)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

