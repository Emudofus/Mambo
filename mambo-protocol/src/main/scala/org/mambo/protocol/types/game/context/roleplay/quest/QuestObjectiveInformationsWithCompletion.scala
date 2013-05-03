




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait QuestObjectiveInformationsWithCompletion extends QuestObjectiveInformations {
  override val typeId = 386

  protected trait Type extends QuestObjectiveInformations.Type with Serializable {
    override val typeId = QuestObjectiveInformationsWithCompletion.typeId

    val curCompletion: Short
    val maxCompletion: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(curCompletion)
      buf.writeShort(maxCompletion)
    }

  }

  protected def create(objectiveId: Short, objectiveStatus: Boolean, curCompletion: Short, maxCompletion: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val objectiveId = buf.readShort()
    val objectiveStatus = buf.readBoolean()
    val curCompletion = buf.readShort()
    val maxCompletion = buf.readShort()

    create(objectiveId, objectiveStatus, curCompletion, maxCompletion)
  }

}

object QuestObjectiveInformationsWithCompletion extends QuestObjectiveInformationsWithCompletion {
  case class TypeImpl(objectiveId: Short, objectiveStatus: Boolean, curCompletion: Short, maxCompletion: Short) extends Type
  override def create(objectiveId: Short, objectiveStatus: Boolean, curCompletion: Short, maxCompletion: Short) = TypeImpl(objectiveId, objectiveStatus, curCompletion, maxCompletion)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(objectiveId: Short, objectiveStatus: Boolean, curCompletion: Short, maxCompletion: Short) = create(objectiveId, objectiveStatus, curCompletion, maxCompletion)

  type Target = TypeImpl

}

