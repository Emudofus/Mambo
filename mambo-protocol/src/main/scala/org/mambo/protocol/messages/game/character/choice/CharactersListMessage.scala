




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharactersListMessage extends MessageDeserializer {
  val messageId = 151

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharactersListMessage.messageId

    val hasStartupActions: Boolean
    val characters: Seq[CharacterBaseInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeBoolean(hasStartupActions)
      buf.writeUShort(characters.length)
      for (entry <- characters) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(hasStartupActions: Boolean, characters: Seq[CharacterBaseInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val hasStartupActions = buf.readBoolean()
    val characters = {
      val builder = collection.immutable.Seq.newBuilder[CharacterBaseInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[CharacterBaseInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(hasStartupActions, characters)
  }

}

object CharactersListMessage extends CharactersListMessage {
  case class MessageImpl(hasStartupActions: Boolean, characters: Seq[CharacterBaseInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(hasStartupActions: Boolean, characters: Seq[CharacterBaseInformations.TypeImpl]) = MessageImpl(hasStartupActions, characters)

  def apply(hasStartupActions: Boolean, characters: Seq[CharacterBaseInformations.TypeImpl]) = create(hasStartupActions, characters)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

