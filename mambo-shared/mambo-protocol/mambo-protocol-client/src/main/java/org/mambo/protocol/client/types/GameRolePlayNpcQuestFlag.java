

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameRolePlayNpcQuestFlag implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 384;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short[] questsToValidId;
    public short[] questsToStartId;
    
    public GameRolePlayNpcQuestFlag() { }
    
    public GameRolePlayNpcQuestFlag(short[] questsToValidId, short[] questsToStartId) {
        this.questsToValidId = questsToValidId;
        this.questsToStartId = questsToStartId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(questsToValidId.length);
        for (short entry : questsToValidId) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(questsToStartId.length);
        for (short entry : questsToStartId) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        questsToValidId = new short[limit];
        for (int i = 0; i < limit; i++) {
            questsToValidId[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        questsToStartId = new short[limit];
        for (int i = 0; i < limit; i++) {
            questsToStartId[i] = reader.readShort();
        }
    }
    
}
