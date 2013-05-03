




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildInfosUpgradeMessage extends MessageDeserializer {
  val messageId = 5636

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildInfosUpgradeMessage.messageId

    val maxTaxCollectorsCount: Byte
    val taxCollectorsCount: Byte
    val taxCollectorLifePoints: Short
    val taxCollectorDamagesBonuses: Short
    val taxCollectorPods: Short
    val taxCollectorProspecting: Short
    val taxCollectorWisdom: Short
    val boostPoints: Short
    val spellId: Seq[Short]
    val spellLevel: Seq[Byte]

    def serialize(buf: Buffer) {
      buf.writeByte(maxTaxCollectorsCount)
      buf.writeByte(taxCollectorsCount)
      buf.writeShort(taxCollectorLifePoints)
      buf.writeShort(taxCollectorDamagesBonuses)
      buf.writeShort(taxCollectorPods)
      buf.writeShort(taxCollectorProspecting)
      buf.writeShort(taxCollectorWisdom)
      buf.writeShort(boostPoints)
      buf.writeUShort(spellId.length)
      for (entry <- spellId) {
        buf.writeShort(entry)
      }
      buf.writeUShort(spellLevel.length)
      for (entry <- spellLevel) {
        buf.writeByte(entry)
      }
    }

  }

  protected def create(maxTaxCollectorsCount: Byte, taxCollectorsCount: Byte, taxCollectorLifePoints: Short, taxCollectorDamagesBonuses: Short, taxCollectorPods: Short, taxCollectorProspecting: Short, taxCollectorWisdom: Short, boostPoints: Short, spellId: Seq[Short], spellLevel: Seq[Byte]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val maxTaxCollectorsCount = buf.readByte()
    val taxCollectorsCount = buf.readByte()
    val taxCollectorLifePoints = buf.readShort()
    val taxCollectorDamagesBonuses = buf.readShort()
    val taxCollectorPods = buf.readShort()
    val taxCollectorProspecting = buf.readShort()
    val taxCollectorWisdom = buf.readShort()
    val boostPoints = buf.readShort()
    val spellId = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val spellLevel = {
      val builder = collection.immutable.Seq.newBuilder[Byte]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readByte()
      }
      builder.result()
    }

    create(maxTaxCollectorsCount, taxCollectorsCount, taxCollectorLifePoints, taxCollectorDamagesBonuses, taxCollectorPods, taxCollectorProspecting, taxCollectorWisdom, boostPoints, spellId, spellLevel)
  }

}

object GuildInfosUpgradeMessage extends GuildInfosUpgradeMessage {
  case class MessageImpl(maxTaxCollectorsCount: Byte, taxCollectorsCount: Byte, taxCollectorLifePoints: Short, taxCollectorDamagesBonuses: Short, taxCollectorPods: Short, taxCollectorProspecting: Short, taxCollectorWisdom: Short, boostPoints: Short, spellId: Seq[Short], spellLevel: Seq[Byte]) extends Message
  type Target = MessageImpl

  override def create(maxTaxCollectorsCount: Byte, taxCollectorsCount: Byte, taxCollectorLifePoints: Short, taxCollectorDamagesBonuses: Short, taxCollectorPods: Short, taxCollectorProspecting: Short, taxCollectorWisdom: Short, boostPoints: Short, spellId: Seq[Short], spellLevel: Seq[Byte]) = MessageImpl(maxTaxCollectorsCount, taxCollectorsCount, taxCollectorLifePoints, taxCollectorDamagesBonuses, taxCollectorPods, taxCollectorProspecting, taxCollectorWisdom, boostPoints, spellId, spellLevel)

  def apply(maxTaxCollectorsCount: Byte, taxCollectorsCount: Byte, taxCollectorLifePoints: Short, taxCollectorDamagesBonuses: Short, taxCollectorPods: Short, taxCollectorProspecting: Short, taxCollectorWisdom: Short, boostPoints: Short, spellId: Seq[Short], spellLevel: Seq[Byte]) = create(maxTaxCollectorsCount, taxCollectorsCount, taxCollectorLifePoints, taxCollectorDamagesBonuses, taxCollectorPods, taxCollectorProspecting, taxCollectorWisdom, boostPoints, spellId, spellLevel)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

