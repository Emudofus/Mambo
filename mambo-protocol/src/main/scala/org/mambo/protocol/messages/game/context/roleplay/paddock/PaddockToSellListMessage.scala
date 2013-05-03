




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PaddockToSellListMessage extends MessageDeserializer {
  val messageId = 6138

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PaddockToSellListMessage.messageId

    val pageIndex: Short
    val totalPage: Short
    val paddockList: Seq[PaddockInformationsForSell.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeShort(pageIndex)
      buf.writeShort(totalPage)
      buf.writeUShort(paddockList.length)
      for (entry <- paddockList) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(pageIndex: Short, totalPage: Short, paddockList: Seq[PaddockInformationsForSell.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val pageIndex = buf.readShort()
    val totalPage = buf.readShort()
    val paddockList = {
      val builder = collection.immutable.Seq.newBuilder[PaddockInformationsForSell.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += PaddockInformationsForSell.deserialize(buf)
      }
      builder.result()
    }

    create(pageIndex, totalPage, paddockList)
  }

}

object PaddockToSellListMessage extends PaddockToSellListMessage {
  case class MessageImpl(pageIndex: Short, totalPage: Short, paddockList: Seq[PaddockInformationsForSell.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(pageIndex: Short, totalPage: Short, paddockList: Seq[PaddockInformationsForSell.TypeImpl]) = MessageImpl(pageIndex, totalPage, paddockList)

  def apply(pageIndex: Short, totalPage: Short, paddockList: Seq[PaddockInformationsForSell.TypeImpl]) = create(pageIndex, totalPage, paddockList)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

