

// Generated on 11/11/2012 19:06:11
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FightOptionsInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 20;
    
    
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
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, isSecret);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, isRestrictedToPartyOnly);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, isClosed);
        flag1 = BooleanByteWrapper.setFlag(flag1, 3, isAskingForHelp);
        writer.writeUnsignedByte(flag1);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        isSecret = BooleanByteWrapper.getFlag(flag1, 0);
        isRestrictedToPartyOnly = BooleanByteWrapper.getFlag(flag1, 1);
        isClosed = BooleanByteWrapper.getFlag(flag1, 2);
        isAskingForHelp = BooleanByteWrapper.getFlag(flag1, 3);
    }
    
}
