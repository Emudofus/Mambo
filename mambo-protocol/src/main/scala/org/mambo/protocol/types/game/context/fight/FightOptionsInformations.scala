




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightOptionsInformations extends TypeDeserializer {
  val typeId = 20

  protected trait Type extends BaseType with Serializable {
    val typeId = FightOptionsInformations.typeId

    val isSecret: Boolean
    val isRestrictedToPartyOnly: Boolean
    val isClosed: Boolean
    val isAskingForHelp: Boolean

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, isSecret)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, isRestrictedToPartyOnly)
      flag1 = BooleanByteWrapper.setFlag(flag1, 2, isClosed)
      flag1 = BooleanByteWrapper.setFlag(flag1, 3, isAskingForHelp)
      buf.writeUByte(flag1.toShort)
    }

  }

  protected def create(isSecret: Boolean, isRestrictedToPartyOnly: Boolean, isClosed: Boolean, isAskingForHelp: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val isSecret = BooleanByteWrapper.getFlag(flag1, 0)
    val isRestrictedToPartyOnly = BooleanByteWrapper.getFlag(flag1, 1)
    val isClosed = BooleanByteWrapper.getFlag(flag1, 2)
    val isAskingForHelp = BooleanByteWrapper.getFlag(flag1, 3)

    create(isSecret, isRestrictedToPartyOnly, isClosed, isAskingForHelp)
  }

}

object FightOptionsInformations extends FightOptionsInformations {
  case class TypeImpl(isSecret: Boolean, isRestrictedToPartyOnly: Boolean, isClosed: Boolean, isAskingForHelp: Boolean) extends Type
  override def create(isSecret: Boolean, isRestrictedToPartyOnly: Boolean, isClosed: Boolean, isAskingForHelp: Boolean) = TypeImpl(isSecret, isRestrictedToPartyOnly, isClosed, isAskingForHelp)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(isSecret: Boolean, isRestrictedToPartyOnly: Boolean, isClosed: Boolean, isAskingForHelp: Boolean) = create(isSecret, isRestrictedToPartyOnly, isClosed, isAskingForHelp)

  type Target = TypeImpl

}

