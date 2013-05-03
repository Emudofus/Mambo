




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightMinimalStatsPreparation extends GameFightMinimalStats {
  override val typeId = 360

  protected trait Type extends GameFightMinimalStats.Type with Serializable {
    override val typeId = GameFightMinimalStatsPreparation.typeId

    val initiative: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(initiative)
    }

  }

  protected def create(lifePoints: Int, maxLifePoints: Int, baseMaxLifePoints: Int, permanentDamagePercent: Int, shieldPoints: Int, actionPoints: Short, maxActionPoints: Short, movementPoints: Short, maxMovementPoints: Short, summoner: Int, summoned: Boolean, neutralElementResistPercent: Short, earthElementResistPercent: Short, waterElementResistPercent: Short, airElementResistPercent: Short, fireElementResistPercent: Short, neutralElementReduction: Short, earthElementReduction: Short, waterElementReduction: Short, airElementReduction: Short, fireElementReduction: Short, criticalDamageFixedResist: Short, pushDamageFixedResist: Short, dodgePALostProbability: Short, dodgePMLostProbability: Short, tackleBlock: Short, tackleEvade: Short, invisibilityState: Byte, initiative: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val lifePoints = buf.readInt()
    val maxLifePoints = buf.readInt()
    val baseMaxLifePoints = buf.readInt()
    val permanentDamagePercent = buf.readInt()
    val shieldPoints = buf.readInt()
    val actionPoints = buf.readShort()
    val maxActionPoints = buf.readShort()
    val movementPoints = buf.readShort()
    val maxMovementPoints = buf.readShort()
    val summoner = buf.readInt()
    val summoned = buf.readBoolean()
    val neutralElementResistPercent = buf.readShort()
    val earthElementResistPercent = buf.readShort()
    val waterElementResistPercent = buf.readShort()
    val airElementResistPercent = buf.readShort()
    val fireElementResistPercent = buf.readShort()
    val neutralElementReduction = buf.readShort()
    val earthElementReduction = buf.readShort()
    val waterElementReduction = buf.readShort()
    val airElementReduction = buf.readShort()
    val fireElementReduction = buf.readShort()
    val criticalDamageFixedResist = buf.readShort()
    val pushDamageFixedResist = buf.readShort()
    val dodgePALostProbability = buf.readShort()
    val dodgePMLostProbability = buf.readShort()
    val tackleBlock = buf.readShort()
    val tackleEvade = buf.readShort()
    val invisibilityState = buf.readByte()
    val initiative = buf.readInt()

    create(lifePoints, maxLifePoints, baseMaxLifePoints, permanentDamagePercent, shieldPoints, actionPoints, maxActionPoints, movementPoints, maxMovementPoints, summoner, summoned, neutralElementResistPercent, earthElementResistPercent, waterElementResistPercent, airElementResistPercent, fireElementResistPercent, neutralElementReduction, earthElementReduction, waterElementReduction, airElementReduction, fireElementReduction, criticalDamageFixedResist, pushDamageFixedResist, dodgePALostProbability, dodgePMLostProbability, tackleBlock, tackleEvade, invisibilityState, initiative)
  }

}

object GameFightMinimalStatsPreparation extends GameFightMinimalStatsPreparation {
  class TypeImpl(val lifePoints: Int, val maxLifePoints: Int, val baseMaxLifePoints: Int, val permanentDamagePercent: Int, val shieldPoints: Int, val actionPoints: Short, val maxActionPoints: Short, val movementPoints: Short, val maxMovementPoints: Short, val summoner: Int, val summoned: Boolean, val neutralElementResistPercent: Short, val earthElementResistPercent: Short, val waterElementResistPercent: Short, val airElementResistPercent: Short, val fireElementResistPercent: Short, val neutralElementReduction: Short, val earthElementReduction: Short, val waterElementReduction: Short, val airElementReduction: Short, val fireElementReduction: Short, val criticalDamageFixedResist: Short, val pushDamageFixedResist: Short, val dodgePALostProbability: Short, val dodgePMLostProbability: Short, val tackleBlock: Short, val tackleEvade: Short, val invisibilityState: Byte, val initiative: Int) extends Type
  override def create(lifePoints: Int, maxLifePoints: Int, baseMaxLifePoints: Int, permanentDamagePercent: Int, shieldPoints: Int, actionPoints: Short, maxActionPoints: Short, movementPoints: Short, maxMovementPoints: Short, summoner: Int, summoned: Boolean, neutralElementResistPercent: Short, earthElementResistPercent: Short, waterElementResistPercent: Short, airElementResistPercent: Short, fireElementResistPercent: Short, neutralElementReduction: Short, earthElementReduction: Short, waterElementReduction: Short, airElementReduction: Short, fireElementReduction: Short, criticalDamageFixedResist: Short, pushDamageFixedResist: Short, dodgePALostProbability: Short, dodgePMLostProbability: Short, tackleBlock: Short, tackleEvade: Short, invisibilityState: Byte, initiative: Int) = new TypeImpl(lifePoints, maxLifePoints, baseMaxLifePoints, permanentDamagePercent, shieldPoints, actionPoints, maxActionPoints, movementPoints, maxMovementPoints, summoner, summoned, neutralElementResistPercent, earthElementResistPercent, waterElementResistPercent, airElementResistPercent, fireElementResistPercent, neutralElementReduction, earthElementReduction, waterElementReduction, airElementReduction, fireElementReduction, criticalDamageFixedResist, pushDamageFixedResist, dodgePALostProbability, dodgePMLostProbability, tackleBlock, tackleEvade, invisibilityState, initiative)

  def apply(lifePoints: Int, maxLifePoints: Int, baseMaxLifePoints: Int, permanentDamagePercent: Int, shieldPoints: Int, actionPoints: Short, maxActionPoints: Short, movementPoints: Short, maxMovementPoints: Short, summoner: Int, summoned: Boolean, neutralElementResistPercent: Short, earthElementResistPercent: Short, waterElementResistPercent: Short, airElementResistPercent: Short, fireElementResistPercent: Short, neutralElementReduction: Short, earthElementReduction: Short, waterElementReduction: Short, airElementReduction: Short, fireElementReduction: Short, criticalDamageFixedResist: Short, pushDamageFixedResist: Short, dodgePALostProbability: Short, dodgePMLostProbability: Short, tackleBlock: Short, tackleEvade: Short, invisibilityState: Byte, initiative: Int) = create(lifePoints, maxLifePoints, baseMaxLifePoints, permanentDamagePercent, shieldPoints, actionPoints, maxActionPoints, movementPoints, maxMovementPoints, summoner, summoned, neutralElementResistPercent, earthElementResistPercent, waterElementResistPercent, airElementResistPercent, fireElementResistPercent, neutralElementReduction, earthElementReduction, waterElementReduction, airElementReduction, fireElementReduction, criticalDamageFixedResist, pushDamageFixedResist, dodgePALostProbability, dodgePMLostProbability, tackleBlock, tackleEvade, invisibilityState, initiative)

  type Target = TypeImpl

}

