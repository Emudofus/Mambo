




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait BasicLatencyStatsMessage extends MessageDeserializer {
  val messageId = 5663

  protected trait Message extends BaseMessage with Serializable {
    val messageId = BasicLatencyStatsMessage.messageId

    val latency: UShort
    val sampleCount: Short
    val max: Short

    def serialize(buf: Buffer) {
      buf.writeUShort(latency)
      buf.writeShort(sampleCount)
      buf.writeShort(max)
    }

  }

  protected def create(latency: UShort, sampleCount: Short, max: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val latency = buf.readUShort()
    val sampleCount = buf.readShort()
    val max = buf.readShort()

    create(latency, sampleCount, max)
  }

}

object BasicLatencyStatsMessage extends BasicLatencyStatsMessage {
  case class MessageImpl(latency: UShort, sampleCount: Short, max: Short) extends Message
  type Target = MessageImpl

  override def create(latency: UShort, sampleCount: Short, max: Short) = MessageImpl(latency, sampleCount, max)

  def apply(latency: UShort, sampleCount: Short, max: Short) = create(latency, sampleCount, max)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

