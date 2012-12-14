

// Generated on 12/14/2012 18:44:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(accountId);
        writer.writeBoolean(tutorialAvailable);
        writer.writeShort(breedsVisible);
        writer.writeShort(breedsAvailable);
        writer.writeByte(status);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        accountId = reader.readInt();
        tutorialAvailable = reader.readBoolean();
        breedsVisible = reader.readShort();
        if (breedsVisible < 0)
            throw new RuntimeException("Forbidden value on breedsVisible = " + breedsVisible + ", it doesn't respect the following condition : breedsVisible < 0");
        breedsAvailable = reader.readShort();
        if (breedsAvailable < 0)
            throw new RuntimeException("Forbidden value on breedsAvailable = " + breedsAvailable + ", it doesn't respect the following condition : breedsAvailable < 0");
        status = reader.readByte();
    }
    
}
