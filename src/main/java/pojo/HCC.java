package pojo;

public class HCC {
    private long index;
    private String code;
    private double raf;
    private String children;
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

    public double getRaf() {
        return raf;
    }

    public void setRaf(double raf) {
        this.raf = raf;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HCC{" +
                "index=" + index +
                ", code='" + code + '\'' +
                ", raf=" + raf +
                ", children='" + children + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof HCC)) {
            return false;
        }

        HCC hcc = (HCC) o;

        // Compare the data members and return accordingly
        return (hcc.getIndex() == this.index) && Double.compare(hcc.getRaf(), this.raf) == 0
                && hcc.code.equals(this.code) && hcc.children.equals(this.children) && hcc.description.equals(this.description);
    }
}
