




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TaxCollectorListMessage extends MessageDeserializer {
  val messageId = 5930

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TaxCollectorListMessage.messageId

    val nbcollectorMax: Byte
    val taxCollectorHireCost: Short
    val informations: Seq[TaxCollectorInformations.TypeImpl]
    val fightersInformations: Seq[TaxCollectorFightersInformation.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeByte(nbcollectorMax)
      buf.writeShort(taxCollectorHireCost)
      buf.writeUShort(informations.length)
      for (entry <- informations) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
      buf.writeUShort(fightersInformations.length)
      for (entry <- fightersInformations) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(nbcollectorMax: Byte, taxCollectorHireCost: Short, informations: Seq[TaxCollectorInformations.TypeImpl], fightersInformations: Seq[TaxCollectorFightersInformation.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val nbcollectorMax = buf.readByte()
    val taxCollectorHireCost = buf.readShort()
    val informations = {
      val builder = collection.immutable.Seq.newBuilder[TaxCollectorInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[TaxCollectorInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val fightersInformations = {
      val builder = collection.immutable.Seq.newBuilder[TaxCollectorFightersInformation.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += TaxCollectorFightersInformation.deserialize(buf)
      }
      builder.result()
    }

    create(nbcollectorMax, taxCollectorHireCost, informations, fightersInformations)
  }

}

object TaxCollectorListMessage extends TaxCollectorListMessage {
  case class MessageImpl(nbcollectorMax: Byte, taxCollectorHireCost: Short, informations: Seq[TaxCollectorInformations.TypeImpl], fightersInformations: Seq[TaxCollectorFightersInformation.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(nbcollectorMax: Byte, taxCollectorHireCost: Short, informations: Seq[TaxCollectorInformations.TypeImpl], fightersInformations: Seq[TaxCollectorFightersInformation.TypeImpl]) = MessageImpl(nbcollectorMax, taxCollectorHireCost, informations, fightersInformations)

  def apply(nbcollectorMax: Byte, taxCollectorHireCost: Short, informations: Seq[TaxCollectorInformations.TypeImpl], fightersInformations: Seq[TaxCollectorFightersInformation.TypeImpl]) = create(nbcollectorMax, taxCollectorHireCost, informations, fightersInformations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

