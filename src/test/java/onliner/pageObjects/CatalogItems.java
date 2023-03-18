package onliner.pageObjects;

public enum CatalogItems {
    ELECTRONICS("Электроника"), COMPUTERS_AND_NETWORKS("Компьютеры и сети"), APPLIANCES("Бытовая техника"),
    CONSTRUCTION_AND_REPAIR("Стройка и реомнт"), HOUSE_AND_GARDEN("Дом и Сад"), AUTO_AND_MOTO("Авто и мото"),
    BEAUTY_AND_SPORTS("Красота и спорт"), CHILDREN_AND_MOTHERS("Детям и мамам"), WORK_AND_OFFICE("Работа и офис"),
    FOOD("Еда");
    private String catalogItem;

    CatalogItems(String catalogItem) {
        this.catalogItem = catalogItem;

    }

    public String getCatalogItem() {
        return catalogItem;
    }
}
