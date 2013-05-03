




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartOkTaxCollectorMessage extends MessageDeserializer {
  val messageId = 5780

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartOkTaxCollectorMessage.messageId

    val collectorId: Int
    val objectsInfos: Seq[ObjectItem.TypeImpl]
    val goldInfo: Int

    def serialize(buf: Buffer) {
      buf.writeInt(collectorId)
      buf.writeUShort(objectsInfos.length)
      for (entry <- objectsInfos) {
        entry.serialize(buf)
      }
      buf.writeInt(goldInfo)
    }

  }

  protected def create(collectorId: Int, objectsInfos: Seq[ObjectItem.TypeImpl], goldInfo: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val collectorId = buf.readInt()
    val objectsInfos = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItem.deserialize(buf)
      }
      builder.result()
    }
    val goldInfo = buf.readInt()

    create(collectorId, objectsInfos, goldInfo)
  }

}

object ExchangeStartOkTaxCollectorMessage extends ExchangeStartOkTaxCollectorMessage {
  case class MessageImpl(collectorId: Int, objectsInfos: Seq[ObjectItem.TypeImpl], goldInfo: Int) extends Message
  type Target = MessageImpl

  override def create(collectorId: Int, objectsInfos: Seq[ObjectItem.TypeImpl], goldInfo: Int) = MessageImpl(collectorId, objectsInfos, goldInfo)

  def apply(collectorId: Int, objectsInfos: Seq[ObjectItem.TypeImpl], goldInfo: Int) = create(collectorId, objectsInfos, goldInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

