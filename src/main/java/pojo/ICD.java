package pojo;

public class ICD {
    private long index;
    private String code;
    private String description;

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ICD{" +
                "index=" + index +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
