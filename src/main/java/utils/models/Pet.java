package utils.models;

import com.google.gson.annotations.SerializedName;

public class Pet {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("category")
    private Category category;
    @SerializedName("photoUrls")
    private String[] photoUrls;
    @SerializedName("tags")
    private Tag[] tags;
    @SerializedName("status")

    private String status;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public static class Category {

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Constructors, getters, setters
    }

    public static class Tag {
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


