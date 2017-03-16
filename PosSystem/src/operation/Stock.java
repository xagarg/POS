package operation;

/**
 * Created by bbk on 2/8/17.
 */
public class Stock {

    private String itemId;
    private String itemName;
    private int itemQny;
    private float itemPurchase;
    private float itemSale;
    private String itemAddedby;

    public int getItemQny() {
        return itemQny;
    }

    public void setItemQny(int itemQny) {
        this.itemQny = itemQny;
    }

    public float getItemPurchase() {
        return itemPurchase;
    }

    public void setItemPurchase(float itemPurchase) {
        this.itemPurchase = itemPurchase;
    }

    public float getItemSale() {
        return itemSale;
    }

    public void setItemSale(float itemSale) {
        this.itemSale = itemSale;
    }

    private String itemDate;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }



    public String getItemAddedby() {
        return itemAddedby;
    }

    public void setItemAddedby(String itemAddedby) {
        this.itemAddedby = itemAddedby;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }
}
