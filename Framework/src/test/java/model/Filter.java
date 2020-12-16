package model;

public class Filter {
    private String color;
    private String category;

    public static class Builder{
        private Filter filter;

        public Builder(){
            filter=new Filter();
        }

        public Builder withColor(String color){
            filter.color=color;
            return this;
        }

        public Builder withCategory(String category){
            filter.category=category;
            return this;
        }

        public Filter build(){
            return filter;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
