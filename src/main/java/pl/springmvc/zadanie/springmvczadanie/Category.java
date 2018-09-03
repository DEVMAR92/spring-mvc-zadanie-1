package pl.springmvc.zadanie.springmvczadanie;

public enum Category {
    FOOD("art.spożywcze"),
    CLEAN("art.gosp.domowego"),
    OTHER("inne");
    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
