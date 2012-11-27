

// Generated on 11/11/2012 20:41:38
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class FightTemporaryBoostWeaponDamagesEffect extends FightTemporaryBoostEffect {
    public static final short TYPE_ID = 211;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short weaponTypeId;
    
    public FightTemporaryBoostWeaponDamagesEffect() { }
    
    public FightTemporaryBoostWeaponDamagesEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, short delta, short weaponTypeId) {
        super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta);
        this.weaponTypeId = weaponTypeId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(weaponTypeId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        weaponTypeId = reader.readShort();
    }
    
}
