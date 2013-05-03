




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GuildEmblem extends TypeDeserializer {
  val typeId = 87

  protected trait Type extends BaseType with Serializable {
    val typeId = GuildEmblem.typeId

    val symbolShape: Short
    val symbolColor: Int
    val backgroundShape: Short
    val backgroundColor: Int

    def serialize(buf: Buffer) {
      buf.writeShort(symbolShape)
      buf.writeInt(symbolColor)
      buf.writeShort(backgroundShape)
      buf.writeInt(backgroundColor)
    }

  }

  protected def create(symbolShape: Short, symbolColor: Int, backgroundShape: Short, backgroundColor: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val symbolShape = buf.readShort()
    val symbolColor = buf.readInt()
    val backgroundShape = buf.readShort()
    val backgroundColor = buf.readInt()

    create(symbolShape, symbolColor, backgroundShape, backgroundColor)
  }

}

object GuildEmblem extends GuildEmblem {
  case class TypeImpl(symbolShape: Short, symbolColor: Int, backgroundShape: Short, backgroundColor: Int) extends Type
  override def create(symbolShape: Short, symbolColor: Int, backgroundShape: Short, backgroundColor: Int) = TypeImpl(symbolShape, symbolColor, backgroundShape, backgroundColor)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(symbolShape: Short, symbolColor: Int, backgroundShape: Short, backgroundColor: Int) = create(symbolShape, symbolColor, backgroundShape, backgroundColor)

  type Target = TypeImpl

}

