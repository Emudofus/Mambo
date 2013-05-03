




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightPlacementPossiblePositionsMessage extends MessageDeserializer {
  val messageId = 703

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightPlacementPossiblePositionsMessage.messageId

    val positionsForChallengers: Seq[Short]
    val positionsForDefenders: Seq[Short]
    val teamNumber: Byte

    def serialize(buf: Buffer) {
      buf.writeUShort(positionsForChallengers.length)
      for (entry <- positionsForChallengers) {
        buf.writeShort(entry)
      }
      buf.writeUShort(positionsForDefenders.length)
      for (entry <- positionsForDefenders) {
        buf.writeShort(entry)
      }
      buf.writeByte(teamNumber)
    }

  }

  protected def create(positionsForChallengers: Seq[Short], positionsForDefenders: Seq[Short], teamNumber: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val positionsForChallengers = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val positionsForDefenders = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val teamNumber = buf.readByte()

    create(positionsForChallengers, positionsForDefenders, teamNumber)
  }

}

object GameFightPlacementPossiblePositionsMessage extends GameFightPlacementPossiblePositionsMessage {
  case class MessageImpl(positionsForChallengers: Seq[Short], positionsForDefenders: Seq[Short], teamNumber: Byte) extends Message
  type Target = MessageImpl

  override def create(positionsForChallengers: Seq[Short], positionsForDefenders: Seq[Short], teamNumber: Byte) = MessageImpl(positionsForChallengers, positionsForDefenders, teamNumber)

  def apply(positionsForChallengers: Seq[Short], positionsForDefenders: Seq[Short], teamNumber: Byte) = create(positionsForChallengers, positionsForDefenders, teamNumber)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

