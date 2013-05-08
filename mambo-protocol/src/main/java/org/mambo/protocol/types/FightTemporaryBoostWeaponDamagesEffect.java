

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(weaponTypeId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        weaponTypeId = buf.readShort();
    }
    
}
