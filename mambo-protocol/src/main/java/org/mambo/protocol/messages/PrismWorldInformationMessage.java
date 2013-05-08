

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(nbSubOwned);
        buf.writeInt(subTotal);
        buf.writeInt(maxSub);
        buf.writeUShort(subAreasInformation.length);
        for (PrismSubAreaInformation entry : subAreasInformation) {
            entry.serialize(buf);
        }
        buf.writeInt(nbConqsOwned);
        buf.writeInt(conqsTotal);
        buf.writeUShort(conquetesInformation.length);
        for (VillageConquestPrismInformation entry : conquetesInformation) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        nbSubOwned = buf.readInt();
        if (nbSubOwned < 0)
            throw new RuntimeException("Forbidden value on nbSubOwned = " + nbSubOwned + ", it doesn't respect the following condition : nbSubOwned < 0");
        subTotal = buf.readInt();
        if (subTotal < 0)
            throw new RuntimeException("Forbidden value on subTotal = " + subTotal + ", it doesn't respect the following condition : subTotal < 0");
        maxSub = buf.readInt();
        if (maxSub < 0)
            throw new RuntimeException("Forbidden value on maxSub = " + maxSub + ", it doesn't respect the following condition : maxSub < 0");
        int limit = buf.readUShort();
        subAreasInformation = new PrismSubAreaInformation[limit];
        for (int i = 0; i < limit; i++) {
            subAreasInformation[i] = new PrismSubAreaInformation();
            subAreasInformation[i].deserialize(buf);
        }
        nbConqsOwned = buf.readInt();
        if (nbConqsOwned < 0)
            throw new RuntimeException("Forbidden value on nbConqsOwned = " + nbConqsOwned + ", it doesn't respect the following condition : nbConqsOwned < 0");
        conqsTotal = buf.readInt();
        if (conqsTotal < 0)
            throw new RuntimeException("Forbidden value on conqsTotal = " + conqsTotal + ", it doesn't respect the following condition : conqsTotal < 0");
        limit = buf.readUShort();
        conquetesInformation = new VillageConquestPrismInformation[limit];
        for (int i = 0; i < limit; i++) {
            conquetesInformation[i] = new VillageConquestPrismInformation();
            conquetesInformation[i].deserialize(buf);
        }
    }
    
}
