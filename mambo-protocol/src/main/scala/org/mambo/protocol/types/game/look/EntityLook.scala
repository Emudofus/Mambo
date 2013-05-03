




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait EntityLook extends TypeDeserializer {
  val typeId = 55

  protected trait Type extends BaseType with Serializable {
    val typeId = EntityLook.typeId

    val bonesId: Short
    val skins: Seq[Short]
    val indexedColors: Seq[Int]
    val scales: Seq[Short]
    val subentities: Seq[SubEntity.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeShort(bonesId)
      buf.writeUShort(skins.length)
      for (entry <- skins) {
        buf.writeShort(entry)
      }
      buf.writeUShort(indexedColors.length)
      for (entry <- indexedColors) {
        buf.writeInt(entry)
      }
      buf.writeUShort(scales.length)
      for (entry <- scales) {
        buf.writeShort(entry)
      }
      buf.writeUShort(subentities.length)
      for (entry <- subentities) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(bonesId: Short, skins: Seq[Short], indexedColors: Seq[Int], scales: Seq[Short], subentities: Seq[SubEntity.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val bonesId = buf.readShort()
    val skins = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val indexedColors = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val scales = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val subentities = {
      val builder = collection.immutable.Seq.newBuilder[SubEntity.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += SubEntity.deserialize(buf)
      }
      builder.result()
    }

    create(bonesId, skins, indexedColors, scales, subentities)
  }

}

object EntityLook extends EntityLook {
  case class TypeImpl(bonesId: Short, skins: Seq[Short], indexedColors: Seq[Int], scales: Seq[Short], subentities: Seq[SubEntity.TypeImpl]) extends Type
  override def create(bonesId: Short, skins: Seq[Short], indexedColors: Seq[Int], scales: Seq[Short], subentities: Seq[SubEntity.TypeImpl]) = TypeImpl(bonesId, skins, indexedColors, scales, subentities)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(bonesId: Short, skins: Seq[Short], indexedColors: Seq[Int], scales: Seq[Short], subentities: Seq[SubEntity.TypeImpl]) = create(bonesId, skins, indexedColors, scales, subentities)

  type Target = TypeImpl

}

