




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AbstractContactInformations extends TypeDeserializer {
  val typeId = 380

  protected trait Type extends BaseType with Serializable {
    val typeId = AbstractContactInformations.typeId

    val accountId: Int
    val accountName: String

    def serialize(buf: Buffer) {
      buf.writeInt(accountId)
      buf.writeString(accountName)
    }

  }

  protected def create(accountId: Int, accountName: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val accountId = buf.readInt()
    val accountName = buf.readString()

    create(accountId, accountName)
  }

}

object AbstractContactInformations extends AbstractContactInformations {
  case class TypeImpl(accountId: Int, accountName: String) extends Type
  override def create(accountId: Int, accountName: String) = TypeImpl(accountId, accountName)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(accountId: Int, accountName: String) = create(accountId, accountName)

  type Target = TypeImpl

}

