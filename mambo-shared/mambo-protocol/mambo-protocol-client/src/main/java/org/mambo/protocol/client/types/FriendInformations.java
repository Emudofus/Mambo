

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class FriendInformations extends AbstractContactInformations {
    public static final short TYPE_ID = 78;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte playerState;
    public int lastConnection;
    
    public FriendInformations() { }
    
    public FriendInformations(int accountId, String accountName, byte playerState, int lastConnection) {
        super(accountId, accountName);
        this.playerState = playerState;
        this.lastConnection = lastConnection;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(playerState);
        writer.writeInt(lastConnection);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        playerState = reader.readByte();
        if (playerState < 0)
            throw new RuntimeException("Forbidden value on playerState = " + playerState + ", it doesn't respect the following condition : playerState < 0");
        lastConnection = reader.readInt();
        if (lastConnection < 0)
            throw new RuntimeException("Forbidden value on lastConnection = " + lastConnection + ", it doesn't respect the following condition : lastConnection < 0");
    }
    
}
