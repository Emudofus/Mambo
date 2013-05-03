




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SetUpdateMessage extends MessageDeserializer {
  val messageId = 5503

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SetUpdateMessage.messageId

    val setId: Short
    val setObjects: Seq[Short]
    val setEffects: Seq[ObjectEffect.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeShort(setId)
      buf.writeUShort(setObjects.length)
      for (entry <- setObjects) {
        buf.writeShort(entry)
      }
      buf.writeUShort(setEffects.length)
      for (entry <- setEffects) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(setId: Short, setObjects: Seq[Short], setEffects: Seq[ObjectEffect.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val setId = buf.readShort()
    val setObjects = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val setEffects = {
      val builder = collection.immutable.Seq.newBuilder[ObjectEffect.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[ObjectEffect.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(setId, setObjects, setEffects)
  }

}

object SetUpdateMessage extends SetUpdateMessage {
  case class MessageImpl(setId: Short, setObjects: Seq[Short], setEffects: Seq[ObjectEffect.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(setId: Short, setObjects: Seq[Short], setEffects: Seq[ObjectEffect.TypeImpl]) = MessageImpl(setId, setObjects, setEffects)

  def apply(setId: Short, setObjects: Seq[Short], setEffects: Seq[ObjectEffect.TypeImpl]) = create(setId, setObjects, setEffects)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

