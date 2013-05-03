




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait BasicGuildInformations extends TypeDeserializer {
  val typeId = 365

  protected trait Type extends BaseType with Serializable {
    val typeId = BasicGuildInformations.typeId

    val guildId: Int
    val guildName: String

    def serialize(buf: Buffer) {
      buf.writeInt(guildId)
      buf.writeString(guildName)
    }

  }

  protected def create(guildId: Int, guildName: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val guildId = buf.readInt()
    val guildName = buf.readString()

    create(guildId, guildName)
  }

}

object BasicGuildInformations extends BasicGuildInformations {
  case class TypeImpl(guildId: Int, guildName: String) extends Type
  override def create(guildId: Int, guildName: String) = TypeImpl(guildId, guildName)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(guildId: Int, guildName: String) = create(guildId, guildName)

  type Target = TypeImpl

}

