




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AchievementRewardable extends TypeDeserializer {
  val typeId = 412

  protected trait Type extends BaseType with Serializable {
    val typeId = AchievementRewardable.typeId

    val id: Short
    val finishedlevel: Short

    def serialize(buf: Buffer) {
      buf.writeShort(id)
      buf.writeShort(finishedlevel)
    }

  }

  protected def create(id: Short, finishedlevel: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readShort()
    val finishedlevel = buf.readShort()

    create(id, finishedlevel)
  }

}

object AchievementRewardable extends AchievementRewardable {
  case class TypeImpl(id: Short, finishedlevel: Short) extends Type
  override def create(id: Short, finishedlevel: Short) = TypeImpl(id, finishedlevel)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Short, finishedlevel: Short) = create(id, finishedlevel)

  type Target = TypeImpl

}

