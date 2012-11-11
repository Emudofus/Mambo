

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class HouseToSellListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6140;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short pageIndex;
    public short totalPage;
    public HouseInformationsForSell[] houseList;
    
    public HouseToSellListMessage() { }
    
    public HouseToSellListMessage(short pageIndex, short totalPage, HouseInformationsForSell[] houseList) {
        this.pageIndex = pageIndex;
        this.totalPage = totalPage;
        this.houseList = houseList;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(pageIndex);
        writer.writeShort(totalPage);
        writer.writeUnsignedShort(houseList.length);
        for (HouseInformationsForSell entry : houseList) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        pageIndex = reader.readShort();
        if (pageIndex < 0)
            throw new RuntimeException("Forbidden value on pageIndex = " + pageIndex + ", it doesn't respect the following condition : pageIndex < 0");
        totalPage = reader.readShort();
        if (totalPage < 0)
            throw new RuntimeException("Forbidden value on totalPage = " + totalPage + ", it doesn't respect the following condition : totalPage < 0");
        int limit = reader.readUnsignedShort();
        houseList = new HouseInformationsForSell[limit];
        for (int i = 0; i < limit; i++) {
            houseList[i] = new HouseInformationsForSell();
            houseList[i].deserialize(reader);
        }
    }
    
}
