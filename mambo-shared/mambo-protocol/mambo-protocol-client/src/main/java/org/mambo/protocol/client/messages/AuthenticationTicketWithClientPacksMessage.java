

// Generated on 11/11/2012 19:16:59
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AuthenticationTicketWithClientPacksMessage extends AuthenticationTicketMessage {
    public static final int MESSAGE_ID = 6190;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] packs;
    
    public AuthenticationTicketWithClientPacksMessage() { }
    
    public AuthenticationTicketWithClientPacksMessage(String lang, String ticket, int[] packs) {
        super(lang, ticket);
        this.packs = packs;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(packs.length);
        for (int entry : packs) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        packs = new int[limit];
        for (int i = 0; i < limit; i++) {
            packs[i] = reader.readInt();
        }
    }
    
}
