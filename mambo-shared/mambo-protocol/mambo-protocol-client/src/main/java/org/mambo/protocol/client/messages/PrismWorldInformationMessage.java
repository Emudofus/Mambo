

// Generated on 11/11/2012 19:17:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PrismWorldInformationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5854;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int nbSubOwned;
    public int subTotal;
    public int maxSub;
    public PrismSubAreaInformation[] subAreasInformation;
    public int nbConqsOwned;
    public int conqsTotal;
    public VillageConquestPrismInformation[] conquetesInformation;
    
    public PrismWorldInformationMessage() { }
    
    public PrismWorldInformationMessage(int nbSubOwned, int subTotal, int maxSub, PrismSubAreaInformation[] subAreasInformation, int nbConqsOwned, int conqsTotal, VillageConquestPrismInformation[] conquetesInformation) {
        this.nbSubOwned = nbSubOwned;
        this.subTotal = subTotal;
        this.maxSub = maxSub;
        this.subAreasInformation = subAreasInformation;
        this.nbConqsOwned = nbConqsOwned;
        this.conqsTotal = conqsTotal;
        this.conquetesInformation = conquetesInformation;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(nbSubOwned);
        writer.writeInt(subTotal);
        writer.writeInt(maxSub);
        writer.writeUnsignedShort(subAreasInformation.length);
        for (PrismSubAreaInformation entry : subAreasInformation) {
            entry.serialize(writer);
        }
        writer.writeInt(nbConqsOwned);
        writer.writeInt(conqsTotal);
        writer.writeUnsignedShort(conquetesInformation.length);
        for (VillageConquestPrismInformation entry : conquetesInformation) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        nbSubOwned = reader.readInt();
        if (nbSubOwned < 0)
            throw new RuntimeException("Forbidden value on nbSubOwned = " + nbSubOwned + ", it doesn't respect the following condition : nbSubOwned < 0");
        subTotal = reader.readInt();
        if (subTotal < 0)
            throw new RuntimeException("Forbidden value on subTotal = " + subTotal + ", it doesn't respect the following condition : subTotal < 0");
        maxSub = reader.readInt();
        if (maxSub < 0)
            throw new RuntimeException("Forbidden value on maxSub = " + maxSub + ", it doesn't respect the following condition : maxSub < 0");
        int limit = reader.readUnsignedShort();
        subAreasInformation = new PrismSubAreaInformation[limit];
        for (int i = 0; i < limit; i++) {
            subAreasInformation[i] = new PrismSubAreaInformation();
            subAreasInformation[i].deserialize(reader);
        }
        nbConqsOwned = reader.readInt();
        if (nbConqsOwned < 0)
            throw new RuntimeException("Forbidden value on nbConqsOwned = " + nbConqsOwned + ", it doesn't respect the following condition : nbConqsOwned < 0");
        conqsTotal = reader.readInt();
        if (conqsTotal < 0)
            throw new RuntimeException("Forbidden value on conqsTotal = " + conqsTotal + ", it doesn't respect the following condition : conqsTotal < 0");
        limit = reader.readUnsignedShort();
        conquetesInformation = new VillageConquestPrismInformation[limit];
        for (int i = 0; i < limit; i++) {
            conquetesInformation[i] = new VillageConquestPrismInformation();
            conquetesInformation[i].deserialize(reader);
        }
    }
    
}
