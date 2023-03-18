package onliner.pageObjects;

public enum ComputersAndNetworksItems {
    COMPUTERS_LAPTOPS_MONITORS("Ноутбуки, компьютеры, мониторы"), ACCESSORIES("Комплектующие")
    , DATA_STORAGE("Хранение данных"), NETWORK_HARDWARE("Сетевое оборудование");

    private String computerItems;

    ComputersAndNetworksItems(String computerItems) {
        this.computerItems = computerItems;
    }

    public String getComputerItems() {
        return computerItems;
    }
}
