




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharactersListWithModificationsMessage extends CharactersListMessage {
  override val messageId = 6120

  protected trait Message extends CharactersListMessage.Message with Serializable {
    override val messageId = CharactersListWithModificationsMessage.messageId

    val charactersToRecolor: Seq[CharacterToRecolorInformation.TypeImpl]
    val charactersToRename: Seq[Int]
    val unusableCharacters: Seq[Int]
    val charactersToRelook: Seq[CharacterToRelookInformation.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(charactersToRecolor.length)
      for (entry <- charactersToRecolor) {
        entry.serialize(buf)
      }
      buf.writeUShort(charactersToRename.length)
      for (entry <- charactersToRename) {
        buf.writeInt(entry)
      }
      buf.writeUShort(unusableCharacters.length)
      for (entry <- unusableCharacters) {
        buf.writeInt(entry)
      }
      buf.writeUShort(charactersToRelook.length)
      for (entry <- charactersToRelook) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(hasStartupActions: Boolean, characters: Seq[CharacterBaseInformations.TypeImpl], charactersToRecolor: Seq[CharacterToRecolorInformation.TypeImpl], charactersToRename: Seq[Int], unusableCharacters: Seq[Int], charactersToRelook: Seq[CharacterToRelookInformation.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val hasStartupActions = buf.readBoolean()
    val characters = {
      val builder = collection.immutable.Seq.newBuilder[CharacterBaseInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[CharacterBaseInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val charactersToRecolor = {
      val builder = collection.immutable.Seq.newBuilder[CharacterToRecolorInformation.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += CharacterToRecolorInformation.deserialize(buf)
      }
      builder.result()
    }
    val charactersToRename = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val unusableCharacters = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val charactersToRelook = {
      val builder = collection.immutable.Seq.newBuilder[CharacterToRelookInformation.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += CharacterToRelookInformation.deserialize(buf)
      }
      builder.result()
    }

    create(hasStartupActions, characters, charactersToRecolor, charactersToRename, unusableCharacters, charactersToRelook)
  }

}

object CharactersListWithModificationsMessage extends CharactersListWithModificationsMessage {
  case class MessageImpl(hasStartupActions: Boolean, characters: Seq[CharacterBaseInformations.TypeImpl], charactersToRecolor: Seq[CharacterToRecolorInformation.TypeImpl], charactersToRename: Seq[Int], unusableCharacters: Seq[Int], charactersToRelook: Seq[CharacterToRelookInformation.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(hasStartupActions: Boolean, characters: Seq[CharacterBaseInformations.TypeImpl], charactersToRecolor: Seq[CharacterToRecolorInformation.TypeImpl], charactersToRename: Seq[Int], unusableCharacters: Seq[Int], charactersToRelook: Seq[CharacterToRelookInformation.TypeImpl]) = MessageImpl(hasStartupActions, characters, charactersToRecolor, charactersToRename, unusableCharacters, charactersToRelook)

  def apply(hasStartupActions: Boolean, characters: Seq[CharacterBaseInformations.TypeImpl], charactersToRecolor: Seq[CharacterToRecolorInformation.TypeImpl], charactersToRename: Seq[Int], unusableCharacters: Seq[Int], charactersToRelook: Seq[CharacterToRelookInformation.TypeImpl]) = create(hasStartupActions, characters, charactersToRecolor, charactersToRename, unusableCharacters, charactersToRelook)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

