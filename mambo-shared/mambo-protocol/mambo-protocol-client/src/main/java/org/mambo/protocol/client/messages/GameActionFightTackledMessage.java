

// Generated on 01/04/2013 14:54:19
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightTackledMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 1004;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] tacklersIds;
    
    public GameActionFightTackledMessage() { }
    
    public GameActionFightTackledMessage(short actionId, int sourceId, int[] tacklersIds) {
        super(actionId, sourceId);
        this.tacklersIds = tacklersIds;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(tacklersIds.length);
        for (int entry : tacklersIds) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        tacklersIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            tacklersIds[i] = reader.readInt();
        }
    }
    
}
