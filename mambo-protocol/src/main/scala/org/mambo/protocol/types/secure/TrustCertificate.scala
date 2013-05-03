




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait TrustCertificate extends TypeDeserializer {
  val typeId = 377

  protected trait Type extends BaseType with Serializable {
    val typeId = TrustCertificate.typeId

    val id: Int
    val hash: String

    def serialize(buf: Buffer) {
      buf.writeInt(id)
      buf.writeString(hash)
    }

  }

  protected def create(id: Int, hash: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val hash = buf.readString()

    create(id, hash)
  }

}

object TrustCertificate extends TrustCertificate {
  case class TypeImpl(id: Int, hash: String) extends Type
  override def create(id: Int, hash: String) = TypeImpl(id, hash)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Int, hash: String) = create(id, hash)

  type Target = TypeImpl

}

