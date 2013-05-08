

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeShort(pageIndex);
        buf.writeShort(totalPage);
        buf.writeUShort(houseList.length);
        for (HouseInformationsForSell entry : houseList) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        pageIndex = buf.readShort();
        if (pageIndex < 0)
            throw new RuntimeException("Forbidden value on pageIndex = " + pageIndex + ", it doesn't respect the following condition : pageIndex < 0");
        totalPage = buf.readShort();
        if (totalPage < 0)
            throw new RuntimeException("Forbidden value on totalPage = " + totalPage + ", it doesn't respect the following condition : totalPage < 0");
        int limit = buf.readUShort();
        houseList = new HouseInformationsForSell[limit];
        for (int i = 0; i < limit; i++) {
            houseList[i] = new HouseInformationsForSell();
            houseList[i].deserialize(buf);
        }
    }
    
}
