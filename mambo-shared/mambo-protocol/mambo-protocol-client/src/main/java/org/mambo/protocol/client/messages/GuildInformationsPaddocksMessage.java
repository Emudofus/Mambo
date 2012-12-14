

// Generated on 12/14/2012 18:44:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildInformationsPaddocksMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5959;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte nbPaddockMax;
    public PaddockContentInformations[] paddocksInformations;
    
    public GuildInformationsPaddocksMessage() { }
    
    public GuildInformationsPaddocksMessage(byte nbPaddockMax, PaddockContentInformations[] paddocksInformations) {
        this.nbPaddockMax = nbPaddockMax;
        this.paddocksInformations = paddocksInformations;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(nbPaddockMax);
        writer.writeUnsignedShort(paddocksInformations.length);
        for (PaddockContentInformations entry : paddocksInformations) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        nbPaddockMax = reader.readByte();
        if (nbPaddockMax < 0)
            throw new RuntimeException("Forbidden value on nbPaddockMax = " + nbPaddockMax + ", it doesn't respect the following condition : nbPaddockMax < 0");
        int limit = reader.readUnsignedShort();
        paddocksInformations = new PaddockContentInformations[limit];
        for (int i = 0; i < limit; i++) {
            paddocksInformations[i] = new PaddockContentInformations();
            paddocksInformations[i].deserialize(reader);
        }
    }
    
}
