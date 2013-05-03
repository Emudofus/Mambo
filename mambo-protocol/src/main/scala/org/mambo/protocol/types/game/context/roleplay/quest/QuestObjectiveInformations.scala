




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait QuestObjectiveInformations extends TypeDeserializer {
  val typeId = 385

  protected trait Type extends BaseType with Serializable {
    val typeId = QuestObjectiveInformations.typeId

    val objectiveId: Short
    val objectiveStatus: Boolean

    def serialize(buf: Buffer) {
      buf.writeShort(objectiveId)
      buf.writeBoolean(objectiveStatus)
    }

  }

  protected def create(objectiveId: Short, objectiveStatus: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectiveId = buf.readShort()
    val objectiveStatus = buf.readBoolean()

    create(objectiveId, objectiveStatus)
  }

}

object QuestObjectiveInformations extends QuestObjectiveInformations {
  case class TypeImpl(objectiveId: Short, objectiveStatus: Boolean) extends Type
  override def create(objectiveId: Short, objectiveStatus: Boolean) = TypeImpl(objectiveId, objectiveStatus)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(objectiveId: Short, objectiveStatus: Boolean) = create(objectiveId, objectiveStatus)

  type Target = TypeImpl

}

