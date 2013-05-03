




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobCrafterDirectoryEntryMessage extends MessageDeserializer {
  val messageId = 6044

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobCrafterDirectoryEntryMessage.messageId

    val playerInfo: JobCrafterDirectoryEntryPlayerInfo.TypeImpl
    val jobInfoList: Seq[JobCrafterDirectoryEntryJobInfo.TypeImpl]
    val playerLook: EntityLook.TypeImpl

    def serialize(buf: Buffer) {
      playerInfo.serialize(buf)
      buf.writeUShort(jobInfoList.length)
      for (entry <- jobInfoList) {
        entry.serialize(buf)
      }
      playerLook.serialize(buf)
    }

  }

  protected def create(playerInfo: JobCrafterDirectoryEntryPlayerInfo.TypeImpl, jobInfoList: Seq[JobCrafterDirectoryEntryJobInfo.TypeImpl], playerLook: EntityLook.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val playerInfo = JobCrafterDirectoryEntryPlayerInfo.deserialize(buf)
    val jobInfoList = {
      val builder = collection.immutable.Seq.newBuilder[JobCrafterDirectoryEntryJobInfo.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += JobCrafterDirectoryEntryJobInfo.deserialize(buf)
      }
      builder.result()
    }
    val playerLook = EntityLook.deserialize(buf)

    create(playerInfo, jobInfoList, playerLook)
  }

}

object JobCrafterDirectoryEntryMessage extends JobCrafterDirectoryEntryMessage {
  case class MessageImpl(playerInfo: JobCrafterDirectoryEntryPlayerInfo.TypeImpl, jobInfoList: Seq[JobCrafterDirectoryEntryJobInfo.TypeImpl], playerLook: EntityLook.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(playerInfo: JobCrafterDirectoryEntryPlayerInfo.TypeImpl, jobInfoList: Seq[JobCrafterDirectoryEntryJobInfo.TypeImpl], playerLook: EntityLook.TypeImpl) = MessageImpl(playerInfo, jobInfoList, playerLook)

  def apply(playerInfo: JobCrafterDirectoryEntryPlayerInfo.TypeImpl, jobInfoList: Seq[JobCrafterDirectoryEntryJobInfo.TypeImpl], playerLook: EntityLook.TypeImpl) = create(playerInfo, jobInfoList, playerLook)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

