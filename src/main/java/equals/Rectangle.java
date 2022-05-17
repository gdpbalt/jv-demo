package equals;

public class Rectangle {
    private Integer width;
    private Integer length;
    private String color;

    public Rectangle(Integer width, Integer length, String color) {
        this.width = width;
        this.length = length;
        this.color = color;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return (length == rectangle.length || (length != null && length.equals(rectangle.length)))
                && (width == rectangle.width || (width != null && width.equals(rectangle.width)))
                && (color == rectangle.color || (color != null && color.equals(rectangle.color)));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (width == null ? 0 : width);
        result = 31 * result + (length == null ? 0 : length);
        result = 31 * result + (color == null ? 0 : color.hashCode());
        return result;
    }
}
