package operation;

/**
 * Created by bbk on 2/7/17.
 */
public class Sales {

    private String saleId;
    private String itemId;
    private String soldDate;
    private float price;
    private int itemQty;
    private String soldBy;

    public String getSaleId() {
        return saleId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }



    public String getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }
}
