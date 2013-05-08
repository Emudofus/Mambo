

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AccountCapabilitiesMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6216;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int accountId;
    public boolean tutorialAvailable;
    public short breedsVisible;
    public short breedsAvailable;
    public byte status;
    
    public AccountCapabilitiesMessage() { }
    
    public AccountCapabilitiesMessage(int accountId, boolean tutorialAvailable, short breedsVisible, short breedsAvailable, byte status) {
        this.accountId = accountId;
        this.tutorialAvailable = tutorialAvailable;
        this.breedsVisible = breedsVisible;
        this.breedsAvailable = breedsAvailable;
        this.status = status;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(accountId);
        buf.writeBoolean(tutorialAvailable);
        buf.writeShort(breedsVisible);
        buf.writeShort(breedsAvailable);
        buf.writeByte(status);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        accountId = buf.readInt();
        tutorialAvailable = buf.readBoolean();
        breedsVisible = buf.readShort();
        if (breedsVisible < 0)
            throw new RuntimeException("Forbidden value on breedsVisible = " + breedsVisible + ", it doesn't respect the following condition : breedsVisible < 0");
        breedsAvailable = buf.readShort();
        if (breedsAvailable < 0)
            throw new RuntimeException("Forbidden value on breedsAvailable = " + breedsAvailable + ", it doesn't respect the following condition : breedsAvailable < 0");
        status = buf.readByte();
    }
    
}
