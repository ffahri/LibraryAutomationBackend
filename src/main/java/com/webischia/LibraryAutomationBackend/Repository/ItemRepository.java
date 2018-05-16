package com.webischia.LibraryAutomationBackend.Repository;

import com.webischia.LibraryAutomationBackend.Domains.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // thanks Java 8, look the custom RowMapper
    public List<ItemType> getAllItemTypes() {

        List<ItemType> result = jdbcTemplate.query(
                "SELECT typeID,typeName FROM FAHRI2.ITEMTYPE",
                (rs, rowNum) -> new ItemType(rs.getInt("typeID"),rs.getString("typeName")) );

        return result;

    }

    public ItemType getItemType(int id){

        return jdbcTemplate.queryForObject("select typeID,typeName from FAHRI2.ITEMTYPE where typeID= "+id,
                (rs,rowNum) ->new ItemType(rs.getInt("typeID"),rs.getString("typeName")));

    }
    public ItemType addItemType(String name)
    {
        jdbcTemplate.execute("INSERT INTO FAHRI2.ITEMTYPE(typeName) VALUES('"+name+"')");
        return jdbcTemplate.queryForObject("select typeID,typeName from FAHRI2.ITEMTYPE where typeName='"+name+"'",
                (rs,rowNum) ->new ItemType(rs.getInt("typeID"),rs.getString("typeName")));
    }
    public void deleteItemType(int id){
        jdbcTemplate.execute("DELETE FROM FAHRI2.ITEMTYPE WHERE typeID= "+id);
    }

    public ItemType updateItemType(ItemType itemType , int id){
        jdbcTemplate.execute("UPDATE FAHRI2.ITEMTYPE SET typeName='"+itemType.getTypeName()+"' WHERE typeID= "+id);
        return getItemType(id);
    }

    public Items addItem(ItemDTO itemDTO, int typeID){
        Items item = itemDTO.getItem();
        jdbcTemplate.execute("INSERT INTO FAHRI2.ITEMS(itemName,typeID,itemDesc,ISBN,stockNo,sizeValue,pageNumber,printYear,editionNo,itemLang,publisherID)"+
        "VALUES('"+item.getItemName()+"',"+typeID+",'"+item.getItemDesc()+"','"+item.getISBN()+"','"+item.getStockNo()+"','"+item.getSizeValue()+
                "','"+item.getPageNumber()+"','"+item.getPrintYear()+"','"+item.getEditionNo()+"','"+item.getItemLang()+"',"+item.getPublisherID()+")");
        int itemID = jdbcTemplate
                .queryForObject("SELECT itemID FROM FAHRI2.ITEMS WHERE stockNo='"+item.getStockNo()+"'",Integer.class);
        for(int i = 0; i< itemDTO.getAuthorIDs().length; i++)
            jdbcTemplate.execute("INSERT INTO FAHRI2.AUTHOR_ITEMS(authorID,itemID) VALUES("+ itemDTO.getAuthorIDs()[i]+","+itemID+")");
        for(int j = 0; j< itemDTO.getSubjectIDs().length; j++)
            jdbcTemplate.execute("INSERT INTO FAHRI2.SUBJECT_ITEMS(subjectID,itemID) VALUES("+ itemDTO.getSubjectIDs()[j]+","+itemID+")");

        return getItem(itemID);
    }
    public Items updateItem(ItemDTO itemDTO,int id)
    {
        Items item = itemDTO.getItem();

        jdbcTemplate.execute("UPDATE FAHRI2.ITEMS SET itemName='"+item.getItemName()+"',"+"typeID= "+item.getTypeID()+","+"itemDesc='"+item.getItemDesc()+"',"+
        "ISBN='"+item.getISBN()+"',"+"stockNo='"+item.getISBN()+"',"+"sizeValue='"+item.getSizeValue()+"',"+"pageNumber='"+item.getPageNumber()+"',"+
        "printYear='"+item.getPrintYear()+"',"+"editionNo='"+item.getEditionNo()+"',"+"itemLang='"+item.getItemLang()+"',publisherID= "+item.getPublisherID()+" WHERE itemID = "+id);
        System.out.println(itemDTO.getSubjectIDs().length);
        //silip baştan oluşturuyorum
        jdbcTemplate.execute("DELETE FROM FAHRI2.AUTHOR_ITEMS WHERE itemID= "+item.getItemID());
        jdbcTemplate.execute("DELETE FROM FAHRI2.SUBJECT_ITEMS WHERE itemID= "+item.getItemID());

        for(int i = 0; i< itemDTO.getAuthorIDs().length; i++)
            jdbcTemplate.execute("INSERT INTO FAHRI2.AUTHOR_ITEMS(authorID,itemID) VALUES("+ itemDTO.getAuthorIDs()[i]+","+id+")");
        for(int j = 0; j< itemDTO.getSubjectIDs().length; j++)
            jdbcTemplate.execute("INSERT INTO FAHRI2.SUBJECT_ITEMS(subjectID,itemID) VALUES("+ itemDTO.getSubjectIDs()[j]+","+id+")");

        return getItem(id);
    }

    public void deleteItem(int id)
    {
        jdbcTemplate.execute("DELETE FROM FAHRI2.ITEMS WHERE itemID= "+id);
    }
    public List<Items> getAllItems(){
        List<Items> result = jdbcTemplate.query("select itemID,itemName,typeID,itemDesc,ISBN,stockNo,sizeValue,pageNumber,printYear,editionNo,itemLang,editDate,publisherID from FAHRI2.ITEMS",
                (rs,rowNum) -> new Items(rs.getInt("itemID"),rs.getString("itemName"),rs.getInt("typeID"),rs.getString("itemDesc"),
                        rs.getString("ISBN"),rs.getString("stockNo"),rs.getString("sizeValue"),rs.getString("pageNumber"),
                        rs.getString("printYear"),rs.getString("editionNo"),rs.getTimestamp("editDate"),rs.getString("itemLang"),rs.getInt("publisherID")));
        return result;
    }
//    itemID int not null,
//    itemName varchar2(80) not null,
//    typeID int not null,
//    itemDesc varchar2(300),
//    ISBN varchar2(60) unique,
//    stockNo varchar2(60) unique, ---filmlerde isbn yok
//    sizeValue varchar2(10), --- 30cm 10cm 10in
//    pageNumber varchar2(10) not null, ---300 + sayfa veya 400 + dk
//    printYear char(4) not null, ---2000
//    editionNo varchar2(10) not null, --- XX1 veya 10.basım iii.
//    itemLang char(2) not null, ---ISO 639-1
//    editDate timestamp not null,
    public Items getItem(int id){
        return jdbcTemplate.queryForObject("select itemID,itemName,typeID,itemDesc,ISBN,stockNo,sizeValue,pageNumber,printYear,editionNo,itemLang,editDate,publisherID from FAHRI2.ITEMS where itemID= "+id,
                (rs,rowNum) -> new Items(rs.getInt("itemID"),rs.getString("itemName"),rs.getInt("typeID"),rs.getString("itemDesc"),
                        rs.getString("ISBN"),rs.getString("stockNo"),rs.getString("sizeValue"),rs.getString("pageNumber"),
                        rs.getString("printYear"),rs.getString("editionNo"),rs.getTimestamp("editDate"),rs.getString("itemLang"),rs.getInt("publisherID")));

    }

    public void addAuthorToItem(int authorID , int itemID )
    {
        jdbcTemplate.execute("INSERT INTO FAHRI2.AUTHOR_ITEMS(authorID,itemID) VALUES("+authorID+","+itemID+")");
    }

    public void addSubjectToItem(int subjectID,int itemID)
    {
        jdbcTemplate.execute("INSERT INTO FAHRI2.SUBJECT_ITEMS(subjectID,itemID) VALUES("+subjectID+","+itemID+")");

    }

    public void addPublisherToItem(int publisherID, int itemID) {
        jdbcTemplate.execute("INSERT INTO FAHRI2.PUBLISHER_ITEM(publisherID,itemID) VALUES("+publisherID+","+itemID+")");

    }

    public void editAuthorToItem(int authorID, int itemID) {
        jdbcTemplate.execute("UPDATE FAHRI2.AUTHOR_ITEMS SET authorID= "+authorID+",itemID= "+itemID);
    }

    public void editSubjectToItem(int subjectid, int itemID) {
        jdbcTemplate.execute("UPDATE FAHRI2.SUBJECT_ITEMS SET subjectID= "+subjectid+",itemID= "+itemID);

    }

    public void editPublisherToItem(int publisherId, int itemID) {
        jdbcTemplate.execute("UPDATE FAHRI2.PUBLISHER_ITEM SET publisherID= "+publisherId+",itemID= "+itemID);

    }

    public Items findItemByISBN(String ISBN) {
        return jdbcTemplate.queryForObject("select itemID,itemName,typeID,itemDesc,ISBN,stockNo,sizeValue,pageNumber,printYear,editionNo,itemLang,editDate,publisherID from FAHRI2.ITEMS where ISBN='"+ISBN+"'",
                (rs,rowNum) -> new Items(rs.getInt("itemID"),rs.getString("itemName"),rs.getInt("typeID"),rs.getString("itemDesc"),
                        rs.getString("ISBN"),rs.getString("stockNo"),rs.getString("sizeValue"),rs.getString("pageNumber"),
                        rs.getString("printYear"),rs.getString("editionNo"),rs.getTimestamp("editDate"),rs.getString("itemLang"),rs.getInt("publisherID")));
    }

    public List<Items> searchItemByKeyword(String keyword) {
        List<Items> result = jdbcTemplate.query("select itemID,itemName,typeID,itemDesc,ISBN,stockNo,sizeValue,pageNumber,printYear,editionNo,itemLang,editDate,publisherID from FAHRI2.ITEMS where itemName LIKE '%"+keyword+"%'",
                (rs,rowNum) -> new Items(rs.getInt("itemID"),rs.getString("itemName"),rs.getInt("typeID"),rs.getString("itemDesc"),
                        rs.getString("ISBN"),rs.getString("stockNo"),rs.getString("sizeValue"),rs.getString("pageNumber"),
                        rs.getString("printYear"),rs.getString("editionNo"),rs.getTimestamp("editDate"),rs.getString("itemLang"),rs.getInt("publisherID")));
        return result;
    }

    public List<Items> searchItemsByPublisher(int publisherID) {
        //join????
        List<Items> result = jdbcTemplate.query("select * from FAHRI2.ITEMS where publisherID= "+publisherID,
                (rs,rowNum) -> new Items(rs.getInt("itemID"),rs.getString("itemName"),rs.getInt("typeID"),rs.getString("itemDesc"),
                        rs.getString("ISBN"),rs.getString("stockNo"),rs.getString("sizeValue"),rs.getString("pageNumber"),
                        rs.getString("printYear"),rs.getString("editionNo"),rs.getTimestamp("editDate"),rs.getString("itemLang"),rs.getInt("publisherID")));
        return result;
    }

    public List<Items> searchItemsByAuthorID(int authorID) {
        return jdbcTemplate.query("SELECT * FROM FAHRI2.ITEMS items JOIN FAHRI2.AUTHOR_ITEMS ai on items.itemID = ai.itemID WHERE ai.authorID = "+authorID,
                (rs,rowNum) -> new Items(rs.getInt("itemID"),rs.getString("itemName"),rs.getInt("typeID"),rs.getString("itemDesc"),
                        rs.getString("ISBN"),rs.getString("stockNo"),rs.getString("sizeValue"),rs.getString("pageNumber"),
                        rs.getString("printYear"),rs.getString("editionNo"),rs.getTimestamp("editDate"),rs.getString("itemLang"),rs.getInt("publisherID")));
    }

    public List<Items> searchItesmBySubject(String subject) {
        return null;
    }
    public List<Items> searchItemsByPost(Search search)
    {

        List<Items> result = jdbcTemplate.query("select itemID,itemName,typeID,itemDesc,ISBN,stockNo,sizeValue,pageNumber,printYear,editionNo,itemLang,editDate,publisherID from FAHRI2.ITEMS where itemName LIKE '%"+search.getKeyword()+"%' and   ",
                (rs,rowNum) -> new Items(rs.getInt("itemID"),rs.getString("itemName"),rs.getInt("typeID"),rs.getString("itemDesc"),
                        rs.getString("ISBN"),rs.getString("stockNo"),rs.getString("sizeValue"),rs.getString("pageNumber"),
                        rs.getString("printYear"),rs.getString("editionNo"),rs.getTimestamp("editDate"),rs.getString("itemLang"),rs.getInt("publisherID")));
                return result;
    }

    public Stock getStock(int id){
            return jdbcTemplate.queryForObject("select stockID,itemID,locationLetter1,locationLetter2,addDate from FAHRI2.STOCKITEM where stockID= "+id,
                    (rs,rowNum) -> new Stock(rs.getInt("itemID"),rs.getInt("stockID"),rs.getString("locationLetter1"),rs.getString("locationLetter2"),rs.getTimestamp("addDate")));

        }

    public Stock addStock(Stock stock) {
        jdbcTemplate.execute("INSERT INTO FAHRI2.STOCKITEM(itemID,locationLetter1,locationLetter2) VALUES("+stock.getItemID()+",'"+stock.getLocationLetter1()+"','"+stock.getLocationLetter2()+"')");
        return getStock(jdbcTemplate
                .queryForObject("SELECT stockID FROM FAHRI2.STOCKITEM WHERE locationLetter1 ='"+stock.getLocationLetter1()+"' and locationLetter2 ='"+stock.getLocationLetter2()+"'",Integer.class));
    }
    public Stock editStock(Stock stock)
    {
        jdbcTemplate.execute("UPDATE FAHRI2.STOCKITEM SET locationLetter1='"+stock.getLocationLetter1()+"',locationLetter2='"+stock.getLocationLetter2()+"' WHERE stockID = "+stock.getStockID());
        return getStock(stock.getStockID());
    }
    public void deleteStock(int id)
    {
        jdbcTemplate.execute("DELETE FROM FAHRI2.STOCKITEM WHERE stockID = "+id);
    }
    public List<Stock> getAllStockByItemID(int id)
    {
        return jdbcTemplate.query("select stockID,itemID,locationLetter1,locationLetter2,addDate from FAHRI2.STOCKITEM where itemID= "+id,
                (rs,rowNum) -> new Stock(rs.getInt("itemID"),rs.getInt("stockID"),rs.getString("locationLetter1"),rs.getString("locationLetter2"),rs.getTimestamp("addDate")));

    }
    public ItemDTO getItemDTO(int id) {
        ItemDTO tmp = new ItemDTO();
        List<Integer> integers =jdbcTemplate.query("SELECT authorID from FAHRI2.AUTHOR_ITEMS au WHERE itemID = "+id,(rs,rowNum) -> new Integer(rs.getInt("authorID")));
        int[] array = integers.stream().mapToInt(i->i).toArray();
        tmp.setAuthorIDs(array);
        List<Integer> integers2 =jdbcTemplate.query("SELECT subjectID from FAHRI2.SUBJECT_ITEMS au WHERE itemID = "+id,(rs,rowNum) -> new Integer(rs.getInt("subjectID")));
        int[] array2 = integers.stream().mapToInt(i->i).toArray();
        tmp.setSubjectIDs(array2);
        return tmp;
    }




}

