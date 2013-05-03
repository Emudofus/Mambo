




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait StartupActionAddObject extends TypeDeserializer {
  val typeId = 52

  protected trait Type extends BaseType with Serializable {
    val typeId = StartupActionAddObject.typeId

    val uid: Int
    val title: String
    val text: String
    val descUrl: String
    val pictureUrl: String
    val items: Seq[ObjectItemInformationWithQuantity.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(uid)
      buf.writeString(title)
      buf.writeString(text)
      buf.writeString(descUrl)
      buf.writeString(pictureUrl)
      buf.writeUShort(items.length)
      for (entry <- items) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(uid: Int, title: String, text: String, descUrl: String, pictureUrl: String, items: Seq[ObjectItemInformationWithQuantity.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val uid = buf.readInt()
    val title = buf.readString()
    val text = buf.readString()
    val descUrl = buf.readString()
    val pictureUrl = buf.readString()
    val items = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItemInformationWithQuantity.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItemInformationWithQuantity.deserialize(buf)
      }
      builder.result()
    }

    create(uid, title, text, descUrl, pictureUrl, items)
  }

}

object StartupActionAddObject extends StartupActionAddObject {
  case class TypeImpl(uid: Int, title: String, text: String, descUrl: String, pictureUrl: String, items: Seq[ObjectItemInformationWithQuantity.TypeImpl]) extends Type
  override def create(uid: Int, title: String, text: String, descUrl: String, pictureUrl: String, items: Seq[ObjectItemInformationWithQuantity.TypeImpl]) = TypeImpl(uid, title, text, descUrl, pictureUrl, items)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(uid: Int, title: String, text: String, descUrl: String, pictureUrl: String, items: Seq[ObjectItemInformationWithQuantity.TypeImpl]) = create(uid, title, text, descUrl, pictureUrl, items)

  type Target = TypeImpl

}

