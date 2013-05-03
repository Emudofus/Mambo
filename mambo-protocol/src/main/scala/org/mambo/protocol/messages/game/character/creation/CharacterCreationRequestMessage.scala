




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterCreationRequestMessage extends MessageDeserializer {
  val messageId = 160

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharacterCreationRequestMessage.messageId

    val name: String
    val breed: Byte
    val sex: Boolean
    val colors: Seq[Int]
    val cosmeticId: Int

    def serialize(buf: Buffer) {
      buf.writeString(name)
      buf.writeByte(breed)
      buf.writeBoolean(sex)
      buf.writeUShort(colors.length)
      for (entry <- colors) {
        buf.writeInt(entry)
      }
      buf.writeInt(cosmeticId)
    }

  }

  protected def create(name: String, breed: Byte, sex: Boolean, colors: Seq[Int], cosmeticId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val name = buf.readString()
    val breed = buf.readByte()
    val sex = buf.readBoolean()
    val colors = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val cosmeticId = buf.readInt()

    create(name, breed, sex, colors, cosmeticId)
  }

}

object CharacterCreationRequestMessage extends CharacterCreationRequestMessage {
  case class MessageImpl(name: String, breed: Byte, sex: Boolean, colors: Seq[Int], cosmeticId: Int) extends Message
  type Target = MessageImpl

  override def create(name: String, breed: Byte, sex: Boolean, colors: Seq[Int], cosmeticId: Int) = MessageImpl(name, breed, sex, colors, cosmeticId)

  def apply(name: String, breed: Byte, sex: Boolean, colors: Seq[Int], cosmeticId: Int) = create(name, breed, sex, colors, cosmeticId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

