




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait IgnoredOnlineInformations extends IgnoredInformations {
  override val typeId = 105

  protected trait Type extends IgnoredInformations.Type with Serializable {
    override val typeId = IgnoredOnlineInformations.typeId

    val playerName: String
    val breed: Byte
    val sex: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(playerName)
      buf.writeByte(breed)
      buf.writeBoolean(sex)
    }

  }

  protected def create(accountId: Int, accountName: String, playerName: String, breed: Byte, sex: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val accountId = buf.readInt()
    val accountName = buf.readString()
    val playerName = buf.readString()
    val breed = buf.readByte()
    val sex = buf.readBoolean()

    create(accountId, accountName, playerName, breed, sex)
  }

}

object IgnoredOnlineInformations extends IgnoredOnlineInformations {
  case class TypeImpl(accountId: Int, accountName: String, playerName: String, breed: Byte, sex: Boolean) extends Type
  override def create(accountId: Int, accountName: String, playerName: String, breed: Byte, sex: Boolean) = TypeImpl(accountId, accountName, playerName, breed, sex)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(accountId: Int, accountName: String, playerName: String, breed: Byte, sex: Boolean) = create(accountId, accountName, playerName, breed, sex)

  type Target = TypeImpl

}

