




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait UpdateMountBoostMessage extends MessageDeserializer {
  val messageId = 6179

  protected trait Message extends BaseMessage with Serializable {
    val messageId = UpdateMountBoostMessage.messageId

    val rideId: Double
    val boostToUpdateList: Seq[UpdateMountBoost.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeDouble(rideId)
      buf.writeUShort(boostToUpdateList.length)
      for (entry <- boostToUpdateList) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(rideId: Double, boostToUpdateList: Seq[UpdateMountBoost.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val rideId = buf.readDouble()
    val boostToUpdateList = {
      val builder = collection.immutable.Seq.newBuilder[UpdateMountBoost.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[UpdateMountBoost.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(rideId, boostToUpdateList)
  }

}

object UpdateMountBoostMessage extends UpdateMountBoostMessage {
  case class MessageImpl(rideId: Double, boostToUpdateList: Seq[UpdateMountBoost.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(rideId: Double, boostToUpdateList: Seq[UpdateMountBoost.TypeImpl]) = MessageImpl(rideId, boostToUpdateList)

  def apply(rideId: Double, boostToUpdateList: Seq[UpdateMountBoost.TypeImpl]) = create(rideId, boostToUpdateList)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

