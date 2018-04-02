package ass2_5_practice;

public class Square {

    Rectangle r;

    public Square(int size){
        this.r = new Rectangle(size, size);
    }

    public double getSize(){
        return r.getHeight();
    }

    public void setSize(int size) {
        r.setWidth(size);
        r.setHeight(size);
    }

}







