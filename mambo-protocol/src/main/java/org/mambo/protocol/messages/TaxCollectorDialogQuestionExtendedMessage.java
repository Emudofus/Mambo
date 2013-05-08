

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TaxCollectorDialogQuestionExtendedMessage extends TaxCollectorDialogQuestionBasicMessage {
    public static final int MESSAGE_ID = 5615;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short maxPods;
    public short prospecting;
    public short wisdom;
    public byte taxCollectorsCount;
    public int taxCollectorAttack;
    public int kamas;
    public double experience;
    public int pods;
    public int itemsValue;
    
    public TaxCollectorDialogQuestionExtendedMessage() { }
    
    public TaxCollectorDialogQuestionExtendedMessage(BasicGuildInformations guildInfo, short maxPods, short prospecting, short wisdom, byte taxCollectorsCount, int taxCollectorAttack, int kamas, double experience, int pods, int itemsValue) {
        super(guildInfo);
        this.maxPods = maxPods;
        this.prospecting = prospecting;
        this.wisdom = wisdom;
        this.taxCollectorsCount = taxCollectorsCount;
        this.taxCollectorAttack = taxCollectorAttack;
        this.kamas = kamas;
        this.experience = experience;
        this.pods = pods;
        this.itemsValue = itemsValue;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(maxPods);
        buf.writeShort(prospecting);
        buf.writeShort(wisdom);
        buf.writeByte(taxCollectorsCount);
        buf.writeInt(taxCollectorAttack);
        buf.writeInt(kamas);
        buf.writeDouble(experience);
        buf.writeInt(pods);
        buf.writeInt(itemsValue);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        maxPods = buf.readShort();
        if (maxPods < 0)
            throw new RuntimeException("Forbidden value on maxPods = " + maxPods + ", it doesn't respect the following condition : maxPods < 0");
        prospecting = buf.readShort();
        if (prospecting < 0)
            throw new RuntimeException("Forbidden value on prospecting = " + prospecting + ", it doesn't respect the following condition : prospecting < 0");
        wisdom = buf.readShort();
        if (wisdom < 0)
            throw new RuntimeException("Forbidden value on wisdom = " + wisdom + ", it doesn't respect the following condition : wisdom < 0");
        taxCollectorsCount = buf.readByte();
        if (taxCollectorsCount < 0)
            throw new RuntimeException("Forbidden value on taxCollectorsCount = " + taxCollectorsCount + ", it doesn't respect the following condition : taxCollectorsCount < 0");
        taxCollectorAttack = buf.readInt();
        kamas = buf.readInt();
        if (kamas < 0)
            throw new RuntimeException("Forbidden value on kamas = " + kamas + ", it doesn't respect the following condition : kamas < 0");
        experience = buf.readDouble();
        if (experience < 0)
            throw new RuntimeException("Forbidden value on experience = " + experience + ", it doesn't respect the following condition : experience < 0");
        pods = buf.readInt();
        if (pods < 0)
            throw new RuntimeException("Forbidden value on pods = " + pods + ", it doesn't respect the following condition : pods < 0");
        itemsValue = buf.readInt();
        if (itemsValue < 0)
            throw new RuntimeException("Forbidden value on itemsValue = " + itemsValue + ", it doesn't respect the following condition : itemsValue < 0");
    }
    
}
