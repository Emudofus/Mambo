




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TaxCollectorDialogQuestionExtendedMessage extends TaxCollectorDialogQuestionBasicMessage {
  override val messageId = 5615

  protected trait Message extends TaxCollectorDialogQuestionBasicMessage.Message with Serializable {
    override val messageId = TaxCollectorDialogQuestionExtendedMessage.messageId

    val maxPods: Short
    val prospecting: Short
    val wisdom: Short
    val taxCollectorsCount: Byte
    val taxCollectorAttack: Int
    val kamas: Int
    val experience: Double
    val pods: Int
    val itemsValue: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(maxPods)
      buf.writeShort(prospecting)
      buf.writeShort(wisdom)
      buf.writeByte(taxCollectorsCount)
      buf.writeInt(taxCollectorAttack)
      buf.writeInt(kamas)
      buf.writeDouble(experience)
      buf.writeInt(pods)
      buf.writeInt(itemsValue)
    }

  }

  protected def create(guildInfo: BasicGuildInformations.TypeImpl, maxPods: Short, prospecting: Short, wisdom: Short, taxCollectorsCount: Byte, taxCollectorAttack: Int, kamas: Int, experience: Double, pods: Int, itemsValue: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val guildInfo = BasicGuildInformations.deserialize(buf)
    val maxPods = buf.readShort()
    val prospecting = buf.readShort()
    val wisdom = buf.readShort()
    val taxCollectorsCount = buf.readByte()
    val taxCollectorAttack = buf.readInt()
    val kamas = buf.readInt()
    val experience = buf.readDouble()
    val pods = buf.readInt()
    val itemsValue = buf.readInt()

    create(guildInfo, maxPods, prospecting, wisdom, taxCollectorsCount, taxCollectorAttack, kamas, experience, pods, itemsValue)
  }

}

object TaxCollectorDialogQuestionExtendedMessage extends TaxCollectorDialogQuestionExtendedMessage {
  case class MessageImpl(guildInfo: BasicGuildInformations.TypeImpl, maxPods: Short, prospecting: Short, wisdom: Short, taxCollectorsCount: Byte, taxCollectorAttack: Int, kamas: Int, experience: Double, pods: Int, itemsValue: Int) extends Message
  type Target = MessageImpl

  override def create(guildInfo: BasicGuildInformations.TypeImpl, maxPods: Short, prospecting: Short, wisdom: Short, taxCollectorsCount: Byte, taxCollectorAttack: Int, kamas: Int, experience: Double, pods: Int, itemsValue: Int) = MessageImpl(guildInfo, maxPods, prospecting, wisdom, taxCollectorsCount, taxCollectorAttack, kamas, experience, pods, itemsValue)

  def apply(guildInfo: BasicGuildInformations.TypeImpl, maxPods: Short, prospecting: Short, wisdom: Short, taxCollectorsCount: Byte, taxCollectorAttack: Int, kamas: Int, experience: Double, pods: Int, itemsValue: Int) = create(guildInfo, maxPods, prospecting, wisdom, taxCollectorsCount, taxCollectorAttack, kamas, experience, pods, itemsValue)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

