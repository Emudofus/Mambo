




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightMinimalStats extends TypeDeserializer {
  val typeId = 31

  protected trait Type extends BaseType with Serializable {
    val typeId = GameFightMinimalStats.typeId

    val lifePoints: Int
    val maxLifePoints: Int
    val baseMaxLifePoints: Int
    val permanentDamagePercent: Int
    val shieldPoints: Int
    val actionPoints: Short
    val maxActionPoints: Short
    val movementPoints: Short
    val maxMovementPoints: Short
    val summoner: Int
    val summoned: Boolean
    val neutralElementResistPercent: Short
    val earthElementResistPercent: Short
    val waterElementResistPercent: Short
    val airElementResistPercent: Short
    val fireElementResistPercent: Short
    val neutralElementReduction: Short
    val earthElementReduction: Short
    val waterElementReduction: Short
    val airElementReduction: Short
    val fireElementReduction: Short
    val criticalDamageFixedResist: Short
    val pushDamageFixedResist: Short
    val dodgePALostProbability: Short
    val dodgePMLostProbability: Short
    val tackleBlock: Short
    val tackleEvade: Short
    val invisibilityState: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(lifePoints)
      buf.writeInt(maxLifePoints)
      buf.writeInt(baseMaxLifePoints)
      buf.writeInt(permanentDamagePercent)
      buf.writeInt(shieldPoints)
      buf.writeShort(actionPoints)
      buf.writeShort(maxActionPoints)
      buf.writeShort(movementPoints)
      buf.writeShort(maxMovementPoints)
      buf.writeInt(summoner)
      buf.writeBoolean(summoned)
      buf.writeShort(neutralElementResistPercent)
      buf.writeShort(earthElementResistPercent)
      buf.writeShort(waterElementResistPercent)
      buf.writeShort(airElementResistPercent)
      buf.writeShort(fireElementResistPercent)
      buf.writeShort(neutralElementReduction)
      buf.writeShort(earthElementReduction)
      buf.writeShort(waterElementReduction)
      buf.writeShort(airElementReduction)
      buf.writeShort(fireElementReduction)
      buf.writeShort(criticalDamageFixedResist)
      buf.writeShort(pushDamageFixedResist)
      buf.writeShort(dodgePALostProbability)
      buf.writeShort(dodgePMLostProbability)
      buf.writeShort(tackleBlock)
      buf.writeShort(tackleEvade)
      buf.writeByte(invisibilityState)
    }

  }

  protected def create(lifePoints: Int, maxLifePoints: Int, baseMaxLifePoints: Int, permanentDamagePercent: Int, shieldPoints: Int, actionPoints: Short, maxActionPoints: Short, movementPoints: Short, maxMovementPoints: Short, summoner: Int, summoned: Boolean, neutralElementResistPercent: Short, earthElementResistPercent: Short, waterElementResistPercent: Short, airElementResistPercent: Short, fireElementResistPercent: Short, neutralElementReduction: Short, earthElementReduction: Short, waterElementReduction: Short, airElementReduction: Short, fireElementReduction: Short, criticalDamageFixedResist: Short, pushDamageFixedResist: Short, dodgePALostProbability: Short, dodgePMLostProbability: Short, tackleBlock: Short, tackleEvade: Short, invisibilityState: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
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

    create(lifePoints, maxLifePoints, baseMaxLifePoints, permanentDamagePercent, shieldPoints, actionPoints, maxActionPoints, movementPoints, maxMovementPoints, summoner, summoned, neutralElementResistPercent, earthElementResistPercent, waterElementResistPercent, airElementResistPercent, fireElementResistPercent, neutralElementReduction, earthElementReduction, waterElementReduction, airElementReduction, fireElementReduction, criticalDamageFixedResist, pushDamageFixedResist, dodgePALostProbability, dodgePMLostProbability, tackleBlock, tackleEvade, invisibilityState)
  }

}

object GameFightMinimalStats extends GameFightMinimalStats {
  class TypeImpl(val lifePoints: Int, val maxLifePoints: Int, val baseMaxLifePoints: Int, val permanentDamagePercent: Int, val shieldPoints: Int, val actionPoints: Short, val maxActionPoints: Short, val movementPoints: Short, val maxMovementPoints: Short, val summoner: Int, val summoned: Boolean, val neutralElementResistPercent: Short, val earthElementResistPercent: Short, val waterElementResistPercent: Short, val airElementResistPercent: Short, val fireElementResistPercent: Short, val neutralElementReduction: Short, val earthElementReduction: Short, val waterElementReduction: Short, val airElementReduction: Short, val fireElementReduction: Short, val criticalDamageFixedResist: Short, val pushDamageFixedResist: Short, val dodgePALostProbability: Short, val dodgePMLostProbability: Short, val tackleBlock: Short, val tackleEvade: Short, val invisibilityState: Byte) extends Type
  override def create(lifePoints: Int, maxLifePoints: Int, baseMaxLifePoints: Int, permanentDamagePercent: Int, shieldPoints: Int, actionPoints: Short, maxActionPoints: Short, movementPoints: Short, maxMovementPoints: Short, summoner: Int, summoned: Boolean, neutralElementResistPercent: Short, earthElementResistPercent: Short, waterElementResistPercent: Short, airElementResistPercent: Short, fireElementResistPercent: Short, neutralElementReduction: Short, earthElementReduction: Short, waterElementReduction: Short, airElementReduction: Short, fireElementReduction: Short, criticalDamageFixedResist: Short, pushDamageFixedResist: Short, dodgePALostProbability: Short, dodgePMLostProbability: Short, tackleBlock: Short, tackleEvade: Short, invisibilityState: Byte) = new TypeImpl(lifePoints, maxLifePoints, baseMaxLifePoints, permanentDamagePercent, shieldPoints, actionPoints, maxActionPoints, movementPoints, maxMovementPoints, summoner, summoned, neutralElementResistPercent, earthElementResistPercent, waterElementResistPercent, airElementResistPercent, fireElementResistPercent, neutralElementReduction, earthElementReduction, waterElementReduction, airElementReduction, fireElementReduction, criticalDamageFixedResist, pushDamageFixedResist, dodgePALostProbability, dodgePMLostProbability, tackleBlock, tackleEvade, invisibilityState)

  def apply(lifePoints: Int, maxLifePoints: Int, baseMaxLifePoints: Int, permanentDamagePercent: Int, shieldPoints: Int, actionPoints: Short, maxActionPoints: Short, movementPoints: Short, maxMovementPoints: Short, summoner: Int, summoned: Boolean, neutralElementResistPercent: Short, earthElementResistPercent: Short, waterElementResistPercent: Short, airElementResistPercent: Short, fireElementResistPercent: Short, neutralElementReduction: Short, earthElementReduction: Short, waterElementReduction: Short, airElementReduction: Short, fireElementReduction: Short, criticalDamageFixedResist: Short, pushDamageFixedResist: Short, dodgePALostProbability: Short, dodgePMLostProbability: Short, tackleBlock: Short, tackleEvade: Short, invisibilityState: Byte) = create(lifePoints, maxLifePoints, baseMaxLifePoints, permanentDamagePercent, shieldPoints, actionPoints, maxActionPoints, movementPoints, maxMovementPoints, summoner, summoned, neutralElementResistPercent, earthElementResistPercent, waterElementResistPercent, airElementResistPercent, fireElementResistPercent, neutralElementReduction, earthElementReduction, waterElementReduction, airElementReduction, fireElementReduction, criticalDamageFixedResist, pushDamageFixedResist, dodgePALostProbability, dodgePMLostProbability, tackleBlock, tackleEvade, invisibilityState)

  type Target = TypeImpl

}

