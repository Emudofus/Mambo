




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PartyGuestInformations extends TypeDeserializer {
  val typeId = 374

  protected trait Type extends BaseType with Serializable {
    val typeId = PartyGuestInformations.typeId

    val guestId: Int
    val hostId: Int
    val name: String
    val guestLook: EntityLook.TypeImpl
    val breed: Byte
    val sex: Boolean

    def serialize(buf: Buffer) {
      buf.writeInt(guestId)
      buf.writeInt(hostId)
      buf.writeString(name)
      guestLook.serialize(buf)
      buf.writeByte(breed)
      buf.writeBoolean(sex)
    }

  }

  protected def create(guestId: Int, hostId: Int, name: String, guestLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val guestId = buf.readInt()
    val hostId = buf.readInt()
    val name = buf.readString()
    val guestLook = EntityLook.deserialize(buf)
    val breed = buf.readByte()
    val sex = buf.readBoolean()

    create(guestId, hostId, name, guestLook, breed, sex)
  }

}

object PartyGuestInformations extends PartyGuestInformations {
  case class TypeImpl(guestId: Int, hostId: Int, name: String, guestLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean) extends Type
  override def create(guestId: Int, hostId: Int, name: String, guestLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean) = TypeImpl(guestId, hostId, name, guestLook, breed, sex)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(guestId: Int, hostId: Int, name: String, guestLook: EntityLook.TypeImpl, breed: Byte, sex: Boolean) = create(guestId, hostId, name, guestLook, breed, sex)

  type Target = TypeImpl

}

