




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectItemToSellInNpcShop extends ObjectItemMinimalInformation {
  override val typeId = 352

  protected trait Type extends ObjectItemMinimalInformation.Type with Serializable {
    override val typeId = ObjectItemToSellInNpcShop.typeId

    val objectPrice: Int
    val buyCriterion: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(objectPrice)
      buf.writeString(buyCriterion)
    }

  }

  protected def create(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectPrice: Int, buyCriterion: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val objectGID = buf.readShort()
    val powerRate = buf.readShort()
    val overMax = buf.readBoolean()
    val effects = {
      val builder = collection.immutable.Seq.newBuilder[ObjectEffect.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[ObjectEffect.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val objectPrice = buf.readInt()
    val buyCriterion = buf.readString()

    create(objectGID, powerRate, overMax, effects, objectPrice, buyCriterion)
  }

}

object ObjectItemToSellInNpcShop extends ObjectItemToSellInNpcShop {
  case class TypeImpl(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectPrice: Int, buyCriterion: String) extends Type
  override def create(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectPrice: Int, buyCriterion: String) = TypeImpl(objectGID, powerRate, overMax, effects, objectPrice, buyCriterion)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectPrice: Int, buyCriterion: String) = create(objectGID, powerRate, overMax, effects, objectPrice, buyCriterion)

  type Target = TypeImpl

}

