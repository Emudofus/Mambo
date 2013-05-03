




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait MapObstacle extends TypeDeserializer {
  val typeId = 200

  protected trait Type extends BaseType with Serializable {
    val typeId = MapObstacle.typeId

    val obstacleCellId: Short
    val state: Byte

    def serialize(buf: Buffer) {
      buf.writeShort(obstacleCellId)
      buf.writeByte(state)
    }

  }

  protected def create(obstacleCellId: Short, state: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val obstacleCellId = buf.readShort()
    val state = buf.readByte()

    create(obstacleCellId, state)
  }

}

object MapObstacle extends MapObstacle {
  case class TypeImpl(obstacleCellId: Short, state: Byte) extends Type
  override def create(obstacleCellId: Short, state: Byte) = TypeImpl(obstacleCellId, state)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(obstacleCellId: Short, state: Byte) = create(obstacleCellId, state)

  type Target = TypeImpl

}

