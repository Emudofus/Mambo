




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait QuestActiveInformations extends TypeDeserializer {
  val typeId = 381

  protected trait Type extends BaseType with Serializable {
    val typeId = QuestActiveInformations.typeId

    val questId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(questId)
    }

  }

  protected def create(questId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val questId = buf.readShort()

    create(questId)
  }

}

object QuestActiveInformations extends QuestActiveInformations {
  case class TypeImpl(questId: Short) extends Type
  override def create(questId: Short) = TypeImpl(questId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(questId: Short) = create(questId)

  type Target = TypeImpl

}

