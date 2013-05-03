




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait IgnoredInformations extends AbstractContactInformations {
  override val typeId = 106

  protected trait Type extends AbstractContactInformations.Type with Serializable {
    override val typeId = IgnoredInformations.typeId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val accountId = buf.readInt()
    val accountName = buf.readString()

    create(accountId, accountName)
  }

}

object IgnoredInformations extends IgnoredInformations {
  case class TypeImpl(accountId: Int, accountName: String) extends Type
  override def create(accountId: Int, accountName: String) = TypeImpl(accountId, accountName)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(accountId: Int, accountName: String) = create(accountId, accountName)

  type Target = TypeImpl

}

