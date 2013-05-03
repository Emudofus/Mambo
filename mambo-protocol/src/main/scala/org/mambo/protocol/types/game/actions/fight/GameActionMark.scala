




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameActionMark extends TypeDeserializer {
  val typeId = 351

  protected trait Type extends BaseType with Serializable {
    val typeId = GameActionMark.typeId

    val markAuthorId: Int
    val markSpellId: Int
    val markId: Short
    val markType: Byte
    val cells: Seq[GameActionMarkedCell.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(markAuthorId)
      buf.writeInt(markSpellId)
      buf.writeShort(markId)
      buf.writeByte(markType)
      buf.writeUShort(cells.length)
      for (entry <- cells) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(markAuthorId: Int, markSpellId: Int, markId: Short, markType: Byte, cells: Seq[GameActionMarkedCell.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val markAuthorId = buf.readInt()
    val markSpellId = buf.readInt()
    val markId = buf.readShort()
    val markType = buf.readByte()
    val cells = {
      val builder = collection.immutable.Seq.newBuilder[GameActionMarkedCell.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += GameActionMarkedCell.deserialize(buf)
      }
      builder.result()
    }

    create(markAuthorId, markSpellId, markId, markType, cells)
  }

}

object GameActionMark extends GameActionMark {
  case class TypeImpl(markAuthorId: Int, markSpellId: Int, markId: Short, markType: Byte, cells: Seq[GameActionMarkedCell.TypeImpl]) extends Type
  override def create(markAuthorId: Int, markSpellId: Int, markId: Short, markType: Byte, cells: Seq[GameActionMarkedCell.TypeImpl]) = TypeImpl(markAuthorId, markSpellId, markId, markType, cells)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(markAuthorId: Int, markSpellId: Int, markId: Short, markType: Byte, cells: Seq[GameActionMarkedCell.TypeImpl]) = create(markAuthorId, markSpellId, markId, markType, cells)

  type Target = TypeImpl

}

