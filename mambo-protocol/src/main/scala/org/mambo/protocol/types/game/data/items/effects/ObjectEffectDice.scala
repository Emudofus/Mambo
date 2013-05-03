




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectEffectDice extends ObjectEffect {
  override val typeId = 73

  protected trait Type extends ObjectEffect.Type with Serializable {
    override val typeId = ObjectEffectDice.typeId

    val diceNum: Short
    val diceSide: Short
    val diceConst: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(diceNum)
      buf.writeShort(diceSide)
      buf.writeShort(diceConst)
    }

  }

  protected def create(actionId: Short, diceNum: Short, diceSide: Short, diceConst: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val diceNum = buf.readShort()
    val diceSide = buf.readShort()
    val diceConst = buf.readShort()

    create(actionId, diceNum, diceSide, diceConst)
  }

}

object ObjectEffectDice extends ObjectEffectDice {
  case class TypeImpl(actionId: Short, diceNum: Short, diceSide: Short, diceConst: Short) extends Type
  override def create(actionId: Short, diceNum: Short, diceSide: Short, diceConst: Short) = TypeImpl(actionId, diceNum, diceSide, diceConst)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short, diceNum: Short, diceSide: Short, diceConst: Short) = create(actionId, diceNum, diceSide, diceConst)

  type Target = TypeImpl

}

