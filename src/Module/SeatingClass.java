package Module;

 enum SeatingClass {
    BALCONY(200),FIRST_CLASS(170),SECOND_CLASS(150);
    private int price;
    SeatingClass(int price){
      this.price=price;
    }

}

