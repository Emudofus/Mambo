




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait SellerBuyerDescriptor extends TypeDeserializer {
  val typeId = 121

  protected trait Type extends BaseType with Serializable {
    val typeId = SellerBuyerDescriptor.typeId

    val quantities: Seq[Int]
    val types: Seq[Int]
    val taxPercentage: Float
    val maxItemLevel: Int
    val maxItemPerAccount: Int
    val npcContextualId: Int
    val unsoldDelay: Short

    def serialize(buf: Buffer) {
      buf.writeUShort(quantities.length)
      for (entry <- quantities) {
        buf.writeInt(entry)
      }
      buf.writeUShort(types.length)
      for (entry <- types) {
        buf.writeInt(entry)
      }
      buf.writeFloat(taxPercentage)
      buf.writeInt(maxItemLevel)
      buf.writeInt(maxItemPerAccount)
      buf.writeInt(npcContextualId)
      buf.writeShort(unsoldDelay)
    }

  }

  protected def create(quantities: Seq[Int], types: Seq[Int], taxPercentage: Float, maxItemLevel: Int, maxItemPerAccount: Int, npcContextualId: Int, unsoldDelay: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val quantities = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val types = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val taxPercentage = buf.readFloat()
    val maxItemLevel = buf.readInt()
    val maxItemPerAccount = buf.readInt()
    val npcContextualId = buf.readInt()
    val unsoldDelay = buf.readShort()

    create(quantities, types, taxPercentage, maxItemLevel, maxItemPerAccount, npcContextualId, unsoldDelay)
  }

}

object SellerBuyerDescriptor extends SellerBuyerDescriptor {
  case class TypeImpl(quantities: Seq[Int], types: Seq[Int], taxPercentage: Float, maxItemLevel: Int, maxItemPerAccount: Int, npcContextualId: Int, unsoldDelay: Short) extends Type
  override def create(quantities: Seq[Int], types: Seq[Int], taxPercentage: Float, maxItemLevel: Int, maxItemPerAccount: Int, npcContextualId: Int, unsoldDelay: Short) = TypeImpl(quantities, types, taxPercentage, maxItemLevel, maxItemPerAccount, npcContextualId, unsoldDelay)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(quantities: Seq[Int], types: Seq[Int], taxPercentage: Float, maxItemLevel: Int, maxItemPerAccount: Int, npcContextualId: Int, unsoldDelay: Short) = create(quantities, types, taxPercentage, maxItemLevel, maxItemPerAccount, npcContextualId, unsoldDelay)

  type Target = TypeImpl

}

