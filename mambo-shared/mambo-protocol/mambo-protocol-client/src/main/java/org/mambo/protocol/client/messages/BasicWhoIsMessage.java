

// Generated on 01/04/2013 14:54:20
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class BasicWhoIsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 180;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean self;
    public byte position;
    public String accountNickname;
    public String characterName;
    public short areaId;
    
    public BasicWhoIsMessage() { }
    
    public BasicWhoIsMessage(boolean self, byte position, String accountNickname, String characterName, short areaId) {
        this.self = self;
        this.position = position;
        this.accountNickname = accountNickname;
        this.characterName = characterName;
        this.areaId = areaId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(self);
        writer.writeByte(position);
        writer.writeString(accountNickname);
        writer.writeString(characterName);
        writer.writeShort(areaId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        self = reader.readBoolean();
        position = reader.readByte();
        accountNickname = reader.readString();
        characterName = reader.readString();
        areaId = reader.readShort();
    }
    
}
