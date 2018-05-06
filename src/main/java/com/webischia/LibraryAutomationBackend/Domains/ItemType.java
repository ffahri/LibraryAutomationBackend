package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;

@Data
public class ItemType {
    int typeID;
    String typeName;

    public ItemType(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }
}
