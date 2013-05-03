




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AdditionalTaxCollectorInformations extends TypeDeserializer {
  val typeId = 165

  protected trait Type extends BaseType with Serializable {
    val typeId = AdditionalTaxCollectorInformations.typeId

    val collectorCallerName: String
    val date: Int

    def serialize(buf: Buffer) {
      buf.writeString(collectorCallerName)
      buf.writeInt(date)
    }

  }

  protected def create(collectorCallerName: String, date: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val collectorCallerName = buf.readString()
    val date = buf.readInt()

    create(collectorCallerName, date)
  }

}

object AdditionalTaxCollectorInformations extends AdditionalTaxCollectorInformations {
  case class TypeImpl(collectorCallerName: String, date: Int) extends Type
  override def create(collectorCallerName: String, date: Int) = TypeImpl(collectorCallerName, date)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(collectorCallerName: String, date: Int) = create(collectorCallerName, date)

  type Target = TypeImpl

}

