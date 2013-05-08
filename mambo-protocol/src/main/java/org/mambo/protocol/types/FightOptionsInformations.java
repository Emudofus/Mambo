

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightOptionsInformations extends NetworkType {
    public static final short TYPE_ID = 20;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public boolean isSecret;
    public boolean isRestrictedToPartyOnly;
    public boolean isClosed;
    public boolean isAskingForHelp;
    
    public FightOptionsInformations() { }
    
    public FightOptionsInformations(boolean isSecret, boolean isRestrictedToPartyOnly, boolean isClosed, boolean isAskingForHelp) {
        this.isSecret = isSecret;
        this.isRestrictedToPartyOnly = isRestrictedToPartyOnly;
        this.isClosed = isClosed;
        this.isAskingForHelp = isAskingForHelp;
    }
    
    @Override
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, isSecret);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, isRestrictedToPartyOnly);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, isClosed);
        flag1 = BooleanByteWrapper.setFlag(flag1, 3, isAskingForHelp);
        buf.writeUByte(flag1);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        isSecret = BooleanByteWrapper.getFlag(flag1, 0);
        isRestrictedToPartyOnly = BooleanByteWrapper.getFlag(flag1, 1);
        isClosed = BooleanByteWrapper.getFlag(flag1, 2);
        isAskingForHelp = BooleanByteWrapper.getFlag(flag1, 3);
    }
    
}
