




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseToSellListMessage extends MessageDeserializer {
  val messageId = 6140

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HouseToSellListMessage.messageId

    val pageIndex: Short
    val totalPage: Short
    val houseList: Seq[HouseInformationsForSell.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeShort(pageIndex)
      buf.writeShort(totalPage)
      buf.writeUShort(houseList.length)
      for (entry <- houseList) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(pageIndex: Short, totalPage: Short, houseList: Seq[HouseInformationsForSell.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val pageIndex = buf.readShort()
    val totalPage = buf.readShort()
    val houseList = {
      val builder = collection.immutable.Seq.newBuilder[HouseInformationsForSell.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += HouseInformationsForSell.deserialize(buf)
      }
      builder.result()
    }

    create(pageIndex, totalPage, houseList)
  }

}

object HouseToSellListMessage extends HouseToSellListMessage {
  case class MessageImpl(pageIndex: Short, totalPage: Short, houseList: Seq[HouseInformationsForSell.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(pageIndex: Short, totalPage: Short, houseList: Seq[HouseInformationsForSell.TypeImpl]) = MessageImpl(pageIndex, totalPage, houseList)

  def apply(pageIndex: Short, totalPage: Short, houseList: Seq[HouseInformationsForSell.TypeImpl]) = create(pageIndex, totalPage, houseList)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

