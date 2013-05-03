




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ActorRestrictionsInformations extends TypeDeserializer {
  val typeId = 204

  protected trait Type extends BaseType with Serializable {
    val typeId = ActorRestrictionsInformations.typeId

    val cantBeAggressed: Boolean
    val cantBeChallenged: Boolean
    val cantTrade: Boolean
    val cantBeAttackedByMutant: Boolean
    val cantRun: Boolean
    val forceSlowWalk: Boolean
    val cantMinimize: Boolean
    val cantMove: Boolean
    val cantAggress: Boolean
    val cantChallenge: Boolean
    val cantExchange: Boolean
    val cantAttack: Boolean
    val cantChat: Boolean
    val cantBeMerchant: Boolean
    val cantUseObject: Boolean
    val cantUseTaxCollector: Boolean
    val cantUseInteractive: Boolean
    val cantSpeakToNPC: Boolean
    val cantChangeZone: Boolean
    val cantAttackMonster: Boolean
    val cantWalk8Directions: Boolean

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, cantBeAggressed)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, cantBeChallenged)
      flag1 = BooleanByteWrapper.setFlag(flag1, 2, cantTrade)
      flag1 = BooleanByteWrapper.setFlag(flag1, 3, cantBeAttackedByMutant)
      flag1 = BooleanByteWrapper.setFlag(flag1, 4, cantRun)
      flag1 = BooleanByteWrapper.setFlag(flag1, 5, forceSlowWalk)
      flag1 = BooleanByteWrapper.setFlag(flag1, 6, cantMinimize)
      flag1 = BooleanByteWrapper.setFlag(flag1, 7, cantMove)
      buf.writeUByte(flag1.toShort)
      var flag2 = 0
      flag2 = BooleanByteWrapper.setFlag(flag2, 0, cantAggress)
      flag2 = BooleanByteWrapper.setFlag(flag2, 1, cantChallenge)
      flag2 = BooleanByteWrapper.setFlag(flag2, 2, cantExchange)
      flag2 = BooleanByteWrapper.setFlag(flag2, 3, cantAttack)
      flag2 = BooleanByteWrapper.setFlag(flag2, 4, cantChat)
      flag2 = BooleanByteWrapper.setFlag(flag2, 5, cantBeMerchant)
      flag2 = BooleanByteWrapper.setFlag(flag2, 6, cantUseObject)
      flag2 = BooleanByteWrapper.setFlag(flag2, 7, cantUseTaxCollector)
      buf.writeUByte(flag2.toShort)
      var flag3 = 0
      flag3 = BooleanByteWrapper.setFlag(flag3, 0, cantUseInteractive)
      flag3 = BooleanByteWrapper.setFlag(flag3, 1, cantSpeakToNPC)
      flag3 = BooleanByteWrapper.setFlag(flag3, 2, cantChangeZone)
      flag3 = BooleanByteWrapper.setFlag(flag3, 3, cantAttackMonster)
      flag3 = BooleanByteWrapper.setFlag(flag3, 4, cantWalk8Directions)
      buf.writeUByte(flag3.toShort)
    }

  }

  protected def create(cantBeAggressed: Boolean, cantBeChallenged: Boolean, cantTrade: Boolean, cantBeAttackedByMutant: Boolean, cantRun: Boolean, forceSlowWalk: Boolean, cantMinimize: Boolean, cantMove: Boolean, cantAggress: Boolean, cantChallenge: Boolean, cantExchange: Boolean, cantAttack: Boolean, cantChat: Boolean, cantBeMerchant: Boolean, cantUseObject: Boolean, cantUseTaxCollector: Boolean, cantUseInteractive: Boolean, cantSpeakToNPC: Boolean, cantChangeZone: Boolean, cantAttackMonster: Boolean, cantWalk8Directions: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val cantBeAggressed = BooleanByteWrapper.getFlag(flag1, 0)
    val cantBeChallenged = BooleanByteWrapper.getFlag(flag1, 1)
    val cantTrade = BooleanByteWrapper.getFlag(flag1, 2)
    val cantBeAttackedByMutant = BooleanByteWrapper.getFlag(flag1, 3)
    val cantRun = BooleanByteWrapper.getFlag(flag1, 4)
    val forceSlowWalk = BooleanByteWrapper.getFlag(flag1, 5)
    val cantMinimize = BooleanByteWrapper.getFlag(flag1, 6)
    val cantMove = BooleanByteWrapper.getFlag(flag1, 7)
    val flag2 = buf.readUByte()
    val cantAggress = BooleanByteWrapper.getFlag(flag2, 0)
    val cantChallenge = BooleanByteWrapper.getFlag(flag2, 1)
    val cantExchange = BooleanByteWrapper.getFlag(flag2, 2)
    val cantAttack = BooleanByteWrapper.getFlag(flag2, 3)
    val cantChat = BooleanByteWrapper.getFlag(flag2, 4)
    val cantBeMerchant = BooleanByteWrapper.getFlag(flag2, 5)
    val cantUseObject = BooleanByteWrapper.getFlag(flag2, 6)
    val cantUseTaxCollector = BooleanByteWrapper.getFlag(flag2, 7)
    val flag3 = buf.readUByte()
    val cantUseInteractive = BooleanByteWrapper.getFlag(flag3, 0)
    val cantSpeakToNPC = BooleanByteWrapper.getFlag(flag3, 1)
    val cantChangeZone = BooleanByteWrapper.getFlag(flag3, 2)
    val cantAttackMonster = BooleanByteWrapper.getFlag(flag3, 3)
    val cantWalk8Directions = BooleanByteWrapper.getFlag(flag3, 4)

    create(cantBeAggressed, cantBeChallenged, cantTrade, cantBeAttackedByMutant, cantRun, forceSlowWalk, cantMinimize, cantMove, cantAggress, cantChallenge, cantExchange, cantAttack, cantChat, cantBeMerchant, cantUseObject, cantUseTaxCollector, cantUseInteractive, cantSpeakToNPC, cantChangeZone, cantAttackMonster, cantWalk8Directions)
  }

}

object ActorRestrictionsInformations extends ActorRestrictionsInformations {
  case class TypeImpl(cantBeAggressed: Boolean, cantBeChallenged: Boolean, cantTrade: Boolean, cantBeAttackedByMutant: Boolean, cantRun: Boolean, forceSlowWalk: Boolean, cantMinimize: Boolean, cantMove: Boolean, cantAggress: Boolean, cantChallenge: Boolean, cantExchange: Boolean, cantAttack: Boolean, cantChat: Boolean, cantBeMerchant: Boolean, cantUseObject: Boolean, cantUseTaxCollector: Boolean, cantUseInteractive: Boolean, cantSpeakToNPC: Boolean, cantChangeZone: Boolean, cantAttackMonster: Boolean, cantWalk8Directions: Boolean) extends Type
  override def create(cantBeAggressed: Boolean, cantBeChallenged: Boolean, cantTrade: Boolean, cantBeAttackedByMutant: Boolean, cantRun: Boolean, forceSlowWalk: Boolean, cantMinimize: Boolean, cantMove: Boolean, cantAggress: Boolean, cantChallenge: Boolean, cantExchange: Boolean, cantAttack: Boolean, cantChat: Boolean, cantBeMerchant: Boolean, cantUseObject: Boolean, cantUseTaxCollector: Boolean, cantUseInteractive: Boolean, cantSpeakToNPC: Boolean, cantChangeZone: Boolean, cantAttackMonster: Boolean, cantWalk8Directions: Boolean) = TypeImpl(cantBeAggressed, cantBeChallenged, cantTrade, cantBeAttackedByMutant, cantRun, forceSlowWalk, cantMinimize, cantMove, cantAggress, cantChallenge, cantExchange, cantAttack, cantChat, cantBeMerchant, cantUseObject, cantUseTaxCollector, cantUseInteractive, cantSpeakToNPC, cantChangeZone, cantAttackMonster, cantWalk8Directions)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(cantBeAggressed: Boolean, cantBeChallenged: Boolean, cantTrade: Boolean, cantBeAttackedByMutant: Boolean, cantRun: Boolean, forceSlowWalk: Boolean, cantMinimize: Boolean, cantMove: Boolean, cantAggress: Boolean, cantChallenge: Boolean, cantExchange: Boolean, cantAttack: Boolean, cantChat: Boolean, cantBeMerchant: Boolean, cantUseObject: Boolean, cantUseTaxCollector: Boolean, cantUseInteractive: Boolean, cantSpeakToNPC: Boolean, cantChangeZone: Boolean, cantAttackMonster: Boolean, cantWalk8Directions: Boolean) = create(cantBeAggressed, cantBeChallenged, cantTrade, cantBeAttackedByMutant, cantRun, forceSlowWalk, cantMinimize, cantMove, cantAggress, cantChallenge, cantExchange, cantAttack, cantChat, cantBeMerchant, cantUseObject, cantUseTaxCollector, cantUseInteractive, cantSpeakToNPC, cantChangeZone, cantAttackMonster, cantWalk8Directions)

  type Target = TypeImpl

}

