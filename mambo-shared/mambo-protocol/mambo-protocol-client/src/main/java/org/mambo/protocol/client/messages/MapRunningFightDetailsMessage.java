

// Generated on 12/14/2012 18:44:07
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class MapRunningFightDetailsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5751;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    public String[] names;
    public short[] levels;
    public byte teamSwap;
    public boolean[] alives;
    
    public MapRunningFightDetailsMessage() { }
    
    public MapRunningFightDetailsMessage(int fightId, String[] names, short[] levels, byte teamSwap, boolean[] alives) {
        this.fightId = fightId;
        this.names = names;
        this.levels = levels;
        this.teamSwap = teamSwap;
        this.alives = alives;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fightId);
        writer.writeUnsignedShort(names.length);
        for (String entry : names) {
            writer.writeString(entry);
        }
        writer.writeUnsignedShort(levels.length);
        for (short entry : levels) {
            writer.writeShort(entry);
        }
        writer.writeByte(teamSwap);
        writer.writeUnsignedShort(alives.length);
        for (boolean entry : alives) {
            writer.writeBoolean(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readInt();
        if (fightId < 0)
            throw new RuntimeException("Forbidden value on fightId = " + fightId + ", it doesn't respect the following condition : fightId < 0");
        int limit = reader.readUnsignedShort();
        names = new String[limit];
        for (int i = 0; i < limit; i++) {
            names[i] = reader.readString();
        }
        limit = reader.readUnsignedShort();
        levels = new short[limit];
        for (int i = 0; i < limit; i++) {
            levels[i] = reader.readShort();
        }
        teamSwap = reader.readByte();
        if (teamSwap < 0)
            throw new RuntimeException("Forbidden value on teamSwap = " + teamSwap + ", it doesn't respect the following condition : teamSwap < 0");
        limit = reader.readUnsignedShort();
        alives = new boolean[limit];
        for (int i = 0; i < limit; i++) {
            alives[i] = reader.readBoolean();
        }
    }
    
}
