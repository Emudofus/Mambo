




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait MountInformationsForPaddock extends TypeDeserializer {
  val typeId = 184

  protected trait Type extends BaseType with Serializable {
    val typeId = MountInformationsForPaddock.typeId

    val modelId: Int
    val name: String
    val ownerName: String

    def serialize(buf: Buffer) {
      buf.writeInt(modelId)
      buf.writeString(name)
      buf.writeString(ownerName)
    }

  }

  protected def create(modelId: Int, name: String, ownerName: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val modelId = buf.readInt()
    val name = buf.readString()
    val ownerName = buf.readString()

    create(modelId, name, ownerName)
  }

}

object MountInformationsForPaddock extends MountInformationsForPaddock {
  case class TypeImpl(modelId: Int, name: String, ownerName: String) extends Type
  override def create(modelId: Int, name: String, ownerName: String) = TypeImpl(modelId, name, ownerName)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(modelId: Int, name: String, ownerName: String) = create(modelId, name, ownerName)

  type Target = TypeImpl

}

