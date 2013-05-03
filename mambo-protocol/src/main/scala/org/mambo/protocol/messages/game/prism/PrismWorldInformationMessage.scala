




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismWorldInformationMessage extends MessageDeserializer {
  val messageId = 5854

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismWorldInformationMessage.messageId

    val nbSubOwned: Int
    val subTotal: Int
    val maxSub: Int
    val subAreasInformation: Seq[PrismSubAreaInformation.TypeImpl]
    val nbConqsOwned: Int
    val conqsTotal: Int
    val conquetesInformation: Seq[VillageConquestPrismInformation.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(nbSubOwned)
      buf.writeInt(subTotal)
      buf.writeInt(maxSub)
      buf.writeUShort(subAreasInformation.length)
      for (entry <- subAreasInformation) {
        entry.serialize(buf)
      }
      buf.writeInt(nbConqsOwned)
      buf.writeInt(conqsTotal)
      buf.writeUShort(conquetesInformation.length)
      for (entry <- conquetesInformation) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(nbSubOwned: Int, subTotal: Int, maxSub: Int, subAreasInformation: Seq[PrismSubAreaInformation.TypeImpl], nbConqsOwned: Int, conqsTotal: Int, conquetesInformation: Seq[VillageConquestPrismInformation.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val nbSubOwned = buf.readInt()
    val subTotal = buf.readInt()
    val maxSub = buf.readInt()
    val subAreasInformation = {
      val builder = collection.immutable.Seq.newBuilder[PrismSubAreaInformation.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += PrismSubAreaInformation.deserialize(buf)
      }
      builder.result()
    }
    val nbConqsOwned = buf.readInt()
    val conqsTotal = buf.readInt()
    val conquetesInformation = {
      val builder = collection.immutable.Seq.newBuilder[VillageConquestPrismInformation.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += VillageConquestPrismInformation.deserialize(buf)
      }
      builder.result()
    }

    create(nbSubOwned, subTotal, maxSub, subAreasInformation, nbConqsOwned, conqsTotal, conquetesInformation)
  }

}

object PrismWorldInformationMessage extends PrismWorldInformationMessage {
  case class MessageImpl(nbSubOwned: Int, subTotal: Int, maxSub: Int, subAreasInformation: Seq[PrismSubAreaInformation.TypeImpl], nbConqsOwned: Int, conqsTotal: Int, conquetesInformation: Seq[VillageConquestPrismInformation.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(nbSubOwned: Int, subTotal: Int, maxSub: Int, subAreasInformation: Seq[PrismSubAreaInformation.TypeImpl], nbConqsOwned: Int, conqsTotal: Int, conquetesInformation: Seq[VillageConquestPrismInformation.TypeImpl]) = MessageImpl(nbSubOwned, subTotal, maxSub, subAreasInformation, nbConqsOwned, conqsTotal, conquetesInformation)

  def apply(nbSubOwned: Int, subTotal: Int, maxSub: Int, subAreasInformation: Seq[PrismSubAreaInformation.TypeImpl], nbConqsOwned: Int, conqsTotal: Int, conquetesInformation: Seq[VillageConquestPrismInformation.TypeImpl]) = create(nbSubOwned, subTotal, maxSub, subAreasInformation, nbConqsOwned, conqsTotal, conquetesInformation)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

