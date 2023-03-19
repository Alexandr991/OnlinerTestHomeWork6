package onliner.pageObjects;

public enum CatalogItems {
    ELECTRONICS("1","Электроника"), COMPUTERS_AND_NETWORKS("2","Компьютеры и сети"), APPLIANCES("3","Бытовая техника"),
    CONSTRUCTION_AND_REPAIR("4","Стройка и реомнт"), HOUSE_AND_GARDEN("5","Дом и Сад"), AUTO_AND_MOTO("6","Авто и мото"),
    BEAUTY_AND_SPORTS("7","Красота и спорт"), CHILDREN_AND_MOTHERS("8","Детям");
    private String catalogItem;
    private String itemId;

    CatalogItems(String itemId, String catalogItem) {
        this.itemId =itemId;
        this.catalogItem = catalogItem;

    }

    public String getCatalogItem() {
        return catalogItem;
    }

    public String getItemId() {
        return itemId;
    }
}
